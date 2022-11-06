package com.cpo.invoice.gui;


import java.io.Serializable;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import com.cpo.invoice.control.InvoiceControl;
import com.cpo.invoice.control.PositionControl;
import com.cpo.invoice.model.ARTICLE;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.INVOICE_POSITION;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class PositionHelper.
 */
public class PositionHelper {

	/** The is new. */
	protected static boolean isNew = true;
	
	/** The selected item. */
	private static INVOICE_POSITION selectedItem = null;
	
	/** The invoice position data. */
	private static Vector<INVOICE_POSITION> invoicePositionData = 
		new Vector<INVOICE_POSITION>();
	
	/** The pos article model. */
	private static ComboBoxModel posArticleModel = null;

	/**
	 * Gets the selected item.
	 *
	 * @return the selected item
	 */
	public static INVOICE_POSITION getSelectedItem() {
		return selectedItem;
	}

	/**
	 * Sets the selected item.
	 *
	 * @param value the new selected item
	 */
	public static void setSelectedItem(INVOICE_POSITION value) {
		selectedItem = value;
	}
	
	/**
	 * Gets the invoice position data.
	 *
	 * @return the invoice position data
	 */
	public static Vector<INVOICE_POSITION> getInvoicePositionData() {
		return invoicePositionData;
	}

	/**
	 * Sets the invoice position data.
	 *
	 * @param objects the new invoice position data
	 */
	public static void setInvoicePositionData(
			Vector<INVOICE_POSITION> objects) {
		invoicePositionData = objects;
	}

	/**
	 * Gets the pos article model.
	 *
	 * @return the pos article model
	 */
	public static ComboBoxModel getPosArticleModel() {
		return posArticleModel;
	}

	/**
	 * Sets the pos article model.
	 *
	 * @param obj the new pos article model
	 */
	public static void setPosArticleModel(ComboBoxModel obj) {
		posArticleModel = obj;
	}

	/**
	 * Fill pos article model.
	 *
	 * @return the combo box model
	 */
	public static ComboBoxModel fillPosArticleModel() {
		Vector<Serializable> v = new Vector<Serializable>();
		v.add("");
		v.addAll(ArticleHelper.getArticleData());
		return new DefaultComboBoxModel(v);
	}

