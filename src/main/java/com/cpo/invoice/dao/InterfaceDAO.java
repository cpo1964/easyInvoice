package com.cpo.invoice.dao;

import java.util.Vector;

import org.hibernate.Session;

// TODO: Auto-generated Javadoc
/**
 * The Interface InterfaceDAO.
 */
public interface InterfaceDAO {

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public Session getSession();

	/**
	 * Creates the.
	 *
	 * @param object the object
	 * @return the long
	 */
	public Long create(Object object);

	/**
	 * Update.
	 *
	 * @param object the object
	 */
	public void update(Object object);

	/**
	 * Delete.
	 *
	 * @param object the object
	 */
	public void delete(Object object);
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @param useFetchMode the use fetch mode
	 * @return the by id
	 */
	public Object getByID(Long id,boolean useFetchMode);

	/**
	 * Gets the all.
	 *
	 * @param useFetchMode the use fetch mode
	 * @return the all
	 */
	public Vector<?> getAll(boolean useFetchMode);
}
