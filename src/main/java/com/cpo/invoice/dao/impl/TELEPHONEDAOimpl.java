package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.TELEPHONEDAO;
import com.cpo.invoice.model.TELEPHONE;

// TODO: Auto-generated Javadoc
/**
 * The Class TELEPHONEDAOimpl.
 */
public class TELEPHONEDAOimpl extends TELEPHONEDAO implements InterfaceDAO {

	/** The dao. */
	private static TELEPHONEDAOimpl dao = null;

	/**
	 * Gets the single instance of TELEPHONEDAO.
	 *
	 * @return single instance of TELEPHONEDAO
	 */
	public static TELEPHONEDAOimpl getInstance() {
		if (dao == null)
			dao = new TELEPHONEDAOimpl();
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
		return super.create((TELEPHONE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((TELEPHONE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((TELEPHONE) object);
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
		String hqlQuery = "select h from TELEPHONE as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<TELEPHONE> arrayList = (ArrayList<TELEPHONE>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}
}
