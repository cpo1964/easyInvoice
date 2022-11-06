package com.cpo.invoice.control;

import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.BANKDAOimpl;
import com.cpo.invoice.gui.BankHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.InvoiceUIValidator;
import com.cpo.invoice.model.BANK;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class BankControl.
 */
public class BankControl {
	
	/** The log. */
	private static Logger log = Logger.getLogger(BankControl.class);

	/**
	 *  The static object.
	 *
	 * @param pCust the cust
	 * @return the customer banks by DAO
	 */
//	private static BankControl staticObject = new BankControl();

	/**
	 * Gets the customer banks by dao.
	 *
	 * @param pCust the cust
	 * @return the customer banks by dao
	 */
	@SuppressWarnings("unchecked")
	public static Vector<BANK> getCustomerBanksByDAO(CUSTOMER pCust) {
		Vector<BANK> customerBanks = new Vector<BANK>();
		if (pCust == null) {
			return customerBanks;
		}
		Vector<BANK> allBanks = (Vector<BANK>)DaoHelper.getAll(
				(InterfaceDAO) BANKDAOimpl.getInstance(), true);
		final Iterator<BANK> it = allBanks.iterator();
		while (it.hasNext()) {
			final BANK bank = it.next();
			if (bank.getCUSTOMER_ID() != null &&
				bank.getCUSTOMER_ID().longValue() == pCust.getId()) {
				customerBanks.add(bank);
			}
		}
		return customerBanks;
	}

	/**
	 * Adds the.
	 */
	public static void add() {
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				final BANK bank = new BANK();
				BankHelper.getBankFromGui(bank);
				bank.setCUSTOMER_ID(
						BankHelper.getBankCustomer().getId());
				final Long id = DaoHelper.create(bank, (InterfaceDAO) BANKDAOimpl.getInstance());
				BankHelper.setBankData(getCustomerBanksByDAO(
						BankHelper.getBankCustomer()));
				BankHelper.updateGui();
				log.info("Created Bank with ID " + id);
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
				if (BankHelper.getSelectedBank() != null) {
					BankHelper.getBankFromGui(
							BankHelper.getSelectedBank());
					DaoHelper.update(
							BankHelper.getSelectedBank(),
							(InterfaceDAO) BANKDAOimpl.getInstance());
					BankHelper.setBankData(getCustomerBanksByDAO(
							BankHelper.getBankCustomer()));
					BankHelper.updateGui();
					log.info("Updated Bank with ID " +
							BankHelper.getSelectedBank().getId());
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
				if (BankHelper.getSelectedBank() != null) {
					if (! isUsedByCustomer(BankHelper.getSelectedBank())) {
						if (CommonHelper.actionConfirmation(
								StringHelper.INFO_DELETE_BANK,
								StringHelper.INFO_ASK_DELETE_BANK) == 0) {
							final Long id = BankHelper.getSelectedBank().getId();
							DaoHelper.delete(
									BankHelper.getSelectedBank(),
									(InterfaceDAO) BANKDAOimpl.getInstance());
							BankHelper.setBankData(getCustomerBanksByDAO(
									BankHelper.getBankCustomer()));
							BankHelper.updateGui();
							log.info("Deleted Bank with ID " + id);
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
	 * @param pBank the bank
	 * @return true, if is used by customer
	 */
	private static boolean isUsedByCustomer(final BANK pBank) {
		final Vector<CUSTOMER> customers = CustomerControl.getCustomersByBank(pBank);
		if (customers.size() > 0) {
			InvoiceUIValidator.ERROR_TITLE_STR =
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.ERROR_ACTION);
			InvoiceUIValidator.ERROR_STR =
				InvoiceUI.getGui().getBundleValueByKey(
						StringHelper.ERROR_BANK_INUSE) +
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
				if (BankHelper.getSelectedBank() != null) {
					BankHelper.getSelectedBank().setCUSTOMER_ID(
						BankHelper.getBankCustomer().getId());
				}
				BankHelper.getBankCustomer().setInvoiceBank(
						BankHelper.getSelectedBank());
				CustomerControl.updateCustomer(BankHelper.getBankCustomer());
				BankHelper.updateGui();
				try {
					InvoiceUI.getGui().getJTabbedPane().remove(6);
				} catch (IndexOutOfBoundsException e) {
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
