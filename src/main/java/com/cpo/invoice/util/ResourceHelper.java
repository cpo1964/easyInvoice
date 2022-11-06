package com.cpo.invoice.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.PhoneHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceHelper.
 */
public final class ResourceHelper {

	/**
	 * Instantiates a new resource helper.
	 */
	private ResourceHelper() {
		super();
	}

	/**
	 * Inits the labels tab settings.
	 */
	public static void initLabelsTabSettings() {
		InvoiceUI.getGui()
				.getJPanelSettingsArea()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Settings.Lbl.SettingsArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbSettingsInvoiceNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.InvoiceNr"));
		InvoiceUI.getGui().lbTax1.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.TaxOne"));
		InvoiceUI.getGui().lbTax2.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.TaxTwo"));
		InvoiceUI.getGui().lbTax3.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.TaxThree"));
		InvoiceUI.getGui().lbBookingYear.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.BookingYear"));
		InvoiceUI.getGui().lbLanguage.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Settings.Lbl.Language"));
	}

	/**
	 * Inits the labels tab invoices.
	 */
	public static void initLabelsTabInvoices() {
		InvoiceUI.getGui()
				.getJPanelInvoice()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Invoices.Lbl.InvoiceArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbInvoiceNr.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.Invoices.Lbl.InvoiceNr"));
		InvoiceUI.getGui().lbInvoiceDate.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.Invoices.Lbl.InvoiceDate"));
		InvoiceUI.getGui().lbInvoicePayUntil.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.Invoices.Lbl.InvoicePayUntil"));
		InvoiceUI.getGui().lbInvoiceSender.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.TAB_NAME_INVOICES_LBL_INVOICE_SENDER));
		InvoiceUI.getGui().lbInvoiceReceiver.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.TAB_NAME_INVOICES_LBL_INVOICE_RECEIVER));
		InvoiceUI.getGui().lbInvoicePositions.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.Invoices.Lbl.InvoicePositions"));
		InvoiceUI.getGui().lbInvoiceTBs.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.Invoices.Lbl.InvoiceTextblocks"));
		InvoiceUI.getGui().getJButtonAddInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
		InvoiceUI.getGui().getJButtonPrintInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Print"));
	}

	/**
	 * Inits the labels tab adresses and phones.
	 */
	public static void initLabelsTabAdressesAndPhones() {
		InvoiceUI.getGui()
				.getJPanelAdress()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Adresses.Lbl.AdressArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbAdressCustomer.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.CustomerArea"));
		InvoiceUI.getGui().lbPhoneCustomer.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.CustomerArea"));
		InvoiceUI.getGui().lbStreet.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Adresses.Lbl.Street"));
		InvoiceUI.getGui().lbHouseNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Adresses.Lbl.HouseNr"));
		InvoiceUI.getGui().lbCountryCode.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Adresses.Lbl.CountryCode"));
		InvoiceUI.getGui().lbPLZ.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Adresses.Lbl.PLZ"));
		InvoiceUI.getGui().lbCity.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Adresses.Lbl.City"));
		InvoiceUI.getGui().getJButtonAssignAdress().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Assign"));
		InvoiceUI.getGui().getJButtonAssignPhone().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Assign"));
		InvoiceUI.getGui().getJButtonAddAdress().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateAdress().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteAdress().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
	}

	/**
	 * Inits the labels tab articles.
	 */
	public static void initLabelsTabArticles() {
		InvoiceUI.getGui().getJPanelArticle().setBorder(
				BorderFactory.createTitledBorder(
					null,
					InvoiceUI.getGui().getBundleValueByKey(
							"tab.name.Articles.Lbl.ArticleArea"),
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION,
					new Font("Dialog", Font.BOLD, 14),
					new Color(51, 51, 51)));
		InvoiceUI.getGui().lbUnit.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Articles.Lbl.Unit"));
		InvoiceUI.getGui().lbDescription.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Articles.Lbl.Description"));
		InvoiceUI.getGui().lbUnitPrice.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Articles.Lbl.UnitPrice"));
		InvoiceUI.getGui().lbArticleTax.setText(InvoiceUI.getGui()
				.getBundleValueByKey("lbl.tax"));
		InvoiceUI.getGui().getJButtonAddArticle().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateArticle().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteArticle().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
	}

	/**
	 * Inits the labels tab banks.
	 */
	public static void initLabelsTabBanks() {
		InvoiceUI.getGui()
				.getJPanelBank()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Banks.Lbl.BankArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbBankCustomer.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.CustomerArea"));
		InvoiceUI.getGui().lbBank_Name.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Banks.Lbl.Name"));
		InvoiceUI.getGui().lbAccountNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Banks.Lbl.AccountNr"));
		InvoiceUI.getGui().lbBLZ.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Banks.Lbl.BLZ"));
		InvoiceUI.getGui().lbBIC.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Banks.Lbl.BIC"));
		InvoiceUI.getGui().lbIBAN.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Banks.Lbl.IBAN"));
		InvoiceUI.getGui().getJButtonAssignBank().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Assign"));
		InvoiceUI.getGui().getJButtonAddBank().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateBank().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteBank().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
	}

	/**
	 * Inits the labels tab customers.
	 */
	public static void initLabelsTabCustomers() {
		InvoiceUI.getGui()
				.getJPanelCustomer()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Customers.Lbl.CustomerArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbCustomerTitle.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.Title"));
		InvoiceUI.getGui().getCheckboxSender().setLabel(
				InvoiceUI.getGui()
						.getBundleValueByKey("tab.name.Customers.Lbl.Sender"));
		InvoiceUI.getGui().lbCustomerName.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.Name"));
		InvoiceUI.getGui().lbCustomerLastName.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.LastName"));
		InvoiceUI.getGui().lbCustomerUID.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.UID"));
		InvoiceUI.getGui().lbCustomerTaxNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.TaxNr"));
		InvoiceUI.getGui().lbCustomerAdress.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.Adresses"));
		InvoiceUI.getGui().lbCustomerPhone.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.Phones"));
		InvoiceUI.getGui().lbCustomerBank.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Customers.Lbl.Bank"));
		InvoiceUI.getGui().getJButtonAddCustomer().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateCustomer().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteCustomer().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
		InvoiceUI.getGui().getJButtonModifyCustomerAdress().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Modify"));
		InvoiceUI.getGui().getJButtonModifyCustomerPhone().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Modify"));
		InvoiceUI.getGui().getJButtonModifyCustomerBank().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Modify"));
	}

	/**
	 * Inits the labels tab phones.
	 */
	public static void initLabelsTabPhones() {
		InvoiceUI.getGui().getJPanelPhone().setBorder(
				BorderFactory.createTitledBorder(
					null,
					InvoiceUI.getGui().getBundleValueByKey(
							"tab.name.Phones.Lbl.PhoneArea"),
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION,
					new Font("Dialog", Font.BOLD, 14),
					new Color(51, 51, 51)));
		InvoiceUI.getGui().lbPhoneCustomer.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Phones.Lbl.Customer"));
		InvoiceUI.getGui().lbNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Phones.Lbl.Nr"));
		InvoiceUI.getGui().lbType.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Phones.Lbl.Type"));
		InvoiceUI.getGui().lbCallNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Phones.Lbl.CallNr"));
		InvoiceUI.getGui().getJButtonAddPhone().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdatePhone().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeletePhone().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
		InvoiceUI.getGui().getJComboBoxPhoneType().setModel(
				PhoneHelper.getPhoneTypeDataModel());

	}

	/**
	 * Inits the labels tab invoice position.
	 */
	public static void initLabelsTabInvoicePosition() {
		InvoiceUI.getGui()
				.getJPanelInvoicePosition()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.InvoicePosition.Lbl.InvoicePositionArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbInvoicePositionInvoiceNr.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.InvoicePosition.Lbl.InvoiceNr"));
		InvoiceUI.getGui().lbInvoicePositionNr.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.InvoicePosition.Lbl.PositionNr"));
		InvoiceUI.getGui().lbInvoicePositionArticle.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.InvoicePosition.Lbl.Article"));
		InvoiceUI.getGui().lbInvoicePositionQuantity.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.InvoicePosition.Lbl.Quantity"));
		InvoiceUI.getGui().lbInvoicePositionAmount.setText(
				InvoiceUI.getGui().getBundleValueByKey(
						"tab.name.InvoicePosition.Lbl.Amount"));
		InvoiceUI.getGui().getJButtonAddPosition().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdatePosition().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeletePosition().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
		InvoiceUI.getGui().getJButtonSavePosition().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Save"));
	}

	/**
	 * Inits the labels tab textblock.
	 */
	public static void initLabelsTabTextblock() {
		InvoiceUI.getGui()
				.getJPanelTextblock()
				.setBorder(
						BorderFactory
								.createTitledBorder(
										null,
										InvoiceUI.getGui()
												.getBundleValueByKey("tab.name.Textblock.Lbl.TextblockArea"),
										TitledBorder.DEFAULT_JUSTIFICATION,
										TitledBorder.DEFAULT_POSITION,
										new Font("Dialog", Font.BOLD, 14),
										new Color(51, 51, 51)));
		InvoiceUI.getGui().lbTBInvoiceNr.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Textblock.Lbl.InvoiceNr"));
		InvoiceUI.getGui().lbTextblockNr.setText(InvoiceUI.getGui()
						.getBundleValueByKey("tab.name.Textblock.Lbl.Nr"));
		InvoiceUI.getGui().lbTextblockDescription.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Textblock.Lbl.Description"));
		InvoiceUI.getGui().lbTextblockText.setText(InvoiceUI.getGui()
				.getBundleValueByKey("tab.name.Textblock.Lbl.Text"));
		InvoiceUI.getGui().getJButtonAddInvoiceTB().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
		InvoiceUI.getGui().getJButtonUpdateInvoiceTB().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Update"));
		InvoiceUI.getGui().getJButtonDeleteInvoiceTB().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Delete"));
		InvoiceUI.getGui().getJButtonSaveTB().setText(
				InvoiceUI.getGui().getBundleValueByKey("btn.Save"));
	}

}
