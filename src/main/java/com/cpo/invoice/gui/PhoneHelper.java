package com.cpo.invoice.gui;

import java.util.LinkedHashSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import com.cpo.invoice.control.PhoneControl;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.model.TELEPHONE;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneHelper.
 */
public class PhoneHelper {

	/** The phone data. */
	private static LinkedHashSet<TELEPHONE> phoneData = 
		new LinkedHashSet<TELEPHONE>();
	
	/** The selected phone. */
	private static TELEPHONE selectedPhone = null;
	
	/** The phone customer. */
	private static CUSTOMER phoneCustomer = null;

	/**
	 * Gets the phone customer.
	 *
	 * @return the phone customer
	 */
	public static CUSTOMER getPhoneCustomer() {
		return phoneCustomer;
	}

	/**
	 * Sets the phone customer.
	 *
	 * @param phoneCustomer the new phone customer
	 */
	public static void setPhoneCustomer(CUSTOMER phoneCustomer) {
		PhoneHelper.phoneCustomer = phoneCustomer;
	}

	/**
	 * Gets the phone data.
	 *
	 * @return the phone data
	 */
	public static LinkedHashSet<TELEPHONE> getPhoneData() {
		return phoneData;
	}

	/**
	 * Sets the phone data.
	 *
	 * @param phones the new phone data
	 */
	public static void setPhoneData(LinkedHashSet<TELEPHONE> phones) {
		phoneData = phones;
	}

	/**
	 * Gets the selected phone.
	 *
	 * @return the selected phone
	 */
	public static TELEPHONE getSelectedPhone() {
		return selectedPhone;
	}

	/**
	 * Sets the selected phone.
	 *
	 * @param phone the new selected phone
	 */
	public static void setSelectedPhone(TELEPHONE phone) {
		selectedPhone = phone;
	}

