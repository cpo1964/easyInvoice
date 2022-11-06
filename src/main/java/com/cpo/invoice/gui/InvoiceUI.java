package com.cpo.invoice.gui;


import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.cpo.invoice.control.SettingsControl;
import com.cpo.invoice.util.ResourceHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceUI.
 */
public final class InvoiceUI extends InvoiceGenUI implements FocusListener {

	/** The log. */
	private static Logger log = Logger.getLogger(InvoiceUI.class);

	/** The visible tabs. */
	private static int visibleTabs = 6;

	/** The gui. */
	private static InvoiceUI gui = new InvoiceUI();

	/** The bundle. */
	private ResourceBundle bundle;

	/** The resource. */
	private static String resource = "resources"; // Package + Prefix
//	private static String resource = "com.cpo.invoice.resources.resources"; // Package + Prefix

	/** The locale. */
	private Locale locale = Locale.getDefault();

	/**
	 * Instantiates a new invoice UI.
	 */
	private InvoiceUI() {
		super();
	}

	/**
	 * Gets the gui.
	 *
	 * @return the gui
	 */
	public static InvoiceUI getGui() {
		return gui;
	}

	/**
	 * Sets the gui.
	 *
	 * @param pValue the new gui
	 */
	public static void setGui(final InvoiceUI pValue) {
		gui = pValue;
	}

	/**
	 * Gets the visible tabs.
	 *
	 * @return the visible tabs
	 */
	public static int getVisibleTabs() {
		return visibleTabs;
	}

	/**
	 * Sets the visible tabs.
	 *
	 * @param pNr the new visible tabs
	 */
	public static void setVisibleTabs(final int pNr) {
		visibleTabs = pNr;
	}

	/**
	 * Inits the labels.
	 */
	protected void initLabels() {
		getGui().getJFrame().setTitle(
				getGui().getBundleValueByKey(StringHelper.APPLICATION_TITLE));
		initLabelsTab();
		ResourceHelper.initLabelsTabInvoices();
		ResourceHelper.initLabelsTabInvoicePosition();
		ResourceHelper.initLabelsTabTextblock();
		ResourceHelper.initLabelsTabCustomers();
		ResourceHelper.initLabelsTabBanks();
		ResourceHelper.initLabelsTabAdressesAndPhones();
		ResourceHelper.initLabelsTabPhones();
		ResourceHelper.initLabelsTabArticles();
		ResourceHelper.initLabelsTabSettings();
	}

