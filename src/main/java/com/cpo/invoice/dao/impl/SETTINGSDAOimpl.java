package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.SETTINGSDAO;
import com.cpo.invoice.model.SETTINGS;

// TODO: Auto-generated Javadoc
/**
 * The Class SETTINGSDAOimpl.
 */
public class SETTINGSDAOimpl extends SETTINGSDAO implements InterfaceDAO {

	/** The dao. */
	private static SETTINGSDAOimpl dao = null;

	/**
	 * Gets the single instance of SETTINGSDAO.
	 *
	 * @return single instance of SETTINGSDAO
	 */
	public static SETTINGSDAOimpl getInstance() {
		if (dao == null)
			dao = new SETTINGSDAOimpl();
		return dao;
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#getSession()
	 */
	public Session getSession() {
		return com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#create(java.lang.Object)
	 */
	public Long create(Object object) {
		return super.create((SETTINGS) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((SETTINGS) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((SETTINGS) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#getByID(java.lang.Long, boolean)
	 */
	public Object getByID(Long id, boolean useFetchMode) {
		return super.read(id);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#getAll(boolean)
	 */
	public Vector<?> getAll(boolean useFetchMode) {
		String hqlQuery = "select h from SETTINGS as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<SETTINGS> arrayList = (ArrayList<SETTINGS>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}

}
