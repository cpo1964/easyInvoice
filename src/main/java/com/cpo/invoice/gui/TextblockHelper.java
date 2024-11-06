package com.cpo.invoice.gui;

import java.util.Vector;

import com.cpo.invoice.control.InvoiceControl;
import com.cpo.invoice.control.TextblockControl;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.TEXTBLOCK;

/**
 * The Class TextblockHelper.
 */
public final class TextblockHelper {

	/** The is new. */
	protected static boolean isNew = true;

	/** The selected item. */
	private static TEXTBLOCK selectedItem;

	/** The textblock data. */
	private static Vector<TEXTBLOCK> textblockData = new Vector<TEXTBLOCK>();

	/**
	 * Instantiates a new textblock helper.
	 */
	private TextblockHelper() {
		super();
	}

	/**
	 * Gets the selected item.
	 *
	 * @return the selected item
	 */
	public static TEXTBLOCK getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Sets the selected item.
	 *
	 * @param pItem the new selected item
	 */
	public static void setSelectedItem(final TEXTBLOCK pItem) {
		selectedItem = pItem;
	}

	/**
	 * Gets the textblock data.
	 *
	 * @return the textblock data
	 */
	public static Vector<TEXTBLOCK> getTextblockData() {
		return textblockData;
	}

	/**
	 * Sets the textblock data.
	 *
	 * @param pObjects the new textblock data
	 */
	public static void setTextblockData(final Vector<TEXTBLOCK> pObjects) {
		textblockData = pObjects;
	}