	/**
	 * Inits the labels tab.
	 */
	private void initLabelsTab() {
		int tabNr = 0;
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_SETTINGS));
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_INVOICES));
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_INVOICE_POSITION));
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_TEXTBLOCK));
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_ARTICLES));
		getGui().getJTabbedPane().setTitleAt(
				tabNr++, getGui().getBundleValueByKey(StringHelper.TAB_NAME_CUSTOMERS));
		if (getVisibleTabs() == 7) {
			getGui().getJTabbedPane().setTitleAt(
					tabNr++, getGui().getBundleValueByKey(
							CustomerHelper.getCustomerDetailTitle()));
		}
	}

	/**
	 * Gets the bundle value by key.
	 *
	 * @param pKey the key
	 * @return the bundle value by key
	 */
	public String getBundleValueByKey(final String pKey) {
//		System.out.println("getBundleValueByKey("+pKey+")");
		final String txt = this.getBundle().getString(pKey);
//		System.out.println("label: "+txt);
		return txt;
	}

	/**
	 * Gets the localized double value.
	 *
	 * @param pDoubleStr the double str
	 * @return the localized double value
	 */
	public double getLocalizedDoubleValue(final String pDoubleStr) {
//		System.out.println("getLocalizedDoubleValue("+pDoubleStr+")");
		final NumberFormat nf = NumberFormat.getNumberInstance(this.locale);
		if (pDoubleStr == null) {
			return 0.0;
		}
		double nr = 0.0;
		try {
			nr = (double)(nf.parse(pDoubleStr).doubleValue());
		} catch (ParseException e) {
		}
//		System.out.println("double: "+nr);
		return nr;
	}

	/**
	 * Gets the combo box model.
	 *
	 * @param objects the objects
	 * @return the combo box model
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static ComboBoxModel getComboBoxModel(final Vector objects) {
		final Vector<Serializable> v = new Vector<Serializable>();
		v.add("");
		v.addAll(objects);
		return new DefaultComboBoxModel(v);
	}

	/**
	 * Gets the combo box model.
	 *
	 * @param objects the objects
	 * @return the combo box model
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static ComboBoxModel getComboBoxModel(final LinkedHashSet objects) {
		final Vector<Serializable> v = new Vector<Serializable>();
		v.add("");
		v.addAll(objects);
		return new DefaultComboBoxModel(v);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		InvoiceUI.setGui(new InvoiceUI());
		final JFrame frame = InvoiceUI.getGui().getJFrame();
		frame.setResizable(false);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(final java.awt.event.WindowEvent e) {
				SettingsControl.update();
				log.info("*** '" +
						getGui().getBundleValueByKey(
								StringHelper.APPLICATION_TITLE) + "' " +
						getGui().getBundleValueByKey(StringHelper.ENDS) + " ...");
				System.exit(0);
			}
		});
		getGui().setBundle(ResourceBundle.getBundle(getGui().getResource()));
		getGui().initLabels();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SettingsHelper.init();
		ArticleHelper.init();
		AdressHelper.init();
		PhoneHelper.init();
		BankHelper.init();
		CustomerHelper.init();
		PositionHelper.init();
		TextblockHelper.init();
		InvoiceHelper.init();
		getGui().getJTabbedPane().remove(6);
		getGui().getJTabbedPane().remove(6);
		getGui().getJTabbedPane().remove(6);
		ImageIcon icon = null;
		java.net.URL imageURL = InvoiceUI.class.getResource("/images/up.gif");
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		}
		getGui().getJButtonPosUp().setIcon(icon);
		getGui().getJButtonTBUp().setIcon(icon);
		imageURL = InvoiceUI.class.getResource("/images/down.gif");
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		}
		getGui().getJButtonPosDown().setIcon(icon);
		getGui().getJButtonTBDown().setIcon(icon);
		frame.setTitle(InvoiceUI.getGui().getBundleValueByKey(
			StringHelper.APPLICATION_TITLE));
		InvoiceUI.getGui().getJButtonAddInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.BTN_ADD));
		frame.setVisible(true);
		log.info("*** '" + InvoiceUI.getGui().getBundleValueByKey(
				StringHelper.APPLICATION_TITLE) + "' " +
				getGui().getBundleValueByKey(StringHelper.STARTS) + " ...");
	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	public void focusGained(final FocusEvent e) {
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	public void focusLost(final FocusEvent e) {
		final Component comp = e.getComponent();
		if (comp instanceof JTextField &&
				"tfInvoicePositionQuantity".equals(comp.getName())) {
//			System.out.println("TfInvoicePositionQuantity.focusLost ...");
			PositionHelper.notifyArticleSelection();
		} else if (comp instanceof JTextField &&
				"tfBookingYear".equals(comp.getName())) {
//			System.out.println("TfBookingYear.focusLost ...");
			InvoiceHelper.notifyBookingYearChanged();
			InvoiceHelper.maintainInvoiceDeselection();
		}
	}

	/**
	 * Show tab.
	 *
	 * @param tab the tab
	 * @param tabName the tab name
	 */
	public static void showTab(JPanel tab, final String tabName) {
		try {
			getGui().getJTabbedPane().remove(6);
		} catch (IndexOutOfBoundsException e) {
		}
		getGui().getJTabbedPane().add(tab, 6);
		InvoiceUI.setVisibleTabs(7);
		getGui().getJTabbedPane().setTitleAt(
				6, getGui().getBundleValueByKey(tabName));
		getGui().getJTabbedPane().setSelectedComponent(tab);
	}

	/**
	 * Gets the bundle.
	 *
	 * @return the bundle
	 */
	public ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 * Sets the bundle.
	 *
	 * @param bundle the new bundle
	 */
	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * Gets the resource.
	 *
	 * @return the resource
	 */
	public static String getResource() {
		return resource;
	}

	/**
	 * Sets the resource.
	 *
	 * @param pValue the new resource
	 */
	public static void setResource(String pValue) {
		resource = pValue;
	}
}
