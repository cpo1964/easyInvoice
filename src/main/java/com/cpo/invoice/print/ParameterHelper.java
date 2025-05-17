package com.cpo.invoice.print;

import java.util.Collections;
import java.util.HashMap;

import com.cpo.invoice.control.TextblockControl;
import com.cpo.invoice.gui.SettingsHelper;
import com.cpo.invoice.gui.TextblockHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.TEXTBLOCK;
import com.cpo.invoice.util.CommonHelper;

/**
 * The Class ParameterHelper.
 */
public final class ParameterHelper {

	/** The Constant EUR_CHAR. */
	public static final char EUR_CHAR = '\u20ac';

	/** The Constant GBP_CHAR. */
	public static final char GBP_CHAR = '\u00a3';

	/** The Constant USD_CHAR. */
	public static final char USD_CHAR = '\u0024';

	public static final String TXT_INV_DATE = "Invoice";

	/** The parameter. */
	private static HashMap<String, String> parameter; // default null

	/**
	 * Instantiates a new parameter helper.
	 */
	private ParameterHelper() {
		super();
	}

	/**
	 * Gets the parameters.
	 *
	 * @param pInvoice the invoice
	 * @return the parameters
	 */
	public static HashMap<String, String> getParameters(final INVOICE pInvoice) {
		parameter = new HashMap<String, String>();
		addOtherParameters();
		addTextblockParameters(pInvoice);
		addInvoiceParameters(pInvoice);
		addPositionParameters(pInvoice);
		addSenderParameters(pInvoice);
		addReceiverParameters(pInvoice);
		return parameter;
	}

	/**
	 * Adds the other parameters.
	 *
	 * @return the hash map
	 */
	public static HashMap<String, String> addOtherParameters() {
		final String tax1Str = SettingsHelper.getTaxData()[0];
		final String tax2Str = SettingsHelper.getTaxData()[1];
		final String tax3Str = SettingsHelper.getTaxData()[2];
		final double tax1 = CommonHelper.getDouble(tax1Str);
		final double tax2 = CommonHelper.getDouble(tax2Str);
		final double tax3 = CommonHelper.getDouble(tax3Str);

		final double sumNettoTax1 = MapHelper.getNettoTax1();
		final double sumNettoTax2 = MapHelper.getNettoTax2();
		final double sumNettoTax3 = MapHelper.getNettoTax3();
		final String nettoTax1Str = CommonHelper.getDezimalString(sumNettoTax1);
		final String nettoTax2Str = CommonHelper.getDezimalString(sumNettoTax2);
		final String nettoTax3Str = CommonHelper.getDezimalString(sumNettoTax3);
//		System.out.println("nettoTax1: "+sumNettoTax1);
//		System.out.println("nettoTax2: "+sumNettoTax2);
//		System.out.println("nettoTax3: "+sumNettoTax3);

		final double total1 = sumNettoTax1 * (1 + tax1 / 100);
		final double total2 = sumNettoTax2 * (1 + tax2 / 100);
		final double total3 = sumNettoTax3 * (1 + tax3 / 100);

		final double totalTax1 = total1-sumNettoTax1;
		final double totalTax2 = total2-sumNettoTax2;
		final double totalTax3 = total3-sumNettoTax3;
		final String totalTax1Str = CommonHelper.getDezimalString(totalTax1);
		final String totalTax2Str = CommonHelper.getDezimalString(totalTax2);
		final String totalTax3Str = CommonHelper.getDezimalString(totalTax3);

		final String totalNettoStr = CommonHelper.getDezimalString(sumNettoTax1 + sumNettoTax2 + sumNettoTax3);
		final String totalTaxStr = CommonHelper.getDezimalString(totalTax1 + totalTax2 + totalTax3);
		final String totalAmtStr = CommonHelper.getDezimalString(total1 + total2 + total3);

		parameter.put("CURR",
				"" + SettingsHelper.getCurrencySymbol(
						(String)InvoiceUI.getGui().getJComboBoxCurrency().getSelectedItem()));
		parameter.put("LBL_FROM",
				InvoiceUI.getGui().getBundleValueByKey(
				"lbl.from"));
		parameter.put("LBL_TAX",
				InvoiceUI.getGui().getBundleValueByKey(
				"lbl.tax"));
		parameter.put("LBL_NETTO",
				InvoiceUI.getGui().getBundleValueByKey(
				"lbl.netto"));
		parameter.put("LBL_TOTAL",
				InvoiceUI.getGui().getBundleValueByKey(
				"lbl.total"));

		parameter.put("TAX1", tax1Str);
		parameter.put("TAX1_AMT", nettoTax1Str);
		parameter.put("TAX1_TAX", totalTax1Str);
		parameter.put("TAX2", tax2Str);
		parameter.put("TAX2_AMT", nettoTax2Str);
		parameter.put("TAX2_TAX", totalTax2Str);
		parameter.put("TAX3", tax3Str);
		parameter.put("TAX3_AMT", nettoTax3Str);
		parameter.put("TAX3_TAX", totalTax3Str);

		parameter.put("TOTAL", totalNettoStr);
		parameter.put("TOTAL_TAX", totalTaxStr);
		parameter.put("TOTAL_AMT", totalAmtStr);
		return parameter;
	}

