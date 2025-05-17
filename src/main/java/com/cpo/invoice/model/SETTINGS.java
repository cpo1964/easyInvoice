package com.cpo.invoice.model;


// TODO: Auto-generated Javadoc
/**
 * The Class SETTINGS.
 *
 * @generated 
 */
public class SETTINGS implements java.io.Serializable {
	
	/** The BOOKIN g_ year. @generated */
	private String BOOKING_YEAR;

	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = 848920706L;
	
	/** The id. @generated */
	private Long id;
	
	/** The Constant BOOKING_YEAR_PROP. @generated */
	public static final String BOOKING_YEAR_PROP = "BOOKING_YEAR";
	
	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;

	/** The CURRENCY. @generated */
	private String CURRENCY;

	/** The Constant CURRENCY_PROP. @generated */
	public static final String CURRENCY_PROP = "CURRENCY";

	/** The LANGUAGE. @generated */
	private String LANGUAGE;

	/** The Constant LANGUAGE_PROP. @generated */
	public static final String LANGUAGE_PROP = "LANGUAGE";

	/** The TA x1. @generated */
	private String TAX1;

	/** The TA x2. @generated */
	private String TAX2;

	/** The TA x3. @generated */
	private String TAX3;

	/** The Constant TAX1_PROP. @generated */
	public static final String TAX1_PROP = "TAX1";

	/** The Constant TAX2_PROP. @generated */
	public static final String TAX2_PROP = "TAX2";

	/** The Constant TAX3_PROP. @generated */
	public static final String TAX3_PROP = "TAX3";

	/**
	 * Instantiates a new settings.
	 *
	 * @generated 
	 */
	public SETTINGS() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "SETTINGS" + " BOOKING_YEAR=" + BOOKING_YEAR + " id=" + id
				+ " TAX1=" + TAX1 + " TAX2=" + TAX2 + " TAX3=" + TAX3
				+ " CURRENCY=" + CURRENCY + " LANGUAGE=" + LANGUAGE;
	}

	/**
	 * Gets the booking year.
	 *
	 * @return the booking year
	 * @generated 
	 */
	public String getBOOKING_YEAR() {
		return this.BOOKING_YEAR;
	}

	/**
	 * Sets the booking year.
	 *
	 * @param BOOKING_YEAR the new booking year
	 * @generated 
	 */
	public void setBOOKING_YEAR(String BOOKING_YEAR) {
		this.BOOKING_YEAR = BOOKING_YEAR;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 * @generated 
	 */
	public String getCURRENCY() {
		return this.CURRENCY;
	}

	/**
	 * Sets the currency.
	 *
	 * @param CURRENCY the new currency
	 * @generated 
	 */
	public void setCURRENCY(String CURRENCY) {
		this.CURRENCY = CURRENCY;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 * @generated 
	 */
	public String getLANGUAGE() {
		return this.LANGUAGE;
	}

	/**
	 * Sets the language.
	 *
	 * @param LANGUAGE the new language
	 * @generated 
	 */
	public void setLANGUAGE(String LANGUAGE) {
		this.LANGUAGE = LANGUAGE;
	}

	/**
	 * Gets the tax1.
	 *
	 * @return the tax1
	 * @generated 
	 */
	public String getTAX1() {
		return this.TAX1;
	}

	/**
	 * Sets the tax1.
	 *
	 * @param TAX1 the new tax1
	 * @generated 
	 */
	public void setTAX1(String TAX1) {
		this.TAX1 = TAX1;
	}

	/**
	 * Gets the tax2.
	 *
	 * @return the tax2
	 * @generated 
	 */
	public String getTAX2() {
		return this.TAX2;
	}

	/**
	 * Sets the tax2.
	 *
	 * @param TAX2 the new tax2
	 * @generated 
	 */
	public void setTAX2(String TAX2) {
		this.TAX2 = TAX2;
	}

	/**
	 * Gets the tax3.
	 *
	 * @return the tax3
	 * @generated 
	 */
	public String getTAX3() {
		return this.TAX3;
	}

	/**
	 * Sets the tax3.
	 *
	 * @param TAX3 the new tax3
	 * @generated 
	 */
	public void setTAX3(String TAX3) {
		this.TAX3 = TAX3;
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

//	@Override
//	public int compareTo(Object obj) {
//		return 0;
//	}

}