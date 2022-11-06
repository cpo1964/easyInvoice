package com.cpo.invoice.control;

import java.util.Collections;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.CUSTOMERDAOimpl;
import com.cpo.invoice.gui.CustomerHelper;
import com.cpo.invoice.gui.InvoiceHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.InvoiceUIValidator;
import com.cpo.invoice.model.ADRESS;
import com.cpo.invoice.model.BANK;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.TELEPHONE;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerControl.
 */
public final class CustomerControl {

	/** The log. */
	private static Logger log = Logger.getLogger(CustomerControl.class);

	/** The CUST. */
	private static CUSTOMER CUST = null;

	/**
	 * Instantiates a new customer control.
	 */
	private CustomerControl() {
		super();
	}

	/**
	 * Gets the customers by adress.
	 *
	 * @param pObj the obj
	 * @return the customers by adress
	 */
	@SuppressWarnings("unchecked")
	public static Vector<CUSTOMER> getCustomersByAdress(ADRESS pObj) {
		Vector<CUSTOMER> customers  = new Vector<CUSTOMER>();
		CustomerHelper.setCustomerData((Vector<CUSTOMER>)DaoHelper.getAll(
				(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
		for (int i = 0; i < CustomerHelper.getCustomerData().size(); i++) {
			final CUSTOMER cust = (CUSTOMER)CustomerHelper.getCustomerData().toArray()[i];
			final ADRESS adress = cust.getInvoiceAdress();
			if (adress != null && adress.getId() != null && pObj.getId() != null &&
				adress.getId().longValue() == pObj.getId().longValue()) {
				customers.add((CUSTOMER)CustomerHelper.getCustomerData().toArray()[i]);
			}
		}
		return customers;
	}

	/**
	 * Gets the customers by phone.
	 *
	 * @param pObj the obj
	 * @return the customers by phone
	 */
	@SuppressWarnings("unchecked")
	public static Vector<CUSTOMER> getCustomersByPhone(TELEPHONE pObj) {
		Vector<CUSTOMER> customers  = new Vector<CUSTOMER>();
		CustomerHelper.setCustomerData((Vector<CUSTOMER>)DaoHelper.getAll(
				(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
		for (int i = 0; i < CustomerHelper.getCustomerData().size(); i++) {
			final CUSTOMER cust = (CUSTOMER)CustomerHelper.getCustomerData().toArray()[i];
			final TELEPHONE phone = cust.getInvoicePhone();
			if (phone != null && phone.getId() != null && pObj.getId() != null &&
				phone.getId().longValue() == pObj.getId().longValue()) {
				customers.add((CUSTOMER)CustomerHelper.getCustomerData().toArray()[i]);
			}
		}
		return customers;
	}

	/**
	 * Gets the customers by bank.
	 *
	 * @param pObj the obj
	 * @return the customers by bank
	 */
	@SuppressWarnings("unchecked")
	public static Vector<CUSTOMER> getCustomersByBank(BANK pObj) {
		Vector<CUSTOMER> customers  = new Vector<CUSTOMER>();
		CustomerHelper.setCustomerData((Vector<CUSTOMER>)DaoHelper.getAll(
				(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
		for (int i = 0; i < CustomerHelper.getCustomerData().size(); i++) {
			final CUSTOMER cust = (CUSTOMER)CustomerHelper.getCustomerData().toArray()[i];
			final BANK bank = cust.getInvoiceBank();
			if (bank != null && bank.getId() != null && pObj.getId() != null &&
					bank.getId().longValue() == pObj.getId().longValue()) {
				customers.add((CUSTOMER)CustomerHelper.getCustomerData().toArray()[i]);
			}
		}
		return customers;
	}

	/**
	 * Gets the senders by dao.
	 *
	 * @return the senders by dao
	 */
	public static Vector<CUSTOMER> getSendersByDAO() {
		Vector<CUSTOMER> v = null;
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final Transaction tx = session.beginTransaction();
		v = CUSTOMERDAOimpl.getInstance().getSenders();
		tx.commit();
		session.close();
		return (Vector<CUSTOMER>) v;
	}

	/**
	 * Gets the receives by dao.
	 *
	 * @return the receives by dao
	 */
	public static Vector<CUSTOMER> getReceivesByDAO() {
		Vector<CUSTOMER> v = null;
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final Transaction tx = session.beginTransaction();
		v = CUSTOMERDAOimpl.getInstance().getReceivers();
		tx.commit();
		session.close();
		return v;
	}

	/**
	 * Checks if is used by invoice.
	 *
	 * @param pCustomer the customer
	 * @return true, if is used by invoice
	 */
	public static boolean isUsedByInvoice(final CUSTOMER pCustomer) {
		Vector<INVOICE> invoices =InvoiceHelper.getInvoiceDataByCustomer(pCustomer);
		if (invoices.size() > 0) {
			InvoiceUIValidator.ERROR_TITLE_STR =
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.ERROR_ACTION);
			InvoiceUIValidator.ERROR_STR =
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.ERROR_CUSTOMER_INUSE) +
						": " + invoices.get(0).toString();
			log.info(InvoiceUIValidator.ERROR_STR);
			CommonHelper.showErrorMsgBox();
			return true;
		}
		return false;
	}

	/**
	 * Adds the customer.
	 */
	public static void addCustomer() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				CustomerHelper.setSelectedCustomer(new CUSTOMER());
				CustomerHelper.getCustomerFromGui(CustomerHelper.getSelectedCustomer());
				// TODO MsgBox
				if ("".equals(CustomerHelper.getSelectedCustomer().getLASTNAME())) {
//					System.out.println("No Name ...");
					return;
				}
				CustomerHelper.getCustomerData().add(
						CustomerHelper.getSelectedCustomer());
				final Long id = DaoHelper.create(CustomerHelper.getSelectedCustomer(),
						(InterfaceDAO) CUSTOMERDAOimpl.getInstance());
				Collections.sort(CustomerHelper.getCustomerData());
				CustomerHelper.updateGui();
				log.info("Created Customer with ID " + id);
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
		}

	/**
	 * Update customer.
	 *
	 * @param pCust the cust
	 */
	public static void updateCustomer(final CUSTOMER pCust) {
		CUST = pCust;
		final Runnable doWorkRunnable = new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				if (CUST != null) {
					CustomerHelper.getCustomerFromGui(CUST);
					DaoHelper.update(CUST, (InterfaceDAO) CUSTOMERDAOimpl.getInstance());
					CustomerHelper.setCustomerData(
							(Vector<CUSTOMER>)DaoHelper.getAll(
									(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
					Collections.sort(CustomerHelper.getCustomerData());
					CustomerHelper.updateGui();
					log.info("Updated Customer with ID " + CUST.getId());
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Delete customer.
	 */
	public static void deleteCustomer() {
		final Runnable doWorkRunnable = new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				if (CustomerHelper.getSelectedCustomer() != null) {
					if (! isUsedByInvoice(CustomerHelper.getSelectedCustomer())) {
						if (CommonHelper.actionConfirmation(
								StringHelper.INFO_DELETE_CUSTOMER,
								StringHelper.INFO_ASK_DELETE_CUSTOMER) == 0) {
							final Long id = CustomerHelper.getSelectedCustomer().getId();
							DaoHelper.delete(CUST, (InterfaceDAO) CUSTOMERDAOimpl.getInstance());
							CustomerHelper.setCustomerData(
									(Vector<CUSTOMER>)DaoHelper.getAll(
											(InterfaceDAO) CUSTOMERDAOimpl.getInstance(), true));
							Collections.sort(CustomerHelper.getCustomerData());
							CustomerHelper.updateGui();
							log.info("Deleted Customer with ID: " + id);
						}
					}
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

}
