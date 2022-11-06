package com.cpo.invoice.control;

import java.util.Collections;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.INVOICE_POSITIONDAOimpl;
import com.cpo.invoice.gui.InvoiceHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.PositionHelper;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.INVOICE_POSITION;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class PositionControl.
 */
public final class PositionControl {

	/** The POS. */
	public static INVOICE_POSITION POS = null;

	/** The log. */
	private static Logger log = Logger.getLogger(PositionControl.class);

	/** The Is new. */
	private static boolean IsNew = true;

	/**
	 * Instantiates a new position control.
	 */
	private PositionControl() {
		super();
	}

	/**
	 * Gets the invoice position data.
	 *
	 * @param invoice the invoice
	 * @return the invoice position data
	 */
	@SuppressWarnings("unchecked")
	public static Vector<INVOICE_POSITION> getInvoicePositionData(
			final INVOICE invoice) {
		@SuppressWarnings("rawtypes")
		Vector lObjects = new Vector();
		final Long invoiceID = invoice.getId();
		if (invoiceID == null) {
			return lObjects;
		}
		Vector<INVOICE_POSITION> allPositions =
			(Vector<INVOICE_POSITION>)DaoHelper.getAll(
				(InterfaceDAO) INVOICE_POSITIONDAOimpl.getInstance(), true);
		for (int i = 0; i < allPositions.size(); i++) {
			final INVOICE_POSITION lObject = (INVOICE_POSITION)allPositions.get(i);
			if (lObject.getINVOICE_ID() != null &&
					lObject.getINVOICE_ID().longValue() == invoiceID) {
				lObjects.add(lObject);
			}
		}
		return lObjects;
	}

	/**
	 * Save.
	 *
	 * @param pPos the pos
	 * @param pIsNew the is new
	 */
	public static void save(final INVOICE_POSITION pPos, final boolean pIsNew) {
		POS = pPos;
		IsNew = pIsNew;
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				InvoiceUI.getGui().getJButtonSavePosition().setEnabled(false);
				InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
						InvoiceUI.getGui().getJPanelInvoices());
				if (IsNew) {
					String amnt = null;
					if (POS == null) {
						amnt = InvoiceUI.getGui()
							.getTfInvoicePositionAmount().getText();
						POS = new INVOICE_POSITION();
						PositionHelper.getInvoicePositionFromGui(POS);
					} else { // create a copy of POS
						amnt = POS.getAMOUNT();
					}
					if (amnt != null && !"".equals(amnt) && !"not calculated".equals(amnt)) {
						POS.setNR("" + (Integer.parseInt(getMaxNr()) + 1));
						create();
					}
				} else {
					if (POS != null) {
						PositionHelper.getInvoicePositionFromGui(POS);
						update();
					}
				}
				PositionHelper.updateGui();
			}
		};
		// SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Creates the.
	 *
	 * @return the long
	 */
	private static Long create() {
		final Long id = DaoHelper.create(
				POS, (InterfaceDAO) INVOICE_POSITIONDAOimpl.getInstance());
		PositionHelper.setInvoicePositionData(
				getInvoicePositionData(
						InvoiceHelper.getSelectedInvoice()));
		Collections.sort(PositionHelper.getInvoicePositionData());
		PositionHelper.updateGui();
		log.info("Created Position with ID " + id);
		return id;
	}

	/**
	 * Update.
	 */
	private static void update() {
		DaoHelper.update(POS, (InterfaceDAO) INVOICE_POSITIONDAOimpl.getInstance());
		PositionHelper.setInvoicePositionData(
				getInvoicePositionData(InvoiceHelper.getSelectedInvoice()));
		Collections.sort(PositionHelper.getInvoicePositionData());
		PositionHelper.updateGui();
		log.info("Updated Position with ID " + POS.getId());
	}

	/**
	 * Delete.
	 *
	 * @param pPos the pos
	 */
	public static void delete(final INVOICE_POSITION pPos) {
		POS = pPos;
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				if (POS != null && POS.getId() != null) {
					final String nr = POS.getNR();
					DaoHelper.delete(POS,
							(InterfaceDAO) INVOICE_POSITIONDAOimpl.getInstance());
					PositionHelper.setInvoicePositionData(
							getInvoicePositionData(
									InvoiceHelper.getSelectedInvoice()));
					Collections.sort(PositionHelper.getInvoicePositionData());
					PositionHelper.updateGui();
					log.info("Deleted Position nr " + nr);
				}
			}
		};
		// SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Gets the next pos.
	 *
	 * @param pPos the pos
	 * @param diff the diff
	 * @return the next pos
	 */
	private static INVOICE_POSITION getNextPos(final INVOICE_POSITION pPos, final int diff) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final String max = getMaxNr();
		final INVOICE_POSITIONDAOimpl dao = INVOICE_POSITIONDAOimpl.getInstance();
		final Transaction tx = session.beginTransaction();
		int nr = diff;
		String nrStr = "";
		INVOICE_POSITION nextPos = null;
		boolean noMinMax = CommonHelper.getNoMinMax(nrStr);
		while (nextPos == null && noMinMax && ! max.equals("" + nr)) {
			nrStr = "" + (Integer.parseInt(pPos.getNR()) + nr);
			nextPos = dao.read(InvoiceHelper.getSelectedInvoice(), nrStr);
			nr = nr + diff;
			noMinMax = CommonHelper.getNoMinMax(nrStr);
		}
		tx.commit();
		session.close();
		return nextPos;
	}

	/**
	 * Gets the max nr.
	 *
	 * @return the max nr
	 */
	private static String getMaxNr() {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final INVOICE_POSITIONDAOimpl dao = INVOICE_POSITIONDAOimpl.getInstance();
		final Transaction tx = session.beginTransaction();
		final String max = dao.getMaxNr(InvoiceHelper.getSelectedInvoice());
		tx.commit();
		session.close();
		if (max == null) {
			return "0";
		}
		return max;
	}

	/**
	 * Move.
	 *
	 * @param pPos the pos
	 * @param diff the diff
	 */
	public static void move(final INVOICE_POSITION pPos, final int diff) {
		if (pPos == null || pPos.getNR() == null) {
			return;
		}
		final String nr = pPos.getNR();
		final INVOICE_POSITION nextPos = getNextPos(pPos, diff);
		if (nextPos != null) {
			POS = pPos;
			POS.setNR(nextPos.getNR());
			update();
			POS = nextPos;
			POS.setNR(nr);
			update();
			PositionHelper.updateGui();
		}
	}

	/**
	 * Up.
	 *
	 * @param pPos the pos
	 */
	public static void upper(final INVOICE_POSITION pPos) {
		move(pPos, -1);
	}

	/**
	 * Down.
	 *
	 * @param pPos the pos
	 */
	public static void down(final INVOICE_POSITION pPos) {
		move(pPos, 1);
	}

}
