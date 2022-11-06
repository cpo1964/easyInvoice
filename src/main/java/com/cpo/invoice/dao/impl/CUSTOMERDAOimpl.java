package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Example;

import com.cpo.invoice.dao.CUSTOMERDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.CUSTOMER;

// TODO: Auto-generated Javadoc
/**
 * The Class CUSTOMERDAOimpl.
 */
public class CUSTOMERDAOimpl extends CUSTOMERDAO implements InterfaceDAO {

	/** The dao. */
	private static CUSTOMERDAOimpl dao = null;

	/**
	 * Gets the single instance of CUSTOMERDAO.
	 *
	 * @return single instance of CUSTOMERDAO
	 */
	public static CUSTOMERDAOimpl getInstance() {
		if (dao == null)
			dao = new CUSTOMERDAOimpl();
		return dao;
	}

	/**
	 * Gets the senders.
	 *
	 * @return the senders
	 */
	@SuppressWarnings("unchecked")
	public Vector<CUSTOMER> getSenders() {
		ArrayList<CUSTOMER> arrayList = null;
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		Criteria crit = session.createCriteria(CUSTOMER.class);
		CUSTOMER cust = new CUSTOMER();
		cust.setSENDER("true");
		Example example =  Example.create(cust);
		crit.add(example);
		crit.setFetchMode("invoiceAdress", FetchMode.JOIN);
		crit.setFetchMode("invoicePhone", FetchMode.JOIN);
		crit.setFetchMode("invoiceBank", FetchMode.JOIN);
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		arrayList = (ArrayList<CUSTOMER>)crit.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;

//		String hqlQuery = "select h from CUSTOMER as h where SENDER='true'";
//		Query q = getSession().createQuery(hqlQuery);
//		ArrayList<CUSTOMER> arrayList = (ArrayList<CUSTOMER>) q.list();
//		Vector v = new Vector();
//		if (arrayList != null && arrayList.size() > 0)
//			v.addAll(arrayList);
//		return v;
	}

	/**
	 * Gets the receivers.
	 *
	 * @return the receivers
	 */
	@SuppressWarnings("unchecked")
	public Vector<CUSTOMER> getReceivers() {
		ArrayList<CUSTOMER> arrayList = null;
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		Criteria crit = session.createCriteria(CUSTOMER.class);
		CUSTOMER cust = new CUSTOMER();
		cust.setSENDER("false");
		Example example =  Example.create(cust);
		crit.add(example);
		crit.setFetchMode("invoiceAdress", FetchMode.JOIN);
		crit.setFetchMode("invoicePhone", FetchMode.JOIN);
		crit.setFetchMode("invoiceBank", FetchMode.JOIN);
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		arrayList = (ArrayList<CUSTOMER>)crit.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
		
//		String hqlQuery = "select h from CUSTOMER as h where SENDER='false'";
//		Query q = getSession().createQuery(hqlQuery);
//		ArrayList<CUSTOMER> arrayList = (ArrayList<CUSTOMER>) q.list();
//		Vector v = new Vector();
//		if (arrayList != null && arrayList.size() > 0)
//			v.addAll(arrayList);
//		return v;
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
		return super.create((CUSTOMER) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((CUSTOMER) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((CUSTOMER) object);
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
		ArrayList<CUSTOMER> arrayList = null;
		Criteria crit = getSession().createCriteria(CUSTOMER.class);
		if (pUseFetchmode) {
			crit.setFetchMode("invoiceAdress", FetchMode.JOIN);
			crit.setFetchMode("invoicePhone", FetchMode.JOIN);
			crit.setFetchMode("invoiceBank", FetchMode.JOIN);
			crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		}
		arrayList = (ArrayList<CUSTOMER>)crit.list();
//		String hqlQuery = "select h from CUSTOMER as h";
//		Query q = getSession().createQuery(hqlQuery);
//		ArrayList<CUSTOMER> arrayList = (ArrayList<CUSTOMER>) q.list();
		Vector data = new Vector();
		data.addAll(arrayList);
		return data;
	}
}
