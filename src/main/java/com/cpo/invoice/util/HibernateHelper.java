package com.cpo.invoice.util;


// TODO: Auto-generated Javadoc
/**
 * The Class HibernateHelper.
 *
 * @generated 
 */
public class HibernateHelper {
	
	/**
	 * The singleton.
	 *
	 * @generated 
	 */
	private static HibernateHelper singleton = new HibernateHelper();
	
	/**
	 * The factory.
	 *
	 * @generated 
	 */
	private org.hibernate.SessionFactory factory;
	
	/**
	 * The current session.
	 *
	 * @generated 
	 */
	private ThreadLocal currentSession = new ThreadLocal();

	/**
	 * Instantiates a new hibernate helper.
	 *
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	private HibernateHelper() throws org.hibernate.HibernateException {
	}

	/**
	 * Gets the single instance of HibernateHelper.
	 *
	 * @return single instance of HibernateHelper
	 * @generated 
	 */
	public static HibernateHelper getInstance() {
		return singleton;
	}

	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public synchronized org.hibernate.SessionFactory getFactory() throws org.hibernate.HibernateException {
		if (factory == null) {
			org.hibernate.cfg.Configuration config = getConfiguration();
			factory = config.buildSessionFactory();
		}
		return factory;
	}

	/**
	 * Close.
	 *
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public synchronized void close() throws org.hibernate.HibernateException {
		closeSession();
		if (factory != null) {
			factory.close();
			factory = null;
		}
	}

	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 * @throws MappingException the mapping exception
	 * @generated 
	 */
	public org.hibernate.cfg.Configuration getConfiguration()
			throws org.hibernate.MappingException {
				org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
				config.addClass(com.cpo.invoice.model.INVOICE.class);
				config.addClass(com.cpo.invoice.model.INVOICE_POSITION.class);
				config.addClass(com.cpo.invoice.model.CUSTOMER.class);
				config.addClass(com.cpo.invoice.model.TEXTBLOCK.class);
				config.addClass(com.cpo.invoice.model.ARTICLE.class);
				config.addClass(com.cpo.invoice.model.TELEPHONE.class);
				config.addClass(com.cpo.invoice.model.ADRESS.class);
				config.addClass(com.cpo.invoice.model.BANK.class);
				config.addClass(com.cpo.invoice.model.SETTINGS.class);
				return config;
			}

	/**
	 * To string.
	 *
	 * @return the string
	 * @generated 
	 */
	public String toString() {
		return "HibernateHelper";
	}

	/**
	 * Open session.
	 *
	 * @return the org.hibernate. session
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	@SuppressWarnings("deprecation")
	public org.hibernate.Session openSession()
			throws org.hibernate.HibernateException {
				org.hibernate.Session session = getFactory().openSession();
				session.connection();
				return session;
			}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public org.hibernate.Session getSession()
			throws org.hibernate.HibernateException {
				org.hibernate.Session session = (org.hibernate.Session) currentSession.get();
				if (session == null || !session.isOpen()) {
					session = openSession();
					currentSession.set(session);
				}
				return session;
			}

	/**
	 * Close session.
	 *
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public void closeSession() throws org.hibernate.HibernateException {
		org.hibernate.Session session = (org.hibernate.Session) currentSession.get();
		if (session != null && session.isOpen()) {
			session.close();
		}
		currentSession.set(null);
	}

	/**
	 * Save.
	 *
	 * @param object the object
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public void save(Object object) throws org.hibernate.HibernateException {
		getSession().save(object);
	}

	/**
	 * Delete.
	 *
	 * @param object the object
	 * @throws HibernateException the hibernate exception
	 * @generated 
	 */
	public void delete(Object object) throws org.hibernate.HibernateException {
		getSession().delete(object);
	}
}