	/**
	 * Adds the textblock parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addTextblockParameters(final INVOICE pInvoice) {
		TextblockHelper.setTextblockData(
			TextblockControl.getTextblockData(pInvoice));
		Collections.sort(TextblockHelper.getTextblockData());
		final int tbCount = TextblockHelper.getTextblockData().size();
		for (int i = 0; i < tbCount; i++) {
			final TEXTBLOCK tb = TextblockHelper.getTextblockData().get(i);
			final String tbStr = tb.getTEXT();
//			System.out.println("TEXTBLOCK"+tb.getNR()+": " + tbStr);
			parameter.put("TEXTBLOCK" + tb.getNR(), tbStr);
		}
		if (tbCount == 0) {
			parameter.put("TEXTBLOCK1", "-");
			parameter.put("TEXTBLOCK2", "--");
		}
		if (tbCount == 1) {
			parameter.put("TEXTBLOCK2", "--");
			parameter.put("TEXTBLOCK2", TextblockHelper.getTextblockData().get(0).getTEXT());
		}
	}

	/**
	 * Adds the invoice parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addInvoiceParameters(final INVOICE pInvoice) {
		parameter.put("LBL_INV", InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoiceArea"));
		parameter.put("LBL_INV_NR", InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoiceNr"));
		parameter.put("TXT_INV_NR", pInvoice.getNR());
		parameter.put("LBL_INV_DATE", InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoiceDate"));
		parameter.put("TXT_INV_DATE", pInvoice.getINV_DATE());
		parameter.put("LBL_PAY_UNTIL", InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoicePayUntil"));
		parameter.put("TXT_PAY_UNTIL", pInvoice.getPAY_UNTIL());
	}

	/**
	 * Adds the position parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addPositionParameters(final INVOICE pInvoice) {
		parameter.put("LBL_POS_NR",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.InvoicePosition.Lbl.PositionNr2"));
		parameter.put("LBL_POS_AMOUNT",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.InvoicePosition.Lbl.Quantity"));
		parameter.put("LBL_POS_UNIT",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Unit"));
		parameter.put("LBL_POS_DESCRIPTION",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Description"));
		parameter.put("LBL_POS_UNITPRICE",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.UnitPrice"));
		parameter.put("LBL_POS_TOTAL",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.InvoicePosition.Lbl.Amount"));
	}

	/**
	 * Adds the sender parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addSenderParameters(final INVOICE pInvoice) {
		if (pInvoice.getSENDER() == null) {
			return;
		}
		parameter.put("LBL_SENDER_UID",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Customers.Lbl.UID"));
		parameter.put("SENDER_UID", pInvoice.getSENDER().getUID());
		parameter.put("LBL_SENDER_TAXNR",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Customers.Lbl.TaxNr"));
		parameter.put("SENDER_TAXNR", pInvoice.getSENDER().getTAXNR());
		parameter.put("SENDER_TITLE", pInvoice.getSENDER().getTITLE());
		parameter.put("SENDER_FIRST_NAME", pInvoice.getSENDER().getNAME());
		parameter.put("SENDER_LAST_NAME", pInvoice.getSENDER().getLASTNAME());
		if (pInvoice.getSENDER().getInvoiceAdress() != null) {
			parameter.put("SENDER_ADR_STREET",
					pInvoice.getSENDER().getInvoiceAdress().getSTREET());
			parameter.put("SENDER_ADR_HOUSENR",
					pInvoice.getSENDER().getInvoiceAdress().getHOUSENR());
			parameter.put("SENDER_ADR_COUNTRYCODE",
					pInvoice.getSENDER().getInvoiceAdress().getCOUNTRYCODE());
			parameter.put("SENDER_ADR_PLZ",
					pInvoice.getSENDER().getInvoiceAdress().getPLZ());
			parameter.put("SENDER_ADR_CITY",
					pInvoice.getSENDER().getInvoiceAdress().getCITY());
		}
		if (pInvoice.getSENDER().getInvoicePhone() != null) {
			parameter.put("SENDER_PHONE_TYPE",
					pInvoice.getSENDER().getInvoicePhone().getTYPE());
			parameter.put("SENDER_PHONE_CALLNR",
					pInvoice.getSENDER().getInvoicePhone().getCALL_NR());
		}
		if (pInvoice.getSENDER().getInvoiceBank() != null) {
			parameter.put("LBL_SENDER_BANK",
					InvoiceUI.getGui().getBundleValueByKey(
					"tab.name.Customers.Lbl.Bank"));
			parameter.put("SENDER_BANK_NAME",
					pInvoice.getSENDER().getInvoiceBank().getNAME());
			parameter.put("LBL_SENDER_BANK_ACCOUNT_NR",
					InvoiceUI.getGui().getBundleValueByKey(
					"tab.name.Banks.Lbl.AccountNr"));
			parameter.put("SENDER_BANK_ACCOUNT_NR",
					pInvoice.getSENDER().getInvoiceBank().getACCOUNT_NR());
			parameter.put("LBL_SENDER_BANK_BLZ",
					InvoiceUI.getGui().getBundleValueByKey(
					"tab.name.Banks.Lbl.BLZ"));
			parameter.put("SENDER_BANK_BLZ",
					pInvoice.getSENDER().getInvoiceBank().getBLZ());
			parameter.put("LBL_SENDER_BANK_BIC",
					InvoiceUI.getGui().getBundleValueByKey(
					"tab.name.Banks.Lbl.BIC"));
			parameter.put("SENDER_BANK_BIC",
					pInvoice.getSENDER().getInvoiceBank().getBIC());
			parameter.put("LBL_SENDER_BANK_IBAN",
					InvoiceUI.getGui().getBundleValueByKey(
					"tab.name.Banks.Lbl.IBAN"));
			parameter.put("SENDER_BANK_IBAN",
					pInvoice.getSENDER().getInvoiceBank().getIBAN());
		}
	}

	/**
	 * Adds the receiver parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addReceiverParameters(final INVOICE pInvoice) {
		if (pInvoice.getRECEIVER() == null) {
			return;
		}
		parameter.put("LBL_RECEIVER",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Invoices.Lbl.InvoiceReceiver2"));
		parameter.put("LBL_RECEIVER_UID",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Customers.Lbl.UID"));
		parameter.put("RECEIVER_UID", pInvoice.getRECEIVER().getUID());
		parameter.put("LBL_RECEIVER_TAXNR",
				InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Customers.Lbl.TaxNr"));
		parameter.put("RECEIVER_TAXNR", pInvoice.getRECEIVER().getTAXNR());
		parameter.put("RECEIVER_TITLE", pInvoice.getRECEIVER().getTITLE());
		parameter.put("RECEIVER_FIRST_NAME", pInvoice.getRECEIVER().getNAME());
		parameter.put("RECEIVER_LAST_NAME",
				pInvoice.getRECEIVER().getLASTNAME());
		if (pInvoice.getRECEIVER().getInvoiceAdress() != null) {
			parameter.put("RECEIVER_ADR_STREET",
					pInvoice.getRECEIVER().getInvoiceAdress().getSTREET());
			parameter.put("RECEIVER_ADR_HOUSENR",
					pInvoice.getRECEIVER().getInvoiceAdress().getHOUSENR());
			parameter.put("RECEIVER_ADR_COUNTRYCODE",
					pInvoice.getRECEIVER().getInvoiceAdress().getCOUNTRYCODE());
			parameter.put("RECEIVER_ADR_PLZ",
					pInvoice.getRECEIVER().getInvoiceAdress().getPLZ());
			parameter.put("RECEIVER_ADR_CITY",
					pInvoice.getRECEIVER().getInvoiceAdress().getCITY());
		}
		if (pInvoice.getRECEIVER().getInvoicePhone() != null) {
			parameter.put("RECEIVER_PHONE_TYPE",
					pInvoice.getRECEIVER().getInvoicePhone().getTYPE());
			parameter.put("RECEIVER_PHONE_CALLNR",
					pInvoice.getRECEIVER().getInvoicePhone().getCALL_NR());
		}
	}

}
