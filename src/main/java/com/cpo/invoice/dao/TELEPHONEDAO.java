package com.cpo.invoice.dao;


// TODO: Auto-generated Javadoc
/**
 * The Class TELEPHONEDAO.
 *
 * @generated 
 */
public class TELEPHONEDAO {
	
	/**
	 * Instantiates a new telephonedao.
	 *
	 * @generated 
	 */
	public TELEPHONEDAO() {
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
	public Long create(com.cpo.invoice.model.TELEPHONE object) {
		if (object == null)
			throw new IllegalArgumentException("object");
		getSession().save(object);
		return object.getId();
	}

	/**
	 * Read.
	 *
	 * @param id the id
	 * @return the com.cpo.invoice.model. TELEPHONE
	 * @generated 
	 */
	public com.cpo.invoice.model.TELEPHONE read(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id");
		return (com.cpo.invoice.model.TELEPHONE) getSession().get(
				com.cpo.invoice.model.TELEPHONE.class, id);
	}

	/**
	 * Update.
	 *
	 * @param object the object
	 * @generated 
	 */
	public void update(com.cpo.invoice.model.TELEPHONE object) {
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
	public void delete(com.cpo.invoice.model.TELEPHONE object) {
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
		return "TELEPHONEDAO";
	}
}