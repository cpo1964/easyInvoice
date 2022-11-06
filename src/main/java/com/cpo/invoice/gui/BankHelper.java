package com.cpo.invoice.gui;

import java.util.Vector;

import com.cpo.invoice.control.BankControl;
import com.cpo.invoice.model.BANK;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class BankHelper.
 */
public final class BankHelper {

	/** The bank data. */
	private static Vector<BANK> bankData = new Vector<BANK>();

	/** The selected bank. */
	private static BANK selectedBank = null;

	/** The bank customer. */
	private static CUSTOMER bankCustomer = null;

	/**
	 * Instantiates a new bank helper.
	 */
	private BankHelper() {
		super();
	}

	/**
	 * Gets the bank customer.
	 *
	 * @return the bank customer
	 */
	public static CUSTOMER getBankCustomer() {
		return bankCustomer;
	}

	/**
	 * Sets the bank customer.
	 *
	 * @param pValue the new bank customer
	 */
	public static void setBankCustomer(final CUSTOMER pValue) {
		BankHelper.bankCustomer = pValue;
	}

	/**
	 * Gets the bank data.
	 *
	 * @return the bank data
	 */
	public static Vector<BANK> getBankData() {
		return bankData;
	}

	/**
	 * Sets the bank data.
	 *
	 * @param banks the new bank data
	 */
	public static void setBankData(final Vector<BANK> banks) {
		bankData = banks;
	}

	/**
	 * Gets the selected bank.
	 *
	 * @return the selected bank
	 */
	public static BANK getSelectedBank() {
		return selectedBank;
	}

	/**
	 * Sets the selected bank.
	 *
	 * @param pValue the new selected bank
	 */
	public static void setSelectedBank(final BANK pValue) {
		selectedBank = pValue;
	}

	/**
	 * Inits the.
	 */
	static void init() {
		InvoiceUI.getGui().getTfAccountNr().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfBLZ().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		// some listeners
		InvoiceUI.getGui().getJButtonAddBank().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						BankControl.add();
						notifyBankSelection();
					}
				});
		InvoiceUI.getGui().getJButtonUpdateBank().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						final int sel = InvoiceUI.getGui().getJListBanks()
							.getSelectedIndex();
						BankControl.update();
						notifyBankSelection();
						InvoiceUI.getGui().getJListBanks()
							.setSelectedIndex(sel);
					}
				});
		InvoiceUI.getGui().getJButtonDeleteBank().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						BankControl.delete();
						notifyBankSelection();
					}
				});
		InvoiceUI.getGui().getJButtonAssignBank().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						BankControl.assign();
						notifyBankSelection();
					}
				});
		InvoiceUI.getGui().getJListBanks().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyBankSelection();
					}
				});
	}

	/**
	 * Gets the bank from gui.
	 *
	 * @param bank the bank
	 * @return the bank from gui
	 */
	public static void getBankFromGui(final BANK bank) {
		bank.setNAME(InvoiceUI.getGui().getTfBank_Name().getText());
		bank.setACCOUNT_NR(InvoiceUI.getGui().getTfAccountNr().getText());
		bank.setBLZ(InvoiceUI.getGui().getTfBLZ().getText());
		bank.setBIC(InvoiceUI.getGui().getTfBIC().getText());
		bank.setIBAN(InvoiceUI.getGui().getTfIBAN().getText());
	}

	/**
	 * Sets the bank to gui.
	 *
	 * @param bank the new bank to gui
	 */
	protected static void setBankToGui(final BANK bank) {
		InvoiceUI.getGui().getTfBank_Name().setText(bank.getNAME());
		InvoiceUI.getGui().getTfAccountNr().setText(bank.getACCOUNT_NR());
		InvoiceUI.getGui().getTfBLZ().setText(bank.getBLZ());
		InvoiceUI.getGui().getTfBIC().setText(bank.getBIC());
		InvoiceUI.getGui().getTfIBAN().setText(bank.getIBAN());
	}

	/**
	 * Notify bank selection.
	 */
	protected static void notifyBankSelection() {
		setSelectedBank(
				(BANK)InvoiceUI.getGui().getJListBanks().getSelectedValue());
		if (getSelectedBank() != null) {
			setBankToGui(getSelectedBank());
			enableButtons(true);
		} else {
			setBankToGui(new BANK());
			enableButtons(false);
		}
		// System.out.println("Banks Selection changed()");
	}

	/**
	 * Enable buttons.
	 *
	 * @param b the b
	 */
	private static void enableButtons(final boolean b) {
		InvoiceUI.getGui().getJButtonAddBank().setEnabled(true);
		InvoiceUI.getGui().getJButtonUpdateBank().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeleteBank().setEnabled(b);
		InvoiceUI.getGui().getJButtonAssignBank().setEnabled(true);
	}

	/**
	 * Modify customer bank.
	 */
	protected static void modifyCustomerBank() {
		CustomerHelper.setCustomerDetailTitle(StringHelper.TAB_NAME_BANKS);
		if (CustomerHelper.getSelectedCustomer() != null) {
			setBankCustomer(CustomerHelper.getSelectedCustomer());
			setBankData(BankControl.getCustomerBanksByDAO(getBankCustomer()));
			updateGui();
			InvoiceUI.showTab(
					InvoiceUI.getGui().getJPanelBanks(),
					StringHelper.TAB_NAME_BANKS);
			final BANK customerInvoiceBank = getBankCustomer().getInvoiceBank();
			if (customerInvoiceBank == null) {
				setBankToGui(new BANK());
			} else {
				setBankToGui(customerInvoiceBank);
				final int sel = getSelectedIndex(getBankData(), customerInvoiceBank);
				InvoiceUI.getGui().getJListBanks().setSelectedIndex(sel);
			}
		}
	}

	/**
	 * Gets the selected index.
	 *
	 * @param objects the objects
	 * @param bank the bank
	 * @return the selected index
	 */
	private static int getSelectedIndex(final Vector<BANK> objects,
			final BANK bank) {
		for (int i = 0; i < objects.size(); i++) {
			if (((BANK)objects.toArray()[i]).getId().longValue()
					== bank.getId().longValue()) {
				return i;
			}
		}
		return -1; // no selection
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		String bankCustomerStr = getBankCustomer().toString();
		if (getBankCustomer().getInvoiceBank() != null) {
			bankCustomerStr = bankCustomerStr + " - " +
			getBankCustomer().getInvoiceBank().toString();
		}
		InvoiceUI.getGui().getTfBankCustomer().setText(bankCustomerStr);
		InvoiceUI.getGui().getJListBanks().
			setListData(getBankData().toArray());
	}
}