	/**
	 * Inits the.
	 */
	protected static void init() {
		InvoiceUI.getGui().getTfInvoicePositionNr().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		InvoiceUI.getGui().getTfInvoicePositionQuantity().setDocument(
				CommonHelper.getNurZahlenPlainDocument());
		setPosArticleModel(fillPosArticleModel());
		InvoiceUI.getGui().
			getJComboBoxPositionArticle().setModel(getPosArticleModel());
		// some listeners
		// button "Invoice Positions"-Add (at tab Invoices)
		InvoiceUI.getGui().getJButtonAddPosition().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						addInvoicePosition(InvoiceHelper.getSelectedInvoice(),
								getSelectedItem());
						if (getSelectedItem() == null || getSelectedItem().getId() == null) {
							InvoiceUI.getGui().getJTabbedPane()
								.setSelectedComponent(InvoiceUI.getGui()
										.getJPanelInvoicesPosition());
						} else {
							saveAndUpdate();
							setSelectedItem(new INVOICE_POSITION());
							InvoiceHelper.maintainInvoiceSelection(InvoiceHelper.getSelectedInvoice());
						}
					}
				});
		// button "Invoice Positions"-Update (at tab Invoices)
		InvoiceUI.getGui().getJButtonUpdatePosition().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						updateInvoicePosition();
					}
				});
		// button "Invoice Positions"-Delete (at tab Invoices)
		InvoiceUI.getGui().getJButtonDeletePosition().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PositionControl.delete(getSelectedItem());
					}
				});
		// button "Invoice Positions"-Up (at tab Invoices)
		InvoiceUI.getGui().getJButtonPosUp().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PositionControl.upper(getSelectedItem());
					}
				});
		// button "Invoice Positions"-Down (at tab Invoices)
		InvoiceUI.getGui().getJButtonPosDown().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						PositionControl.down(getSelectedItem());
					}
				});
		// list of invoice positions (at tab invoices)
		InvoiceUI.getGui().getJListInvoicePositions().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent e) {
						notifyInvoicePositionsSelection();
					}
				});
		InvoiceUI.getGui().getJListInvoicePositions().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						if (!InvoiceUI.getGui().getJListInvoicePositions().isSelectionEmpty() &&
								e.getClickCount() > 1) {
							updateInvoicePosition();
						}
					}
				});
		// textfield Quantity (at tab "Invoice Position")
		InvoiceUI.getGui().
			getTfInvoicePositionQuantity().addFocusListener(InvoiceUI.getGui());

		// drop down article (at tab "Invoice Position")
		InvoiceUI.getGui().getJComboBoxPositionArticle().
			addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				notifyArticleSelection();
			}
		});
		// button Save (at tab "Invoice Position")
		InvoiceUI.getGui().getJButtonSavePosition().addActionListener(
			new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveAndUpdate();
				}
			});
	}

	/**
	 * Save and update.
	 */
	private static void saveAndUpdate() {
		PositionControl.save(
				getSelectedItem(),isNew);
		InvoiceControl.updateInvoice(
				InvoiceHelper.getSelectedInvoice(),false);
	}

	/**
	 * Gets the invoice position from gui.
	 *
	 * @param invoicePosition the invoice position
	 * @return the invoice position from gui
	 */
	public static void getInvoicePositionFromGui(
			INVOICE_POSITION invoicePosition) {
		invoicePosition.setINVOICE_ID(InvoiceHelper.getSelectedInvoice().getId());
		invoicePosition.setNR(
				InvoiceUI.getGui().getTfInvoicePositionNr().getText());
		invoicePosition.setQUANTITY(InvoiceUI.getGui()
				.getTfInvoicePositionQuantity().getText());
		invoicePosition.setAMOUNT(InvoiceUI.getGui()
				.getTfInvoicePositionAmount().getText());
		// article
		if (invoicePosition.getARTICLE() == null) {
			Object objArticle = InvoiceUI.getGui()
					.getJComboBoxPositionArticle().getSelectedItem();
			if (objArticle instanceof String) {
				invoicePosition.setARTICLE(null);
			} else {
				invoicePosition.setARTICLE((ARTICLE) objArticle);
			}
		}
		notifyArticleSelection();
	}

	/**
	 * Sets the invoice position to gui.
	 *
	 * @param invoicePosition the invoice position
	 * @param invoiceNr the invoice nr
	 */
	protected static void setInvoicePositionToGui(
		INVOICE_POSITION invoicePosition, String invoiceNr) {
		InvoiceUI.getGui().getTfPosInvoiceReadOnlyNr().setText(invoiceNr);
		InvoiceUI.getGui().getTfInvoicePositionNr().setText(
				invoicePosition.getNR());
		InvoiceUI.getGui().getTfInvoicePositionQuantity().setText(
				invoicePosition.getQUANTITY());
		// article
		ARTICLE article = invoicePosition.getARTICLE();
		if (article != null) {
			int ix = ArticleHelper.getArticleIndex(article);
//			log.debug("article: " + ix);
			InvoiceUI.getGui().getJComboBoxPositionArticle()
					.setSelectedIndex(ix);
			InvoiceUI.getGui().getTfInvoicePositionAmount().setText(
					calcAMOUNT(article.getUNIT_PRICE(),invoicePosition.getQUANTITY()));
		} else {
			InvoiceUI.getGui().getJComboBoxPositionArticle().setSelectedIndex(0);
			InvoiceUI.getGui().getTfInvoicePositionAmount().setText("");
		}
	}

	/**
	 * Calc amount.
	 *
	 * @param unitPRICE the unit price
	 * @param QUANTITY the qUANTITY
	 * @return the string
	 */
	private static String calcAMOUNT(String unitPRICE, String QUANTITY) {
		String amountStr = "not calculated";
		try {
//			log.debug("unitPRICE: " + unitPRICE);
//			log.debug("QUANTITY: " + QUANTITY);
			double unitPrize = CommonHelper.getDouble(unitPRICE);
			double quantity = CommonHelper.getDouble(QUANTITY);
			double amount = unitPrize*quantity;
//			log.debug("unitPrize: " + unitPrize);
//			log.debug("quantity: " + quantity);
//			log.debug("amount: " + amount);
			amountStr = CommonHelper.getDezimalString(amount);
//			log.debug("amountStr: " + amountStr);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return amountStr;
	}

	/**
	 * Adds the invoice position.
	 *
	 * @param pInvoice the invoice
	 * @param pPos the pos
	 */
	protected static void addInvoicePosition(
			INVOICE pInvoice,INVOICE_POSITION pPos) {
		isNew = true;
		if (InvoiceHelper.getSelectedInvoice().getId() == null)
			return;
		if (pPos != null) {
			InvoiceUI.getGui().getTfInvoicePositionNr()
				.setText(pPos.getNR());
			InvoiceUI.getGui().getJComboBoxPositionArticle()
				.setSelectedItem(pPos.getARTICLE());
			InvoiceUI.getGui().getTfInvoicePositionQuantity()
				.setText(pPos.getQUANTITY());
			InvoiceUI.getGui().getTfInvoicePositionAmount()
				.setText(pPos.getAMOUNT());
		}
		InvoiceUI.getGui().getTfPosInvoiceReadOnlyNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		InvoiceUI.getGui().getTfSettingsInvoiceNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		InvoiceUI.getGui().getTfInvoicePositionNr().setEnabled(true);
		InvoiceUI.getGui().getJButtonSavePosition().setEnabled(true);
//		log.debug("AddInvoicePosition actionPerformed()");
	}

	/**
	 * Update invoice position.
	 */
	protected static void updateInvoicePosition() {
		isNew = false;
		if (InvoiceHelper.getSelectedInvoice().getId() == null) return;
		InvoiceUI.getGui().getTfPosInvoiceReadOnlyNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		InvoiceUI.getGui().getTfSettingsInvoiceNr().setText(
				InvoiceHelper.getSelectedInvoice().getNR());
		setSelectedItem((INVOICE_POSITION) InvoiceUI.getGui()
				.getJListInvoicePositions().getSelectedValue());
		if (getSelectedItem() != null) {
			InvoiceUI.getGui().getTfInvoicePositionNr().setEnabled(false);
			InvoiceUI.getGui().getJButtonSavePosition().setEnabled(true);
			InvoiceUI.getGui().getJTabbedPane().setSelectedComponent(
					InvoiceUI.getGui().getJPanelInvoicesPosition());
		}
//		log.debug("UpdateInvoicePosition actionPerformed()");
	}

	/**
	 * Notify article selection.
	 */
	static void notifyArticleSelection() {
//		log.debug("Calling notifyArticleSelection ...");
		String amountStr = "not calculated";
		Object selObject = 
			InvoiceUI.getGui().getJComboBoxPositionArticle().getSelectedItem();
		if (selObject != null && selObject instanceof ARTICLE) {
			amountStr = calcAMOUNT(((ARTICLE) selObject).getUNIT_PRICE(),
				InvoiceUI.getGui().getTfInvoicePositionQuantity().getText());
		}
		InvoiceUI.getGui().getTfInvoicePositionAmount().setText(amountStr);
	}

	/**
	 * Notify invoice positions selection.
	 */
	static void notifyInvoicePositionsSelection() {
		String invoiceNr = InvoiceUI.getGui().getTfInvoiceNr().getText();
		INVOICE_POSITION invoicePosition = (INVOICE_POSITION) InvoiceUI.getGui()
			.getJListInvoicePositions().getSelectedValue();
		if (invoicePosition != null) {
			setSelectedItem(invoicePosition);
			setInvoicePositionToGui(getSelectedItem(), invoiceNr);
			InvoiceUI.getGui().getJButtonAddPosition().setText(
					InvoiceUI.getGui().getBundleValueByKey("btn.Copy"));
			InvoiceUI.getGui().getJButtonUpdatePosition().setEnabled(true);
			InvoiceUI.getGui().getJButtonDeletePosition().setEnabled(true);
			InvoiceUI.getGui().getJButtonSavePosition().setEnabled(true);
		} else {
			setSelectedItem(new INVOICE_POSITION());
			setInvoicePositionToGui(getSelectedItem(), "");
			InvoiceUI.getGui().getJButtonAddPosition().setText(
					InvoiceUI.getGui().getBundleValueByKey("btn.Add"));
			InvoiceUI.getGui().getJButtonUpdatePosition().setEnabled(false);
			InvoiceUI.getGui().getJButtonDeletePosition().setEnabled(false);
			InvoiceUI.getGui().getJButtonSavePosition().setEnabled(false);
		}
	}

	/**
	 * Copy position.
	 *
	 * @param next the next
	 * @return the iNVOIC e_ position
	 */
	protected static INVOICE_POSITION copyPosition(INVOICE_POSITION next) {
		INVOICE_POSITION pos = new INVOICE_POSITION();
		pos.setAMOUNT(next.getAMOUNT());
		pos.setARTICLE(next.getARTICLE());
		pos.setId(next.getId());
		pos.setNR(next.getNR());
		pos.setQUANTITY(next.getQUANTITY());
		return pos;
	}

	/**
	 * Update gui.
	 */
	public static void updateGui() {
		InvoiceUI.getGui().getJListInvoicePositions()
			.setListData(getInvoicePositionData());
	}
}
