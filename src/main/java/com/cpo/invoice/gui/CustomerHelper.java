package com.cpo.invoice.gui;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.cpo.invoice.control.CustomerControl;
import com.cpo.invoice.dao.CUSTOMERDAO;
import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.CUSTOMERDAOimpl;
import com.cpo.invoice.model.ADRESS;
import com.cpo.invoice.model.BANK;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.model.TELEPHONE;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerHelper.
 */
public final class CustomerHelper {

	/** The receiver data. */
	protected static Vector<CUSTOMER> receiverData = new Vector<CUSTOMER>();

	/** The sender data. */
	protected static Vector<CUSTOMER> senderData = new Vector<CUSTOMER>();

	/** The bank model. */
	protected static ComboBoxModel bankModel = null;

	/** The customer adress model. */
	protected static ComboBoxModel customerAdressModel = null;

	/** The customer data. */
	private static Vector<CUSTOMER> customerData = new Vector<CUSTOMER>();

	/** The selected customer. */
	private static CUSTOMER selectedCustomer = null;

	/** The customer detail title. */
	private static String customerDetailTitle = null;

	/**
	 * Instantiates a new customer helper.
	 */
	private CustomerHelper() {
		super();
	}

	/**
	 * Gets the customer detail title.
	 *
	 * @return the customer detail title
	 */
	public static String getCustomerDetailTitle() {
		return customerDetailTitle;
	}

	/**
	 * Sets the customer detail title.
	 *
	 * @param pValue the new customer detail title
	 */
	public static void setCustomerDetailTitle(final String pValue) {
		CustomerHelper.customerDetailTitle = pValue;
	}

	/**
	 * Gets the customer data.
	 *
	 * @return the customer data
	 */
	public static Vector<CUSTOMER> getCustomerData() {
		return customerData;
	}

	/**
	 * Sets the customer data.
	 *
	 * @param objects the new customer data
	 */
	public static void setCustomerData(final Vector<CUSTOMER> objects) {
		customerData = objects;
	}

	/**
	 * Gets the selected customer.
	 *
	 * @return the selected customer
	 */
	public static CUSTOMER getSelectedCustomer() {
		return selectedCustomer;
	}

	/**
	 * Sets the selected customer.
	 *
	 * @param pValue the new selected customer
	 */
	public static void setSelectedCustomer(final CUSTOMER pValue) {
		CustomerHelper.selectedCustomer = pValue;
	}

