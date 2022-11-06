package com.cpo.invoice.model;

import com.cpo.invoice.gui.InvoiceUI;

// TODO: Auto-generated Javadoc
/**
 * The Class ARTICLE.
 *
 * @generated 
 */
public class ARTICLE implements java.io.Serializable {
	
	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = -1859650409L;
	
	/** The id. @generated */
	private Long id;
	
	/** The UNIT. @generated */
	private String UNIT;
	
	/** The DESCRIPTION. @generated */
	private String DESCRIPTION;
	
	/** The UNI t_ price. @generated */
	private String UNIT_PRICE;
	
	/** The TAX. @generated */
	private String TAX;
	
	/**
	 * Instantiates a new article.
	 *
	 * @generated 
	 */
	public ARTICLE() {
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 * @generated 
	 */
	public String getUNIT() {
		return this.UNIT;
	}

	/**
	 * Sets the unit.
	 *
	 * @param UNIT the new unit
	 * @generated 
	 */
	public void setUNIT(String UNIT) {
		this.UNIT = UNIT;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 * @generated 
	 */
	public String getDESCRIPTION() {
		return this.DESCRIPTION;
	}

	/**
	 * Sets the description.
	 *
	 * @param DESCRIPTION the new description
	 * @generated 
	 */
	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return the unit price
	 * @generated 
	 */
	public String getUNIT_PRICE() {
		return this.UNIT_PRICE;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param UNIT_PRICE the new unit price
	 * @generated 
	 */
	public void setUNIT_PRICE(String UNIT_PRICE) {
		this.UNIT_PRICE = UNIT_PRICE;
	}

	/**
	 * Gets the tax.
	 *
	 * @return the tax
	 * @generated 
	 */
	public String getTAX() {
		return this.TAX;
	}

	/**
	 * Sets the tax.
	 *
	 * @param TAX the new tax
	 * @generated 
	 */
	public void setTAX(String TAX) {
		this.TAX = TAX;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return 
			InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Description")+"=" + DESCRIPTION +
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.Unit")+"=" + UNIT +
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Articles.Lbl.UnitPrice")+"=" + UNIT_PRICE + 
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"lbl.tax")+"=" + TAX;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "ARTICLE" + " UNIT=" + UNIT + " DESCRIPTION=" + DESCRIPTION
				+ " UNIT_PRICE=" + UNIT_PRICE + " TAX=" + TAX + " id=" + id;
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