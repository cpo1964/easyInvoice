package com.cpo.invoice.gui;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import com.cpo.invoice.control.SettingsControl;
import com.cpo.invoice.model.SETTINGS;
import com.cpo.invoice.print.ParameterHelper;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsHelper.
 */
public final class SettingsHelper {

	/** The currency data. */
	private static String[] currencyData;

	/** The tax data. */
	private static String[] taxData;

	/** The language data. */
	private static String[] languageData;

	/** The selected settings. */
	private static SETTINGS selectedSettings;

	/** The settings data. */
	private static Vector<SETTINGS> settingsData =
		new Vector<SETTINGS>();

	/** The Constant ENGLISCH. */
	private static final String ENGLISCH = "Englisch";

	/** The Constant DEUTSCH. */
	private static final String DEUTSCH = "Deutsch";

	/**
	 * Instantiates a new settings helper.
	 */
	private SettingsHelper() {
		super();
	}

	/**
	 * Gets the tax data.
	 *
	 * @return the tax data
	 */
	public static String[] getTaxData() {
		return taxData;
	}

	/**
	 * Sets the tax data.
	 *
	 * @param pValues the new tax data
	 */
	public static void setTaxData(final String[] pValues) {
		SettingsHelper.taxData = pValues;
	}

	/**
	 * Gets the selected settings.
	 *
	 * @return the selected settings
	 */
	public static SETTINGS getSelectedSettings() {
		return selectedSettings;
	}

	/**
	 * Sets the selected settings.
	 *
	 * @param pValue the new selected settings
	 */
	public static void setSelectedSettings(final SETTINGS pValue) {
		SettingsHelper.selectedSettings = pValue;
	}

	/**
	 * Gets the settings data.
	 *
	 * @return the settings data
	 */
	public static Vector<SETTINGS> getSettingsData() {
		return settingsData;
	}

	/**
	 * Sets the settings data.
	 *
	 * @param pValues the new settings data
	 */
	public static void setSettingsData(final Vector<SETTINGS> pValues) {
		SettingsHelper.settingsData = pValues;
	}

