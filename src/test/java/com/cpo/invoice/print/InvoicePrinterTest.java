package com.cpo.invoice.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cpo.invoice.util.CommonHelper;

public class InvoicePrinterTest {

	private static HashMap<String, String> parameter = new HashMap<String, String>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		String date = "30.04.2025";
		Collection map = getMap();
		HashMap<String, String> params = getParameters();
		InvoicePrinter.printInvoice(date, map, params, false);
	}
	
	public static Collection<Map<String, Object>> getMap() {
		final Collection<Map<String, Object>> lColl = new ArrayList<Map<String, Object>>();
		lColl.add(getPositionMap());
		return lColl;
	}

	/**
	 * Gets the position map.
	 *
	 * @param pPos the pos
	 * @return the position map
	 */
	private static Map<String, Object> getPositionMap() {
		// {
		String article_unit_price="100,00";
		String article_description="Teilzahlung Werklohn 2025";
		String article_tax="20";
		String pos_quantity="162";
		String pos_amount="16.200,00";
		String article_unit="Std";
		
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("pos_quantity", pos_quantity);
//		System.out.println("pos_quantity: "+pPos.getQUANTITY());
		map.put("article_unit", article_unit);
//		System.out.println("article_unit: "+pPos.getARTICLE().getUNIT());
		map.put("article_description", article_description);
//		System.out.println("article_description: "+pPos.getARTICLE().getDESCRIPTION());
		map.put("article_tax", article_tax);
//		System.out.println("article_tax: "+pPos.getARTICLE().getTAX());
		map.put("article_unit_price", article_unit_price);
//		System.out.println("article_unit_price: "+pPos.getARTICLE().getUNIT_PRICE());
		map.put("pos_amount", pos_amount);
//		System.out.println("pos_amount: "+pPos.getAMOUNT());
//		setNettoTax1(getNettoTax1() +
//			getAmountForTax(1, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
//		setNettoTax2(getNettoTax2() +
//			getAmountForTax(2, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
//		setNettoTax3(getNettoTax3() +
//			getAmountForTax(3, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
//		System.out.println("netto: "+netto);
		return map;
	}

	/**
	 * Gets the parameters.
	 *
	 * @param pInvoice the invoice
	 * @return the parameters
	 */
	public static HashMap<String, String> getParameters() {
		parameter = new HashMap<String, String>();
		addOtherParameters();
		addTextblockParameters();
		addInvoiceParameters();
		addPositionParameters();
		addSenderParameters();
		addReceiverParameters();
		return parameter;
	}

	/**
	 * Adds the other parameters.
	 *
	 * @return the hash map
	 */
	public static HashMap<String, String> addOtherParameters() {
		final String tax1Str = "Mwst. #1";
		final String tax2Str = "Mwst. #2";
		final String tax3Str = "Mwst. #3";
		final double tax1 = 20;
		final double tax2 = 10;
		final double tax3 = 0;

		final double sumNettoTax1 = 16200;
		final double sumNettoTax2 = 0;
		final double sumNettoTax3 = 0;
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

		parameter.put("CURR", "EUR / €");
		parameter.put("LBL_FROM", "aus");
		parameter.put("LBL_TAX", "Mwst");
		parameter.put("LBL_NETTO", "Netto");
		parameter.put("LBL_TOTAL", "Gesamt");

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
	private static void addTextblockParameters() {
		String tbStr1 = "Berechnungszeitraum: 01.04.2025 - 30.04.2025";
		String tbStr2 = "alles ok";
		parameter.put("TEXTBLOCK" + 1, tbStr1);
		parameter.put("TEXTBLOCK" + 2, tbStr2);
		int tbCount = 1;
		if (tbCount  == 0) {
			parameter.put("TEXTBLOCK1", "-");
			parameter.put("TEXTBLOCK2", "--");
		}
		if (tbCount == 1) {
			parameter.put("TEXTBLOCK2", "--");
			parameter.put("TEXTBLOCK2", tbStr2);
		}
	}

	/**
	 * Adds the invoice parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addInvoiceParameters() {
		parameter.put("LBL_INV", "Rechnung");
		parameter.put("LBL_INV_NR", "Rechnungs-Nr.");
		parameter.put("TXT_INV_NR", "R25.004");
		parameter.put("LBL_INV_DATE", "Rechnungsdatum");
		parameter.put("TXT_INV_DATE", "30.04.2025");
		parameter.put("LBL_PAY_UNTIL", "Zahlbar bis");
		parameter.put("TXT_PAY_UNTIL", "30.05.2025");
	}

	/**
	 * Adds the position parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addPositionParameters() {
		parameter.put("LBL_POS_NR", "Pos");
		parameter.put("LBL_POS_AMOUNT", "Menge");
		parameter.put("LBL_POS_UNIT", "Einheit");
		parameter.put("LBL_POS_DESCRIPTION", "Bezeichnung");
		parameter.put("LBL_POS_UNITPRICE", "Preis");
		parameter.put("LBL_POS_TOTAL", "Gesamt");
	}

	/**
	 * Adds the sender parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addSenderParameters() {
		parameter.put("LBL_SENDER_UID", "UID");
		parameter.put("SENDER_UID", "UID123");
		parameter.put("LBL_SENDER_TAXNR","Steuer-Nr.");
		parameter.put("SENDER_TAXNR", "123456");
		parameter.put("SENDER_TITLE", "Herr");
		parameter.put("SENDER_FIRST_NAME", "Joe");
		parameter.put("SENDER_LAST_NAME", "Doe");
		//if (pInvoice.getSENDER().getInvoiceAdress() != null) {
			parameter.put("SENDER_ADR_STREET", "Seestrasse");
			parameter.put("SENDER_ADR_HOUSENR", "1");
			parameter.put("SENDER_ADR_COUNTRYCODE", "A");
			parameter.put("SENDER_ADR_PLZ", "1010");
			parameter.put("SENDER_ADR_CITY", "Vienna");
		//}
	
		//if (pInvoice.getSENDER().getInvoicePhone() != null) {
			parameter.put("SENDER_PHONE_TYPE", "Handy");
			parameter.put("SENDER_PHONE_CALLNR", "0043-660- 1234567");
		//}
		//if (pInvoice.getSENDER().getInvoiceBank() != null) {
			parameter.put("LBL_SENDER_BANK", "Bank");
			parameter.put("SENDER_BANK_NAME", "SPK");
			parameter.put("LBL_SENDER_BANK_ACCOUNT_NR", "Kontonummer");
			parameter.put("SENDER_BANK_ACCOUNT_NR", "1234567");
			parameter.put("LBL_SENDER_BANK_BLZ", "BLZ");
			parameter.put("SENDER_BANK_BLZ", "12345");
			parameter.put("LBL_SENDER_BANK_BIC", "BIC");
			parameter.put("SENDER_BANK_BIC", "ASPAKTL");
			parameter.put("LBL_SENDER_BANK_IBAN", "IBAN");
			parameter.put("SENDER_BANK_IBAN", "AT1234567");
//		}
	}

	/**
	 * Adds the receiver parameters.
	 *
	 * @param pInvoice the invoice
	 */
	private static void addReceiverParameters() {
		parameter.put("LBL_RECEIVER", "Empfänger");
		parameter.put("LBL_RECEIVER_UID", "UID");
		parameter.put("RECEIVER_UID", "UID789");
		parameter.put("LBL_RECEIVER_TAXNR", "Steuer-Nr.");
		parameter.put("RECEIVER_TAXNR", "345345");
		parameter.put("RECEIVER_TITLE", "Firma");
		parameter.put("RECEIVER_FIRST_NAME", "Jane");
		parameter.put("RECEIVER_LAST_NAME", "Doe");
//		if (pInvoice.getRECEIVER().getInvoiceAdress() != null) {
			parameter.put("RECEIVER_ADR_STREET", "Lagerstrasse");
			parameter.put("RECEIVER_ADR_HOUSENR", "1");
			parameter.put("RECEIVER_ADR_COUNTRYCODE", "A");
			parameter.put("RECEIVER_ADR_PLZ", "1010");
			parameter.put("RECEIVER_ADR_CITY", "Vienna");
//		}
//		if (pInvoice.getRECEIVER().getInvoicePhone() != null) {
			parameter.put("RECEIVER_PHONE_TYPE", "Handy");
			parameter .put("RECEIVER_PHONE_CALLNR", "0043-660-23232323");
//		}
	}
}
