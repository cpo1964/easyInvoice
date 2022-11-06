package com.cpo.invoice.dao;


// TODO: Auto-generated Javadoc
/**
 * The Class INVOICEDAO.
 *
 * @generated 
 */
public class INVOICEDAO {
	
	/**
	 * Instantiates a new invoicedao.
	 *
	 * @generated 
	 */
	public INVOICEDAO() {
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 * @generated 
	 */
	private org.hibernate.Session getSession() {
		return com.cpo.invoice.util.HibernateHelper.getInstance().getSession();
	}

	/**
	 * Creates the.
	 *
	 * @param object the object
	 * @return the long
	 * @generated 
	 */
	public Long create(com.cpo.invoice.model.INVOICE object) {
		if (object == null)
			throw new IllegalArgumentException("object");
		getSession().save(object);
		return object.getId();
	}

	/**
	 * Read.
	 *
	 * @param id the id
	 * @return the com.cpo.invoice.model. INVOICE
	 * @generated 
	 */
	public com.cpo.invoice.model.INVOICE read(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id");
		return (com.cpo.invoice.model.INVOICE) getSession().get(
				com.cpo.invoice.model.INVOICE.class, id);
	}

	/**
	 * Update.
	 *
	 * @param object the object
	 * @generated 
	 */
	public void update(com.cpo.invoice.model.INVOICE object) {
		if (object == null)
			throw new IllegalArgumentException("object");
		getSession().update(object);
	}

	/**
	 * Delete.
	 *
	 * @param object the object
	 * @generated 
	 */
	public void delete(com.cpo.invoice.model.INVOICE object) {
		if (object == null)
			throw new IllegalArgumentException("object");
		getSession().delete(object);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @generated 
	 */
	public String toString() {
		return "INVOICEDAO";
	}
}