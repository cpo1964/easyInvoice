package com.cpo.invoice.gui;

import java.util.Date;

import com.cpo.invoice.control.InvoiceControl;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceUIValidator.
 */
public class InvoiceUIValidator {
	
	/** The NL. */
	public static String NL = System.getProperty("line.separator");
	
	/** The ERRO r_ titl e_ str. */
	public static String ERROR_TITLE_STR = null;
	
	/** The ERRO r_ str. */
	public static String ERROR_STR = null;
	
	/**
	 * Validate invoice.
	 *
	 * @return the string
	 */
	protected static String validateInvoice() {
		ERROR_TITLE_STR = InvoiceUI.getGui().getBundleValueByKey(
			"error.Input");
		ERROR_STR = null;
		validateInvoiceNr(InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoiceNr"),
			InvoiceUI.getGui().getTfInvoiceNr().getText());
		validateDate(InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoiceDate"),
			InvoiceUI.getGui().getJDateChooserDate().getDate());
		validateDate(InvoiceUI.getGui().getBundleValueByKey(
			"tab.name.Invoices.Lbl.InvoicePayUntil"),
			InvoiceUI.getGui().getJDateChooserPayUntil().getDate());
//		System.out.println(ERROR_STR);
		return ERROR_STR;
	}

	/**
	 * Validate invoice nr.
	 *
	 * @param pStr the str
	 * @param tfInvoiceNr the tf invoice nr
	 */
	private static void validateInvoiceNr(String pStr,String tfInvoiceNr) {
		String errMsg = InvoiceUI.getGui()
			.getBundleValueByKey("error.notValid");
		INVOICE inv = (INVOICE) InvoiceControl.getByNR(tfInvoiceNr);
		boolean newInvoiceNrAlreadyUsed = 
			(inv != null) && InvoiceHelper.isANew();
		if (newInvoiceNrAlreadyUsed)
			errMsg = InvoiceUI.getGui()
				.getBundleValueByKey("error.invoiceNr.inuse");
		// exactly 7 chars
		String regexStr1 = ".{7}";
		// not a 0 at the end
		String regexStr2 = ".+([^0])";
		// 1 capital letter, 2 digits, a '.', 3 more digits
		String regexStr3 = "[A-Z]{1}(\\d{2})\\.(\\d{3})";
		String res = null;
		if (tfInvoiceNr == null || newInvoiceNrAlreadyUsed ||
				!CommonHelper.isValidByRegex(tfInvoiceNr, regexStr1) ||
//				!CommonHelper.isValidByRegex(tfInvoiceNr, regexStr2) ||
				!CommonHelper.isValidByRegex(tfInvoiceNr, regexStr3)) {
			res = pStr+" "+errMsg;
			if (ERROR_STR == null) {
				ERROR_STR = res + NL;
			} else {
				ERROR_STR = ERROR_STR + res + NL;
			}
			if (!newInvoiceNrAlreadyUsed)
				ERROR_STR = ERROR_STR + InvoiceUI.getGui().getBundleValueByKey(
					"valid.pattern")+": [A-Z]{1}(\\d{2})\\.(\\d{3})" + NL;
//			System.out.println("INFO: "+res);
		} else {
//			System.out.println("INFO: "+pStr+
//					" invoice nr "+tfInvoiceNr+" is VALID");
		}
	}

	/**
	 * Validate date.
	 *
	 * @param pStr the str
	 * @param pDate the date
	 */
	private static void validateDate(String pStr,Date pDate) {
		String res = null;
		if (pDate == null) {
			res = pStr+" "+InvoiceUI.getGui().getBundleValueByKey(
				"error.notValid");
			if (ERROR_STR == null) {
				ERROR_STR = res + NL;
			} else {
				ERROR_STR = ERROR_STR + res + NL;
			}
//			System.out.println("INFO: "+res);
		} else {
//			System.out.println("INFO: "+pStr+" date "+pDate+" is VALID");
		}
	}

}
