package com.cpo.invoice.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ADRESS.
 *
 * @generated 
 */
public class ADRESS implements Comparable<Object>, java.io.Serializable {
	
	/** The COUNTRYCODE. @generated */
	private String COUNTRYCODE;
	
	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -1042812267L;

	/** The id. @generated */
	private Long id;

	/** The STREET. @generated */
	private String STREET;

	/** The HOUSENR. @generated */
	private String HOUSENR;

	/** The PLZ. @generated */
	private String PLZ;

	/** The CITY. @generated */
	private String CITY;

	/** The CUSTOME r_ id. @generated */
	private Long CUSTOMER_ID;
	
//	/** The Constant STREET_PROP. @generated */
//	public static final String STREET_PROP = "STREET";
//
//	/** The Constant HOUSENR_PROP. @generated */
//	public static final String HOUSENR_PROP = "HOUSENR";
//
//	/** The Constant PLZ_PROP. @generated */
//	public static final String PLZ_PROP = "PLZ";
//
//	/** The Constant CITY_PROP. @generated */
//	public static final String CITY_PROP = "CITY";
//	
//	/** The Constant CUSTOMER_ID_PROP. @generated */
//	public static final String CUSTOMER_ID_PROP = "CUSTOMER_ID";
//	
//	/** The Constant COUNTRYCODE_PROP. @generated */
//	public static final String COUNTRYCODE_PROP = "COUNTRYCODE";
//
//	/** The property support. @generated */
//	private transient java.beans.PropertyChangeSupport propertySupport;
	
	/**
 * Instantiates a new adress.
 *
 * @generated 
 */
	public ADRESS() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ((getSTREET() != null && !"".equals(getSTREET())) ? 
						getSTREET() : "")
				+ ((getHOUSENR() != null && !"".equals(getHOUSENR())) ? 
						" " + getHOUSENR() : "")
				+ ((getCOUNTRYCODE() != null && !"".equals(getCOUNTRYCODE())) ?
						", " + getCOUNTRYCODE() : "")
				+ ((getPLZ() != null && !"".equals(getPLZ())) ?
						"-" + getPLZ() : "")
				+ ((getCITY() != null && !"".equals(getCITY())) ?
						" " + getCITY() + "" : "");
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "ADRESS" + " STREET=" + STREET + " HOUSENR=" + HOUSENR
				+ " COUNTRYCODE=" + COUNTRYCODE + " PLZ=" + PLZ + " CITY="
				+ CITY + " id=" + id + " CUSTOMER_ID=" + CUSTOMER_ID;
	}

	/**
	 * Gets the countrycode.
	 *
	 * @return the countrycode
	 * @generated 
	 */
	public String getCOUNTRYCODE() {
		return this.COUNTRYCODE;
	}

	/**
	 * Sets the countrycode.
	 *
	 * @param COUNTRYCODE the new countrycode
	 * @generated 
	 */
	public void setCOUNTRYCODE(String COUNTRYCODE) {
		this.COUNTRYCODE = COUNTRYCODE;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 * @generated 
	 */
	public String getSTREET() {
		return this.STREET;
	}

	/**
	 * Sets the street.
	 *
	 * @param STREET the new street
	 * @generated 
	 */
	public void setSTREET(String STREET) {
		this.STREET = STREET;
	}

	/**
	 * Gets the housenr.
	 *
	 * @return the housenr
	 * @generated 
	 */
	public String getHOUSENR() {
		return this.HOUSENR;
	}

	/**
	 * Sets the housenr.
	 *
	 * @param HOUSENR the new housenr
	 * @generated 
	 */
	public void setHOUSENR(String HOUSENR) {
		this.HOUSENR = HOUSENR;
	}

	/**
	 * Gets the plz.
	 *
	 * @return the plz
	 * @generated 
	 */
	public String getPLZ() {
		return this.PLZ;
	}

	/**
	 * Sets the plz.
	 *
	 * @param PLZ the new plz
	 * @generated 
	 */
	public void setPLZ(String PLZ) {
		this.PLZ = PLZ;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 * @generated 
	 */
	public String getCITY() {
		return this.CITY;
	}

	/**
	 * Sets the city.
	 *
	 * @param CITY the new city
	 * @generated 
	 */
	public void setCITY(String CITY) {
		this.CITY = CITY;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		if (obj.getClass() != getClass())
			throw new ClassCastException(); 
		if (this == obj)
		     return 0; 
	    return (this.getSTREET()+this.getHOUSENR()).compareTo(
	    		((ADRESS) obj).getSTREET()+((ADRESS)obj).getHOUSENR());
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