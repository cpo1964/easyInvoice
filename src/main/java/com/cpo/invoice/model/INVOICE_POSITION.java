package com.cpo.invoice.model;

import com.cpo.invoice.gui.InvoiceUI;


// TODO: Auto-generated Javadoc
/**
 * The Class INVOICE_POSITION.
 *
 * @generated 
 */
public class INVOICE_POSITION implements Comparable<Object>, java.io.Serializable {
	
	/** The NR. @generated */
	private String NR;
	
	/** The QUANTITY. @generated */
	private String QUANTITY;
	
	/** The AMOUNT. @generated */
	private String AMOUNT;

	/** The a rticle. @generated */
	private ARTICLE aRTICLE;
	
	/** The INVOIC e_ id. @generated */
	private Long INVOICE_ID;
	
	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -2146332806L;
	
	/** The id. @generated */
	private Long id;
	
	/** The Constant NR_PROP. @generated */
	public static final String NR_PROP = "NR";
	
	/** The Constant QUANTITY_PROP. @generated */
	public static final String QUANTITY_PROP = "QUANTITY";
	
	/** The Constant AMOUNT_PROP. @generated */
	public static final String AMOUNT_PROP = "AMOUNT";
	
	/** The Constant ARTICLE. @generated */
	public static final String ARTICLE = "aRTICLE";
	
	/** The Constant INVOICE_ID_PROP. @generated */
	public static final String INVOICE_ID_PROP = "INVOICE_ID";
	
	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;
	
	/**
	 * Instantiates a new invoice position.
	 *
	 * @generated 
	 */
	public INVOICE_POSITION() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return 
//			InvoiceUI.getGui().getBundleValueByKey(
//				"tab.name.InvoicePosition.Lbl.PositionNr")+"=" + 
//				NR + "; "+ 
			InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.InvoicePosition.Lbl.Quantity")+"=" + QUANTITY + /*
			((this.getARTICLE() != null) ? (
			"; "+ InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Unit")+"="+
					this.getARTICLE().getUNIT() +
			"; "+ InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Description")+"="+
					this.getARTICLE().getDESCRIPTION() +
			"; "+ InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Tax")+"="+
					this.getARTICLE().getTAX() +
			"; "+ InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.UnitPrice")+"="+
					this.getARTICLE().getUNIT_PRICE()):"") + */
			"; "+ InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.InvoicePosition.Lbl.Amount")+"=" + AMOUNT;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "INVOICE_POSITION" + " NR=" + NR + " QUANTITY=" + QUANTITY
				+ " AMOUNT=" + AMOUNT + /*" id=" + id +*/ " INVOICE_ID="
				+ INVOICE_ID;
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 * @generated 
	 */
	public String getQUANTITY() {
		return this.QUANTITY;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param QUANTITY the new quantity
	 * @generated 
	 */
	public void setQUANTITY(String QUANTITY) {
		this.QUANTITY = QUANTITY;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 * @generated 
	 */
	public String getAMOUNT() {
		return this.AMOUNT;
	}

	/**
	 * Sets the amount.
	 *
	 * @param AMOUNT the new amount
	 * @generated 
	 */
	public void setAMOUNT(String AMOUNT) {
		this.AMOUNT = AMOUNT;
	}

	/**
	 * Gets the article.
	 *
	 * @return the article
	 * @generated 
	 */
	public ARTICLE getARTICLE() {
		return this.aRTICLE;
	}

	/**
	 * Sets the article.
	 *
	 * @param aRTICLE the new article
	 * @generated 
	 */
	public void setARTICLE(ARTICLE aRTICLE) {
		this.aRTICLE = aRTICLE;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		if (obj.getClass() != getClass())
			throw new ClassCastException(); 
		if (this == obj)
		     return 0; 
	    return (this.getNR()).compareTo(((INVOICE_POSITION) obj).getNR());
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