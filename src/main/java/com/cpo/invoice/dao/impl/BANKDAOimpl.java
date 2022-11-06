package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.BANKDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.BANK;


// TODO: Auto-generated Javadoc
/**
 * The Class BANKDAOimpl.
 */
public class BANKDAOimpl extends BANKDAO implements InterfaceDAO {

	/** The dao. */
	private static BANKDAOimpl dao = null;

	/**
	 * Gets the single instance of BANKDAO.
	 *
	 * @return single instance of BANKDAO
	 */
	public static BANKDAOimpl getInstance() {
		if (dao == null)
			dao = new BANKDAOimpl();
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
		return super.create((BANK) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((BANK) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((BANK) object);
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
		String hqlQuery = "select h from BANK as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<BANK> arrayList = (ArrayList<BANK>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}
}