	/**
	 * Inits the.
	 */
	protected static void init() {
		InvoiceUI.getGui().getJButtonAddInvoiceTB().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						addTextblock(InvoiceHelper.getSelectedInvoice(),
								getSelectedItem());
						if (getSelectedItem() == null || getSelectedItem().getId() == null) {
							InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
									InvoiceUI.getGui().getJPanelTextblocks());
						} else {
							saveAndUpdate();
							setSelectedItem(new TEXTBLOCK());
						}
					}

				});
		InvoiceUI.getGui().getJButtonUpdateInvoiceTB().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						updateTextblock();
					}
				});
		InvoiceUI.getGui().getJButtonDeleteInvoiceTB().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						TextblockControl.delete(null);
					}
				});
		// button "Invoice Textblocks"-Up (at tab Invoices)
		InvoiceUI.getGui().getJButtonTBUp().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						TextblockControl.upper(getSelectedItem());
					}
				});
		// button "Invoice Textblocks"-Down (at tab Invoices)
		InvoiceUI.getGui().getJButtonTBDown().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						TextblockControl.down(getSelectedItem());
					}
				});
		InvoiceUI.getGui().getJListInvoiceTBs().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyTextblockesSelection();
					}
				});
		InvoiceUI.getGui().getJListInvoiceTBs().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mouseClicked(final java.awt.event.MouseEvent e) {
						if (! InvoiceUI.getGui().getJListInvoiceTBs().isSelectionEmpty() &&
								e.getClickCount() > 1) {
							updateTextblock();
						}
					}
				});
		// button Save at tab "Textblocks"
		InvoiceUI.getGui().getJButtonSaveTB().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						saveAndUpdate();
					}
				});
	}

	/**
	 * Save and update.
	 */
	private static void saveAndUpdate() {
		TextblockControl.save(getSelectedItem(), isNew);
		InvoiceControl.updateInvoice(
				InvoiceHelper.getSelectedInvoice(), false);
	}

	/**
	 * Gets the textblock from gui.
	 *
	 * @param textblock the textblock
	 * @return the textblock from gui
	 */
	public static void getTextblockFromGui(final TEXTBLOCK textblock) {
		textblock.setINVOICE_ID(InvoiceHelper.getSelectedInvoice().getId());
		textblock.setNR(InvoiceUI.getGui().getTfTBNr().getText());
		textblock.setDESCRIBER(InvoiceUI.getGui().getTfTextblockDescription()
				.getText());
		textblock.setTEXT(InvoiceUI.getGui().getJTextAreaTextblock().getText());
	}

	/**
	 * Sets the textblock to gui.
	 *
	 * @param textblock the textblock
	 * @param invoiceNr the invoice nr
	 */
	protected static void setTextblockToGui(final TEXTBLOCK textblock,
			final String invoiceNr) {
		InvoiceUI.getGui().getTfTBInvoiceReadOnlyNr().setText(invoiceNr);
		InvoiceUI.getGui().getTfTBNr().setText(textblock.getNR());
		InvoiceUI.getGui().getTfTextblockDescription().setText(
				textblock.getDESCRIBER());
		InvoiceUI.getGui().getJTextAreaTextblock().setText(textblock.getTEXT());
	}

	/**
	 * Adds the textblock.
	 *
	 * @param pInvoice the invoice
	 * @param pTB the tB
	 */
	protected static void addTextblock(final INVOICE pInvoice, final TEXTBLOCK pTB) {
		isNew = true;
		if (InvoiceHelper.getSelectedInvoice().getId() == null) {
			return;
		}
		if (pTB != null) {
			InvoiceUI.getGui().getTfTBNr().setText(pTB.getNR());
			InvoiceUI.getGui().getTfTextblockDescription().setText(pTB.getDESCRIBER());
			InvoiceUI.getGui().getJTextAreaTextblock().setText(pTB.getTEXT());
		}
		InvoiceUI.getGui().getTfTBInvoiceReadOnlyNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		InvoiceUI.getGui().getTfTBNr().setEnabled(true);
		InvoiceUI.getGui().getJButtonSaveTB().setEnabled(true);
	}

	/**
	 * Update textblock.
	 */
	protected static void updateTextblock() {
		isNew = false;
		if (InvoiceHelper.getSelectedInvoice().getId() == null) {
			return;
		}
		InvoiceUI.getGui().getTfTBInvoiceReadOnlyNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		setSelectedItem((TEXTBLOCK)InvoiceUI.getGui()
				.getJListInvoiceTBs().getSelectedValue());
		if (getSelectedItem() != null) {
			InvoiceUI.getGui().getTfTBNr().setEnabled(false);
			InvoiceUI.getGui().getJButtonSaveTB().setEnabled(true);
			InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
					InvoiceUI.getGui().getJPanelTextblocks());
		}
	}

	/**
	 * Notify textblockes selection.
	 */
	static void notifyTextblockesSelection() {
		final String invoiceNr = InvoiceUI.getGui().getTfInvoiceNr().getText();
		final TEXTBLOCK textblock = (TEXTBLOCK)InvoiceUI.getGui()
			.getJListInvoiceTBs().getSelectedValue();
		setSelectedItem(textblock);
		if (textblock != null) {
			setTextblockToGui(textblock, invoiceNr);
			String text = InvoiceUI.getGui().getBundleValueByKey("btn.Copy");
			InvoiceUI.getGui().getJButtonAddInvoiceTB().setText(text);
			InvoiceUI.getGui().getJButtonUpdateInvoiceTB().setEnabled(true);
			InvoiceUI.getGui().getJButtonDeleteInvoiceTB().setEnabled(true);
			InvoiceUI.getGui().getJButtonSaveTB().setEnabled(true);
		} else {
			setTextblockToGui(new TEXTBLOCK(), invoiceNr);
			String text = InvoiceUI.getGui().getBundleValueByKey("btn.Add");
			InvoiceUI.getGui().getJButtonAddInvoiceTB().setText(text);
			InvoiceUI.getGui().getJButtonUpdateInvoiceTB().setEnabled(false);
			InvoiceUI.getGui().getJButtonDeleteInvoiceTB().setEnabled(false);
			InvoiceUI.getGui().getJButtonSaveTB().setEnabled(false);
		}
		// System.out.println("Textblockes Selection changed()");
	}

	/**
	 * Copy text block.
	 *
	 * @param next the next
	 * @return the tEXTBLOCK
	 */
	protected static TEXTBLOCK copyTextBlock(final TEXTBLOCK next) {
		final TEXTBLOCK tb = new TEXTBLOCK();
		tb.setDESCRIBER(next.getDESCRIBER());
		tb.setId(next.getId());
		tb.setINVOICE_ID(next.getINVOICE_ID());
		tb.setNR(next.getNR());
		tb.setTEXT(next.getTEXT());
		return tb;
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		InvoiceUI.getGui().getJListInvoiceTBs()
			.setListData(getTextblockData());
		InvoiceHelper.notifyInvoicesSelection();
	}
}
