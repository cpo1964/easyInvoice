package com.cpo.invoice.control;

import java.util.Vector;

import org.apache.log4j.Logger;

import com.cpo.invoice.dao.DaoHelper;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.impl.SETTINGSDAOimpl;
import com.cpo.invoice.gui.SettingsHelper;
import com.cpo.invoice.model.SETTINGS;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsControl.
 */
public class SettingsControl {

	/** The log. */
	private static Logger log = Logger.getLogger(SettingsControl.class);

	/**
	 * Adds the.
	 */
	public static void add() {
		final Runnable doWorkRunnable = new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				final SETTINGS settings = new SETTINGS();
				SettingsHelper.getSettingsFromGui(settings);
				SettingsHelper.getSettingsData().add(settings);
				final Long id = DaoHelper.create(settings, (InterfaceDAO) SETTINGSDAOimpl.getInstance());
				SettingsHelper.setSelectedSettings(settings);
				SettingsHelper.setSettingsData(
						(Vector<SETTINGS>)DaoHelper.getAll(
								(InterfaceDAO) SETTINGSDAOimpl.getInstance(), true));
				SettingsHelper.updateGui();
				log.info("Created Settings with ID " + id);
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
				if (SettingsHelper.getSelectedSettings() != null) {
					SettingsHelper.getSettingsFromGui(
							SettingsHelper.getSelectedSettings());
					DaoHelper.update(
							SettingsHelper.getSelectedSettings(),
							(InterfaceDAO) SETTINGSDAOimpl.getInstance());
					SettingsHelper.setSettingsData(
							(Vector<SETTINGS>)DaoHelper.getAll(
									(InterfaceDAO) SETTINGSDAOimpl.getInstance(), true));
					SettingsHelper.updateGui();
					log.info("Updated Settings with ID " +
							SettingsHelper.getSelectedSettings().getId());
				}
			}
		};
//		SwingUtilities.invokeLater(doWorkRunnable);
		doWorkRunnable.run();
	}

	/**
	 * Load settings.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void loadSettings() {
		final Vector v = (Vector<SETTINGS>)DaoHelper.getAll(
				(InterfaceDAO) SETTINGSDAOimpl.getInstance(), true);
		if (v == null || v.size() ==0) {
			add();
			log.info("created new settings ...");
		} else {
			SettingsHelper.setSelectedSettings((SETTINGS)v.get(0));
			SettingsHelper.setSettingsToGui(SettingsHelper.getSelectedSettings());
			log.info("loaded settings ...");
		}
	}
}
