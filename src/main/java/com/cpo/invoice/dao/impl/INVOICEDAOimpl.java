package com.cpo.invoice.dao.impl;

import java.util.ArrayList;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cpo.invoice.dao.INVOICEDAO;
import com.cpo.invoice.dao.InterfaceDAO;
import com.cpo.invoice.model.INVOICE;


// TODO: Auto-generated Javadoc
/**
 * The Class INVOICEDAOimpl.
 */
public class INVOICEDAOimpl extends INVOICEDAO implements InterfaceDAO {
	/** The dao. */
	private static INVOICEDAOimpl dao = null;

	/**
	 * Gets the single instance of INVOICEDAO.
	 *
	 * @return single instance of INVOICEDAO
	 */
	public static INVOICEDAOimpl getInstance() {
		if (dao == null)
			dao = new INVOICEDAOimpl();
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
		return super.create((INVOICE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#update(java.lang.Object)
	 */
	public void update(Object object) {
		super.update((INVOICE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#delete(java.lang.Object)
	 */
	public void delete(Object object) {
		super.delete((INVOICE) object);
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#getByID(java.lang.Long, boolean)
	 */
	public Object getByID(Long pID, boolean pUseFetchmode) {
		ArrayList<INVOICE> arrayList = null;
		Criteria crit = getSession().createCriteria(INVOICE.class);
		if (pUseFetchmode) {
			crit.setFetchMode("SENDER", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoiceAdress", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoicePhone", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoiceBank", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER.invoiceAdress", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER.invoicePhone", FetchMode.JOIN);
			crit.setFetchMode("INVOICE_POSITION", FetchMode.JOIN);
			crit.setFetchMode("TEXTBLOCK", FetchMode.JOIN);
		}
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.eq("id", pID));
		arrayList = (ArrayList<INVOICE>)crit.list();
		if (arrayList != null && arrayList.size() > 0) {
			INVOICE inv = arrayList.get(0);
			inv.getINVOICE_POSITION();
			inv.getTEXTBLOCK();
			return inv;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.cpo.invoice.dao.InterfaceDAO#getAll(boolean)
	 */
	public Vector<?> getAll(boolean pUseFetchmode) {
		ArrayList<INVOICE> arrayList = null;
		
		// method 1 for fetch mode: use crit.setFetchMode
		Criteria crit = getSession().createCriteria(INVOICE.class);
		if (pUseFetchmode) {
			crit.setFetchMode("SENDER", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoiceAdress", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoicePhone", FetchMode.JOIN);
			crit.setFetchMode("SENDER.invoiceBank", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER.invoiceAdress", FetchMode.JOIN);
			crit.setFetchMode("RECEIVER.invoicePhone", FetchMode.JOIN);
			crit.setFetchMode("SETTINGS", FetchMode.JOIN);
			crit.setFetchMode("SETTINGS.TAX", FetchMode.JOIN);
		}
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		arrayList = (ArrayList<INVOICE>)crit.list();
		
		// method 2 for fetch mode: use Hibernate.initialize
//		String hqlQuery = "select h from INVOICE as h";
//		Query q = getSession().createQuery(hqlQuery);
//		arrayList = (ArrayList<INVOICE>) q.list();
//		for (int i=0;i<arrayList.size();i++) {
//			// because of lazy loading ...
//			INVOICE inv = arrayList.get(i);
//			try {
//				Hibernate.initialize(inv.getSENDER());
//				if (inv.getSENDER().getCustomerAdress() != null) 
//					Hibernate.initialize(inv.getSENDER().getInvoiceAdress());
//				Hibernate.initialize(inv.getRECEIVER());
//				if (inv.getRECEIVER().getCustomerAdress() != null) 
//					Hibernate.initialize(inv.getRECEIVER().getInvoiceAdress());
//			} catch (LazyInitializationException e) {
//			} catch (Exception e) {
//			}
//		}

		Vector v = new Vector();
		v.addAll(arrayList);
		return v;
	}

	/**
	 * Gets the by nr.
	 *
	 * @param NR the nR
	 * @return the by nr
	 */
	@SuppressWarnings("unchecked")
	public INVOICE getByNR(String NR) {
		ArrayList<INVOICE> arrayList = null;
		Criteria crit = getSession().createCriteria(INVOICE.class);
		crit.add(Restrictions.eq("NR", NR));
		arrayList = (ArrayList<INVOICE>)crit.list();
		if (arrayList != null && arrayList.size() > 0) {
			INVOICE inv = arrayList.get(0);
			return inv;
		}
		return null;
	}

}
