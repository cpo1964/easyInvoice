package com.cpo.invoice.model;


// TODO: Auto-generated Javadoc
/**
 * The Class BANK.
 *
 * @generated 
 */
public class BANK implements java.io.Serializable {
	
	/** The NAME. @generated */
	private String NAME;
	
	/** The ACCOUN t_ nr. @generated */
	private String ACCOUNT_NR;
	
	/** The BLZ. @generated */
	private String BLZ;
	
	/** The IBAN. @generated */
	private String IBAN;
	
	/** The BIC. @generated */
	private String BIC;

	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -206644709L;
	
	/** The id. @generated */
	private Long id;
	
	/** The Constant NAME_PROP. @generated */
	public static final String NAME_PROP = "NAME";
	
	/** The Constant ACCOUNT_NR_PROP. @generated */
	public static final String ACCOUNT_NR_PROP = "ACCOUNT_NR";
	
	/** The Constant BLZ_PROP. @generated */
	public static final String BLZ_PROP = "BLZ";
	
	/** The Constant IBAN_PROP. @generated */
	public static final String IBAN_PROP = "IBAN";
	
	/** The Constant BIC_PROP. @generated */
	public static final String BIC_PROP = "BIC";
	
	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;

	/** The bank adress. @generated */
	private ADRESS bankAdress;
	
	/** The Constant BANKADRESS. @generated */
	public static final String BANKADRESS = "bankAdress";

	/** The CUSTOME r_ id. @generated */
	private Long CUSTOMER_ID;
	
	/** The Constant CUSTOMER_ID_PROP. @generated */
	public static final String CUSTOMER_ID_PROP = "CUSTOMER_ID";

	/**
	 * Instantiates a new bank.
	 *
	 * @generated 
	 */
	public BANK() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getNAME() + "; IBAN=" + IBAN + "; BIC=" + BIC;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "BANK" + " NAME=" + getNAME() + " ACCOUNT_NR=" + ACCOUNT_NR + " BLZ="
				+ BLZ + " IBAN=" + IBAN + " BIC=" + BIC + " id=" + id
				+ " CUSTOMER_ID=" + CUSTOMER_ID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 * @generated 
	 */
	public String getNAME() {
		return this.NAME;
	}

	/**
	 * Sets the name.
	 *
	 * @param NAME the new name
	 * @generated 
	 */
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	/**
	 * Gets the account nr.
	 *
	 * @return the account nr
	 * @generated 
	 */
	public String getACCOUNT_NR() {
		return this.ACCOUNT_NR;
	}

	/**
	 * Sets the account nr.
	 *
	 * @param ACCOUNT_NR the new account nr
	 * @generated 
	 */
	public void setACCOUNT_NR(String ACCOUNT_NR) {
		this.ACCOUNT_NR = ACCOUNT_NR;
	}

	/**
	 * Gets the blz.
	 *
	 * @return the blz
	 * @generated 
	 */
	public String getBLZ() {
		return this.BLZ;
	}

	/**
	 * Sets the blz.
	 *
	 * @param BLZ the new blz
	 * @generated 
	 */
	public void setBLZ(String BLZ) {
		this.BLZ = BLZ;
	}

	/**
	 * Gets the iban.
	 *
	 * @return the iban
	 * @generated 
	 */
	public String getIBAN() {
		return this.IBAN;
	}

	/**
	 * Sets the iban.
	 *
	 * @param IBAN the new iban
	 * @generated 
	 */
	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	/**
	 * Gets the bic.
	 *
	 * @return the bic
	 * @generated 
	 */
	public String getBIC() {
		return this.BIC;
	}

	/**
	 * Sets the bic.
	 *
	 * @param BIC the new bic
	 * @generated 
	 */
	public void setBIC(String BIC) {
		this.BIC = BIC;
	}

	/**
	 * Gets the bank adress.
	 *
	 * @return the bank adress
	 * @generated 
	 */
	public ADRESS getBankAdress() {
		return this.bankAdress;
	}

	/**
	 * Sets the bank adress.
	 *
	 * @param bankAdress the new bank adress
	 * @generated 
	 */
	public void setBankAdress(ADRESS bankAdress) {
		this.bankAdress = bankAdress;
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

//	@Override
//	public int compareTo(Object obj) {
//		return 0;
//	}
}