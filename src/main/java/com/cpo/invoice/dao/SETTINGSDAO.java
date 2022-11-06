package com.cpo.invoice.dao;


// TODO: Auto-generated Javadoc
/**
 * The Class SETTINGSDAO.
 *
 * @generated 
 */
public class SETTINGSDAO {
	
	/**
	 * Instantiates a new settingsdao.
	 *
	 * @generated 
	 */
	public SETTINGSDAO() {
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
	public Long create(com.cpo.invoice.model.SETTINGS object) {
		if (object == null)
			throw new IllegalArgumentException("object");
		getSession().save(object);
		return object.getId();
	}

	/**
	 * Read.
	 *
	 * @param id the id
	 * @return the com.cpo.invoice.model. SETTINGS
	 * @generated 
	 */
	public com.cpo.invoice.model.SETTINGS read(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id");
		return (com.cpo.invoice.model.SETTINGS) getSession().get(
				com.cpo.invoice.model.SETTINGS.class, id);
	}

	/**
	 * Update.
	 *
	 * @param object the object
	 * @generated 
	 */
	public void update(com.cpo.invoice.model.SETTINGS object) {
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
	public void delete(com.cpo.invoice.model.SETTINGS object) {
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
		return "SETTINGSDAO";
	}
}