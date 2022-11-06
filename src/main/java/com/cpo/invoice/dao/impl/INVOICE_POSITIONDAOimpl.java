package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;

import com.cpo.invoice.dao.INVOICE_POSITIONDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.INVOICE_POSITION;

// TODO: Auto-generated Javadoc
/**
 * The Class INVOICE_POSITIONDAOimpl.
 */
public class INVOICE_POSITIONDAOimpl extends INVOICE_POSITIONDAO implements InterfaceDAO {

	/** The dao. */
	private static INVOICE_POSITIONDAOimpl dao = null;

	/**
	 * Gets the single instance of INVOICE_POSITIONDAO.
	 * 
	 * @return single instance of INVOICE_POSITIONDAO
	 */
	public static INVOICE_POSITIONDAOimpl getInstance() {
		if (dao == null)
			dao = new INVOICE_POSITIONDAOimpl();
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
		return super.create((INVOICE_POSITION) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((INVOICE_POSITION) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((INVOICE_POSITION) object);
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
	public Vector<?> getAll(boolean pUseFetchmode) {
		ArrayList<INVOICE_POSITION> arrayList = null;
		Criteria crit = getSession().createCriteria(INVOICE_POSITION.class);
		if (pUseFetchmode) {
			crit.setFetchMode("ARTICLE", FetchMode.JOIN);
			crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		}
		arrayList = (ArrayList<INVOICE_POSITION>)crit.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}

	/**
	 * Read.
	 * 
	 * @param inv
	 *            the inv
	 * @param nr
	 *            the nr
	 * @return the iNVOIC e_ position
	 */
	@SuppressWarnings("unchecked")
	public INVOICE_POSITION read(INVOICE inv, String nr) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance()
				.getSession();
		String hqlQuery = "select h from INVOICE_POSITION as h"
				+ " where h.NR like '" + nr + "' and h.INVOICE_ID="
				+ inv.getId();
		Query q = session.createQuery(hqlQuery);
		ArrayList<INVOICE_POSITION> arrayList = (ArrayList<INVOICE_POSITION>) q
				.list();
		if (arrayList.size() == 0)
			return null;
		return arrayList.get(0);
	}

	/**
	 * Gets the max nr.
	 * 
	 * @param inv
	 *            the inv
	 * @return the max nr
	 */
	@SuppressWarnings("unchecked")
	public String getMaxNr(INVOICE inv) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance()
				.getSession();
		String hqlQuery = "select max(h.NR) from INVOICE_POSITION as h"
				+ " where h.INVOICE_ID=" + inv.getId();
		Query q = session.createQuery(hqlQuery);
		ArrayList<String> arrayList = (ArrayList<String>) q.list();
		if (arrayList.size() == 0)
			return null;
		return arrayList.get(0);
	}
}
