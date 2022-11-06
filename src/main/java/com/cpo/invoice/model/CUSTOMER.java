package com.cpo.invoice.model;

import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.util.StringHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class CUSTOMER.
 *
 * @generated 
 */
public class CUSTOMER implements Comparable<Object>, java.io.Serializable {
	
	/** The Constant NAME_PROP. @generated */
	public static final String NAME_PROP = "NAME";

	/** The Constant LASTNAME_PROP. @generated */
	public static final String LASTNAME_PROP = "LASTNAME";

	/** The Constant UID_PROP. @generated */
	public static final String UID_PROP = "UID";

	/** The Constant TITLE_PROP. @generated */
	public static final String TITLE_PROP = "TITLE";

	/** The Constant SENDER_PROP. @generated */
	public static final String SENDER_PROP = "SENDER";

	/** The Constant TAXNR_PROP. @generated */
	public static final String TAXNR_PROP = "TAXNR";

	/** The Constant INVOICEPHONE. @generated */
	public static final String INVOICEPHONE = "invoicePhone";

	/** The Constant INVOICEADRESS. @generated */
	public static final String INVOICEADRESS = "invoiceAdress";

	/** The Constant INVOICEBANK. @generated */
	public static final String INVOICEBANK = "invoiceBank";

	/** The Constant serialVersionUID. @generated */
	private static final long serialVersionUID = 20464701L;

	/** The NAME. @generated */
	private String NAME;

	/** The LASTNAME. @generated */
	private String LASTNAME;

	/** The UID. @generated */
	private String UID;

	/** The TITLE. @generated */
	private String TITLE;

	/** The id. @generated */
	private Long id;

	/** The property support. @generated */
	private transient java.beans.PropertyChangeSupport propertySupport;

	/** The SENDER. @generated */
	private String SENDER;

	/** The TAXNR. @generated */
	private String TAXNR;

	/** The invoice phone. @generated */
	private TELEPHONE invoicePhone;

	/** The invoice adress. @generated */
	private ADRESS invoiceAdress;

	/** The invoice bank. @generated */
	private BANK invoiceBank;

	/**
	 * Instantiates a new customer.
	 *
	 * @generated 
	 */
	public CUSTOMER() {
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
	 * Gets the lastname.
	 *
	 * @return the lastname
	 * @generated 
	 */
	public String getLASTNAME() {
		return this.LASTNAME;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param LASTNAME the new lastname
	 * @generated 
	 */
	public void setLASTNAME(String LASTNAME) {
		this.LASTNAME = LASTNAME;
	}

	/**
	 * Gets the uid.
	 *
	 * @return the uid
	 * @generated 
	 */
	public String getUID() {
		return this.UID;
	}

	/**
	 * Sets the uid.
	 *
	 * @param UID the new uid
	 * @generated 
	 */
	public void setUID(String UID) {
		this.UID = UID;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 * @generated 
	 */
	public String getTITLE() {
		return this.TITLE;
	}

	/**
	 * Sets the title.
	 *
	 * @param TITLE the new title
	 * @generated 
	 */
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 * @generated 
	 */
	public String getSENDER() {
		return this.SENDER;
	}

	/**
	 * Sets the sender.
	 *
	 * @param SENDER the new sender
	 * @generated 
	 */
	public void setSENDER(String SENDER) {
		this.SENDER = SENDER;
	}

	/**
	 * Gets the taxnr.
	 *
	 * @return the taxnr
	 * @generated 
	 */
	public String getTAXNR() {
		return this.TAXNR;
	}

	/**
	 * Sets the taxnr.
	 *
	 * @param TAXNR the new taxnr
	 * @generated 
	 */
	public void setTAXNR(String TAXNR) {
		this.TAXNR = TAXNR;
	}

	/**
	 * Gets the invoice phone.
	 *
	 * @return the invoice phone
	 * @generated 
	 */
	public TELEPHONE getInvoicePhone() {
		return this.invoicePhone;
	}

	/**
	 * Sets the invoice phone.
	 *
	 * @param invoicePhone the new invoice phone
	 * @generated 
	 */
	public void setInvoicePhone(TELEPHONE invoicePhone) {
		this.invoicePhone = invoicePhone;
	}

	/**
	 * Gets the invoice adress.
	 *
	 * @return the invoice adress
	 * @generated 
	 */
	public ADRESS getInvoiceAdress() {
		return this.invoiceAdress;
	}

	/**
	 * Sets the invoice adress.
	 *
	 * @param invoiceAdress the new invoice adress
	 * @generated 
	 */
	public void setInvoiceAdress(ADRESS invoiceAdress) {
		this.invoiceAdress = invoiceAdress;
	}

	/**
	 * Gets the invoice bank.
	 *
	 * @return the invoice bank
	 * @generated 
	 */
	public BANK getInvoiceBank() {
		return this.invoiceBank;
	}

	/**
	 * Sets the invoice bank.
	 *
	 * @param invoiceBank the new invoice bank
	 * @generated 
	 */
	public void setInvoiceBank(BANK invoiceBank) {
		this.invoiceBank = invoiceBank;
	}

	/**
	 * To string2.
	 *
	 * @return the string
	 */
	public String toString2() {
		return "CUSTOMER" + " NAME=" + NAME + " LASTNAME=" + LASTNAME + " UID=" +
				UID + " TITLE=" + TITLE + " SENDER=" + SENDER + " id=" + id +
				" TAXNR=" + TAXNR;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("true".equals(SENDER) ?
				InvoiceUI.getGui().getBundleValueByKey(
					StringHelper.TAB_NAME_INVOICES_LBL_INVOICE_SENDER) + ": " :
				InvoiceUI.getGui().getBundleValueByKey(
					StringHelper.TAB_NAME_INVOICES_LBL_INVOICE_RECEIVER) + ": ") +
				((TITLE != null && !"".equals(TITLE)) ? TITLE + " " : "") +
				((NAME != null && !"".equals(NAME)) ? NAME + " ":"") +
				((LASTNAME != null && !"".equals(LASTNAME)) ? LASTNAME:" ") +
				((UID != null && !"".equals(UID)) ? "; UID: " + UID + "" : "");
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(final Object obj) {
		if (obj.getClass() != getClass()) {
			throw new ClassCastException();
		}
		if (this == obj) {
			return 0;
		}
		final String str2 = ((CUSTOMER)obj).getSENDER().replace('t', 'a') + ((CUSTOMER)obj).toString();
		final String str1 = this.getSENDER().replace('t', 'a') + this.toString();
//	    System.out.println("compare '"+str1+"' with '"+str2+"'");
		return str1.compareTo(str2);
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