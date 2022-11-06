package com.cpo.invoice.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.cpo.invoice.control.PositionControl;
import com.cpo.invoice.gui.PositionHelper;
import com.cpo.invoice.gui.SettingsHelper;
import com.cpo.invoice.model.INVOICE;
import com.cpo.invoice.model.INVOICE_POSITION;
import com.cpo.invoice.util.CommonHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class MapHelper.
 */
public final class MapHelper {

	/** The netto tax1. */
	private static double nettoTax1; // default 0

	/** The netto tax2. */
	private static double nettoTax2; // default 0

	/** The netto tax3. */
	private static double nettoTax3; // default 0

	/**
	 * Instantiates a new map helper.
	 */
	private MapHelper() {
		super();
	}

	/**
	 * Gets the netto tax 1.
	 *
	 * @return the netto tax 1
	 */
	public static double getNettoTax1() {
		return nettoTax1;
	}

	/**
	 * Sets the netto tax 1.
	 *
	 * @param pValue the new netto tax 1
	 */
	public static void setNettoTax1(final double pValue) {
		MapHelper.nettoTax1 = pValue;
	}

	/**
	 * Gets the netto tax 2.
	 *
	 * @return the netto tax 2
	 */
	public static double getNettoTax2() {
		return nettoTax2;
	}

	/**
	 * Sets the netto tax 2.
	 *
	 * @param pValue the new netto tax 2
	 */
	public static void setNettoTax2(final double pValue) {
		MapHelper.nettoTax2 = pValue;
	}

	/**
	 * Gets the netto tax 3.
	 *
	 * @return the netto tax 3
	 */
	public static double getNettoTax3() {
		return nettoTax3;
	}

	/**
	 * Sets the netto tax 3.
	 *
	 * @param pValue the new netto tax 3
	 */
	public static void setNettoTax3(final double pValue) {
		MapHelper.nettoTax3 = pValue;
	}
	/**
	 * Gets the map.
	 *
	 * @param pInvoice the invoice
	 * @return the map
	 */
	public static Collection<Map<String, Object>> getMap(final INVOICE pInvoice) {
		setNettoTax1(0);
		setNettoTax2(0);
		setNettoTax3(0);
		PositionHelper.setInvoicePositionData(PositionControl
			.getInvoicePositionData(pInvoice));
		Collections.sort(PositionHelper.getInvoicePositionData());
		final Collection<Map<String, Object>> lColl =
			new ArrayList<Map<String, Object>>();
		final int posCount = PositionHelper.getInvoicePositionData().size();
		for (int i = 0; i < posCount; i++) {
			lColl.add(getPositionMap(
					PositionHelper.getInvoicePositionData().get(i)));
		}
		return lColl;
	}

	/**
	 * Gets the position map.
	 *
	 * @param pPos the pos
	 * @return the position map
	 */
	private static Map<String, Object> getPositionMap(final INVOICE_POSITION pPos) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("pos_quantity", pPos.getQUANTITY());
//		System.out.println("pos_quantity: "+pPos.getQUANTITY());
		map.put("article_unit", pPos.getARTICLE().getUNIT());
//		System.out.println("article_unit: "+pPos.getARTICLE().getUNIT());
		map.put("article_description", pPos.getARTICLE().getDESCRIPTION());
//		System.out.println("article_description: "+pPos.getARTICLE().getDESCRIPTION());
		map.put("article_tax", pPos.getARTICLE().getTAX());
//		System.out.println("article_tax: "+pPos.getARTICLE().getTAX());
		map.put("article_unit_price", pPos.getARTICLE().getUNIT_PRICE());
//		System.out.println("article_unit_price: "+pPos.getARTICLE().getUNIT_PRICE());
		map.put("pos_amount", pPos.getAMOUNT());
//		System.out.println("pos_amount: "+pPos.getAMOUNT());
		setNettoTax1(getNettoTax1() +
			getAmountForTax(1, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
		setNettoTax2(getNettoTax2() +
			getAmountForTax(2, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
		setNettoTax3(getNettoTax3() +
			getAmountForTax(3, pPos.getARTICLE().getTAX(), pPos.getAMOUNT()));
//		System.out.println("netto: "+netto);
		return map;
	}

	/**
	 * Gets the amount for tax.
	 *
	 * @param taxNr the tax nr
	 * @param tax the tax
	 * @param amount the amount
	 * @return the amount for tax
	 */
	private static double getAmountForTax(final int taxNr, final String tax, final String amount) {
		final double amnt = CommonHelper.getDouble(amount);
		final String lTax = SettingsHelper.getTaxData()[taxNr-1];
		if (lTax.equals(tax)) {
			return amnt;
		}
		return 0;
	}

}
