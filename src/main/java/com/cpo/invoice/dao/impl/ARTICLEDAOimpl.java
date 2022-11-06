package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.ARTICLEDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.ARTICLE;


// TODO: Auto-generated Javadoc
/**
 * The Class ARTICLEDAOimpl.
 */
public class ARTICLEDAOimpl extends ARTICLEDAO implements InterfaceDAO {

	/** The dao. */
	private static ARTICLEDAOimpl dao = null;

	/**
	 * Gets the single instance of ARTICLEDAO.
	 *
	 * @return single instance of ARTICLEDAO
	 */
	public static ARTICLEDAOimpl getInstance() {
		if (dao == null)
			dao = new ARTICLEDAOimpl();
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
		return super.create((ARTICLE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((ARTICLE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((ARTICLE) object);
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
		String hqlQuery = "select h from ARTICLE as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<ARTICLE> arrayList = (ArrayList<ARTICLE>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}
}