	/**
	 * Inits the.
	 */
	static void init() {
		InvoiceUI.getGui().getJComboBoxPhoneType().setModel(getPhoneTypeDataModel());
		InvoiceUI.getGui().getJListPhones().setListData(getPhoneData().toArray());
		// some listeners
		InvoiceUI.getGui().getJButtonAddPhone().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PhoneControl.add();
						notifyPhoneSelection();
					}
				});
		InvoiceUI.getGui().getJButtonUpdatePhone().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						int sel = InvoiceUI.getGui().getJListPhones()
							.getSelectedIndex();
						PhoneControl.update();
						notifyPhoneSelection();
						InvoiceUI.getGui().getJListPhones()
							.setSelectedIndex(sel);
					}
				});
		InvoiceUI.getGui().getJButtonAssignPhone().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PhoneControl.assign();
						notifyPhoneSelection();
					}
				});
		InvoiceUI.getGui().getJButtonDeletePhone().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PhoneControl.delete();
						notifyPhoneSelection();
					}
				});
		InvoiceUI.getGui().getJListPhones().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent e) {
						notifyPhoneSelection();
					}
				});
	}

	/**
	 * Gets the phone type data model.
	 *
	 * @return the phone type data model
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ComboBoxModel<?> getPhoneTypeDataModel() {
		String[] phoneTypeData = null;
		phoneTypeData = new String[3];
		phoneTypeData[0] = 
			InvoiceUI.getGui().getBundleValueByKey(StringHelper.LANDLINE);
		phoneTypeData[1] = 
			InvoiceUI.getGui().getBundleValueByKey(StringHelper.MOBILE);
		phoneTypeData[2] = 
			InvoiceUI.getGui().getBundleValueByKey(StringHelper.FAX);
		return new DefaultComboBoxModel(phoneTypeData);
	}

	/**
	 * Gets the phone from gui.
	 *
	 * @param phone the phone
	 * @return the phone from gui
	 */
	public static void getPhoneFromGui(TELEPHONE phone) {
		phone.setNR(InvoiceUI.getGui().getTfNr().getText());
		phone.setTYPE((String) 
				InvoiceUI.getGui().getJComboBoxPhoneType().getSelectedItem());
		phone.setCALL_NR(InvoiceUI.getGui().getTfCallNr().getText());
	}

	/**
	 * Sets the phone to gui.
	 *
	 * @param phone the new phone to gui
	 */
	protected static void setPhoneToGui(TELEPHONE phone) {
		InvoiceUI.getGui().getTfNr().setText(phone.getNR());
		InvoiceUI.getGui().getJComboBoxPhoneType()
			.setSelectedItem(phone.getTYPE());
		InvoiceUI.getGui().getTfCallNr().setText(phone.getCALL_NR());
	}

	/**
	 * Notify phone selection.
	 */
	protected static void notifyPhoneSelection() {
		setSelectedPhone(
				(TELEPHONE) InvoiceUI.getGui()
					.getJListPhones().getSelectedValue());
		if (getSelectedPhone() != null) {
			setPhoneToGui(getSelectedPhone());
			enableButtons(true);
		} else {
			setPhoneToGui(new TELEPHONE());
			enableButtons(false);
		}
		// System.out.println("Phone Selection changed()");
	}

	/**
	 * Enable buttons.
	 *
	 * @param b the b
	 */
	private static void enableButtons(boolean b) {
		InvoiceUI.getGui().getJButtonAddPhone().setEnabled(true);
		InvoiceUI.getGui().getJButtonUpdatePhone().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeletePhone().setEnabled(b);
		InvoiceUI.getGui().getJButtonAssignPhone().setEnabled(true);
	}
	
	/**
	 * Modify customer phone.
	 */
	protected static void modifyCustomerPhone() {
		CustomerHelper.setCustomerDetailTitle(StringHelper.TAB_NAME_PHONES);
		if (CustomerHelper.getSelectedCustomer() != null) {
			System.out.println("Customer: "+CustomerHelper.getSelectedCustomer().toString());
			setPhoneCustomer(CustomerHelper.getSelectedCustomer());
			setPhoneData(PhoneControl.getCustomerPhonesByDAO(
					getPhoneCustomer().getId()));
			updateGui();
			InvoiceUI.showTab(
					InvoiceUI.getGui().getJPanelPhones(),
					StringHelper.TAB_NAME_PHONES);
			TELEPHONE customerInvoicePhone = 
				getPhoneCustomer().getInvoicePhone();
			if (customerInvoicePhone == null) {
				setPhoneToGui(new TELEPHONE());
			} else {
				setPhoneToGui(customerInvoicePhone);
				int sel = getSelectedIndex(getPhoneData(),customerInvoicePhone);
				InvoiceUI.getGui().getJListPhones().setSelectedIndex(sel);
			}
		}
	}

	/**
	 * Gets the selected index.
	 *
	 * @param linkedHashSet the linked hash set
	 * @param phone the phone
	 * @return the selected index
	 */
	private static int getSelectedIndex(LinkedHashSet<TELEPHONE> linkedHashSet,
			TELEPHONE phone) {
		for (int i=0;i<linkedHashSet.size();i++) {
			if (((TELEPHONE)linkedHashSet.toArray()[i]).getId().longValue() ==
				phone.getId().longValue())
				return i;
		}
		return -1; // no selection
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
//		System.out.println("PhoneCustomer: "+getPhoneCustomer().toString());
		String phoneCustomerStr = getPhoneCustomer().toString();
		if (getPhoneCustomer().getInvoicePhone() != null)
			phoneCustomerStr = phoneCustomerStr + " - "+
			getPhoneCustomer().getInvoicePhone().toString();
		System.out.println("PhoneCustomerStr: "+phoneCustomerStr);
		InvoiceUI.getGui().getTfPhoneCustomer().setText(phoneCustomerStr);
		InvoiceUI.getGui().getJListPhones().setListData(
				getPhoneData().toArray());
	}
}
