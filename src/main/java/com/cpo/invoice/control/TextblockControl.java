package com.cpo.invoice.control;

import java.util.Collections;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.TEXTBLOCKDAOimpl;
import com.cpo.invoice.gui.InvoiceHelper;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.TextblockHelper;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.TEXTBLOCK;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class TextblockControl.
 */
public final class TextblockControl {

	/** The log. */
	private static Logger log = Logger.getLogger(TextblockControl.class);

	/** The TB. */
	private static TEXTBLOCK TB = null;

	/** The Is new. */
	private static boolean isNew = true;

	/**
	 * Instantiates a new textblock control.
	 */
	private TextblockControl() {
		super();
	}

	/**
	 * Gets the textblock data.
	 *
	 * @param invoice the invoice
	 * @return the textblock data
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector<TEXTBLOCK> getTextblockData(INVOICE invoice) {
		Vector vTextblocks = new Vector();
		final Long invoiceID = invoice.getId();
		if (invoiceID == null) {
			return vTextblocks;
		}
		Vector v = null;
		v = DaoHelper.getAll((InterfaceDAO) TEXTBLOCKDAOimpl.getInstance(), true);
		for (int i = 0; i < v.size(); i++) {
			final TEXTBLOCK lObject = (TEXTBLOCK)v.get(i);
			if (lObject.getINVOICE_ID() != null &&
					lObject.getINVOICE_ID().longValue() == invoiceID) {
				vTextblocks.add(lObject);
			}
		}
		return vTextblocks;
	}

	/**
	 * Save.
	 *
	 * @param pTB the tB
	 * @param pIsNew the is new
	 */
	public static void save(final TEXTBLOCK pTB, final boolean pIsNew) {
		TB = pTB;
		isNew = pIsNew;
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				InvoiceUI.getGui().getJButtonSaveTB().setEnabled(false);
				InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
						InvoiceUI.getGui().getJPanelInvoices());
				if (isNew) {
					if (TB == null) {
						TB = new TEXTBLOCK(); // a new TB
						TextblockHelper.getTextblockFromGui(TB);
					} // else create a copy of pTB
					TB.setNR("" + (Integer.parseInt(getMaxNr()) + 1));
					if (TB.getTEXT() == null || "".equals(TB.getTEXT())) {
//						TB.setDESCRIBER("-");
						TB.setTEXT("-");
					}
					create();
				} else {
					if (TB != null) {
						TextblockHelper.getTextblockFromGui(TB);
						update();
					}
				}
				TextblockHelper.updateGui();
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Creates the.
	 */
	private static void create() {
		final Long id = DaoHelper.create(TB, (InterfaceDAO) TEXTBLOCKDAOimpl.getInstance());
		TextblockHelper.setTextblockData(getTextblockData(
				InvoiceHelper.getSelectedInvoice()));
		Collections.sort(TextblockHelper.getTextblockData());
		log.debug("Created Textblock with ID " + id);
	}

	/**
	 * Update.
	 */
	private static void update() {
		DaoHelper.update(TB, (InterfaceDAO) TEXTBLOCKDAOimpl.getInstance());
		TextblockHelper.setTextblockData(getTextblockData(
				InvoiceHelper.getSelectedInvoice()));
		Collections.sort(TextblockHelper.getTextblockData());
		log.debug("Updated Textblock with ID " + TB.getId());
	}

	/**
	 * Delete.
	 *
	 * @param pTB the tB
	 */
	public static void delete(final TEXTBLOCK pTB) {
		TB = pTB;
		final Runnable doWorkRunnable = new Runnable() {
			public void run() {
				TEXTBLOCK tb = TextblockHelper.getSelectedItem();
				if (TB != null) {
					tb = TB;
				}
				if (tb != null) {
					final Long id = tb.getId();
					DaoHelper.delete(tb, (InterfaceDAO) TEXTBLOCKDAOimpl.getInstance());
					TextblockHelper.setTextblockData(getTextblockData(
							InvoiceHelper.getSelectedInvoice()));
					Collections.sort(TextblockHelper.getTextblockData());
					log.debug("Deleted Textblock with ID " + id);
				}
				TextblockHelper.updateGui();
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Gets the next tb.
	 *
	 * @param pTB the tB
	 * @param diff the diff
	 * @return the next tb
	 */
	private static TEXTBLOCK getNextTB(final TEXTBLOCK pTB, final int diff) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final String max = getMaxNr();
		final TEXTBLOCKDAOimpl dao = TEXTBLOCKDAOimpl.getInstance();
		final Transaction tx = session.beginTransaction();
		int nr = diff;
		String nrStr = "";
		TEXTBLOCK nextTB = null;
		boolean noMinMax = CommonHelper.getNoMinMax(nrStr);
		while (nextTB == null && noMinMax && ! max.equals("" + nr)) {
			nrStr = "" + (Integer.parseInt(pTB.getNR()) + nr);
			nextTB = dao.read(InvoiceHelper.getSelectedInvoice(), nrStr);
			nr = nr + diff;
			noMinMax = CommonHelper.getNoMinMax(nrStr);
		}
		tx.commit();
		session.close();
		return nextTB;
	}

	/**
	 * Gets the max nr.
	 *
	 * @return the max nr
	 */
	private static String getMaxNr() {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		final TEXTBLOCKDAOimpl dao = TEXTBLOCKDAOimpl.getInstance();
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
	 * @param pTB the tB
	 * @param diff the diff
	 */
	public static void move(final TEXTBLOCK pTB, final int diff) {
		if (pTB == null || pTB.getNR() == null) {
			return;
		}
		final String nr = pTB.getNR();
		final TEXTBLOCK nextTB = getNextTB(pTB, diff);
		if (nextTB != null) {
			TB = pTB;
			TB.setNR(nextTB.getNR());
			update();
			TB = nextTB;
			TB.setNR(nr);
			update();
			TextblockHelper.updateGui();
		}
	}

	/**
	 * Up.
	 *
	 * @param pTB the tB
	 */
	public static void upper(final TEXTBLOCK pTB) {
		move(pTB, -1);
	}

	/**
	 * Down.
	 *
	 * @param pTB the tB
	 */
	public static void down(final TEXTBLOCK pTB) {
		move(pTB, 1);
	}
}
