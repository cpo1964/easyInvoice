package com.cpo.invoice.model;


// TODO: Auto-generated Javadoc
/**
 * The Class TELEPHONE.
 *
 * @generated 
 */
public class TELEPHONE implements java.io.Serializable {
	
	/** The TYPE. @generated */
	private String TYPE;
	
	/** The NR. @generated */
	private String NR;

	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -193954971L;
	
	/** The id. @generated */
	private Long id;
	
	/** The Constant TYPE_PROP. @generated */
	public static final String TYPE_PROP = "TYPE";
	
	/** The Constant NR_PROP. @generated */
	public static final String NR_PROP = "NR";
	
	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;

	/** The CAL l_ nr. @generated */
	private String CALL_NR;
	
	/** The Constant CALL_NR_PROP. @generated */
	public static final String CALL_NR_PROP = "CALL_NR";

	/** The CUSTOME r_ id. @generated */
	private Long CUSTOMER_ID;
	
	/** The Constant CUSTOMER_ID_PROP. @generated */
	public static final String CUSTOMER_ID_PROP = "CUSTOMER_ID";

	/**
	 * Instantiates a new telephone.
	 *
	 * @generated 
	 */
	public TELEPHONE() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return TYPE + ": " + CALL_NR;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 * @generated 
	 */
	public String getTYPE() {
		return this.TYPE;
	}

	/**
	 * Sets the type.
	 *
	 * @param TYPE the new type
	 * @generated 
	 */
	public void setTYPE(String TYPE) {
		this.TYPE = TYPE;
	}

	/**
	 * Gets the nr.
	 *
	 * @return the nr
	 * @generated 
	 */
	public String getNR() {
		return this.NR;
	}

	/**
	 * Sets the nr.
	 *
	 * @param NR the new nr
	 * @generated 
	 */
	public void setNR(String NR) {
		this.NR = NR;
	}

	/**
	 * Gets the call nr.
	 *
	 * @return the call nr
	 * @generated 
	 */
	public String getCALL_NR() {
		return this.CALL_NR;
	}

	/**
	 * Sets the call nr.
	 *
	 * @param CALL_NR the new call nr
	 * @generated 
	 */
	public void setCALL_NR(String CALL_NR) {
		this.CALL_NR = CALL_NR;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 * @generated 
	 */
	public Long getCUSTOMER_ID() {
		return this.CUSTOMER_ID;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param CUSTOMER_ID the new customer id
	 * @generated 
	 */
	public void setCUSTOMER_ID(Long CUSTOMER_ID) {
		this.CUSTOMER_ID = CUSTOMER_ID;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 * @generated 
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 * @generated 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public java.beans.PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(java.beans.PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}

}