	/**
	 * Inits the.
	 */
	static void init() {
		InvoiceUI.getGui().getTfTax1().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfTax1().setText("20");
		InvoiceUI.getGui().getTfTax2().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfTax2().setText("10");
		InvoiceUI.getGui().getTfTax3().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfTax3().setText("0");
		InvoiceUI.getGui().getTfBookingYear().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfBookingYear().setText("2010");
		InvoiceUI.getGui().getJComboBoxArticleTax().setModel(getTaxDataModel());
		InvoiceUI.getGui().getJComboBoxCurrency().setModel(getCurrencyDataModel());
		InvoiceUI.getGui().getJComboBoxLanguage().setModel(getLanguageDataModel());
		InvoiceUI.getGui().getJComboBoxLanguage().setSelectedItem(ENGLISCH);
		InvoiceUI.getGui().getJComboBoxLanguage().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						changeLanguage(null);
					}
				});
		// textfield BookingYear (at tab "Settings")
		InvoiceUI.getGui().getTfBookingYear().addFocusListener(InvoiceUI.getGui());
		SettingsControl.loadSettings();
	}

	/**
	 * Change language.
	 *
	 * @param pLang the lang
	 */
	protected static void changeLanguage(final String pLang) {
		String lang = (String)InvoiceUI.getGui().getJComboBoxLanguage()
				.getSelectedItem();
		if (pLang != null) {
			lang = pLang;
			InvoiceUI.getGui().getJComboBoxLanguage().setSelectedItem(pLang);
		}
		setBundle(lang);
		InvoiceUI.getGui().initLabels();
	}

	/**
	 * Sets the bundle.
	 *
	 * @param lang the new bundle
	 */
	public static void setBundle(final String lang) {
		if (DEUTSCH.equals(lang)) {
			InvoiceUI.getGui();
			InvoiceUI.getGui().setBundle(ResourceBundle.getBundle(
					InvoiceUI.getResource(), new Locale("de", "AT")));
		} else {
			InvoiceUI.getGui();
			InvoiceUI.getGui().setBundle(ResourceBundle.getBundle(
					InvoiceUI.getResource(), new Locale("en")));
		}
	}

	/**
	 * Gets the tax data model.
	 *
	 * @return the tax data model
	 */
	@SuppressWarnings("rawtypes")
	private static ComboBoxModel<?> getTaxDataModel() {
		setTaxData(new String[3]);
		// taxData[0] = "";
		getTaxData()[0] = "20";
		getTaxData()[1] = "10";
		getTaxData()[2] = "0";
		return new DefaultComboBoxModel(getTaxData());
	}

	/**
	 * Gets the currency data model.
	 *
	 * @return the currency data model
	 */
	@SuppressWarnings("rawtypes")
	private static ComboBoxModel<?> getCurrencyDataModel() {
		currencyData = new String[4];
		// taxData[0] = "";
		currencyData[0] = "EUR / " + ParameterHelper.EUR_CHAR; // Euro
		currencyData[1] = "CHF"; // Schweizer Franken CHF
		currencyData[2] = "USD / " + ParameterHelper.USD_CHAR; // US-Dollar
		currencyData[3] = "GBP / " + ParameterHelper.GBP_CHAR; // Britisches Pfund
		return new DefaultComboBoxModel(currencyData);
	}

	// Currency Code
	/**
	 * Gets the checks if is o4217.
	 *
	 * @return the checks if is o4217
	 */
	public static String getISO4217() {
		return null;
	}

	/**
	 * Gets the currency symbol.
	 *
	 * @param pCurrency the currency
	 * @return the currency symbol
	 */
	public static String getCurrencySymbol(final String pCurrency) {
		String curr = null;
		curr = pCurrency;
		if (curr.length() == 3) {
			return curr;
		} else {
			return curr.substring(curr.length()-1);
		}
	}

	/**
	 * Gets the language data model.
	 *
	 * @return the language data model
	 */
	@SuppressWarnings("rawtypes")
	private static ComboBoxModel<?> getLanguageDataModel() {
		languageData = new String[2];
		// languageData[0] = "";
		languageData[0] = DEUTSCH;
		languageData[1] = ENGLISCH;
		return new DefaultComboBoxModel(languageData);
	}

	/**
	 * Gets the settings from gui.
	 *
	 * @param settings the settings
	 * @return the settings from gui
	 */
	public static void getSettingsFromGui(final SETTINGS settings) {
		settings.setBOOKING_YEAR(
				InvoiceUI.getGui().getTfBookingYear().getText());
		settings.setCURRENCY(InvoiceUI.getGui().getJComboBoxCurrency()
				.getSelectedItem().toString());
		settings.setLANGUAGE(InvoiceUI.getGui().getJComboBoxLanguage()
				.getSelectedItem().toString());
		settings.setTAX1(InvoiceUI.getGui().getTfTax1().getText());
		settings.setTAX2(InvoiceUI.getGui().getTfTax2().getText());
		settings.setTAX3(InvoiceUI.getGui().getTfTax3().getText());
	}

	/**
	 * Sets the settings to gui.
	 *
	 * @param settings the new settings to gui
	 */
	public static void setSettingsToGui(final SETTINGS settings) {
		InvoiceUI.getGui().getTfBookingYear().setText(
				settings.getBOOKING_YEAR());
		InvoiceUI.getGui().getJComboBoxCurrency().setSelectedItem(
				settings.getCURRENCY());
		InvoiceUI.getGui().getJComboBoxLanguage().setSelectedItem(
				settings.getLANGUAGE());
		InvoiceUI.getGui().getTfTax1().setText(settings.getTAX1());
		InvoiceUI.getGui().getTfTax2().setText(settings.getTAX2());
		InvoiceUI.getGui().getTfTax3().setText(settings.getTAX3());
	}

	/**
	 * Update settings gui.
	 */
	public static void updateGui() {
		// TODO Auto-generated method stub
		
	}

}
