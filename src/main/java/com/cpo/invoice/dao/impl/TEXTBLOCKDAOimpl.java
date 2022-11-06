package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.dao.TEXTBLOCKDAO;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.TEXTBLOCK;


// TODO: Auto-generated Javadoc
/**
 * The Class TEXTBLOCKDAOimpl.
 */
public class TEXTBLOCKDAOimpl extends TEXTBLOCKDAO implements InterfaceDAO {

	/** The dao. */
	private static TEXTBLOCKDAOimpl dao = null;

	/**
	 * Gets the single instance of TEXTBLOCKDAO.
	 *
	 * @return single instance of TEXTBLOCKDAO
	 */
	public static TEXTBLOCKDAOimpl getInstance() {
		if (dao == null)
			dao = new TEXTBLOCKDAOimpl();
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
		return super.create((TEXTBLOCK) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((TEXTBLOCK) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((TEXTBLOCK) object);
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
		String hqlQuery = "select h from TEXTBLOCK as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<TEXTBLOCK> arrayList = (ArrayList<TEXTBLOCK>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}

	/**
	 * Gets the max nr.
	 *
	 * @param inv the inv
	 * @return the max nr
	 */
	@SuppressWarnings("unchecked")
	public String getMaxNr(INVOICE inv) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		String hqlQuery = "select max(h.NR) from TEXTBLOCK as h"+
			" where h.INVOICE_ID="+inv.getId();
		Query q = session.createQuery(hqlQuery);
		ArrayList<String> arrayList = 
			(ArrayList<String>) q.list();
		if (arrayList.size() == 0)
			return null;
		return arrayList.get(0);
	}

	/**
	 * Read.
	 *
	 * @param inv the inv
	 * @param nr the nr
	 * @return the tEXTBLOCK
	 */
	@SuppressWarnings("unchecked")
	public TEXTBLOCK read(INVOICE inv,String nr) {
		Session session = com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
		String hqlQuery = "select h from TEXTBLOCK as h"+
			" where h.NR like '"+nr+"' and h.INVOICE_ID="+inv.getId();
		Query q = session.createQuery(hqlQuery);
		ArrayList<TEXTBLOCK> arrayList = 
			(ArrayList<TEXTBLOCK>) q.list();
		if (arrayList.size() == 0)
			return null;
		return arrayList.get(0);
	}
}
