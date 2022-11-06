package com.cpo.invoice.gui;

import java.util.Collections;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.cpo.invoice.control.AdressControl;
import com.cpo.invoice.model.ADRESS;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class AdressHelper.
 */
public class AdressHelper {

	/** The adress model. */
	protected static ComboBoxModel adressModel = null;

	/** The selected adress. */
	protected static ADRESS selectedAdress = null;

	/** The static object. */
//	private static AdressHelper staticObject = new AdressHelper();

	/** The adress data. */
	private static Vector<ADRESS>
		adressData = new Vector<ADRESS>();

	/** The adress customer. */
	private static CUSTOMER adressCustomer = null;

	/**
	 * Gets the adress customer.
	 *
	 * @return the adress customer
	 */
	public static CUSTOMER getAdressCustomer() {
		return adressCustomer;
	}

	/**
	 * Sets the adress customer.
	 *
	 * @param obj the new adress customer
	 */
	public static void setAdressCustomer(final CUSTOMER obj) {
		adressCustomer = obj;
	}

	/**
	 * Gets the adress data.
	 *
	 * @return the adress data
	 */
	public static Vector<ADRESS> getAdressData() {
		return adressData;
	}

	/**
	 * Sets the adress data.
	 *
	 * @param adressData the new adress data
	 */
	public static void setAdressData(final Vector<ADRESS> adressData) {
		AdressHelper.adressData = adressData;
	}

	/**
	 * Gets the selected adress.
	 *
	 * @return the selected adress
	 */
	public static ADRESS getSelectedAdress() {
		return selectedAdress;
	}

	/**
	 * Sets the selected adress.
	 *
	 * @param pValue the new selected adress
	 */
	public static void setSelectedAdress(final ADRESS pValue) {
		AdressHelper.selectedAdress = pValue;
	}

	/**
	 * Inits the.
	 */
	protected static void init() {
		adressModel = InvoiceUI.getComboBoxModel(getAdressData());
		// some listeners
		InvoiceUI.getGui().getJButtonAddAdress().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						AdressControl.add();
						notifyAdressesSelection();
					}
				});
		InvoiceUI.getGui().getJButtonUpdateAdress().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						final int sel = InvoiceUI.getGui().getJListAdresses()
							.getSelectedIndex();
						AdressControl.update();
						notifyAdressesSelection();
						InvoiceUI.getGui().getJListAdresses()
							.setSelectedIndex(sel);
					}
				});
		InvoiceUI.getGui().getJButtonDeleteAdress().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						AdressControl.delete();
						notifyAdressesSelection();
					}
				});
		InvoiceUI.getGui().getJButtonAssignAdress().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						AdressControl.assign();
						notifyAdressesSelection();
					}
				});
		InvoiceUI.getGui().getJListAdresses().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyAdressesSelection();
					}
				});
	}

	/**
	 * Gets the adress from gui.
	 *
	 * @param adress the adress
	 * @return the adress from gui
	 */
	public static void getAdressFromGui(final ADRESS adress) {
		adress.setSTREET(InvoiceUI.getGui().getTfStreet().getText());
		adress.setHOUSENR(InvoiceUI.getGui().getTfHouseNr().getText());
		adress.setCOUNTRYCODE(InvoiceUI.getGui().getTfCountryCode().getText());
		adress.setPLZ(InvoiceUI.getGui().getTfPLZ().getText());
		adress.setCITY(InvoiceUI.getGui().getTfCity().getText());
	}

	/**
	 * Sets the adress to gui.
	 *
	 * @param adress the new adress to gui
	 */
	protected static void setAdressToGui(final ADRESS adress) {
		InvoiceUI.getGui().getTfStreet().setText(adress.getSTREET());
		InvoiceUI.getGui().getTfHouseNr().setText(adress.getHOUSENR());
		InvoiceUI.getGui().getTfCountryCode().setText(adress.getCOUNTRYCODE());
		InvoiceUI.getGui().getTfPLZ().setText(adress.getPLZ());
		InvoiceUI.getGui().getTfCity().setText(adress.getCITY());
	}

	/**
	 * Notify adresses selection.
	 */
	static void notifyAdressesSelection() {
		setSelectedAdress(
				(ADRESS)InvoiceUI.getGui()
					.getJListAdresses().getSelectedValue());
		if (getSelectedAdress() != null) {
			setAdressToGui(getSelectedAdress());
			enableButtons(true);
		} else {
			setAdressToGui(new ADRESS());
			enableButtons(false);
		}
	}

	/**
	 * Enable buttons.
	 *
	 * @param b the b
	 */
	private static void enableButtons(final boolean b) {
		InvoiceUI.getGui().getJButtonAddAdress().setEnabled(true);
		InvoiceUI.getGui().getJButtonUpdateAdress().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeleteAdress().setEnabled(b);
		InvoiceUI.getGui().getJButtonAssignAdress().setEnabled(true);
	}

	/**
	 * Modify customer adress.
	 */
	protected static void modifyCustomerAdress() {
		CustomerHelper.setCustomerDetailTitle(StringHelper.TAB_NAME_ADRESSES);
		if (CustomerHelper.getSelectedCustomer() != null) {
			setAdressCustomer(CustomerHelper.getSelectedCustomer());
			AdressHelper.setAdressData(AdressControl.getCustomerAdressesByDAO(
					AdressHelper.getAdressCustomer()));
			Collections.sort(getAdressData());
			updateGui();
			InvoiceUI.showTab(
					InvoiceUI.getGui().getJPanelAdresses(),
					StringHelper.TAB_NAME_ADRESSES);
			final ADRESS customerInvoiceAdress =
				getAdressCustomer().getInvoiceAdress();
			if (customerInvoiceAdress == null) {
				setAdressToGui(new ADRESS());
			} else {
				setAdressToGui(customerInvoiceAdress);
				final int sel = getSelectedIndex(getAdressData(), customerInvoiceAdress);
				InvoiceUI.getGui().getJListAdresses().setSelectedIndex(sel);
			}
		}
	}

	/**
	 * Gets the selected index.
	 *
	 * @param pAdresses the adresses
	 * @param customerInvoiceAdress the customer invoice adress
	 * @return the selected index
	 */
	private static int getSelectedIndex(final Vector<ADRESS> pAdresses,
			final ADRESS customerInvoiceAdress) {
		for (int i = 0; i < pAdresses.size(); i++) {
			if (((ADRESS)pAdresses.toArray()[i]).getId().longValue()
					== customerInvoiceAdress.getId().longValue()) {
				return i;
			}
		}
		return -1; // no selection
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		String adressCustomerStr = getAdressCustomer().toString();
		if (getAdressCustomer().getInvoiceAdress() != null) {
			adressCustomerStr = adressCustomerStr + " - " +
			getAdressCustomer().getInvoiceAdress().toString();
		}
		InvoiceUI.getGui().getTfAdressCustomer().setText(adressCustomerStr);
		InvoiceUI.getGui().getJListAdresses().setListData(
				getAdressData().toArray());
	}
}
