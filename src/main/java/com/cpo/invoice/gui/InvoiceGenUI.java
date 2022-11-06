package com.cpo.invoice.gui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceGenUI.
 */
public class InvoiceGenUI {

	/** The j frame. */
	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="-25,-30"
	
	/** The j content pane. */
	private JPanel jContentPane = null;
	
	/** The j tabbed pane. */
	private JTabbedPane jTabbedPane = null;
	
	/** The j panel settings. */
	private JPanel jPanelSettings = null;
	
	/** The j panel invoices. */
	private JPanel jPanelInvoices = null;
	
	/** The j panel textblocks. */
	private JPanel jPanelTextblocks = null;
	
	/** The j panel banks. */
	private JPanel jPanelBanks = null;
	
	/** The j panel articles. */
	private JPanel jPanelArticles = null;
	
	/** The j panel adresses. */
	private JPanel jPanelAdresses = null;
	
	/** The lb street. */
	public JLabel lbStreet = null;
	
	/** The lb house nr. */
	public JLabel lbHouseNr = null;
	
	/** The j list adresses. */
	private JList jListAdresses = null;
	
	/** The j button add adress. */
	public JButton jButtonAddAdress = null;
	
	/** The j button delete adress. */
	public JButton jButtonDeleteAdress = null;
	
	/** The lb country code. */
	public JLabel lbCountryCode = null;
	
	/** The lb plz. */
	public JLabel lbPLZ = null;
	
	/** The lb city. */
	public JLabel lbCity = null;
	
	/** The j button update adress. */
	public JButton jButtonUpdateAdress = null;
	
	/** The tf street. */
	private JTextField tfStreet = null;
	
	/** The tf house nr. */
	private JTextField tfHouseNr = null;
	
	/** The tf country code. */
	private JTextField tfCountryCode = null;
	
	/** The tf plz. */
	private JTextField tfPLZ = null;
	
	/** The tf city. */
	private JTextField tfCity = null;
	
	/** The j list banks. */
	private JList jListBanks = null;
	
	/** The lb bank_ name. */
	public JLabel lbBank_Name = null;
	
	/** The lb account nr. */
	public JLabel lbAccountNr = null;
	
	/** The lb blz. */
	public JLabel lbBLZ = null;
	
	/** The lb iban. */
	public JLabel lbIBAN = null;
	
	/** The lb bic. */
	public JLabel lbBIC = null;
	
	/** The tf bank_ name. */
	private JTextField tfBank_Name = null;
	
	/** The tf account nr. */
	private JTextField tfAccountNr = null;
	
	/** The tf blz. */
	private JTextField tfBLZ = null;
	
	/** The tf bic. */
	private JTextField tfBIC = null;
	
	/** The tf iban. */
	private JTextField tfIBAN = null;
	
	/** The j button add bank. */
	private JButton jButtonAddBank = null;
	
	/** The j button update bank. */
	private JButton jButtonUpdateBank = null;
	
	/** The j button delete bank. */
	private JButton jButtonDeleteBank = null;
	
	/** The lb unit. */
	public JLabel lbUnit = null;
	
	/** The tf unit. */
	private JTextField tfUnit = null;
	
	/** The lb description. */
	public JLabel lbDescription = null;
	
	/** The lb unit price. */
	public JLabel lbUnitPrice = null;
	
	/** The lb article tax. */
	public JLabel lbArticleTax = null;
	
	/** The ta article description. */
	private JTextArea taArticleDescription = null;
	
	/** The tf unit price. */
	private JTextField tfUnitPrice = null;
	
	/** The j button add article. */
	private JButton jButtonAddArticle = null;
	
	/** The j list articles. */
	private JList jListArticles = null;
	
	/** The j button update article. */
	private JButton jButtonUpdateArticle = null;
	
	/** The j button delete article. */
	private JButton jButtonDeleteArticle = null;
	
	/** The j panel customers. */
	private JPanel jPanelCustomers = null;
	
	/** The lb customer name. */
	public JLabel lbCustomerName = null;
	
	/** The tf customer name. */
	private JTextField tfCustomerName = null;
	
	/** The lb customer last name. */
	public JLabel lbCustomerLastName = null;
	
	/** The tf customer last name. */
	private JTextField tfCustomerLastName = null;
	
	/** The lb customer title. */
	public JLabel lbCustomerTitle = null;
	
	/** The tf customer title. */
	private JTextField tfCustomerTitle = null;
	
	/** The lb customer uid. */
	public JLabel lbCustomerUID = null;
	
	/** The tf customer uid. */
	private JTextField tfCustomerUID = null;
	
	/** The lb customer adress. */
	public JLabel lbCustomerAdress = null;
	
	/** The lb customer bank. */
	public JLabel lbCustomerBank = null;
	
	/** The j button add customer. */
	private JButton jButtonAddCustomer = null;
	
	/** The j button update customer. */
	private JButton jButtonUpdateCustomer = null;
	
	/** The j button delete customer. */
	private JButton jButtonDeleteCustomer = null;
	
	/** The j list customers. */
	private JList jListCustomers = null;
	
	/** The lb textblock description. */
	public JLabel lbTextblockDescription = null;
	
	/** The tf textblock description. */
	private JTextField tfTextblockDescription = null;
	
	/** The lb textblock text. */
	public JLabel lbTextblockText = null;
	
	/** The j text area textblock. */
	private JTextArea jTextAreaTextblock = null;
	
	/** The j button save tb. */
	private JButton jButtonSaveTB = null;
	
	/** The lb booking year. */
	public JLabel lbBookingYear = null;
	
	/** The tf booking year. */
	private JTextField tfBookingYear = null;
	
	/** The lb invoice nr. */
	public JLabel lbInvoiceNr = null;
	
	/** The tf invoice nr. */
	private JTextField tfInvoiceNr = null;
	
	/** The lb invoice date. */
	public JLabel lbInvoiceDate = null;
	
	/** The lb invoice pay until. */
	public JLabel lbInvoicePayUntil = null;
	
	/** The lb invoice positions. */
	public JLabel lbInvoicePositions = null;
	
	/** The j list invoice positions. */
	private JList jListInvoicePositions = null;
	
	/** The j panel invoices position. */
	private JPanel jPanelInvoicesPosition = null;
	
	/** The lb invoice position invoice nr. */
	public JLabel lbInvoicePositionInvoiceNr = null;
	
	/** The tf pos invoice read only nr. */
	private JTextField tfPosInvoiceReadOnlyNr = null;
	
	/** The lb invoice position nr. */
	public JLabel lbInvoicePositionNr = null;
	
	/** The lb invoice position quantity. */
	public JLabel lbInvoicePositionQuantity = null;
	
	/** The tf invoice position nr. */
	private JTextField tfInvoicePositionNr = null;
	
	/** The tf invoice position quantity. */
	private JTextField tfInvoicePositionQuantity = null;
	
	/** The j combo box position article. */
	private JComboBox jComboBoxPositionArticle = null;
	
	/** The lb invoice position article. */
	public JLabel lbInvoicePositionArticle = null;
	
	/** The j button save position. */
	private JButton jButtonSavePosition = null;
	
	/** The lb invoice position amount. */
	public JLabel lbInvoicePositionAmount = null;
	
	/** The tf invoice position amount. */
	private JTextField tfInvoicePositionAmount = null;
	
	/** The j button add position. */
	private JButton jButtonAddPosition = null;
	
	/** The j button update position. */
	private JButton jButtonUpdatePosition = null;
	
	/** The j button delete position. */
	private JButton jButtonDeletePosition = null;
	
	/** The j panel invoice. */
	private JPanel jPanelInvoice = null;
	
	/** The j button add invoice. */
	private JButton jButtonAddInvoice = null;
	
	/** The j button update invoice. */
	private JButton jButtonUpdateInvoice = null;
	
	/** The j button delete invoice. */
	private JButton jButtonDeleteInvoice = null;
	
	/** The j list invoices. */
	private JList jListInvoices = null;
	
	/** The j panel adress. */
	private JPanel jPanelAdress = null;
	
	/** The lb invoice sender. */
	public JLabel lbInvoiceSender = null;
	
	/** The checkbox sender. */
	private Checkbox checkboxSender = null;
	
	/** The j panel bank. */
	private JPanel jPanelBank = null;
	
	/** The j panel customer. */
	private JPanel jPanelCustomer = null;
	
	/** The j panel article. */
	private JPanel jPanelArticle = null;
	
	/** The j panel textblock. */
	private JPanel jPanelTextblock = null;
	
	/** The lb invoice receiver. */
	public JLabel lbInvoiceReceiver = null;
	
	/** The j combo box receiver. */
	private JComboBox jComboBoxReceiver = null;
	
	/** The j scroll pane customers. */
	private JScrollPane jScrollPaneCustomers = null;
	
	/** The j scroll pane adresses. */
	private JScrollPane jScrollPaneAdresses = null;
	
	/** The j scroll pane invoices. */
	private JScrollPane jScrollPaneInvoices = null;
	
	/** The j scroll pane invoice positions. */
	private JScrollPane jScrollPaneInvoicePositions = null;
	
	/** The j scroll pane banks. */
	private JScrollPane jScrollPaneBanks = null;
	
	/** The j scroll pane articles. */
	private JScrollPane jScrollPaneArticles = null;
	
	/** The j combo box sender. */
	private JComboBox jComboBoxSender = null;
	
	/** The lb invoice t bs. */
	public JLabel lbInvoiceTBs = null;
	
	/** The j scroll pane invoice t bs. */
	private JScrollPane jScrollPaneInvoiceTBs = null;
	
	/** The j list invoice t bs. */
	private JList jListInvoiceTBs = null;
	
	/** The j button add invoice tb. */
	private JButton jButtonAddInvoiceTB = null;
	
	/** The j button update invoice tb. */
	private JButton jButtonUpdateInvoiceTB = null;
	
	/** The j button delete invoice tb. */
	private JButton jButtonDeleteInvoiceTB = null;
	
	/** The lb tb invoice nr. */
	public JLabel lbTBInvoiceNr = null;
	
	/** The tf tb invoice read only nr. */
	private JTextField tfTBInvoiceReadOnlyNr = null;
	
