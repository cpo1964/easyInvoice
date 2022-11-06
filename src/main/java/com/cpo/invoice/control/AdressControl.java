package com.cpo.invoice.control;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.ADRESSDAOimpl;
import com.cpo.invoice.gui.AdressHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.InvoiceUIValidator;
import com.cpo.invoice.model.ADRESS;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class AdressControl.
 */
public class AdressControl {

	/** The log. */
	private static Logger log = Logger.getLogger(AdressControl.class);

	/** The static object. */
//	private static AdressControl staticObject = new AdressControl();

	public AdressControl() {
		super();
	}

	/**
	 * Gets the customer adresses by dao.
	 *
	 * @param pCust the cust
	 * @return the customer adresses by dao
	 */
	@SuppressWarnings("unchecked")
	public static Vector<ADRESS> getCustomerAdressesByDAO(final CUSTOMER pCust) {
		Vector<ADRESS> customerAdresses = new Vector<ADRESS>();
		if (pCust == null) {
			return customerAdresses;
		}
		Vector<ADRESS> allAdresses =
			(Vector<ADRESS>)DaoHelper.getAll((InterfaceDAO) ADRESSDAOimpl.getInstance(), true);
		final Iterator<ADRESS> it = allAdresses.iterator();
		while (it.hasNext()) {
			final ADRESS adress = it.next();
			if (adress.getCUSTOMER_ID() != null &&
				adress.getCUSTOMER_ID().longValue() == pCust.getId()) {
				customerAdresses.add(adress);
			}
		}
		return customerAdresses;
	}

	/**
	 * Adds the.
	 */
	public static void add() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				if (AdressHelper.getAdressCustomer() != null) {
					final ADRESS adress = new ADRESS();
					AdressHelper.getAdressFromGui(adress);
					adress.setCUSTOMER_ID(
							AdressHelper.getAdressCustomer().getId());
					final Long id = DaoHelper.create(adress, (InterfaceDAO) ADRESSDAOimpl.getInstance());
					AdressHelper.setAdressData(
							getCustomerAdressesByDAO(
									AdressHelper.getAdressCustomer()));
					Collections.sort(AdressHelper.getAdressData());
					AdressHelper.updateGui();
					log.info("Created Adress with ID " + id);
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Update.
	 */
	public static void update() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				if (AdressHelper.getSelectedAdress() != null) {
					AdressHelper.getAdressFromGui(
							AdressHelper.getSelectedAdress());
					DaoHelper.update(
							AdressHelper.getSelectedAdress(),
							(InterfaceDAO) ADRESSDAOimpl.getInstance());
					AdressHelper.setAdressData(getCustomerAdressesByDAO(
							AdressHelper.getAdressCustomer()));
					Collections.sort(AdressHelper.getAdressData());
					AdressHelper.updateGui();
					log.info("Updated Adress with ID " +
							AdressHelper.getSelectedAdress().getId());
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Delete.
	 */
	public static void delete() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				if (AdressHelper.getSelectedAdress() != null) {
					if (! isUsedByCustomer(AdressHelper.getSelectedAdress())) {
						if (CommonHelper.actionConfirmation(
								StringHelper.INFO_DELETE_ADRESS,
								StringHelper.INFO_ASK_DELETE_ADRESS) == 0) {
							final Long id = AdressHelper.getSelectedAdress().getId();
							DaoHelper.delete(
									AdressHelper.getSelectedAdress(),
									(InterfaceDAO) ADRESSDAOimpl.getInstance());
							AdressHelper.setAdressData(
									getCustomerAdressesByDAO(
											AdressHelper.getAdressCustomer()));
							Collections.sort(AdressHelper.getAdressData());
							AdressHelper.updateGui();
							log.info("Deleted Adress with ID " + id);
						}
					}
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Checks if is used by customer.
	 *
	 * @param pAdress the adress
	 * @return true, if is used by customer
	 */
	private static boolean isUsedByCustomer(final ADRESS pAdress) {
		final Vector<CUSTOMER> customers = CustomerControl.getCustomersByAdress(pAdress);
		if (customers.size() > 0) {
			InvoiceUIValidator.ERROR_TITLE_STR =
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.ERROR_ACTION);
			InvoiceUIValidator.ERROR_STR =
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.ERROR_ADRESS_INUSE) +
						": " + customers.toArray()[0].toString();
			System.out.println(InvoiceUIValidator.ERROR_STR);
			CommonHelper.showErrorMsgBox();
			return true;
		}
		return false;
	}

	/**
	 * Assign.
	 */
	public static void assign() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				InvoiceUI.setVisibleTabs(6);
				final int sel = InvoiceUI.getGui().getJListCustomers().getSelectedIndex();
				if (AdressHelper.getSelectedAdress() != null) {
					AdressHelper.getSelectedAdress().setCUSTOMER_ID(
						AdressHelper.getAdressCustomer().getId());
				}
				AdressHelper.getAdressCustomer().setInvoiceAdress(
						AdressHelper.getSelectedAdress());
				CustomerControl.updateCustomer(AdressHelper.getAdressCustomer());
				AdressHelper.updateGui();
				try {
					InvoiceUI.getGui().getJTabbedPane().remove(6);
				} catch (Exception e) {
				}
				InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
						InvoiceUI.getGui().getJPanelCustomers());
				InvoiceUI.getGui().getJListCustomers().setSelectedIndex(sel);
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

}