	/**
	 * Inits the.
	 */
	@SuppressWarnings("unchecked")
	static void init() {
		enableButtons(false);
		CustomerHelper.setCustomerData(
				(Vector<CUSTOMER>)DaoHelper.getAll(
						(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
		Collections.sort(getCustomerData());
		updateGui();
		// some listeners
		InvoiceUI.getGui().getJButtonModifyCustomerAdress().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						AdressHelper.modifyCustomerAdress();
					}
				});
		InvoiceUI.getGui().getJButtonModifyCustomerPhone().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						PhoneHelper.modifyCustomerPhone();
					}
				});
		InvoiceUI.getGui().getJButtonModifyCustomerBank().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						BankHelper.modifyCustomerBank();
					}
				});
		InvoiceUI.getGui().getJButtonAddCustomer().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						CustomerControl.addCustomer();
						Collections.sort(CustomerHelper.getCustomerData());
						CustomerHelper.updateGui();
						notifyCustomerSelection();
					}
				});
		InvoiceUI.getGui().getJButtonUpdateCustomer().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						CustomerControl.updateCustomer(getSelectedCustomer());
						Collections.sort(CustomerHelper.getCustomerData());
						CustomerHelper.updateGui();
						notifyCustomerSelection();
					}
				});
		InvoiceUI.getGui().getJButtonDeleteCustomer().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						CustomerControl.deleteCustomer();
						Collections.sort(CustomerHelper.getCustomerData());
						CustomerHelper.updateGui();
						notifyCustomerSelection();
					}
				});
		InvoiceUI.getGui().getJListCustomers().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyCustomerSelection();
					}
				});
	}

	/**
	 * Gets the customer from gui.
	 *
	 * @param customer the customer
	 * @return the customer from gui
	 */
	public static void getCustomerFromGui(final CUSTOMER customer) {
		customer.setNAME(InvoiceUI.getGui().getTfCustomerName().getText());
		customer.setLASTNAME(InvoiceUI.getGui().getTfCustomerLastName().getText());
		customer.setTITLE(InvoiceUI.getGui().getTfCustomerTitle().getText());
		customer.setUID(InvoiceUI.getGui().getTfCustomerUID().getText());
		customer.setTAXNR(InvoiceUI.getGui().getTfCustomerTaxNr().getText());
		customer.setSENDER(Boolean.valueOf(
				InvoiceUI.getGui().getCheckboxSender().getState()).toString());
	}

	/**
	 * Sets the customer to gui.
	 *
	 * @param customer the new customer to gui
	 */
	protected static void setCustomerToGui(final CUSTOMER customer) {
		InvoiceUI.getGui().getTfCustomerName().setText(customer.getNAME());
		InvoiceUI.getGui().getTfCustomerLastName().setText(customer.getLASTNAME());
		InvoiceUI.getGui().getTfCustomerTitle().setText(customer.getTITLE());
		InvoiceUI.getGui().getTfCustomerUID().setText(customer.getUID());
		InvoiceUI.getGui().getTfCustomerTaxNr().setText(customer.getTAXNR());
		InvoiceUI.getGui().getCheckboxSender().setState(
				"true".equals(customer.getSENDER()));
		// set adress
		final ADRESS adress = customer.getInvoiceAdress();
		if (adress == null) {
			InvoiceUI.getGui().getTfCustomerAdress()
					.setText("- - -");
		} else {
			InvoiceUI.getGui().getTfCustomerAdress().setText(
					adress.toString());
			AdressHelper.setAdressData(new Vector<ADRESS>());
		}
		// set phone
		final TELEPHONE phone = customer.getInvoicePhone();
		if (phone == null) {
			InvoiceUI.getGui().getTfCustomerPhone()
					.setText("- - -");
		} else {
			InvoiceUI.getGui().getTfCustomerPhone().setText(phone.toString());
			PhoneHelper.setPhoneData(new LinkedHashSet<TELEPHONE>());
		}
		// set bank
		final BANK bank = customer.getInvoiceBank();
		if (bank == null) {
			InvoiceUI.getGui().getTfCustomerBank()
					.setText("- - -");
		} else {
			InvoiceUI.getGui().getTfCustomerBank().setText(bank.toString());
			BankHelper.setBankData(new Vector<BANK>());
		}
	}

	/**
	 * Refresh sender receiver.
	 */
	public static void refreshSenderReceiver() {
		senderData = CustomerControl.getSendersByDAO();
		InvoiceUI.getGui().getJComboBoxSender().setModel(
				InvoiceUI.getComboBoxModel(senderData));
		receiverData = CustomerControl.getReceivesByDAO();
		InvoiceUI.getGui().getJComboBoxReceiver().setModel(
				InvoiceUI.getComboBoxModel(receiverData));
		InvoiceHelper.notifyInvoicesSelection();
	}

	/**
	 * Notify customer selection.
	 */
	protected static void notifyCustomerSelection() {
		setSelectedCustomer(
				(CUSTOMER)InvoiceUI.getGui().getJListCustomers()
					.getSelectedValue());
		if (getSelectedCustomer() != null) {
			setCustomerToGui(getSelectedCustomer());
			enableButtons(true);
		} else {
			setCustomerToGui(new CUSTOMER());
			PhoneHelper.setPhoneToGui(new TELEPHONE());
			enableButtons(false);
		}
		try {
			InvoiceUI.getGui().getJTabbedPane().remove(6);
		} catch (IndexOutOfBoundsException e) {
		}
	}

	/**
	 * Enable buttons.
	 *
	 * @param b the b
	 */
	private static void enableButtons(final boolean b) {
		InvoiceUI.getGui().getJButtonModifyCustomerAdress().setEnabled(b);
		InvoiceUI.getGui().getJButtonModifyCustomerPhone().setEnabled(b);
		InvoiceUI.getGui().getJButtonModifyCustomerBank().setEnabled(b);
		InvoiceUI.getGui().getJButtonUpdateCustomer().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeleteCustomer().setEnabled(b);
	}

	/**
	 * Gets the invoice sender index.
	 *
	 * @param sender the sender
	 * @return the invoice sender index
	 */
	protected static int getInvoiceSenderIndex(final CUSTOMER sender) {
		int id = 0;
		for (int i = 0; i < senderData.size(); i++) {
			if (senderData.get(i).getId().longValue() == sender.getId()
					.longValue()) {
				id = i + 1;
			}
		}
		return id;
	}

	/**
	 * Gets the invoice receiver index.
	 *
	 * @param receiver the receiver
	 * @return the invoice receiver index
	 */
	protected static int getInvoiceReceiverIndex(final CUSTOMER receiver) {
		int id = 0;
		for (int i = 0; i < receiverData.size(); i++) {
			if (receiverData.get(i).getId().longValue() == receiver.getId()
					.longValue()) {
				id = i + 1;
			}
		}
		return id;
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		InvoiceUI.getGui().getJListCustomers().setListData(
				CustomerHelper.getCustomerData().toArray());
		refreshSenderReceiver();
	}

}
