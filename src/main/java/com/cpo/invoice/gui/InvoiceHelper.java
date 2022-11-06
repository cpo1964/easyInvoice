package com.cpo.invoice.gui;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ListModel;

import org.apache.log4j.Logger;

import com.cpo.invoice.control.InvoiceControl;
import com.cpo.invoice.control.PositionControl;
import com.cpo.invoice.control.TextblockControl;
import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.INVOICEDAOimpl;
import com.cpo.invoice.model.CUSTOMER;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.INVOICE_POSITION;
import com.cpo.invoice.model.TEXTBLOCK;
import com.cpo.invoice.print.InvoicePrinter;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceHelper.
 */
public final class InvoiceHelper {

	/** The log. */
	private static Logger log = Logger.getLogger(InvoiceHelper.class);

	/** The a new. */
	private static boolean aNew;

	/** The sender data. */
	private static Vector<INVOICE> senderData = new Vector<INVOICE>();

	/** The invoice data. */
	private static Vector<INVOICE> invoiceData = new Vector<INVOICE>();

	/** The df. */
	private static SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

	/** The selected invoice. */
	private static INVOICE selectedInvoice = new INVOICE();

	/**
	 * Instantiates a new invoice helper.
	 */
	private InvoiceHelper() {
		super();
	}

	/**
	 * Checks if is a new.
	 *
	 * @return true, if is a new
	 */
	public static boolean isANew() {
		return aNew;
	}

	/**
	 * Sets the a new.
	 *
	 * @param value the new a new
	 */
	public static void setANew(final boolean value) {
		aNew = value;
	}

	/**
	 * Gets the invoice data.
	 *
	 * @return the invoice data
	 */
	public static Vector<INVOICE> getInvoiceData() {
		return invoiceData;
	}

	/**
	 * Sets the invoice data.
	 *
	 * @param objects the new invoice data
	 */
	public static void setInvoiceData(final Vector<INVOICE> objects) {
		invoiceData = objects;
	}

	/**
	 * Gets the selected invoice.
	 *
	 * @return the selected invoice
	 */
	public static INVOICE getSelectedInvoice() {
		return selectedInvoice;
	}

	/**
	 * Sets the selected invoice.
	 *
	 * @param pInvoice the new selected invoice
	 */
	public static void setSelectedInvoice(final INVOICE pInvoice) {
		selectedInvoice = pInvoice;
	}

	/**
	 * Inits the.
	 */
	@SuppressWarnings("unchecked")
	protected static void init() {
		setInvoiceData((Vector<INVOICE>)DaoHelper.getAll(
				(InterfaceDAO) INVOICEDAOimpl.getInstance(), true));
		InvoiceUI.getGui().getJListInvoices().setListData(senderData);
		InvoiceUI.getGui().getJListInvoices().setListData(invoiceData);
		InvoiceUI.getGui().getJButtonAddInvoice().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						if (getSelectedInvoice().getId() == null) {
							setANew(true);
						}
						if (InvoiceUIValidator.validateInvoice() == null) {
							if (getSelectedInvoice().getId() == null) {
								InvoiceControl.addInvoice();
							} else {
								InvoiceControl.copyInvoice(getSelectedInvoice());
							}
						} else {
							CommonHelper.showErrorMsgBox();
						}
						setANew(false);
					}
				});
		InvoiceUI.getGui().getJButtonUpdateInvoice().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						final INVOICE invoice = (INVOICE)InvoiceUI.getGui()
							.getJListInvoices().getSelectedValue();
						if (InvoiceUIValidator.validateInvoice() == null) {
							InvoiceControl.updateInvoice(invoice, true);
						} else {
							CommonHelper.showErrorMsgBox();
						}
					}
				});
		InvoiceUI.getGui().getJButtonDeleteInvoice().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						InvoiceControl.deleteInvoice();
					}
				});
		InvoiceUI.getGui().getJButtonPrintInvoice().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
//						if (InvoiceUIValidator.validateInvoice() == null) {
							printInvoice();
