package com.cpo.invoice.dao;

import java.util.Vector;

import org.hibernate.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class DaoHelper.
 */
public class DaoHelper {

	/**
	 * Creates the.
	 *
	 * @param tb the tb
	 * @param dao the dao
	 * @return the long
	 */
	public static Long create(Object tb, InterfaceDAO dao) {
		Transaction tx = dao.getSession().beginTransaction();
		Long id = dao.create(tb);
		tx.commit();
		dao.getSession().close();
		return id;
	}

	/**
	 * Update.
	 *
	 * @param tb the tb
	 * @param dao the dao
	 */
	public static void update(Object tb, InterfaceDAO dao) {
		Transaction tx = dao.getSession().beginTransaction();
		dao.update(tb);
		tx.commit();
		dao.getSession().close();
	}

	/**
	 * Delete.
	 *
	 * @param tb the tb
	 * @param dao the dao
	 */
	public static void delete(Object tb, InterfaceDAO dao) {
		Transaction tx = dao.getSession().beginTransaction();
		dao.delete(tb);
		tx.commit();
		dao.getSession().close();
	}
	
	/**
	 * Gets the by id.
	 *
	 * @param dao the dao
	 * @param id the id
	 * @param useFetchMode the use fetch mode
	 * @return the by id
	 */
	public static Object getByID(InterfaceDAO dao, Long id, boolean useFetchMode) {
		if (id == null) return null;
		Transaction tx = dao.getSession().beginTransaction();
		Object inv = dao.getByID(id,true);
		tx.commit();
		dao.getSession().close();
		return inv;
	}

	/**
	 * Gets the all.
	 *
	 * @param dao the dao
	 * @param useFetchMode the use fetch mode
	 * @return the all
	 */
	public static Vector<?> getAll(InterfaceDAO dao, boolean useFetchMode) {
		Vector<?> objects;
		Transaction tx = dao.getSession().beginTransaction();
		objects = dao.getAll(useFetchMode);
		tx.commit();
		dao.getSession().close();
		return objects;
	}
}
