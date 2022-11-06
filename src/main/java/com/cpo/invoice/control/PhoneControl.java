package com.cpo.invoice.control;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.TELEPHONEDAOimpl;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.InvoiceUIValidator;
import com.cpo.invoice.gui.PhoneHelper;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.model.TELEPHONE;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneControl.
 */
public final class PhoneControl {

	/** The log. */
	private static Logger log = Logger.getLogger(PhoneControl.class);

	/** The static object. */
//	private static PhoneControl staticObject = new PhoneControl();

	private PhoneControl() {
		super();
	}

	/**
	 * Gets the customer phones by dao.
	 *
	 * @param custID the cust id
	 * @return the customer phones by dao
	 */
	@SuppressWarnings("unchecked")
	public static LinkedHashSet<TELEPHONE> getCustomerPhonesByDAO(long custID) {
		LinkedHashSet<TELEPHONE> customerPhones = new LinkedHashSet<TELEPHONE>();
		Vector<TELEPHONE> allPhones = (Vector<TELEPHONE>)DaoHelper
			.getAll((InterfaceDAO) TELEPHONEDAOimpl.getInstance(), true);
		final Iterator<TELEPHONE> it = allPhones.iterator();
		while (it.hasNext()) {
			final TELEPHONE phone = it.next();
			if (phone.getCUSTOMER_ID() != null &&
				phone.getCUSTOMER_ID().longValue() == custID) {
				customerPhones.add(phone);
			}
		}
		return customerPhones;
	}

	/**
	 * Adds the.
	 */
	public static void add() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				final TELEPHONE phone = new TELEPHONE();
				PhoneHelper.getPhoneFromGui(phone);
				phone.setCUSTOMER_ID(
						PhoneHelper.getPhoneCustomer().getId());
				final Long id = DaoHelper.create(phone, (InterfaceDAO) TELEPHONEDAOimpl.getInstance());
				PhoneHelper.setPhoneData(getCustomerPhonesByDAO(
						PhoneHelper.getPhoneCustomer().getId()));
				PhoneHelper.updateGui();
				log.info("Created Phone with ID " + id);
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
				if (PhoneHelper.getSelectedPhone() != null) {
					PhoneHelper.getPhoneFromGui(
							PhoneHelper.getSelectedPhone());
					DaoHelper.update(
							PhoneHelper.getSelectedPhone(),
							(InterfaceDAO) TELEPHONEDAOimpl.getInstance());
					PhoneHelper.setPhoneData(getCustomerPhonesByDAO(
							PhoneHelper.getPhoneCustomer().getId()));
					PhoneHelper.updateGui();
					log.info("Updated Phone with ID " +
							PhoneHelper.getPhoneCustomer().getId());
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
				if (PhoneHelper.getSelectedPhone() != null) {
					if (! isUsedByCustomer(PhoneHelper.getSelectedPhone())) {
						if (CommonHelper.actionConfirmation(
								StringHelper.INFO_DELETE_PHONE,
								StringHelper.INFO_ASK_DELETE_PHONE) == 0) {
							final Long id = PhoneHelper.getSelectedPhone().getId();
							DaoHelper.delete(
									PhoneHelper.getSelectedPhone(),
									(InterfaceDAO) TELEPHONEDAOimpl.getInstance());
							PhoneHelper.setPhoneData(getCustomerPhonesByDAO(
									PhoneHelper.getPhoneCustomer().getId()));
							PhoneHelper.updateGui();
							log.info("Deleted Phone with ID " + id);
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
	 * @param pPhone the phone
	 * @return true, if is used by customer
	 */
	private static boolean isUsedByCustomer(final TELEPHONE pPhone) {
		Vector<CUSTOMER> customers = CustomerControl.getCustomersByPhone(pPhone);
		if (customers.size() > 0) {
			InvoiceUIValidator.ERROR_TITLE_STR =
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.ERROR_ACTION);
			InvoiceUIValidator.ERROR_STR =
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.ERROR_PHONE_INUSE) +
						": " + customers.toArray()[0].toString();
			log.info(InvoiceUIValidator.ERROR_STR);
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
				if (PhoneHelper.getSelectedPhone() != null) {
					PhoneHelper.getSelectedPhone().setCUSTOMER_ID(
						PhoneHelper.getPhoneCustomer().getId());
				}
				PhoneHelper.getPhoneCustomer().setInvoicePhone(
						PhoneHelper.getSelectedPhone());
				CustomerControl.updateCustomer(PhoneHelper.getPhoneCustomer());
				PhoneHelper.updateGui();
				InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
						InvoiceUI.getGui().getJPanelCustomers());
				InvoiceUI.getGui().getJListCustomers().setSelectedIndex(sel);
				try {
					InvoiceUI.getGui().getJTabbedPane().remove(6);
				} catch (IndexOutOfBoundsException e) {
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

}
