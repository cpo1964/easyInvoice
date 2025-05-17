package com.cpo.invoice.gui;

import java.util.Vector;

import com.cpo.invoice.control.ArticleControl;
import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.ARTICLEDAOimpl;
import com.cpo.invoice.model.ARTICLE;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleHelper.
 */
public final class ArticleHelper {

	/** The selected article. */
	private static ARTICLE selectedArticle = null;

	/** The article data. */
	private static Vector<ARTICLE> articleData =
		new Vector<ARTICLE>();

	/**
	 * Instantiates a new article helper.
	 */
	private ArticleHelper() {
		super();
	}

	/**
	 * Gets the article data.
	 *
	 * @return the article data
	 */
	public static Vector<ARTICLE> getArticleData() {
		return articleData;
	}

	/**
	 * Sets the article data.
	 *
	 * @param objects the new article data
	 */
	public static void setArticleData(final Vector<ARTICLE> objects) {
		articleData = objects;
	}

	/**
	 * Gets the selected article.
	 *
	 * @return the selected article
	 */
	public static ARTICLE getSelectedArticle() {
		return selectedArticle;
	}

	/**
	 * Sets the selected article.
	 *
	 * @param obj the new selected article
	 */
	public static void setSelectedArticle(final ARTICLE obj) {
		selectedArticle = obj;
	}

	/**
	 * Inits the.
	 */
	@SuppressWarnings("unchecked")
	static void init() {
		ArticleHelper.setArticleData(
				(Vector<ARTICLE>)DaoHelper.getAll(
						(InterfaceDAO) ARTICLEDAOimpl.getInstance(), true));
		// some listeners
		InvoiceUI.getGui().getJButtonAddArticle().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						ArticleControl.add();
					}
				});
		InvoiceUI.getGui().getJButtonUpdateArticle().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						ArticleControl.update();
					}
				});
		InvoiceUI.getGui().getJButtonDeleteArticle().addActionListener(
				new java.awt.event.ActionListener() {
					public void actionPerformed(final java.awt.event.ActionEvent e) {
						ArticleControl.delete();
					}
				});
		InvoiceUI.getGui().getJListArticles().addListSelectionListener(
				new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							final javax.swing.event.ListSelectionEvent e) {
						notifyArticleSelection();
					}
				});
		InvoiceUI.getGui().getJButtonUpdateArticle().setEnabled(false);
		InvoiceUI.getGui().getJButtonDeleteArticle().setEnabled(false);
		updateGui();
	}

	/**
	 * Gets the article from gui.
	 *
	 * @param article the article
	 * @return the article from gui
	 */
	public static void getArticleFromGui(final ARTICLE article) {
		article.setUNIT(InvoiceUI.getGui().getTfUnit().getText());
		article.setDESCRIPTION(InvoiceUI.getGui().getTaArticleDescription()
				.getText());
		article.setUNIT_PRICE(InvoiceUI.getGui().getTfUnitPrice().getText());
		article.setTAX((String)InvoiceUI.getGui().getJComboBoxArticleTax()
				.getSelectedItem());
	}

	/**
	 * Sets the article to gui.
	 *
	 * @param article the new article to gui
	 */
	protected static void setArticleToGui(final ARTICLE article) {
		InvoiceUI.getGui().getTfUnit().setText(article.getUNIT());
		InvoiceUI.getGui().getTaArticleDescription().setText(
				article.getDESCRIPTION());
		InvoiceUI.getGui().getTfUnitPrice().setText(article.getUNIT_PRICE());
		InvoiceUI.getGui().getJComboBoxArticleTax()
				.setSelectedItem(article.getTAX());
	}

	/**
	 * Gets the article index.
	 *
	 * @param article the article
	 * @return the article index
	 */
	protected static int getArticleIndex(final ARTICLE article) {
		int id = 0;
		for (int i = 0; i < getArticleData().size(); i++) {
			if (((ARTICLE)getArticleData().toArray()[i]).getId().longValue()
					== article.getId().longValue()) {
				id = i + 1;
			}
		}
		return id;
	}

	/**
	 * Notify article selection.
	 */
	public static void notifyArticleSelection() {
		setSelectedArticle(
				(ARTICLE)InvoiceUI.getGui()
					.getJListArticles().getSelectedValue());
		if (getSelectedArticle() != null) {
			setArticleToGui(getSelectedArticle());
			setButtonsEnabledForSelectedArticle(true);
		} else {
			setArticleToGui(new ARTICLE());
			setButtonsEnabledForSelectedArticle(false);
		}
		// System.out.println("Article Selection changed()");
	}

	/**
	 * Sets the buttons enabled for selected article.
	 *
	 * @param pSelected the new buttons enabled for selected article
	 */
	private static void setButtonsEnabledForSelectedArticle(final boolean pSelected) {
		if (pSelected) {
			InvoiceUI.getGui().getJButtonAddArticle().setText(InvoiceUI.getGui()
					.getBundleValueByKey(StringHelper.BTN_COPY));
		} else {
			InvoiceUI.getGui().getJButtonAddArticle().setText(InvoiceUI.getGui()
					.getBundleValueByKey(StringHelper.BTN_ADD));
		}
		InvoiceUI.getGui().getJButtonUpdateArticle().setEnabled(pSelected);
		InvoiceUI.getGui().getJButtonDeleteArticle().setEnabled(pSelected);
	}

	/**
	 * Update article gui.
	 */
	public static void updateGui() {
		InvoiceUI.getGui().getJListArticles().setListData(
				getArticleData().toArray());
		if (InvoiceUI.getGui().getJListArticles().getModel().getSize() > 0) {
			InvoiceUI.getGui().getJListArticles().setSelectedIndex(0);
		}
		PositionHelper.setPosArticleModel(
				PositionHelper.fillPosArticleModel());
		InvoiceUI.getGui().getJComboBoxPositionArticle().setModel(
				PositionHelper.getPosArticleModel());
	}

}
