package com.cpo.invoice.control;

import java.util.Collections;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.INVOICEDAOimpl;
import com.cpo.invoice.gui.InvoiceHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.util.CommonHelper;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceControl.
 */
public final class InvoiceControl {

	/** The log. */
	private static Logger log = Logger.getLogger(InvoiceControl.class);

	/**
	 * Instantiates a new invoice control.
	 */
	private InvoiceControl() {
		super();
	}

	/**
	 * Gets the by nr.
	 *
	 * @param nr the nR
	 * @return the by nr
	 */
	public static Object getByNR(final String nr) {
		if (nr == null) {
			return null;
		}
		final INVOICEDAOimpl dao = INVOICEDAOimpl.getInstance();
		final Transaction tx = dao.getSession().beginTransaction();
		final Object inv = dao.getByNR(nr);
		tx.commit();
		INVOICEDAOimpl.getInstance().getSession().close();
		return inv;
	}

	/**
	 * Adds the invoice.
	 *
	 * @return the iNVOICE
	 */
	public static INVOICE addInvoice() {
		final INVOICE inv = new INVOICE();
		InvoiceHelper.getInvoiceFromGui(inv);
		final Long id = DaoHelper.create(inv, (InterfaceDAO) INVOICEDAOimpl.getInstance());
		InvoiceHelper.getInvoiceData().add(inv);
		InvoiceHelper.updateGui();
		log.info("Created Invoice with ID " + id);
		return inv;
	}

	/**
	 * Update invoice.
	 *
	 * @param pInvoice the invoice
	 * @param updateGui the update gui
	 */
	@SuppressWarnings("unchecked")
	public static void updateInvoice(final INVOICE pInvoice, final boolean updateGui) {
		if (pInvoice != null) {
			final INVOICE inv = (INVOICE)DaoHelper.getByID(
					(InterfaceDAO) INVOICEDAOimpl.getInstance(), pInvoice.getId(), false);
			InvoiceHelper.getInvoiceFromGui(inv);
			DaoHelper.update(inv, (InterfaceDAO) INVOICEDAOimpl.getInstance());
			InvoiceHelper.setInvoiceData(
					(Vector<INVOICE>)DaoHelper.getAll(
							(InterfaceDAO) INVOICEDAOimpl.getInstance(), true));
			Collections.sort(InvoiceHelper.getInvoiceData());
			if (updateGui) {
				final int sel = InvoiceUI.getGui().getJListInvoices().getSelectedIndex();
				InvoiceHelper.updateGui();
				InvoiceHelper.notifyBookingYearChanged();
				InvoiceUI.getGui().getJListInvoices().setSelectedIndex(sel);
			}
			log.info("Updated Invoice with ID " + inv.getId());
		}
	}

	/**
	 * Delete invoice.
	 */
	@SuppressWarnings("unchecked")
	public static void deleteInvoice() {
		if (CommonHelper.actionConfirmation(
				StringHelper.INFO_DELETE_INVOICE,
				StringHelper.INFO_ASK_DELETE_INVOICE) == 1) {
			return;
		}
		final INVOICE inv =
			(INVOICE)InvoiceUI.getGui().getJListInvoices().getSelectedValue();
		if (inv != null) {
			InvoiceHelper.deleteDependencies(inv);
			DaoHelper.delete(inv, (InterfaceDAO) INVOICEDAOimpl.getInstance());
			InvoiceHelper.setInvoiceData((Vector<INVOICE>)DaoHelper.getAll(
					(InterfaceDAO) INVOICEDAOimpl.getInstance(), false));
			Collections.sort(InvoiceHelper.getInvoiceData());
			InvoiceHelper.updateGui();
			InvoiceHelper.notifyBookingYearChanged();
			log.info("Deleted Invoice with ID " + inv.getId());
		}
	}

	/**
	 * Copy invoice.
	 *
	 * @param pFromInvoice the from invoice
	 */
	@SuppressWarnings("unchecked")
	public static void copyInvoice(final INVOICE pFromInvoice) {
		final int sel = InvoiceUI.getGui().getJListInvoices().getSelectedIndex();
		final INVOICE completeInvoice = (INVOICE)DaoHelper.getByID(
				(InterfaceDAO) INVOICEDAOimpl.getInstance(), pFromInvoice.getId(), false);
		final INVOICE toInvoice = addInvoice();
		InvoiceHelper.copyPositions(completeInvoice, toInvoice);
		updateInvoice(toInvoice, true);
		InvoiceHelper.copyTextblocks(completeInvoice, toInvoice);
		updateInvoice(toInvoice, true);
		completeInvoice.setNR(completeInvoice.getNR() + " - " +
				InvoiceUI.getGui().getBundleValueByKey(StringHelper.COPY));
		InvoiceHelper.setInvoiceToGui(completeInvoice);
		updateInvoice(toInvoice, true);
		InvoiceHelper.setInvoiceData(
				(Vector<INVOICE>)DaoHelper.getAll(
						(InterfaceDAO) INVOICEDAOimpl.getInstance(), true));
		Collections.sort(InvoiceHelper.getInvoiceData());
		InvoiceHelper.updateGui();
		InvoiceHelper.notifyBookingYearChanged();
		// select the copied invoice
		InvoiceUI.getGui().getJListInvoices().setSelectedIndex(sel + 1);
	}

}
