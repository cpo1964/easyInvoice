package com.cpo.invoice.control;

import java.util.Vector;

import org.apache.log4j.Logger;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.ARTICLEDAOimpl;
import com.cpo.invoice.gui.ArticleHelper;
import com.cpo.invoice.model.ARTICLE;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleControl.
 */
public class ArticleControl {

	/** The log. */
	private static Logger log = Logger.getLogger(ArticleControl.class);

	/** The static object. */
//	private static ArticleControl staticObject = new ArticleControl();

	public ArticleControl() {
		super();
	}

	/**
	 * Adds the.
	 */
	public static void add() {
		final Runnable doWorkRunnable = new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				final ARTICLE article = new ARTICLE();
				ArticleHelper.getArticleFromGui(article);
				ArticleHelper.getArticleData().add(article);
				final Long id = DaoHelper.create(article, (InterfaceDAO) ARTICLEDAOimpl.getInstance());
				ArticleHelper.setArticleData(
						(Vector<ARTICLE>)DaoHelper.getAll(
								(InterfaceDAO) ARTICLEDAOimpl.getInstance(), true));
				ArticleHelper.updateGui();
				log.info("Created Article with ID " + id);
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
			@SuppressWarnings("unchecked")
			public void run() {
				if (ArticleHelper.getSelectedArticle() != null) {
					ArticleHelper.getArticleFromGui(
							ArticleHelper.getSelectedArticle());
					DaoHelper.update(
							ArticleHelper.getSelectedArticle(),
							(InterfaceDAO) ARTICLEDAOimpl.getInstance());
					ArticleHelper.setArticleData(
							(Vector<ARTICLE>)DaoHelper.getAll(
									(InterfaceDAO) ARTICLEDAOimpl.getInstance(), true));
					ArticleHelper.updateGui();
					log.info("Updated Article with ID " +
							ArticleHelper.getSelectedArticle().getId());
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
			@SuppressWarnings("unchecked")
			public void run() {
				if (ArticleHelper.getSelectedArticle() != null) {
					final Long id = ArticleHelper.getSelectedArticle().getId();
					DaoHelper.delete(
							ArticleHelper.getSelectedArticle(),
							(InterfaceDAO) ARTICLEDAOimpl.getInstance());
					ArticleHelper.setArticleData(
							(Vector<ARTICLE>)DaoHelper.getAll(
									(InterfaceDAO) ARTICLEDAOimpl.getInstance(), true));
					ArticleHelper.updateGui();
					log.info("Deleted Adress with ID " + id);
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

}