	/** The j button print invoice. */
	private JButton jButtonPrintInvoice = null;
	
	/** The lb textblock nr. */
	public JLabel lbTextblockNr = null;
	
	/** The tf tb nr. */
	private JTextField tfTBNr = null;
	
	/** The lb customer tax nr. */
	public JLabel lbCustomerTaxNr = null;
	
	/** The tf customer tax nr. */
	private JTextField tfCustomerTaxNr = null;
	
	/** The lb tax1. */
	public JLabel lbTax1 = null;
	
	/** The tf tax1. */
	private JTextField tfTax1 = null;
	
	/** The lb tax2. */
	public JLabel lbTax2 = null;
	
	/** The lb tax3. */
	public JLabel lbTax3 = null;
	
	/** The tf tax2. */
	private JTextField tfTax2 = null;
	
	/** The tf tax3. */
	private JTextField tfTax3 = null;
	
	/** The lb customer phone. */
	public JLabel lbCustomerPhone = null;
	
	/** The j combo box article tax. */
	private JComboBox jComboBoxArticleTax = null;
	
	/** The lb settings invoice nr. */
	public JLabel lbSettingsInvoiceNr = null;
	
	/** The tf settings invoice nr. */
	private JTextField tfSettingsInvoiceNr = null;
	
	/** The j combo box language. */
	private JComboBox jComboBoxLanguage = null;
	
	/** The lb language. */
	public JLabel lbLanguage = null;
	
	/** The j panel invoice position. */
	private JPanel jPanelInvoicePosition = null;
	
	/** The j panel settings area. */
	private JPanel jPanelSettingsArea = null;
	
	/** The j panel phones. */
	private JPanel jPanelPhones = null;
	
	/** The j panel phone1. */
	private JPanel jPanelPhone1 = null;
	
	/** The lb type. */
	public JLabel lbType = null;
	
	/** The lb nr. */
	public JLabel lbNr = null;
	
	/** The tf nr1. */
	public JTextField tfNr1 = null;
	
	/** The lb call nr. */
	public JLabel lbCallNr = null;
	
	/** The tf call nr1. */
	public JTextField tfCallNr1 = null;
	
	/** The j combo box phone type1. */
	public JComboBox jComboBoxPhoneType1 = null;
	
	/** The j scroll pane phones1. */
	private JScrollPane jScrollPanePhones1 = null;
	
	/** The j list phones1. */
	private JList jListPhones1 = null;
	
	/** The j button add phone1. */
	private JButton jButtonAddPhone1 = null;
	
	/** The j button update phone1. */
	private JButton jButtonUpdatePhone1 = null;
	
	/** The j button delete phone1. */
	private JButton jButtonDeletePhone1 = null;
	
	/** The tf customer phone. */
	private JTextField tfCustomerPhone = null;
	
	/** The j button modify customer phone. */
	private JButton jButtonModifyCustomerPhone = null;
	
	/** The j button modify customer adress. */
	private JButton jButtonModifyCustomerAdress = null;
	
	/** The j button modify customer bank. */
	private JButton jButtonModifyCustomerBank = null;
	
	/** The lb phone customer. */
	public JLabel lbPhoneCustomer = null;
	
	/** The tf phone customer. */
	private JTextField tfPhoneCustomer = null;
	
	/** The lb currency. */
	public JLabel lbCurrency = null;
	
	/** The j combo box currency. */
	private JComboBox jComboBoxCurrency = null;
	
	/** The tf customer adress. */
	private JTextField tfCustomerAdress = null;
	
	/** The tf customer bank. */
	private JTextField tfCustomerBank = null;
	
	/** The lb adress customer. */
	public JLabel lbAdressCustomer = null;
	
	/** The tf adress customer. */
	private JTextField tfAdressCustomer = null;
	
	/** The lb bank customer. */
	public JLabel lbBankCustomer = null;
	
	/** The tf bank customer. */
	private JTextField tfBankCustomer = null;
	
	/** The j date chooser date. */
	private JDateChooser jDateChooserDate = null;
	
	/** The j date chooser pay until. */
	private JDateChooser jDateChooserPayUntil = null;
	
	/** The j button assign adress. */
	private JButton jButtonAssignAdress = null;
	
	/** The j button assign phone. */
	private JButton jButtonAssignPhone = null;
	
	/** The j button assign bank. */
	private JButton jButtonAssignBank = null;
	
	/** The j button pos up. */
	private JButton jButtonPosUp = null;
	
	/** The j button pos down. */
	private JButton jButtonPosDown = null;
	
	/** The j button tb up. */
	private JButton jButtonTBUp = null;
	
	/** The j button tb down. */
	private JButton jButtonTBDown = null;
	
	/** The lb iba ntxt. */
	private JLabel lbIBANtxt = null;
	
	/** The lb bi ctxt. */
	private JLabel lbBICtxt = null;
	
