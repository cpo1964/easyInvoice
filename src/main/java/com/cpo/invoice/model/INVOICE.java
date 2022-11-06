package com.cpo.invoice.model;

import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.SettingsHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class INVOICE.
 *
 * @generated 
 */
public class INVOICE implements Comparable<Object>, java.io.Serializable {
	
	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = 832926414L;
	
	/** The NR. @generated */
	private String NR;
	
	/** The IN v_ date. @generated */
	private String INV_DATE;

	/**
	 * Gets the inv date.
	 *
	 * @return the inv date
	 */
	public String getINV_DATE() {
		return INV_DATE;
	}

	/**
	 * Sets the inv date.
	 *
	 * @param iNV_DATE the new inv date
	 */
	public void setINV_DATE(String iNV_DATE) {
		INV_DATE = iNV_DATE;
	}

	/** The PA y_ until. @generated */
	private String PAY_UNTIL;

	/** The id. @generated */
	private Long id;
	
	/** The Constant TEXTBLOCK. @generated */
	public static final String TEXTBLOCK = "tEXTBLOCK";
	
	/** The t extblock. @generated */
	private java.util.Set<TEXTBLOCK> tEXTBLOCK;

	/** The s ender. @generated */
	private CUSTOMER sENDER;
	
	/** The r eceiver. @generated */
	private CUSTOMER rECEIVER;
	
	/** The Constant SENDER. @generated */
	public static final String SENDER = "sENDER";
	
	/** The Constant RECEIVER. @generated */
	public static final String RECEIVER = "rECEIVER";

	/** The i nvoic e_ position. @generated */
	private java.util.Set<INVOICE_POSITION> iNVOICE_POSITION;
	
	/** The Constant INVOICE_POSITION. @generated */
	public static final String INVOICE_POSITION = "iNVOICE_POSITION";

	/** The TA x1. @generated */
	private String TAX1;
	
	/** The TA x2. @generated */
	private String TAX2;
	
	/** The TA x3. @generated */
	private String TAX3;
	
	/** The CURRENCY. @generated */
	private String CURRENCY;
	
	/** The LANGUAGE. @generated */
	private String LANGUAGE;
	
	/**
	 * Instantiates a new invoice.
	 *
	 * @generated 
	 */
	public INVOICE() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return 
			InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Invoices.Lbl.InvoiceNr")+"=" + NR +
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Invoices.Lbl.InvoiceDate")+"=" + INV_DATE + 
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Invoices.Lbl.InvoicePayUntil")+"=" + PAY_UNTIL +
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Settings.Lbl.Currency")+"=" + 
					SettingsHelper.getCurrencySymbol(CURRENCY) + 
			"; " + InvoiceUI.getGui().getBundleValueByKey(
				"tab.name.Settings.Lbl.Language")+"="+ LANGUAGE;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "INVOICE" + " NR=" + NR + " DATE=" + INV_DATE + " PAY_UNTIL="
				+ PAY_UNTIL + " id=" + id + " TAX1=" + TAX1 + " TAX2=" + TAX2
				+ " TAX3=" + TAX3 + " CURRENCY=" + CURRENCY + " LANGUAGE="
				+ LANGUAGE;
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
	 * Gets the pay until.
	 *
	 * @return the pay until
	 * @generated 
	 */
	public String getPAY_UNTIL() {
		return this.PAY_UNTIL;
	}

	/**
	 * Sets the pay until.
	 *
	 * @param PAY_UNTIL the new pay until
	 * @generated 
	 */
	public void setPAY_UNTIL(String PAY_UNTIL) {
		this.PAY_UNTIL = PAY_UNTIL;
	}

	/**
	 * Gets the textblock.
	 *
	 * @return the textblock
	 * @generated 
	 */
	public java.util.Set<TEXTBLOCK> getTEXTBLOCK() {
		return tEXTBLOCK;
	}

	/**
	 * Sets the textblock.
	 *
	 * @param tEXTBLOCK the new textblock
	 * @generated 
	 */
	public void setTEXTBLOCK(java.util.Set<TEXTBLOCK> tEXTBLOCK) {
		this.tEXTBLOCK = tEXTBLOCK;
	}

	/**
	 * Adds the TEXTBLOCK.
	 *
	 * @param tEXTBLOCK the t EXTBLOCK
	 * @generated 
	 */
	public void addTEXTBLOCK(TEXTBLOCK tEXTBLOCK) {
		getTEXTBLOCK().add(tEXTBLOCK);
	}

	/**
	 * Removes the TEXTBLOCK.
	 *
	 * @param tEXTBLOCK the t EXTBLOCK
	 * @generated 
	 */
	public void removeTEXTBLOCK(TEXTBLOCK tEXTBLOCK) {
		getTEXTBLOCK().remove(tEXTBLOCK);
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 * @generated 
	 */
	public CUSTOMER getSENDER() {
		return this.sENDER;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sENDER the new sender
	 * @generated 
	 */
	public void setSENDER(CUSTOMER sENDER) {
		this.sENDER = sENDER;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 * @generated 
	 */
	public CUSTOMER getRECEIVER() {
		return this.rECEIVER;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param rECEIVER the new receiver
	 * @generated 
	 */
	public void setRECEIVER(CUSTOMER rECEIVER) {
		this.rECEIVER = rECEIVER;
	}

	/**
	 * Gets the invoice position.
	 *
	 * @return the invoice position
	 * @generated 
	 */
	public java.util.Set<INVOICE_POSITION> getINVOICE_POSITION() {
		return iNVOICE_POSITION;
	}

	/**
	 * Sets the invoice position.
	 *
	 * @param iNVOICE_POSITION the new invoice position
	 * @generated 
	 */
	public void setINVOICE_POSITION(
			java.util.Set<INVOICE_POSITION> iNVOICE_POSITION) {
				this.iNVOICE_POSITION = iNVOICE_POSITION;
			}

	/**
	 * Adds the INVOIC E POSITION.
	 *
	 * @param iNVOICE_POSITION the i NVOIC E POSITION
	 * @generated 
	 */
	public void addINVOICE_POSITION(INVOICE_POSITION iNVOICE_POSITION) {
		getINVOICE_POSITION().add(iNVOICE_POSITION);
	}

	/**
	 * Removes the INVOIC E POSITION.
	 *
	 * @param iNVOICE_POSITION the i NVOIC E POSITION
	 * @generated 
	 */
	public void removeINVOICE_POSITION(INVOICE_POSITION iNVOICE_POSITION) {
		getINVOICE_POSITION().remove(iNVOICE_POSITION);
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object obj) {
		if (obj.getClass() != getClass())
			throw new ClassCastException(); 
		if (this == obj)
		     return 0; 
	    return (this.getNR()).compareTo(
	    		((INVOICE) obj).getNR());
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