package com.cpo.invoice.model;


// TODO: Auto-generated Javadoc
/**
 * The Class TEXTBLOCK.
 *
 * @generated 
 */
public class TEXTBLOCK implements Comparable<Object>, java.io.Serializable  {
	
	/** The DESCRIBER. @generated */
	private String DESCRIBER;
	
	/** The TEXT. @generated */
	private String TEXT;

	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -2012185887L;
	
	/** The id. @generated */
	private Long id;
	
	/** The Constant DESCRIBER_PROP. @generated */
	public static final String DESCRIBER_PROP = "DESCRIBER";
	
	/** The Constant TEXT_PROP. @generated */
	public static final String TEXT_PROP = "TEXT";
	
	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;

	/** The INVOIC e_ id. @generated */
	private Long INVOICE_ID;
	
	/** The Constant INVOICE_ID_PROP. @generated */
	public static final String INVOICE_ID_PROP = "INVOICE_ID";

	/** The NR. @generated */
	private String NR;
	
	/** The Constant NR_PROP. @generated */
	public static final String NR_PROP = "NR";

	/**
	 * Instantiates a new textblock.
	 *
	 * @generated 
	 */
	public TEXTBLOCK() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return 
//			NR + "; "+ 
			TEXT;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "TEXTBLOCK" + " DESCRIBER=" + DESCRIBER + " TEXT=" + TEXT
				+ " id=" + id + " INVOICE_ID=" + INVOICE_ID + " NR=" + NR;
	}

	/**
	 * Gets the describer.
	 *
	 * @return the describer
	 * @generated 
	 */
	public String getDESCRIBER() {
		return this.DESCRIBER;
	}

	/**
	 * Sets the describer.
	 *
	 * @param DESCRIBER the new describer
	 * @generated 
	 */
	public void setDESCRIBER(String DESCRIBER) {
		this.DESCRIBER = DESCRIBER;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 * @generated 
	 */
	public String getTEXT() {
		return this.TEXT;
	}

	/**
	 * Sets the text.
	 *
	 * @param TEXT the new text
	 * @generated 
	 */
	public void setTEXT(String TEXT) {
		this.TEXT = TEXT;
	}

	/**
	 * Gets the invoice id.
	 *
	 * @return the invoice id
	 * @generated 
	 */
	public Long getINVOICE_ID() {
		return this.INVOICE_ID;
	}

	/**
	 * Sets the invoice id.
	 *
	 * @param INVOICE_ID the new invoice id
	 * @generated 
	 */
	public void setINVOICE_ID(Long INVOICE_ID) {
		this.INVOICE_ID = INVOICE_ID;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		if (obj.getClass() != getClass())
			throw new ClassCastException(); 
		if (this == obj)
		     return 0; 
	    return (this.getNR()).compareTo(((TEXTBLOCK) obj).getNR());
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

}