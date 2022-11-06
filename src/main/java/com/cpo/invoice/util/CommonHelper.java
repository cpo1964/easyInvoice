package com.cpo.invoice.util;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.apache.log4j.Logger;

import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.InvoiceUIValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonHelper.
 */
public final class CommonHelper {

	/** The log. */
	private static Logger log = Logger.getLogger(CommonHelper.class);

	/**
	 * Instantiates a new common helper.
	 */
	private CommonHelper() {
		super();
	}

	/**
	 * Gets the dezimal string.
	 *
	 * @param pValue the value
	 * @return the dezimal string
	 */
	public static String getDezimalString(final double pValue) {
		// log.debug("Calling getDezimalString for value: " + pValue);
		String formattedStr = "not formatted";
		final DecimalFormat df = (DecimalFormat)DecimalFormat
				.getInstance(Locale.GERMAN);
		try {
			df.applyPattern("#.###.##0,00");
		} catch (Exception e) {
			// log.debug(e.getMessage());
		}
		try {
			formattedStr = df.format(pValue);
		} catch (Exception e) {
			// log.debug(e.getMessage());
		}
		if (! formattedStr.contains(",")) {
			formattedStr = formattedStr + ",00";
		}
		final int ix = formattedStr.indexOf(",");
		// log.debug("formattedStr: " + formattedStr.substring(ix));
		if (formattedStr.substring(ix).length() == 2) {
			formattedStr = formattedStr + "0";
		}
		// log.debug("formattedStr: " + formattedStr);
		return formattedStr;
	}

	/**
	 * Gets the double.
	 *
	 * @param pValue the value
	 * @return the double
	 */
	public static Double getDouble(final String pValue) {
		String lValue = pValue;
		lValue = removeChar(lValue, '.');
		lValue = lValue.replaceAll(",", ".");
		// log.debug("Calling getDouble for: " + lValue);
		final String myDigits = "(\\p{Digit}+)";
		final String myHexDigits = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally
		// signed decimal integer.
		final String myExp = "[eE][+-]?" + myDigits;
		final String fpRegex = "[\\x00-\\x20]*" + // Optional leading
				// "whitespace"
				"[+-]?(" + // Optional sign character
				"NaN|" + // "NaN" string
				"Infinity|" + // "Infinity" string

				// A decimal floating-point string representing a finite
				// positive
				// number without a leading sign has at most five basic pieces:
				// Digits . Digits ExponentPart FloatTypeSuffix
				//
				// Since this method allows integer-only strings as input
				// in addition to strings of floating-point literals, the
				// two sub-patterns below are simplifications of the grammar
				// productions from the Java Language Specification, 2nd
				// edition, section 3.10.2.

				// Digits ,_opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
				"(((" + myDigits + "(\\.)?(" + myDigits + "?)(" + myExp + ")?)|" +

		// . Digits ExponentPart_opt FloatTypeSuffix_opt
				"(\\.(" + myDigits + ")(" + myExp + ")?)|" +

				// Hexadecimal strings
				"((" +
				// 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
				"(0[xX]" + myHexDigits + "(\\.)?)|" +

				// 0[xX] HexDigits_opt . HexDigits BinaryExponent
				// FloatTypeSuffix_opt
				"(0[xX]" + myHexDigits + "?(\\.)" + myHexDigits + ")" +

				// Optional trailing "whitespace"
				")[pP][+-]?" + myDigits + "))" + "[fFdD]?))" + "[\\x00-\\x20]*";

		Double db = null;
		if (Pattern.matches(fpRegex, lValue)) {
			// log.debug("Pattern matches: " + lValue);
			try {
				db = Double.valueOf(lValue.replace(',', '.'));
			} catch (NumberFormatException e) {
				log.debug("NumberFormatException: " + lValue);
			}
		} else {
			// log.debug("Pattern matches NOT: " + lValue);
			// Perform suitable alternative action
			db = Double.valueOf(0);
		}
		// log.debug("double: " + db);
		return db;
	}

	/**
	 * Removes the char.
	 *
	 * @param s the s
	 * @param c the c
	 * @return the string
	 */
	public static String removeChar(final String s, final char c) {
		final StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	/**
	 * Gets the nur zahlen plain document.
	 *
	 * @return the nur zahlen plain document
	 */
	public static PlainDocument getNurZahlenPlainDocument() {
		return new PlainDocument() {
			private static final long serialVersionUID = -1543612623021274594L;

			public void insertString(final int offset, final String str, final AttributeSet a)
					throws BadLocationException {
				// Nur Zahlen eingaben zulassen
				if (! str.matches("\\d*")) {
					return;
				}
				super.insertString(offset, str, a);
			}
		};
	}

	/**
	 * Show error msg box.
	 */
	public static void showErrorMsgBox() {
		JOptionPane.showMessageDialog(null, InvoiceUIValidator.ERROR_STR,
				InvoiceUIValidator.ERROR_TITLE_STR,
				JOptionPane.OK_CANCEL_OPTION);
	}

	/**
	 * Action confirmation.
	 *
	 * @param title the title
	 * @param text the text
	 * @return the int
	 */
	public static int actionConfirmation(final String title, final String text) {
		// Erstellung Array vom Datentyp Object, Hinzuf�gen der Optionen
		final Object[] options = {InvoiceUI.getGui().getBundleValueByKey("yes"),
				InvoiceUI.getGui().getBundleValueByKey("no")};
		final int selected = JOptionPane.showOptionDialog(null, InvoiceUI.getGui()
				.getBundleValueByKey(text), InvoiceUI.getGui()
				.getBundleValueByKey(title), JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return selected;
	}

	/**
	 * Gets the no min max.
	 *
	 * @param nrStr the nr str
	 * @return the no min max
	 */
	public static boolean getNoMinMax(final String nrStr) {
		if ("".equals(nrStr)) {
			return true;
		}
		if ("0".equals(nrStr)) {
			return false;
		}
		if (9999 < Integer.parseInt(nrStr)) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if is valid by regex.
	 *
	 * @param matchStr the match str
	 * @param regexStr the regex str
	 * @return true, if is valid by regex
	 */
	public static boolean isValidByRegex(final String matchStr, final String regexStr) {
		final Pattern p = Pattern.compile(regexStr);
		final Matcher m = p.matcher(matchStr);
		if (m.matches()) {
			log.debug("OK, matching: " + matchStr + " with pattern: " + regexStr);
		} else {
			log.debug("FAILED, matching: " + matchStr + " with pattern: " + regexStr);
			return false;
		}
		return true;
	}

	/**
	 * Test validate by regex.
	 */
	private static void testValidateByRegex() {
		final String matchStr1 = "R1-000";
		final String matchStr2 = "A10.001";
		// exactly 7 chars
		final String regexStr1 = ".{7}";
		// not a 0 at the end
		final String regexStr2 = ".+([^0])";
		// 1 capital letter, 2 digits, a '.', 3 more digits
		final String regexStr3 = "[A-Z]{1}(\\d{2})\\.(\\d{3})";
		isValidByRegex(matchStr1, regexStr1);
		isValidByRegex(matchStr1, regexStr2);
		isValidByRegex(matchStr1, regexStr3);
		log.debug("");
		isValidByRegex(matchStr2, regexStr1);
		isValidByRegex(matchStr2, regexStr2);
		isValidByRegex(matchStr2, regexStr3);
		log.debug("");
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
//		getDezimalString(1116321.10);
//		getDouble("7.821,00");
		testValidateByRegex();
	}

}
