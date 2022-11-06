package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cpo.invoice.dao.ADRESSDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.ADRESS;

// TODO: Auto-generated Javadoc
/**
 * The Class ADRESSDAOimpl.
 */
public class ADRESSDAOimpl extends ADRESSDAO implements InterfaceDAO {

	/** The dao. */
	private static ADRESSDAOimpl dao = null;

	/**
	 * Gets the single instance of ADRESSDAO.
	 * 
	 * @return single instance of ADRESSDAO
	 */
	public static ADRESSDAOimpl getInstance() {
		if (dao == null)
			dao = new ADRESSDAOimpl();
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
		return super.create((ADRESS) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((ADRESS) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((ADRESS) object);
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
		String hqlQuery = "select h from ADRESS as h";
		Query q = getSession().createQuery(hqlQuery);
		ArrayList<ADRESS> arrayList = (ArrayList<ADRESS>) q.list();
		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}

}