	/**
	 * This method initializes jFrame.
	 *
	 * @return javax.swing.JFrame
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setBackground(new Color(184, 227, 229));
			jFrame.setTitle("Invoice Maker 1.0");
			jFrame.setBounds(new Rectangle(0, 0, 1024, 760));
			jFrame.setContentPane(getJContentPane());
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.X_AXIS));
			jContentPane.setBackground(new Color(184, 207, 229));
			jContentPane.setPreferredSize(new Dimension(1010, 760));
			jContentPane.add(getJTabbedPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPane.
	 *
	 * @return javax.swing.JTabbedPane
	 */
	public JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
			jTabbedPane.setPreferredSize(new Dimension(1010, 760));
			jTabbedPane.addTab("Settings", null, getJPanelSettings(), null);
			jTabbedPane.addTab("Invoices", null, getJPanelInvoices(), null);
			jTabbedPane.addTab("Invoice Position", null, getJPanelInvoicesPosition(), null);
			jTabbedPane.addTab("Textblock", null, getJPanelTextblocks(), null);
			jTabbedPane.addTab("Articles", null, getJPanelArticles(), null);
			jTabbedPane.addTab("Customers", null, getJPanelCustomers(), null);
			jTabbedPane.addTab("Banks", null, getJPanelBanks(), null);
			jTabbedPane.addTab("Adresses", null, getJPanelAdresses(), null);
			jTabbedPane.addTab("Phones", null, getJPanelPhones(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanelSettings.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelSettings() {
		if (jPanelSettings == null) {
			lbLanguage = new JLabel();
			lbLanguage.setText("Language");
			lbLanguage.setBounds(new Rectangle(10, 220, 111, 21));
			lbSettingsInvoiceNr = new JLabel();
			lbSettingsInvoiceNr.setText("Invoice Nr.");
			lbSettingsInvoiceNr.setBounds(new Rectangle(10, 30, 111, 21));
			lbTax3 = new JLabel();
			lbTax3.setText("Tax 3 (%)");
			lbTax3.setBounds(new Rectangle(10, 120, 111, 21));
			lbTax2 = new JLabel();
			lbTax2.setText("Tax 2 (%)");
			lbTax2.setBounds(new Rectangle(10, 90, 111, 21));
			lbTax1 = new JLabel();
			lbTax1.setText("Tax 1 (%)");
			lbTax1.setBounds(new Rectangle(10, 60, 111, 21));
			lbBookingYear = new JLabel();
			lbBookingYear.setText("Booking Year");
			lbBookingYear.setBounds(new Rectangle(10, 190, 111, 21));
			jPanelSettings = new JPanel();
			jPanelSettings.setLayout(null);
			jPanelSettings.add(getJPanelSettingsArea(), null);
		}
		return jPanelSettings;
	}

	/**
	 * This method initializes jPanelInvoices.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelInvoices() {
		if (jPanelInvoices == null) {
			lbInvoicePositions = new JLabel();
			lbInvoicePositions.setText("Invoice Positions");
			lbInvoicePositions.setBounds(new Rectangle(10, 120, 121, 21));
			lbInvoicePayUntil = new JLabel();
			lbInvoicePayUntil.setText("Pay Until");
			lbInvoicePayUntil.setBounds(new Rectangle(10, 90, 121, 21));
			lbInvoiceDate = new JLabel();
			lbInvoiceDate.setText("Date");
			lbInvoiceDate.setBounds(new Rectangle(10, 60, 121, 21));
			lbInvoiceNr = new JLabel();
			lbInvoiceNr.setText("Invoice Nr.");
			lbInvoiceNr.setBounds(new Rectangle(10, 30, 121, 21));
			jPanelInvoices = new JPanel();
			jPanelInvoices.setLayout(null);
			jPanelInvoices.add(getJPanelInvoice(), null);
			jPanelInvoices.add(getJScrollPaneInvoices(), null);
			jPanelInvoices.add(getJButtonAddInvoice(), null);
			jPanelInvoices.add(getJButtonUpdateInvoice(), null);
			jPanelInvoices.add(getJButtonDeleteInvoice(), null);
			jPanelInvoices.add(getJButtonPrintInvoice(), null);
		}
		return jPanelInvoices;
	}

	/**
	 * This method initializes jPanelTextblocks.
	 *
	 * @return javax.swing.JPanel
	 */
	JPanel getJPanelTextblocks() {
		if (jPanelTextblocks == null) {
			lbTextblockText = new JLabel();
			lbTextblockText.setText("Text");
			lbTextblockText.setBounds(new Rectangle(10, 90, 111, 21));
			lbTextblockDescription = new JLabel();
			lbTextblockDescription.setText("Description");
			lbTextblockDescription.setBounds(new Rectangle(10, 60, 111, 21));
			jPanelTextblocks = new JPanel();
			jPanelTextblocks.setLayout(null);
			jPanelTextblocks.add(getJButtonSaveTB(), null);
			jPanelTextblocks.add(getJPanelTextblock(), null);
		}
		return jPanelTextblocks;
	}

	/**
	 * This method initializes jPanelBanks.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelBanks() {
		if (jPanelBanks == null) {
			lbBIC = new JLabel();
			lbBIC.setText("BIC");
			lbBIC.setBounds(new Rectangle(10, 150, 111, 21));
			lbIBAN = new JLabel();
			lbIBAN.setText("IBAN");
			lbIBAN.setBounds(new Rectangle(10, 180, 111, 21));
			lbBLZ = new JLabel();
			lbBLZ.setText("BLZ");
			lbBLZ.setBounds(new Rectangle(10, 120, 111, 21));
			lbAccountNr = new JLabel();
			lbAccountNr.setText("Account Nr");
			lbAccountNr.setBounds(new Rectangle(10, 90, 111, 21));
			lbBank_Name = new JLabel();
			lbBank_Name.setText("Name");
			lbBank_Name.setBounds(new Rectangle(10, 60, 111, 21));
			jPanelBanks = new JPanel();
			jPanelBanks.setLayout(null);
			jPanelBanks.add(getJButtonAddBank(), null);
			jPanelBanks.add(getJButtonUpdateBank(), null);
			jPanelBanks.add(getJButtonDeleteBank(), null);
			jPanelBanks.add(getJPanelBank(), null);
			jPanelBanks.add(getJScrollPaneBanks(), null);
		}
		return jPanelBanks;
	}

	/**
	 * This method initializes jPanel14.
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelArticles() {
		if (jPanelArticles == null) {
			lbArticleTax = new JLabel();
			lbArticleTax.setText("Tax");
			lbArticleTax.setBounds(new Rectangle(10, 170, 111, 21));
			lbUnitPrice = new JLabel();
			lbUnitPrice.setText("Unit Price");
			lbUnitPrice.setBounds(new Rectangle(10, 140, 111, 21));
			lbDescription = new JLabel();
			lbDescription.setText("Description");
			lbDescription.setBounds(new Rectangle(10, 60, 111, 21));
			lbUnit = new JLabel();
			lbUnit.setText("Unit");
			lbUnit.setBounds(new Rectangle(10, 30, 111, 21));
			jPanelArticles = new JPanel();
			jPanelArticles.setLayout(null);
			jPanelArticles.add(getJButtonAddArticle(), null);
			jPanelArticles.add(getJButtonUpdateArticle(), null);
			jPanelArticles.add(getJButtonDeleteArticle(), null);
			jPanelArticles.add(getJPanelArticle(), null);
			jPanelArticles.add(getJScrollPaneArticles(), null);
		}
		return jPanelArticles;
	}

	/**
	 * This method initializes jPanelAdresses.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelAdresses() {
		if (jPanelAdresses == null) {
			lbCity = new JLabel();
			lbCity.setText("City");
			lbCity.setBounds(new Rectangle(10, 180, 111, 21));
			lbPLZ = new JLabel();
			lbPLZ.setText("PLZ");
			lbPLZ.setBounds(new Rectangle(10, 150, 111, 21));
			lbCountryCode = new JLabel();
			lbCountryCode.setText("CountryCode");
			lbCountryCode.setBounds(new Rectangle(10, 120, 111, 21));
			lbHouseNr = new JLabel();
			lbHouseNr.setText("HouseNr");
			lbHouseNr.setBounds(new Rectangle(10, 90, 111, 21));
			lbStreet = new JLabel();
			lbStreet.setText("Street");
			lbStreet.setBounds(new Rectangle(10, 60, 111, 21));
			jPanelAdresses = new JPanel();
			jPanelAdresses.setLayout(null);
			jPanelAdresses.add(getJPanelAdress(), null);
			jPanelAdresses.add(getJButtonDeleteAdress(), null);
			jPanelAdresses.add(getJButtonAddAdress(), null);
			jPanelAdresses.add(getJButtonUpdateAdress(), null);
			jPanelAdresses.add(getJScrollPaneAdresses(), null);
		}
		return jPanelAdresses;
	}

	/**
	 * This method initializes jListAdresses.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListAdresses() {
		if (jListAdresses == null) {
			jListAdresses = new JList();
			jListAdresses.setBounds(new Rectangle(0, 0, 691, 208));
			jListAdresses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListAdresses;
	}

	/**
	 * This method initializes jButtonAddAdress.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddAdress() {
		if (jButtonAddAdress == null) {
			jButtonAddAdress = new JButton();
			jButtonAddAdress.setActionCommand("AddAdress");
			jButtonAddAdress.setBounds(new Rectangle(10, 270, 121, 21));
			jButtonAddAdress.setText("Add");
		}
		return jButtonAddAdress;
	}

	/**
	 * This method initializes jButtonDeleteAdress.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteAdress() {
		if (jButtonDeleteAdress == null) {
			jButtonDeleteAdress = new JButton();
			jButtonDeleteAdress.setActionCommand("DeleteAdress");
			jButtonDeleteAdress.setBounds(new Rectangle(270, 270, 121, 21));
			jButtonDeleteAdress.setText("Delete");
		}
		return jButtonDeleteAdress;
	}

	/**
	 * This method initializes jButtonUpdateAdress.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateAdress() {
		if (jButtonUpdateAdress == null) {
			jButtonUpdateAdress = new JButton();
			jButtonUpdateAdress.setActionCommand("UpdateAdress");
			jButtonUpdateAdress.setBounds(new Rectangle(140, 270, 121, 21));
			jButtonUpdateAdress.setText("Update");
		}
		return jButtonUpdateAdress;
	}

	/**
	 * This method initializes tfStreet.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfStreet() {
		if (tfStreet == null) {
			tfStreet = new JTextField();
			tfStreet.setBounds(new Rectangle(130, 60, 291, 21));
		}
		return tfStreet;
	}

	/**
	 * This method initializes tfHouseNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfHouseNr() {
		if (tfHouseNr == null) {
			tfHouseNr = new JTextField();
			tfHouseNr.setBounds(new Rectangle(130, 90, 131, 21));
		}
		return tfHouseNr;
	}

	/**
	 * This method initializes tfCountryCode.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCountryCode() {
		if (tfCountryCode == null) {
			tfCountryCode = new JTextField();
			tfCountryCode.setBounds(new Rectangle(130, 120, 26, 21));
		}
		return tfCountryCode;
	}

	/**
	 * This method initializes tfPLZ.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfPLZ() {
		if (tfPLZ == null) {
			tfPLZ = new JTextField();
			tfPLZ.setBounds(new Rectangle(130, 150, 131, 21));
		}
		return tfPLZ;
	}

	/**
	 * This method initializes tfCity.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCity() {
		if (tfCity == null) {
			tfCity = new JTextField();
			tfCity.setBounds(new Rectangle(130, 180, 271, 21));
		}
		return tfCity;
	}

	/**
	 * This method initializes jListBanks.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListBanks() {
		if (jListBanks == null) {
			jListBanks = new JList();
			jListBanks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListBanks;
	}

	/**
	 * This method initializes tfBank_Name.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfBank_Name() {
		if (tfBank_Name == null) {
			tfBank_Name = new JTextField();
			tfBank_Name.setBounds(new Rectangle(130, 60, 321, 21));
		}
		return tfBank_Name;
	}

	/**
	 * This method initializes tfAccountNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfAccountNr() {
		if (tfAccountNr == null) {
			tfAccountNr = new JTextField();
			tfAccountNr.setBounds(new Rectangle(130, 90, 251, 20));
		}
		return tfAccountNr;
	}

	/**
	 * This method initializes tfBLZ.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfBLZ() {
		if (tfBLZ == null) {
			tfBLZ = new JTextField();
			tfBLZ.setBounds(new Rectangle(130, 120, 101, 20));
		}
		return tfBLZ;
	}

	/**
	 * This method initializes tfBIC.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfBIC() {
		if (tfBIC == null) {
			tfBIC = new JTextField();
			tfBIC.setBounds(new Rectangle(130, 150, 251, 20));
		}
		return tfBIC;
	}

	/**
	 * This method initializes tfIBAN.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfIBAN() {
		if (tfIBAN == null) {
			tfIBAN = new JTextField();
			tfIBAN.setBounds(new Rectangle(130, 180, 251, 20));
		}
		return tfIBAN;
	}

	/**
	 * This method initializes jButtonAddBank.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddBank() {
		if (jButtonAddBank == null) {
			jButtonAddBank = new JButton();
			jButtonAddBank.setBounds(new Rectangle(10, 260, 121, 21));
			jButtonAddBank.setText("Add");
			jButtonAddBank.setActionCommand("AddAdress");
		}
		return jButtonAddBank;
	}

	/**
	 * This method initializes jButtonUpdateBank.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateBank() {
		if (jButtonUpdateBank == null) {
			jButtonUpdateBank = new JButton();
			jButtonUpdateBank.setBounds(new Rectangle(140, 260, 121, 21));
			jButtonUpdateBank.setText("Update");
			jButtonUpdateBank.setActionCommand("AddAdress");
		}
		return jButtonUpdateBank;
	}

	/**
	 * This method initializes jButtonDeleteBank.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteBank() {
		if (jButtonDeleteBank == null) {
			jButtonDeleteBank = new JButton();
			jButtonDeleteBank.setBounds(new Rectangle(270, 260, 121, 21));
			jButtonDeleteBank.setText("Delete");
			jButtonDeleteBank.setActionCommand("AddAdress");
		}
		return jButtonDeleteBank;
	}

	/**
	 * This method initializes tfUnit.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfUnit() {
		if (tfUnit == null) {
			tfUnit = new JTextField();
			tfUnit.setBounds(new Rectangle(130, 30, 131, 21));
		}
		return tfUnit;
	}

	/**
	 * This method initializes taArticleDescription.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextArea getTaArticleDescription() {
		if (taArticleDescription == null) {
			taArticleDescription = new JTextArea();
			taArticleDescription.setBounds(new Rectangle(130, 60, 431, 71));
			taArticleDescription.setLineWrap(true);
		}
		return taArticleDescription;
	}

	/**
	 * This method initializes tfUnitPrice.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfUnitPrice() {
		if (tfUnitPrice == null) {
			tfUnitPrice = new JTextField();
			tfUnitPrice.setBounds(new Rectangle(130, 140, 131, 21));
		}
		return tfUnitPrice;
	}

	/**
	 * This method initializes jButtonAddArticle.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddArticle() {
		if (jButtonAddArticle == null) {
			jButtonAddArticle = new JButton();
			jButtonAddArticle.setBounds(new Rectangle(10, 240, 121, 21));
			jButtonAddArticle.setText("Add");
			jButtonAddArticle.setActionCommand("AddArticle");
		}
		return jButtonAddArticle;
	}

	/**
	 * This method initializes jListArticles.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListArticles() {
		if (jListArticles == null) {
			jListArticles = new JList();
			jListArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListArticles;
	}

	/**
	 * This method initializes jButtonUpdateArticle.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateArticle() {
		if (jButtonUpdateArticle == null) {
			jButtonUpdateArticle = new JButton();
			jButtonUpdateArticle.setBounds(new Rectangle(140, 240, 121, 21));
			jButtonUpdateArticle.setText("Update");
			jButtonUpdateArticle.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButtonUpdateArticle.setActionCommand("AddArticle");
		}
		return jButtonUpdateArticle;
	}

	/**
	 * This method initializes jButtonDeleteArticle.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteArticle() {
		if (jButtonDeleteArticle == null) {
			jButtonDeleteArticle = new JButton();
			jButtonDeleteArticle.setBounds(new Rectangle(270, 240, 121, 21));
			jButtonDeleteArticle.setActionCommand("AddArticle");
			jButtonDeleteArticle.setText("Delete");
			jButtonDeleteArticle.setMnemonic(KeyEvent.VK_UNDEFINED);
		}
		return jButtonDeleteArticle;
	}

	/**
	 * This method initializes jPanelCustomers.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelCustomers() {
		if (jPanelCustomers == null) {
			lbCustomerBank = new JLabel();
			lbCustomerBank.setText("Bank");
			lbCustomerBank.setBounds(new Rectangle(10, 240, 151, 21));
			lbCustomerAdress = new JLabel();
			lbCustomerAdress.setText("Adress");
			lbCustomerAdress.setBounds(new Rectangle(10, 180, 151, 21));
			lbCustomerUID = new JLabel();
			lbCustomerUID.setText("UID");
			lbCustomerUID.setBounds(new Rectangle(10, 120, 151, 21));
			lbCustomerTitle = new JLabel();
			lbCustomerTitle.setText("Title");
			lbCustomerTitle.setBounds(new Rectangle(10, 30, 151, 21));
			lbCustomerLastName = new JLabel();
			lbCustomerLastName.setText("Last Name");
			lbCustomerLastName.setBounds(new Rectangle(10, 90, 151, 21));
			lbCustomerName = new JLabel();
			lbCustomerName.setText("Name");
			lbCustomerName.setBounds(new Rectangle(10, 60, 151, 21));
			jPanelCustomers = new JPanel();
			jPanelCustomers.setLayout(null);
			jPanelCustomers.add(getJButtonAddCustomer(), null);
			jPanelCustomers.add(getJButtonUpdateCustomer(), null);
			jPanelCustomers.add(getJButtonDeleteCustomer(), null);
			jPanelCustomers.add(getJPanelCustomer(), null);
			jPanelCustomers.add(getJScrollPaneCustomers(), null);
		}
		return jPanelCustomers;
	}

	/**
	 * This method initializes tfCustomerName.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerName() {
		if (tfCustomerName == null) {
			tfCustomerName = new JTextField();
			tfCustomerName.setBounds(new Rectangle(170, 60, 451, 21));
		}
		return tfCustomerName;
	}

	/**
	 * This method initializes tfCustomerLastName.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerLastName() {
		if (tfCustomerLastName == null) {
			tfCustomerLastName = new JTextField();
			tfCustomerLastName.setBounds(new Rectangle(170, 90, 451, 21));
		}
		return tfCustomerLastName;
	}

	/**
	 * This method initializes tfCustomerTitle.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerTitle() {
		if (tfCustomerTitle == null) {
			tfCustomerTitle = new JTextField();
			tfCustomerTitle.setBounds(new Rectangle(170, 30, 201, 21));
		}
		return tfCustomerTitle;
	}

	/**
	 * This method initializes tfCustomerUID.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerUID() {
		if (tfCustomerUID == null) {
			tfCustomerUID = new JTextField();
			tfCustomerUID.setBounds(new Rectangle(170, 120, 221, 21));
		}
		return tfCustomerUID;
	}

	/**
	 * This method initializes jButtonAddCustomer.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddCustomer() {
		if (jButtonAddCustomer == null) {
			jButtonAddCustomer = new JButton();
			jButtonAddCustomer.setBounds(new Rectangle(10, 320, 121, 21));
			jButtonAddCustomer.setText("Add");
			jButtonAddCustomer.setActionCommand("AddCustomer");
		}
		return jButtonAddCustomer;
	}

	/**
	 * This method initializes jButtonUpdateCustomer.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateCustomer() {
		if (jButtonUpdateCustomer == null) {
			jButtonUpdateCustomer = new JButton();
			jButtonUpdateCustomer.setBounds(new Rectangle(140, 320, 121, 21));
			jButtonUpdateCustomer.setText("Update");
			jButtonUpdateCustomer.setActionCommand("UpdateCustomer");
		}
		return jButtonUpdateCustomer;
	}

	/**
	 * This method initializes jButtonDeleteCustomer.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteCustomer() {
		if (jButtonDeleteCustomer == null) {
			jButtonDeleteCustomer = new JButton();
			jButtonDeleteCustomer.setBounds(new Rectangle(270, 320, 121, 21));
			jButtonDeleteCustomer.setText("Delete");
			jButtonDeleteCustomer.setActionCommand("DeleteCustomer");
		}
		return jButtonDeleteCustomer;
	}

	/**
	 * This method initializes jListCustomers.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListCustomers() {
		if (jListCustomers == null) {
			jListCustomers = new JList();
			jListCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jListCustomers.setBounds(new Rectangle(0, 0, 671, 208));
		}
		return jListCustomers;
	}

	/**
	 * This method initializes tfTextblockDescription.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTextblockDescription() {
		if (tfTextblockDescription == null) {
			tfTextblockDescription = new JTextField();
			tfTextblockDescription.setBounds(new Rectangle(130, 60, 541, 20));
		}
		return tfTextblockDescription;
	}

	/**
	 * This method initializes jTextAreaTextblock.
	 *
	 * @return javax.swing.JTextArea
	 */
	public JTextArea getJTextAreaTextblock() {
		if (jTextAreaTextblock == null) {
			jTextAreaTextblock = new JTextArea();
			jTextAreaTextblock.setBounds(new Rectangle(130, 90, 541, 101));
		}
		return jTextAreaTextblock;
	}

	/**
	 * This method initializes jButtonSaveTB.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonSaveTB() {
		if (jButtonSaveTB == null) {
			jButtonSaveTB = new JButton();
			jButtonSaveTB.setBounds(new Rectangle(10, 260, 131, 21));
			jButtonSaveTB.setText("Save");
			jButtonSaveTB.setEnabled(false);
			jButtonSaveTB.setActionCommand("DeleteTextblock");
		}
		return jButtonSaveTB;
	}

	/**
	 * This method initializes tfBookingYear.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfBookingYear() {
		if (tfBookingYear == null) {
			tfBookingYear = new JTextField();
			tfBookingYear.setName("tfBookingYear");
			tfBookingYear.setBounds(new Rectangle(130, 190, 101, 21));
			tfBookingYear.setText("");
		}
		return tfBookingYear;
	}

	/**
	 * This method initializes tfInvoiceNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfInvoiceNr() {
		if (tfInvoiceNr == null) {
			tfInvoiceNr = new JTextField();
			tfInvoiceNr.setBounds(new Rectangle(140, 30, 151, 21));
			tfInvoiceNr.setToolTipText("use pattern [A-Z]{1}(\\d{2})\\.(\\d{3}) and no 0 as last char");
		}
		return tfInvoiceNr;
	}

	/**
	 * This method initializes jListInvoicePositions.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListInvoicePositions() {
		if (jListInvoicePositions == null) {
			jListInvoicePositions = new JList();
			jListInvoicePositions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListInvoicePositions;
	}

	/**
	 * This method initializes jPanelInvoicesPosition.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelInvoicesPosition() {
		if (jPanelInvoicesPosition == null) {
			lbInvoicePositionAmount = new JLabel();
			lbInvoicePositionAmount.setText("Amount");
			lbInvoicePositionAmount.setBounds(new Rectangle(10, 120, 111, 21));
			lbInvoicePositionArticle = new JLabel();
			lbInvoicePositionArticle.setText("Article");
			lbInvoicePositionArticle.setBounds(new Rectangle(10, 60, 111, 21));
			lbInvoicePositionQuantity = new JLabel();
			lbInvoicePositionQuantity.setText("Quantity");
			lbInvoicePositionQuantity.setBounds(new Rectangle(10, 90, 111, 21));
			lbInvoicePositionNr = new JLabel();
			lbInvoicePositionNr.setText("Position Nr.");
			lbInvoicePositionNr.setBounds(new Rectangle(10, 170, 111, 21));
			lbInvoicePositionNr.setVisible(false);
			lbInvoicePositionInvoiceNr = new JLabel();
			lbInvoicePositionInvoiceNr.setText("Invoice Nr.");
			lbInvoicePositionInvoiceNr.setBounds(new Rectangle(10, 30, 111, 21));
			jPanelInvoicesPosition = new JPanel();
			jPanelInvoicesPosition.setLayout(null);
			jPanelInvoicesPosition.setToolTipText("");
			jPanelInvoicesPosition.add(getJButtonSavePosition(), null);
			jPanelInvoicesPosition.add(getJPanelInvoicePosition(), null);
		}
		return jPanelInvoicesPosition;
	}

	/**
	 * This method initializes tfPosInvoiceReadOnlyNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfPosInvoiceReadOnlyNr() {
		if (tfPosInvoiceReadOnlyNr == null) {
			tfPosInvoiceReadOnlyNr = new JTextField();
			tfPosInvoiceReadOnlyNr.setEnabled(false);
			tfPosInvoiceReadOnlyNr.setBounds(new Rectangle(130, 30, 321, 21));
			tfPosInvoiceReadOnlyNr.setEditable(false);
		}
		return tfPosInvoiceReadOnlyNr;
	}

	/**
	 * This method initializes tfInvoicePositionNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfInvoicePositionNr() {
		if (tfInvoicePositionNr == null) {
			tfInvoicePositionNr = new JTextField();
			tfInvoicePositionNr.setBounds(new Rectangle(130, 170, 161, 21));
			tfInvoicePositionNr.setVisible(false);
		}
		return tfInvoicePositionNr;
	}

	/**
	 * This method initializes tfInvoicePositionQuantity.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfInvoicePositionQuantity() {
		if (tfInvoicePositionQuantity == null) {
			tfInvoicePositionQuantity = new JTextField();
			tfInvoicePositionQuantity.setName("tfInvoicePositionQuantity");
			tfInvoicePositionQuantity.setBounds(new Rectangle(130, 90, 161, 21));
		}
		return tfInvoicePositionQuantity;
	}

	/**
	 * This method initializes jComboBoxPositionArticle.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxPositionArticle() {
		if (jComboBoxPositionArticle == null) {
			jComboBoxPositionArticle = new JComboBox();
			jComboBoxPositionArticle.setBounds(new Rectangle(130, 60, 551, 21));
		}
		return jComboBoxPositionArticle;
	}

	/**
	 * This method initializes jButtonSavePosition.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonSavePosition() {
		if (jButtonSavePosition == null) {
			jButtonSavePosition = new JButton();
			jButtonSavePosition.setBounds(new Rectangle(10, 220, 131, 21));
			jButtonSavePosition.setText("Save");
			jButtonSavePosition.setEnabled(false);
			jButtonSavePosition.setActionCommand("AddAdress");
		}
		return jButtonSavePosition;
	}

	/**
	 * This method initializes tfInvoicePositionAmount.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfInvoicePositionAmount() {
		if (tfInvoicePositionAmount == null) {
			tfInvoicePositionAmount = new JTextField();
			tfInvoicePositionAmount.setEditable(false);
			tfInvoicePositionAmount.setBounds(new Rectangle(130, 120, 161, 21));
			tfInvoicePositionAmount.setEnabled(false);
		}
		return tfInvoicePositionAmount;
	}

	/**
	 * This method initializes jButtonAddPosition.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddPosition() {
		if (jButtonAddPosition == null) {
			jButtonAddPosition = new JButton();
			jButtonAddPosition.setText("Add");
			jButtonAddPosition.setBounds(new Rectangle(10, 150, 121, 21));
			jButtonAddPosition.setActionCommand("AddPosition");
		}
		return jButtonAddPosition;
	}

	/**
	 * This method initializes jButtonUpdatePosition.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdatePosition() {
		if (jButtonUpdatePosition == null) {
			jButtonUpdatePosition = new JButton();
			jButtonUpdatePosition.setText("Update");
			jButtonUpdatePosition.setBounds(new Rectangle(10, 180, 121, 21));
			jButtonUpdatePosition.setEnabled(false);
			jButtonUpdatePosition.setActionCommand("UpdatePosition");
		}
		return jButtonUpdatePosition;
	}

	/**
	 * This method initializes jButtonDeletePosition.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeletePosition() {
		if (jButtonDeletePosition == null) {
			jButtonDeletePosition = new JButton();
			jButtonDeletePosition.setText("Delete");
			jButtonDeletePosition.setBounds(new Rectangle(10, 210, 121, 21));
			jButtonDeletePosition.setActionCommand("DeletePosition");
		}
		return jButtonDeletePosition;
	}

	/**
	 * This method initializes jPanelInvoice.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelInvoice() {
		if (jPanelInvoice == null) {
			lbInvoiceTBs = new JLabel();
			lbInvoiceTBs.setBounds(new Rectangle(10, 270, 121, 21));
			lbInvoiceTBs.setText("Textblocks");
			lbInvoiceReceiver = new JLabel();
			lbInvoiceReceiver.setBounds(new Rectangle(300, 90, 91, 21));
			lbInvoiceReceiver.setText("Receiver");
			lbInvoiceSender = new JLabel();
			lbInvoiceSender.setBounds(new Rectangle(300, 60, 91, 21));
			lbInvoiceSender.setText("Sender");
			jPanelInvoice = new JPanel();
			jPanelInvoice.setLayout(null);
			jPanelInvoice.setBounds(new Rectangle(10, 10, 831, 421));
			jPanelInvoice.setBorder(BorderFactory.createTitledBorder(null, "Invoice", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelInvoice.add(lbInvoiceNr, null);
			jPanelInvoice.add(getTfInvoiceNr(), null);
			jPanelInvoice.add(lbInvoiceDate, null);
			jPanelInvoice.add(lbInvoicePayUntil, null);
			jPanelInvoice.add(lbInvoicePositions, null);
			jPanelInvoice.add(getJButtonAddPosition(), null);
			jPanelInvoice.add(getJButtonUpdatePosition(), null);
			jPanelInvoice.add(getJButtonDeletePosition(), null);
			jPanelInvoice.add(lbInvoiceSender, null);
			jPanelInvoice.add(lbInvoiceReceiver, null);
			jPanelInvoice.add(getJComboBoxReceiver(), null);
			jPanelInvoice.add(getJScrollPaneInvoicePositions(), null);
			jPanelInvoice.add(getJComboBoxSender(), null);
			jPanelInvoice.add(lbInvoiceTBs, null);
			jPanelInvoice.add(getJScrollPaneInvoiceTBs(), null);
			jPanelInvoice.add(getJButtonAddInvoiceTB(), null);
			jPanelInvoice.add(getJButtonUpdateInvoiceTB(), null);
			jPanelInvoice.add(getJButtonDeleteInvoiceTB(), null);
			jPanelInvoice.add(getJDateChooserDate(), null);
			jPanelInvoice.add(getJDateChooserPayUntil(), null);
			jPanelInvoice.add(getJButtonPosUp(), null);
			jPanelInvoice.add(getJButtonPosDown(), null);
			jPanelInvoice.add(getJButtonTBUp(), null);
			jPanelInvoice.add(getJButtonTBDown(), null);
		}
		return jPanelInvoice;
	}

	/**
	 * This method initializes jButtonAddInvoice.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddInvoice() {
		if (jButtonAddInvoice == null) {
			jButtonAddInvoice = new JButton();
			jButtonAddInvoice.setText("Add");
			jButtonAddInvoice.setBounds(new Rectangle(10, 450, 121, 21));
			jButtonAddInvoice.setActionCommand("AddInvoice");
		}
		return jButtonAddInvoice;
	}

	/**
	 * This method initializes jButtonUpdateInvoice.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateInvoice() {
		if (jButtonUpdateInvoice == null) {
			jButtonUpdateInvoice = new JButton();
			jButtonUpdateInvoice.setText("Update");
			jButtonUpdateInvoice.setBounds(new Rectangle(140, 450, 121, 21));
			jButtonUpdateInvoice.setActionCommand("UpdateInvoice");
		}
		return jButtonUpdateInvoice;
	}

	/**
	 * This method initializes jButtonDeleteInvoice.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteInvoice() {
		if (jButtonDeleteInvoice == null) {
			jButtonDeleteInvoice = new JButton();
			jButtonDeleteInvoice.setText("Delete");
			jButtonDeleteInvoice.setBounds(new Rectangle(270, 450, 121, 21));
			jButtonDeleteInvoice.setActionCommand("DeleteInvoice");
		}
		return jButtonDeleteInvoice;
	}

	/**
	 * This method initializes jListInvoices.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListInvoices() {
		if (jListInvoices == null) {
			jListInvoices = new JList();
			jListInvoices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListInvoices;
	}

	/**
	 * This method initializes jPanelAdress.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelAdress() {
		if (jPanelAdress == null) {
			lbAdressCustomer = new JLabel();
			lbAdressCustomer.setBounds(new Rectangle(10, 30, 111, 21));
			lbAdressCustomer.setText("Customer");
			jPanelAdress = new JPanel();
			jPanelAdress.setLayout(null);
			jPanelAdress.setBounds(new Rectangle(10, 10, 831, 241));
			jPanelAdress.setBorder(BorderFactory.createTitledBorder(null, "Adress", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelAdress.add(lbStreet, null);
			jPanelAdress.add(getTfStreet(), null);
			jPanelAdress.add(lbHouseNr, null);
			jPanelAdress.add(getTfHouseNr(), null);
			jPanelAdress.add(lbCountryCode, null);
			jPanelAdress.add(getTfCountryCode(), null);
			jPanelAdress.add(lbPLZ, null);
			jPanelAdress.add(getTfPLZ(), null);
			jPanelAdress.add(lbCity, null);
			jPanelAdress.add(getTfCity(), null);
			jPanelAdress.add(lbAdressCustomer, null);
			jPanelAdress.add(getTfAdressCustomer(), null);
			jPanelAdress.add(getJButtonAssignAdress(), null);
		}
		return jPanelAdress;
	}

	/**
	 * This method initializes checkboxSender.
	 *
	 * @return java.awt.Checkbox
	 */
	public Checkbox getCheckboxSender() {
		if (checkboxSender == null) {
			checkboxSender = new Checkbox();
			checkboxSender.setLabel("Sender");
			checkboxSender.setBounds(new Rectangle(380, 30, 128, 21));
		}
		return checkboxSender;
	}

	/**
	 * This method initializes jPanelBank.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelBank() {
		if (jPanelBank == null) {
			lbBICtxt = new JLabel();
			lbBICtxt.setBounds(new Rectangle(390, 150, 251, 20));
			lbBICtxt.setText("Bank Identifier Code");
			lbIBANtxt = new JLabel();
			lbIBANtxt.setBounds(new Rectangle(390, 180, 251, 20));
			lbIBANtxt.setText("International Bank Account Number");
			lbBankCustomer = new JLabel();
			lbBankCustomer.setBounds(new Rectangle(10, 30, 111, 21));
			lbBankCustomer.setText("Customer");
			jPanelBank = new JPanel();
			jPanelBank.setLayout(null);
			jPanelBank.setBounds(new Rectangle(10, 10, 761, 231));
			jPanelBank.setBorder(BorderFactory.createTitledBorder(null, "Bank", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelBank.add(lbBank_Name, null);
			jPanelBank.add(getTfBank_Name(), null);
			jPanelBank.add(lbAccountNr, null);
			jPanelBank.add(getTfAccountNr(), null);
			jPanelBank.add(lbBLZ, null);
			jPanelBank.add(getTfBLZ(), null);
			jPanelBank.add(lbBIC, null);
			jPanelBank.add(getTfBIC(), null);
			jPanelBank.add(lbIBAN, null);
			jPanelBank.add(getTfIBAN(), null);
			jPanelBank.add(lbBankCustomer, null);
			jPanelBank.add(getTfBankCustomer(), null);
			jPanelBank.add(getJButtonAssignBank(), null);
			jPanelBank.add(lbIBANtxt, null);
			jPanelBank.add(lbBICtxt, null);
		}
		return jPanelBank;
	}

	/**
	 * This method initializes jPanelCustomer.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelCustomer() {
		if (jPanelCustomer == null) {
			lbCustomerPhone = new JLabel();
			lbCustomerPhone.setBounds(new Rectangle(10, 210, 151, 21));
			lbCustomerPhone.setText("Phone");
			lbCustomerTaxNr = new JLabel();
			lbCustomerTaxNr.setBounds(new Rectangle(10, 150, 151, 21));
			lbCustomerTaxNr.setText("Tax Nr.");
			jPanelCustomer = new JPanel();
			jPanelCustomer.setLayout(null);
			jPanelCustomer.setBounds(new Rectangle(10, 10, 831, 301));
			jPanelCustomer.setBorder(BorderFactory.createTitledBorder(null, "Customer", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelCustomer.add(lbCustomerTitle, null);
			jPanelCustomer.add(getTfCustomerTitle(), null);
			jPanelCustomer.add(getCheckboxSender(), null);
			jPanelCustomer.add(lbCustomerName, null);
			jPanelCustomer.add(getTfCustomerName(), null);
			jPanelCustomer.add(lbCustomerLastName, null);
			jPanelCustomer.add(getTfCustomerLastName(), null);
			jPanelCustomer.add(lbCustomerUID, null);
			jPanelCustomer.add(getTfCustomerUID(), null);
			jPanelCustomer.add(lbCustomerAdress, null);
			jPanelCustomer.add(lbCustomerBank, null);
			jPanelCustomer.add(lbCustomerTaxNr, null);
			jPanelCustomer.add(getTfCustomerTaxNr(), null);
			jPanelCustomer.add(lbCustomerPhone, null);
			jPanelCustomer.add(getTfCustomerPhone(), null);
			jPanelCustomer.add(getJButtonModifyCustomerPhone(), null);
			jPanelCustomer.add(getJButtonModifyCustomerAdress(), null);
			jPanelCustomer.add(getJButtonModifyCustomerBank(), null);
			jPanelCustomer.add(getTfCustomerAdress(), null);
			jPanelCustomer.add(getTfCustomerBank(), null);
		}
		return jPanelCustomer;
	}

	/**
	 * This method initializes jPanelArticle.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelArticle() {
		if (jPanelArticle == null) {
			jPanelArticle = new JPanel();
			jPanelArticle.setLayout(null);
			jPanelArticle.setBounds(new Rectangle(10, 10, 571, 211));
			jPanelArticle.setBorder(BorderFactory.createTitledBorder(null, "Article", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelArticle.add(lbUnit, null);
			jPanelArticle.add(getTfUnit(), null);
			jPanelArticle.add(lbDescription, null);
			jPanelArticle.add(getTaArticleDescription(), null);
			jPanelArticle.add(lbUnitPrice, null);
			jPanelArticle.add(getTfUnitPrice(), null);
			jPanelArticle.add(lbArticleTax, null);
			jPanelArticle.add(getJComboBoxArticleTax(), null);
		}
		return jPanelArticle;
	}

	/**
	 * This method initializes jPanelTextblock.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelTextblock() {
		if (jPanelTextblock == null) {
			lbTextblockNr = new JLabel();
			lbTextblockNr.setBounds(new Rectangle(10, 210, 111, 21));
			lbTextblockNr.setText("Nr");
			lbTextblockNr.setVisible(false);
			lbTBInvoiceNr = new JLabel();
			lbTBInvoiceNr.setBounds(new Rectangle(10, 30, 111, 21));
			lbTBInvoiceNr.setText("Invoice Nr.");
			lbTBInvoiceNr.setVisible(true);
			jPanelTextblock = new JPanel();
			jPanelTextblock.setLayout(null);
			jPanelTextblock.setBounds(new Rectangle(10, 10, 691, 241));
			jPanelTextblock.setBorder(BorderFactory.createTitledBorder(null, "Textblock", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelTextblock.add(lbTextblockDescription, null);
			jPanelTextblock.add(getTfTextblockDescription(), null);
			jPanelTextblock.add(lbTextblockText, null);
			jPanelTextblock.add(getJTextAreaTextblock(), null);
			jPanelTextblock.add(lbTBInvoiceNr, null);
			jPanelTextblock.add(getTfTBInvoiceReadOnlyNr(), null);
			jPanelTextblock.add(lbTextblockNr, null);
			jPanelTextblock.add(getTfTBNr(), null);
		}
		return jPanelTextblock;
	}

	/**
	 * This method initializes jComboBoxReceiver.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxReceiver() {
		if (jComboBoxReceiver == null) {
			jComboBoxReceiver = new JComboBox();
			jComboBoxReceiver.setBounds(new Rectangle(400, 90, 421, 21));
		}
		return jComboBoxReceiver;
	}

	/**
	 * This method initializes jScrollPaneCustomers.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneCustomers() {
		if (jScrollPaneCustomers == null) {
			jScrollPaneCustomers = new JScrollPane();
			jScrollPaneCustomers.setBounds(new Rectangle(10, 350, 831, 221));
			jScrollPaneCustomers.setViewportView(getJListCustomers());
		}
		return jScrollPaneCustomers;
	}

	/**
	 * This method initializes jScrollPaneAdresses.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneAdresses() {
		if (jScrollPaneAdresses == null) {
			jScrollPaneAdresses = new JScrollPane();
			jScrollPaneAdresses.setBounds(new Rectangle(10, 300, 831, 211));
			jScrollPaneAdresses.setViewportView(getJListAdresses());
		}
		return jScrollPaneAdresses;
	}

	/**
	 * This method initializes jScrollPaneInvoices.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneInvoices() {
		if (jScrollPaneInvoices == null) {
			jScrollPaneInvoices = new JScrollPane();
			jScrollPaneInvoices.setBounds(new Rectangle(10, 480, 831, 241));
			jScrollPaneInvoices.setViewportView(getJListInvoices());
		}
		return jScrollPaneInvoices;
	}

	/**
	 * This method initializes jScrollPaneInvoicePositions.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneInvoicePositions() {
		if (jScrollPaneInvoicePositions == null) {
			jScrollPaneInvoicePositions = new JScrollPane();
			jScrollPaneInvoicePositions.setBounds(new Rectangle(140, 120, 631, 121));
			jScrollPaneInvoicePositions.setViewportView(getJListInvoicePositions());
		}
		return jScrollPaneInvoicePositions;
	}

	/**
	 * This method initializes jScrollPaneBanks.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneBanks() {
		if (jScrollPaneBanks == null) {
			jScrollPaneBanks = new JScrollPane();
			jScrollPaneBanks.setBounds(new Rectangle(10, 300, 691, 211));
			jScrollPaneBanks.setViewportView(getJListBanks());
		}
		return jScrollPaneBanks;
	}

	/**
	 * This method initializes jScrollPaneArticles.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneArticles() {
		if (jScrollPaneArticles == null) {
			jScrollPaneArticles = new JScrollPane();
			jScrollPaneArticles.setBounds(new Rectangle(10, 280, 661, 241));
			jScrollPaneArticles.setViewportView(getJListArticles());
		}
		return jScrollPaneArticles;
	}

	/**
	 * This method initializes jComboBoxSender.
	 *
	 * @return javax.swing.JComboBox
	 */
	JComboBox getJComboBoxSender() {
		if (jComboBoxSender == null) {
			jComboBoxSender = new JComboBox();
			jComboBoxSender.setBounds(new Rectangle(400, 60, 421, 21));
		}
		return jComboBoxSender;
	}

	/**
	 * This method initializes jScrollPaneInvoiceTBs.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneInvoiceTBs() {
		if (jScrollPaneInvoiceTBs == null) {
			jScrollPaneInvoiceTBs = new JScrollPane();
			jScrollPaneInvoiceTBs.setBounds(new Rectangle(140, 270, 631, 131));
			jScrollPaneInvoiceTBs.setViewportView(getJListInvoiceTBs());
		}
		return jScrollPaneInvoiceTBs;
	}

	/**
	 * This method initializes jListInvoiceTBs.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListInvoiceTBs() {
		if (jListInvoiceTBs == null) {
			jListInvoiceTBs = new JList();
			jListInvoiceTBs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListInvoiceTBs;
	}

	/**
	 * This method initializes jButtonAddInvoiceTB.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddInvoiceTB() {
		if (jButtonAddInvoiceTB == null) {
			jButtonAddInvoiceTB = new JButton();
			jButtonAddInvoiceTB.setBounds(new Rectangle(10, 300, 121, 21));
			jButtonAddInvoiceTB.setText("Add");
			jButtonAddInvoiceTB.setActionCommand("AddPosition");
		}
		return jButtonAddInvoiceTB;
	}

	/**
	 * This method initializes jButtonUpdateInvoiceTB.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdateInvoiceTB() {
		if (jButtonUpdateInvoiceTB == null) {
			jButtonUpdateInvoiceTB = new JButton();
			jButtonUpdateInvoiceTB.setBounds(new Rectangle(10, 330, 121, 21));
			jButtonUpdateInvoiceTB.setText("Update");
			jButtonUpdateInvoiceTB.setEnabled(false);
			jButtonUpdateInvoiceTB.setActionCommand("UpdatePosition");
		}
		return jButtonUpdateInvoiceTB;
	}

	/**
	 * This method initializes jButtonDeleteInvoiceTB.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeleteInvoiceTB() {
		if (jButtonDeleteInvoiceTB == null) {
			jButtonDeleteInvoiceTB = new JButton();
			jButtonDeleteInvoiceTB.setBounds(new Rectangle(10, 360, 121, 21));
			jButtonDeleteInvoiceTB.setText("Delete");
			jButtonDeleteInvoiceTB.setActionCommand("DeletePosition");
		}
		return jButtonDeleteInvoiceTB;
	}

	/**
	 * This method initializes tfTBInvoiceReadOnlyNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTBInvoiceReadOnlyNr() {
		if (tfTBInvoiceReadOnlyNr == null) {
			tfTBInvoiceReadOnlyNr = new JTextField();
			tfTBInvoiceReadOnlyNr.setBounds(new Rectangle(130, 30, 321, 21));
			tfTBInvoiceReadOnlyNr.setEditable(false);
			tfTBInvoiceReadOnlyNr.setEnabled(false);
			tfTBInvoiceReadOnlyNr.setVisible(true);
		}
		return tfTBInvoiceReadOnlyNr;
	}

	/**
	 * This method initializes jButtonPrintInvoice.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonPrintInvoice() {
		if (jButtonPrintInvoice == null) {
			jButtonPrintInvoice = new JButton();
			jButtonPrintInvoice.setBounds(new Rectangle(400, 450, 121, 21));
			jButtonPrintInvoice.setText("Print");
			jButtonPrintInvoice.setActionCommand("DeleteInvoice");
		}
		return jButtonPrintInvoice;
	}

	/**
	 * This method initializes tfTBNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTBNr() {
		if (tfTBNr == null) {
			tfTBNr = new JTextField();
			tfTBNr.setBounds(new Rectangle(130, 210, 81, 20));
			tfTBNr.setVisible(false);
		}
		return tfTBNr;
	}

	/**
	 * This method initializes tfCustomerTaxNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerTaxNr() {
		if (tfCustomerTaxNr == null) {
			tfCustomerTaxNr = new JTextField();
			tfCustomerTaxNr.setBounds(new Rectangle(170, 150, 221, 21));
		}
		return tfCustomerTaxNr;
	}

	/**
	 * This method initializes tfTax1.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTax1() {
		if (tfTax1 == null) {
			tfTax1 = new JTextField();
			tfTax1.setText("");
			tfTax1.setBounds(new Rectangle(130, 60, 101, 21));
		}
		return tfTax1;
	}

	/**
	 * This method initializes tfTax2.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTax2() {
		if (tfTax2 == null) {
			tfTax2 = new JTextField();
			tfTax2.setText("");
			tfTax2.setBounds(new Rectangle(130, 90, 101, 21));
		}
		return tfTax2;
	}

	/**
	 * This method initializes tfTax3.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfTax3() {
		if (tfTax3 == null) {
			tfTax3 = new JTextField();
			tfTax3.setText("");
			tfTax3.setBounds(new Rectangle(130, 120, 101, 21));
		}
		return tfTax3;
	}

	/**
	 * This method initializes jComboBoxArticleTax.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxArticleTax() {
		if (jComboBoxArticleTax == null) {
			jComboBoxArticleTax = new JComboBox();
			jComboBoxArticleTax.setBounds(new Rectangle(130, 170, 131, 21));
		}
		return jComboBoxArticleTax;
	}

	/**
	 * This method initializes tfSettingsInvoiceNr.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfSettingsInvoiceNr() {
		if (tfSettingsInvoiceNr == null) {
			tfSettingsInvoiceNr = new JTextField();
			tfSettingsInvoiceNr.setEnabled(false);
			tfSettingsInvoiceNr.setBounds(new Rectangle(130, 30, 101, 21));
			tfSettingsInvoiceNr.setEditable(false);
		}
		return tfSettingsInvoiceNr;
	}

	/**
	 * This method initializes jComboBoxLanguage.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxLanguage() {
		if (jComboBoxLanguage == null) {
			jComboBoxLanguage = new JComboBox();
			jComboBoxLanguage.setBounds(new Rectangle(130, 220, 281, 21));
		}
		return jComboBoxLanguage;
	}

	/**
	 * This method initializes jPanelInvoicePosition.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelInvoicePosition() {
		if (jPanelInvoicePosition == null) {
			jPanelInvoicePosition = new JPanel();
			jPanelInvoicePosition.setLayout(null);
			jPanelInvoicePosition.setBounds(new Rectangle(10, 10, 711, 201));
			jPanelInvoicePosition.setBorder(BorderFactory.createTitledBorder(null, "Invoice Position", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelInvoicePosition.add(lbInvoicePositionInvoiceNr, null);
			jPanelInvoicePosition.add(getTfPosInvoiceReadOnlyNr(), null);
			jPanelInvoicePosition.add(lbInvoicePositionNr, null);
			jPanelInvoicePosition.add(getTfInvoicePositionNr(), null);
			jPanelInvoicePosition.add(lbInvoicePositionArticle, null);
			jPanelInvoicePosition.add(getJComboBoxPositionArticle(), null);
			jPanelInvoicePosition.add(lbInvoicePositionQuantity, null);
			jPanelInvoicePosition.add(getTfInvoicePositionQuantity(), null);
			jPanelInvoicePosition.add(lbInvoicePositionAmount, null);
			jPanelInvoicePosition.add(getTfInvoicePositionAmount(), null);
		}
		return jPanelInvoicePosition;
	}

	/**
	 * This method initializes jPanelSettingsArea.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelSettingsArea() {
		if (jPanelSettingsArea == null) {
			lbCurrency = new JLabel();
			lbCurrency.setBounds(new Rectangle(10, 250, 111, 21));
			lbCurrency.setText("Currency");
			jPanelSettingsArea = new JPanel();
			jPanelSettingsArea.setLayout(null);
			jPanelSettingsArea.setBounds(new Rectangle(10, 10, 731, 331));
			jPanelSettingsArea.setBorder(BorderFactory.createTitledBorder(null, "Settings", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelSettingsArea.add(lbSettingsInvoiceNr, null);
			jPanelSettingsArea.add(getTfSettingsInvoiceNr(), null);
			jPanelSettingsArea.add(lbTax1, null);
			jPanelSettingsArea.add(getTfTax1(), null);
			jPanelSettingsArea.add(lbTax2, null);
			jPanelSettingsArea.add(getTfTax2(), null);
			jPanelSettingsArea.add(lbTax3, null);
			jPanelSettingsArea.add(getTfTax3(), null);
			jPanelSettingsArea.add(lbBookingYear, null);
			jPanelSettingsArea.add(getTfBookingYear(), null);
			jPanelSettingsArea.add(lbLanguage, null);
			jPanelSettingsArea.add(getJComboBoxLanguage(), null);
			jPanelSettingsArea.add(lbCurrency, null);
			jPanelSettingsArea.add(getJComboBoxCurrency(), null);
		}
		return jPanelSettingsArea;
	}

	/**
	 * This method initializes jPanelPhones.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelPhones() {
		if (jPanelPhones == null) {
			jPanelPhones = new JPanel();
			jPanelPhones.setLayout(null);
			jPanelPhones.add(getJPanelPhone(), null);
			jPanelPhones.add(getJScrollPanePhones1(), null);
			jPanelPhones.add(getJButtonAddPhone(), null);
			jPanelPhones.add(getJButtonUpdatePhone(), null);
			jPanelPhones.add(getJButtonDeletePhone(), null);
		}
		return jPanelPhones;
	}

	/**
	 * This method initializes jPanelPhone1.
	 *
	 * @return javax.swing.JPanel
	 */
	public JPanel getJPanelPhone() {
		if (jPanelPhone1 == null) {
			lbPhoneCustomer = new JLabel();
			lbPhoneCustomer.setBounds(new Rectangle(10, 30, 111, 21));
			lbPhoneCustomer.setText("Customer");
			lbCallNr = new JLabel();
			lbCallNr.setBounds(new Rectangle(10, 90, 111, 21));
			lbCallNr.setText("Call-Nr");
			lbNr = new JLabel();
			lbNr.setBounds(new Rectangle(10, 120, 111, 21));
			lbNr.setText("Nr");
			lbNr.setVisible(false);
			lbType = new JLabel();
			lbType.setBounds(new Rectangle(10, 60, 111, 21));
			lbType.setText("Type");
			jPanelPhone1 = new JPanel();
			jPanelPhone1.setLayout(null);
			jPanelPhone1.setBounds(new Rectangle(10, 10, 761, 161));
			jPanelPhone1.setBorder(BorderFactory.createTitledBorder(null, "Phone", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 14), new Color(51, 51, 51)));
			jPanelPhone1.add(lbType, null);
			jPanelPhone1.add(lbNr, null);
			jPanelPhone1.add(getTfNr(), null);
			jPanelPhone1.add(lbCallNr, null);
			jPanelPhone1.add(getTfCallNr(), null);
			jPanelPhone1.add(getJComboBoxPhoneType(), null);
			jPanelPhone1.add(lbPhoneCustomer, null);
			jPanelPhone1.add(getTfPhoneCustomer(), null);
			jPanelPhone1.add(getJButtonAssignPhone(), null);
		}
		return jPanelPhone1;
	}

	/**
	 * This method initializes tfNr1.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfNr() {
		if (tfNr1 == null) {
			tfNr1 = new JTextField();
			tfNr1.setBounds(new Rectangle(130, 120, 131, 21));
			tfNr1.setVisible(false);
		}
		return tfNr1;
	}

	/**
	 * This method initializes tfCallNr1.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCallNr() {
		if (tfCallNr1 == null) {
			tfCallNr1 = new JTextField();
			tfCallNr1.setBounds(new Rectangle(130, 90, 271, 21));
		}
		return tfCallNr1;
	}

	/**
	 * This method initializes jComboBoxPhoneType1.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxPhoneType() {
		if (jComboBoxPhoneType1 == null) {
			jComboBoxPhoneType1 = new JComboBox();
			jComboBoxPhoneType1.setBounds(new Rectangle(130, 60, 271, 21));
		}
		return jComboBoxPhoneType1;
	}

	/**
	 * This method initializes jScrollPanePhones1.
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPanePhones1() {
		if (jScrollPanePhones1 == null) {
			jScrollPanePhones1 = new JScrollPane();
			jScrollPanePhones1.setBounds(new Rectangle(10, 230, 831, 211));
			jScrollPanePhones1.setViewportView(getJListPhones());
		}
		return jScrollPanePhones1;
	}

	/**
	 * This method initializes jListPhones1.
	 *
	 * @return javax.swing.JList
	 */
	public JList getJListPhones() {
		if (jListPhones1 == null) {
			jListPhones1 = new JList();
			jListPhones1.setBounds(new Rectangle(0, 0, 691, 208));
			jListPhones1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jListPhones1;
	}

	/**
	 * This method initializes jButtonAddPhone1.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAddPhone() {
		if (jButtonAddPhone1 == null) {
			jButtonAddPhone1 = new JButton();
			jButtonAddPhone1.setBounds(new Rectangle(10, 190, 121, 21));
			jButtonAddPhone1.setText("Add");
			jButtonAddPhone1.setActionCommand("AddAdress");
		}
		return jButtonAddPhone1;
	}

	/**
	 * This method initializes jButtonUpdatePhone1.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonUpdatePhone() {
		if (jButtonUpdatePhone1 == null) {
			jButtonUpdatePhone1 = new JButton();
			jButtonUpdatePhone1.setBounds(new Rectangle(140, 190, 121, 21));
			jButtonUpdatePhone1.setText("Update");
			jButtonUpdatePhone1.setActionCommand("UpdateAdress");
		}
		return jButtonUpdatePhone1;
	}

	/**
	 * This method initializes jButtonDeletePhone1.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonDeletePhone() {
		if (jButtonDeletePhone1 == null) {
			jButtonDeletePhone1 = new JButton();
			jButtonDeletePhone1.setBounds(new Rectangle(270, 190, 121, 21));
			jButtonDeletePhone1.setText("Delete");
			jButtonDeletePhone1.setActionCommand("DeleteAdress");
		}
		return jButtonDeletePhone1;
	}

	/**
	 * This method initializes tfCustomerPhone.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfCustomerPhone() {
		if (tfCustomerPhone == null) {
			tfCustomerPhone = new JTextField();
			tfCustomerPhone.setBounds(new Rectangle(170, 210, 541, 21));
			tfCustomerPhone.setEnabled(false);
			tfCustomerPhone.setBackground(Color.white);
			tfCustomerPhone.setFont(new Font("Dialog", Font.BOLD, 12));
			tfCustomerPhone.setEditable(false);
		}
		return tfCustomerPhone;
	}

	/**
	 * This method initializes jButtonModifyCustomerPhone.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonModifyCustomerPhone() {
		if (jButtonModifyCustomerPhone == null) {
			jButtonModifyCustomerPhone = new JButton();
			jButtonModifyCustomerPhone.setBounds(new Rectangle(720, 210, 101, 21));
			jButtonModifyCustomerPhone.setText("Modify");
			jButtonModifyCustomerPhone.setActionCommand("DeleteCustomer");
		}
		return jButtonModifyCustomerPhone;
	}

	/**
	 * This method initializes jButtonModifyCustomerAdress.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonModifyCustomerAdress() {
		if (jButtonModifyCustomerAdress == null) {
			jButtonModifyCustomerAdress = new JButton();
			jButtonModifyCustomerAdress.setBounds(new Rectangle(720, 180, 101, 21));
			jButtonModifyCustomerAdress.setText("Modify");
			jButtonModifyCustomerAdress.setActionCommand("DeleteCustomer");
		}
		return jButtonModifyCustomerAdress;
	}

	/**
	 * This method initializes jButtonModifyCustomerBank.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonModifyCustomerBank() {
		if (jButtonModifyCustomerBank == null) {
			jButtonModifyCustomerBank = new JButton();
			jButtonModifyCustomerBank.setBounds(new Rectangle(720, 240, 101, 21));
			jButtonModifyCustomerBank.setText("Modify");
			jButtonModifyCustomerBank.setActionCommand("DeleteCustomer");
		}
		return jButtonModifyCustomerBank;
	}

	/**
	 * This method initializes tfPhoneCustomer.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfPhoneCustomer() {
		if (tfPhoneCustomer == null) {
			tfPhoneCustomer = new JTextField();
			tfPhoneCustomer.setBounds(new Rectangle(130, 30, 501, 21));
			tfPhoneCustomer.setEnabled(false);
			tfPhoneCustomer.setEditable(false);
		}
		return tfPhoneCustomer;
	}

	/**
	 * This method initializes jComboBoxCurrency.
	 *
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJComboBoxCurrency() {
		if (jComboBoxCurrency == null) {
			jComboBoxCurrency = new JComboBox();
			jComboBoxCurrency.setBounds(new Rectangle(130, 250, 101, 21));
		}
		return jComboBoxCurrency;
	}

	/**
	 * This method initializes tfCustomerAdress.
	 *
	 * @return javax.swing.JTextField
	 */
	protected JTextField getTfCustomerAdress() {
		if (tfCustomerAdress == null) {
			tfCustomerAdress = new JTextField();
			tfCustomerAdress.setBounds(new Rectangle(170, 180, 541, 21));
			tfCustomerAdress.setEnabled(false);
			tfCustomerAdress.setFont(new Font("Dialog", Font.BOLD, 12));
			tfCustomerAdress.setEditable(false);
			tfCustomerAdress.setBackground(Color.white);
		}
		return tfCustomerAdress;
	}

	/**
	 * This method initializes tfCustomerBank.
	 *
	 * @return javax.swing.JTextField
	 */
	protected JTextField getTfCustomerBank() {
		if (tfCustomerBank == null) {
			tfCustomerBank = new JTextField();
			tfCustomerBank.setBounds(new Rectangle(170, 240, 541, 21));
			tfCustomerBank.setEnabled(false);
			tfCustomerBank.setFont(new Font("Dialog", Font.BOLD, 12));
			tfCustomerBank.setEditable(false);
			tfCustomerBank.setBackground(Color.white);
		}
		return tfCustomerBank;
	}

	/**
	 * This method initializes tfAdressCustomer.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfAdressCustomer() {
		if (tfAdressCustomer == null) {
			tfAdressCustomer = new JTextField();
			tfAdressCustomer.setBounds(new Rectangle(130, 30, 571, 21));
			tfAdressCustomer.setEditable(false);
			tfAdressCustomer.setEnabled(false);
		}
		return tfAdressCustomer;
	}

	/**
	 * This method initializes tfBankCustomer.
	 *
	 * @return javax.swing.JTextField
	 */
	public JTextField getTfBankCustomer() {
		if (tfBankCustomer == null) {
			tfBankCustomer = new JTextField();
			tfBankCustomer.setBounds(new Rectangle(130, 30, 501, 21));
			tfBankCustomer.setEditable(false);
			tfBankCustomer.setEnabled(false);
		}
		return tfBankCustomer;
	}

	/**
	 * This method initializes jDateChooserDate.
	 *
	 * @return com.toedter.calendar.JDateChooser
	 */
	public JDateChooser getJDateChooserDate() {
		if (jDateChooserDate == null) {
			jDateChooserDate = new JDateChooser();
			jDateChooserDate.setBounds(new Rectangle(140, 60, 151, 21));
		}
		return jDateChooserDate;
	}

	/**
	 * This method initializes jDateChooserPayUntil.
	 *
	 * @return com.toedter.calendar.JDateChooser
	 */
	public JDateChooser getJDateChooserPayUntil() {
		if (jDateChooserPayUntil == null) {
			jDateChooserPayUntil = new JDateChooser();
			jDateChooserPayUntil.setBounds(new Rectangle(140, 90, 151, 21));
		}
		return jDateChooserPayUntil;
	}

	/**
	 * This method initializes jButtonAssignAdress.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAssignAdress() {
		if (jButtonAssignAdress == null) {
			jButtonAssignAdress = new JButton();
			jButtonAssignAdress.setBounds(new Rectangle(710, 30, 111, 21));
			jButtonAssignAdress.setText("Assign");
			jButtonAssignAdress.setActionCommand("UpdateAdress");
		}
		return jButtonAssignAdress;
	}

	/**
	 * This method initializes jButtonAssignPhone.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAssignPhone() {
		if (jButtonAssignPhone == null) {
			jButtonAssignPhone = new JButton();
			jButtonAssignPhone.setBounds(new Rectangle(640, 30, 111, 21));
			jButtonAssignPhone.setText("Assign");
			jButtonAssignPhone.setActionCommand("UpdateAdress");
		}
		return jButtonAssignPhone;
	}

	/**
	 * This method initializes jButtonAssignBank.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAssignBank() {
		if (jButtonAssignBank == null) {
			jButtonAssignBank = new JButton();
			jButtonAssignBank.setBounds(new Rectangle(640, 30, 111, 21));
			jButtonAssignBank.setText("Assign");
			jButtonAssignBank.setActionCommand("UpdateAdress");
		}
		return jButtonAssignBank;
	}

	/**
	 * This method initializes jButtonPosUp.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonPosUp() {
		if (jButtonPosUp == null) {
			jButtonPosUp = new JButton();
			jButtonPosUp.setBounds(new Rectangle(780, 120, 41, 21));
		}
		return jButtonPosUp;
	}

	/**
	 * This method initializes jButtonPosDown.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonPosDown() {
		if (jButtonPosDown == null) {
			jButtonPosDown = new JButton();
			jButtonPosDown.setBounds(new Rectangle(780, 150, 41, 21));
			jButtonPosDown.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return jButtonPosDown;
	}

	/**
	 * This method initializes jButtonTBUp.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonTBUp() {
		if (jButtonTBUp == null) {
			jButtonTBUp = new JButton();
			jButtonTBUp.setBounds(new Rectangle(780, 270, 41, 21));
		}
		return jButtonTBUp;
	}

	/**
	 * This method initializes jButtonTBDown.
	 *
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonTBDown() {
		if (jButtonTBDown == null) {
			jButtonTBDown = new JButton();
			jButtonTBDown.setBounds(new Rectangle(780, 300, 41, 21));
		}
		return jButtonTBDown;
	}
}