//						} else {
//							CommonHelper.showErrorMsgBox();
//						}
					}
				});
		InvoiceUI.getGui().getJListInvoices().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyInvoicesSelection();
					}
				});
		notifyBookingYearChanged();
	}

	/**
	 * Gets the invoice from gui.
	 *
	 * @param invoice the invoice
	 * @return the invoice from gui
	 */
	public static void getInvoiceFromGui(final INVOICE invoice) {
		invoice.setNR(InvoiceUI.getGui().getTfInvoiceNr().getText());
		invoice.setINV_DATE(
				df.format(InvoiceUI.getGui().getJDateChooserDate().getDate()));
		invoice.setPAY_UNTIL(
				df.format(InvoiceUI.getGui().getJDateChooserPayUntil().getDate()));
		// settings
		invoice.setTAX1(InvoiceUI.getGui().getTfTax1().getText());
		invoice.setTAX2(InvoiceUI.getGui().getTfTax2().getText());
		invoice.setTAX3(InvoiceUI.getGui().getTfTax3().getText());
		invoice.setCURRENCY((String)InvoiceUI.getGui()
				.getJComboBoxCurrency().getSelectedItem());
		invoice.setLANGUAGE((String)InvoiceUI.getGui()
				.getJComboBoxLanguage().getSelectedItem());
		// get sender
		final Object objSender =
			InvoiceUI.getGui().getJComboBoxSender().getSelectedItem();
		if (objSender instanceof CUSTOMER) {
			invoice.setSENDER((CUSTOMER)objSender);
		} else {
			invoice.setSENDER(null);
		}
		// get receiver
		final Object objReceiver = InvoiceUI.getGui().getJComboBoxReceiver()
				.getSelectedItem();
		if (objReceiver instanceof CUSTOMER) {
			invoice.setRECEIVER((CUSTOMER)objReceiver);
		} else {
			invoice.setRECEIVER(null);
		}
	}

	/**
	 * Sets the invoice to gui.
	 *
	 * @param invoice the new invoice to gui
	 */
	public static void setInvoiceToGui(final INVOICE invoice) {
		// main attrs
		InvoiceUI.getGui().getTfInvoiceNr().setText(invoice.getNR());
		try {
			if (invoice.getINV_DATE() != null) {
				InvoiceUI.getGui().getJDateChooserDate()
					.setDate(df.parse(invoice.getINV_DATE()));
			}
			if (invoice.getPAY_UNTIL() != null) {
				InvoiceUI.getGui().getJDateChooserPayUntil()
					.setDate(df.parse(invoice.getPAY_UNTIL()));
			}
		} catch (ParseException e) {
		}
		// set sender
		final CUSTOMER sender = invoice.getSENDER();
		if (sender != null) {
			final int ix = CustomerHelper.getInvoiceSenderIndex(sender);
//			log.debug("sender: " + ix);
			InvoiceUI.getGui().getJComboBoxSender().setSelectedIndex(ix);
		} else {
			InvoiceUI.getGui().getJComboBoxSender().setSelectedIndex(0);
		}
		// set receiver
		final CUSTOMER receiver = invoice.getRECEIVER();
		if (receiver != null) {
			final int ix = CustomerHelper.getInvoiceReceiverIndex(receiver);
//			log.debug("receiver: " + ix);
			InvoiceUI.getGui().getJComboBoxReceiver().setSelectedIndex(ix);
		} else {
			InvoiceUI.getGui().getJComboBoxReceiver().setSelectedIndex(0);
		}
		// tab Settings
		InvoiceUI.getGui().getTfSettingsInvoiceNr().setText(invoice.getNR());
		if (invoice.getId() != null) {
			InvoiceUI.getGui().getTfTax1().setText(invoice.getTAX1());
			InvoiceUI.getGui().getTfTax2().setText(invoice.getTAX2());
			InvoiceUI.getGui().getTfTax3().setText(invoice.getTAX3());
		}
		// tab Invoice-Position
		InvoiceUI.getGui().getTfPosInvoiceReadOnlyNr().setText(invoice.getNR());
		// tab Textblock
		InvoiceUI.getGui().getTfTBInvoiceReadOnlyNr().setText(invoice.getNR());
	}

	/**
	 * Copy textblocks.
	 *
	 * @param fromInvoice the from invoice
	 * @param toInvoice the to invoice
	 */
	public static void copyTextblocks(
			final INVOICE fromInvoice, final INVOICE toInvoice) {
		Vector<TEXTBLOCK> tbs =
			TextblockControl.getTextblockData(fromInvoice);
		final Iterator<TEXTBLOCK> it = tbs.iterator();
		while (it.hasNext()) {
			final TEXTBLOCK tb = TextblockHelper.copyTextBlock(it.next());
			tb.setINVOICE_ID(toInvoice.getId());
			// persist new tb
			TextblockControl.save(tb, true);
			toInvoice.addTEXTBLOCK(tb);
		}
	}

	/**
	 * Copy positions.
	 *
	 * @param fromInvoice the from invoice
	 * @param toInvoice the to invoice
	 */
	public static void copyPositions(
			final INVOICE fromInvoice, final INVOICE toInvoice) {
		Vector<INVOICE_POSITION> positions =
			PositionControl.getInvoicePositionData(fromInvoice);
		final Iterator<INVOICE_POSITION> it = positions.iterator();
		while (it.hasNext()) {
			final INVOICE_POSITION pos = PositionHelper.copyPosition(it.next());
			// persist new pos
			pos.setINVOICE_ID(toInvoice.getId());
			PositionControl.save(pos, true);
			toInvoice.addINVOICE_POSITION(pos);
		}
	}

	/**
	 * Delete dependencies.
	 *
	 * @param selInvoice the sel invoice
	 */
	public static void deleteDependencies(final INVOICE selInvoice) {
		Vector<INVOICE_POSITION> positions =
			PositionControl.getInvoicePositionData(selInvoice);
		final Iterator<INVOICE_POSITION> itPos = positions.iterator();
		while (itPos.hasNext()) {
			// delete pos
			PositionControl.delete(itPos.next());
		}
		final Vector<TEXTBLOCK> tbs = TextblockControl.getTextblockData(selInvoice);
		final Iterator<TEXTBLOCK> itTB = tbs.iterator();
		while (itTB.hasNext()) {
			// delete tb
			TextblockControl.delete(itTB.next());
		}
	}

	/**
	 * Prints the invoice.
	 */
	protected static void printInvoice() {
		if (getSelectedInvoice().getId() == null) {
			return;
		}
		final INVOICE invoice = (INVOICE)DaoHelper.getByID(
				(InterfaceDAO) INVOICEDAOimpl.getInstance(), getSelectedInvoice().getId(), true);
		if (invoice != null) {
			InvoicePrinter.printInvoice(invoice);
		}
	}

	/**
	 * Gets the invoice data by customer.
	 * used by CustomerControl
	 *
	 * @param pCustomer the customer
	 * @return the invoice data by customer
	 */
	@SuppressWarnings("unchecked")
	public static Vector<INVOICE> getInvoiceDataByCustomer(final CUSTOMER pCustomer) {
		log.debug("checking Customer with ID: " + pCustomer.getId());
		final Vector<INVOICE> invoices  = new Vector<INVOICE>();
		final Vector<INVOICE> allInvoices = (Vector<INVOICE>)DaoHelper.getAll(
				(InterfaceDAO) INVOICEDAOimpl.getInstance(), true);
		for (int i = 0; i < allInvoices.size(); i++) {
			if (allInvoices.get(i).getRECEIVER() != null &&
					allInvoices.get(i).getSENDER() != null) {
				final Long receiverID = allInvoices.get(i).getRECEIVER().getId();
				final Long senderID = allInvoices.get(i).getSENDER().getId();
				log.debug("with receiver with ID: " + receiverID);
				log.debug("with sender with ID: " + senderID);
				if (receiverID.longValue() == pCustomer.getId().longValue() ||
						senderID.longValue() == pCustomer.getId().longValue()) {
					invoices.add(allInvoices.get(i));
				}
			}
		}
		return invoices;
	}

	/**
	 * Gets the invoice data.
	 * used by notifyBookingYearChanged
	 *
	 * @param pYear the year
	 * @return the invoice data
	 */
	@SuppressWarnings("unchecked")
	private static Vector<INVOICE> getInvoiceDataByYear(final String pYear) {
		final Vector<INVOICE> invoices  = new Vector<INVOICE>();
		final Vector<INVOICE> allInvoiceData = (Vector<INVOICE>)DaoHelper.getAll(
				(InterfaceDAO) INVOICEDAOimpl.getInstance(), false);
		for (int i = 0; i < allInvoiceData.size(); i++) {
			final String dateStr = allInvoiceData.get(i).getINV_DATE();
			if (dateStr != null && dateStr.endsWith(pYear)) {
				invoices.add(allInvoiceData.get(i));
			}
		}
		return invoices;
	}

	/**
	 * Notify invoices selection.
	 */
	static void notifyInvoicesSelection() {
		final Object objInvoice =
			InvoiceUI.getGui().getJListInvoices().getSelectedValue();
		if (objInvoice != null) {
			maintainInvoiceSelection(objInvoice);
		} else {
			maintainInvoiceDeselection();
		}
		// System.out.println("Invoices Selection changed()");
	}

	/**
	 * Maintain invoice deselection.
	 */
	static void maintainInvoiceDeselection() {
		SettingsHelper.changeLanguage(null);
		setSelectedInvoice(new INVOICE());
		setInvoiceToGui(getSelectedInvoice());
		PositionHelper.setInvoicePositionData(new Vector<INVOICE_POSITION>());
		TextblockHelper.setTextblockData(new Vector<TEXTBLOCK>());
		InvoiceUI.getGui().getJListInvoices().clearSelection();
		updateInvoiceListsToGui();
		enableButtons(false);
		InvoiceUI.getGui().getJButtonAddInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.BTN_ADD));
	}

	/**
	 * Maintain invoice selection.
	 *
	 * @param objInvoice the obj invoice
	 */
	static void maintainInvoiceSelection(final Object objInvoice) {
		setSelectedInvoice((INVOICE)objInvoice);
		setInvoiceToGui(getSelectedInvoice());
		SettingsHelper.changeLanguage(getSelectedInvoice().getLANGUAGE());
		updateInvoiceListsToGui();
		enableButtons(true);
		InvoiceUI.getGui().getJButtonAddInvoice().setText(
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.BTN_COPY));
	}

	/**
	 * Update invoice lists to gui.
	 */
	private static void updateInvoiceListsToGui() {
		PositionHelper.setInvoicePositionData(PositionControl
				.getInvoicePositionData(getSelectedInvoice()));
		Collections.sort(PositionHelper.getInvoicePositionData());
		TextblockHelper.setTextblockData(TextblockControl
				.getTextblockData(getSelectedInvoice()));
		Collections.sort(TextblockHelper.getTextblockData());
		InvoiceUI.getGui().getJListInvoicePositions().setListData(
				PositionHelper.getInvoicePositionData());
		InvoiceUI.getGui().getJListInvoiceTBs().setListData(
				TextblockHelper.getTextblockData());
	}

	/**
	 * Enable buttons.
	 *
	 * @param b the b
	 */
	private static void enableButtons(final boolean b) {
		InvoiceUI.getGui().getJButtonAddPosition().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeletePosition().setEnabled(false);
		InvoiceUI.getGui().getJButtonAddInvoiceTB().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeleteInvoiceTB().setEnabled(false);
		InvoiceUI.getGui().getJButtonUpdateInvoice().setEnabled(b);
		InvoiceUI.getGui().getJButtonDeleteInvoice().setEnabled(b);
		InvoiceUI.getGui().getJButtonPrintInvoice().setEnabled(b);
	}

	/**
	 * Notify booking year changed.
	 */
	public static void notifyBookingYearChanged() {
		Vector<INVOICE> invoiceDataByYear = getInvoiceDataByYear(
				InvoiceUI.getGui().getTfBookingYear().getText());
		setInvoiceData(invoiceDataByYear);
		Collections.sort(getInvoiceData());
		updateGui();
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		InvoiceUI.getGui().getJListInvoices().setListData(getInvoiceData());
		if (InvoiceUI.getGui().getJListInvoices().getModel().getSize() > 0) {
			System.out.println("hurra");
		}
		maintainInvoiceSelection(getSelectedInvoice());
	}

}
