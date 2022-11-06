package com.cpo.invoice.print;

/**
 * This Program is a small example for how to use Jasperreports
 * 
 * Copyright (C) 2006 Alexander Merz
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

import java.io.InputStream;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import com.cpo.invoice.control.AdressControl;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.SettingsHelper;
import com.cpo.invoice.model.INVOICE;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoicePrinter.
 */
public final class InvoicePrinter {

	/** The log. */
	private static Logger log = Logger.getLogger(AdressControl.class);

	/** The Constant STREAM_INVOICE_A4_JASPER. */
	private static final String STREAM_INVOICE_A4_JASPER = "/com/cpo/invoice/print/Invoice_A4.jasper";

	/**
	 * Instantiates a new invoice printer.
	 */
	private InvoicePrinter() {
		super();
	}

	/**
	 * Gets the jasper print.
	 *
	 * @param compiledReport the compiled report
	 * @param parameter the parameter
	 * @param dataSource the data source
	 * @return the jasper print
	 */
	private static JasperPrint getJasperPrint(
			final InputStream compiledReport,
			final HashMap<String, String> parameter,
			final JRMapCollectionDataSource dataSource) {
		JasperPrint jasperPrint = null;
		try {
			// use report template (compile it first)
//			String template = "src/invoice/Invoice_A4.jrxml";
//			JasperReport jasperReport = JasperCompileManager.compileReport(template);
//			jasperPrint =
//				JasperFillManager.fillReport(jasperReport, parameter,dataSource);

			// use compiled report
			jasperPrint =
				JasperFillManager.fillReport(compiledReport, parameter, dataSource);

//			 fill report from DB
//			try {
//				Class.forName("org.apache.derby.jdbc.ClientDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			java.sql.Connection conn;
//			try {
//				conn = DriverManager.getConnection(
//						"jdbc:derby://myIPserver:1527", "user", "password");
//				// fill some parameter from derby DB
//				jasperPrint = JasperFillManager.fillReport(
//						report, parameter,conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		} catch (JRException e) {
			log.error("JasperFillManager.fillReport failed ...", e);
		}
		return jasperPrint;
	}

	/**
	 * Prints the invoice.
	 *
	 * @param pInvoice the invoice
	 */
	public static void printInvoice(final INVOICE pInvoice) {
		final ResourceBundle bundle = InvoiceUI.getGui().getBundle();
		SettingsHelper.setBundle(pInvoice.getLANGUAGE());
		final InvoicePrinter pr = new InvoicePrinter();
		String stream = STREAM_INVOICE_A4_JASPER;
		InputStream report =
			pr.getClass().getResourceAsStream(stream);
		if (report == null) {
			stream = "src" + STREAM_INVOICE_A4_JASPER;
			report =
				pr.getClass().getResourceAsStream(stream);
		}
		if (report == null) {
			log.error("stream not found: " + STREAM_INVOICE_A4_JASPER);
			return;
		}
		final JRMapCollectionDataSource dataSource =
			new JRMapCollectionDataSource(MapHelper.getMap(pInvoice));
		final HashMap<String, String> parameter =
			ParameterHelper.getParameters(pInvoice);

		// fill some parameter from Java code
		final JasperPrint jasperPrint =
			getJasperPrint(report, parameter, dataSource);

		// export to pdf
//			JasperExportManager.exportReportToPdfFile(jasperPrint,
//					ParameterHelper.TXT_INV_DATE + ".pdf");

		// show standard print dialog
//		 JasperPrintManager.printReport(jasperPrint, true);

		// show print preview
		JasperViewer.viewReport(jasperPrint, false);
		InvoiceUI.getGui().setBundle(bundle);
	}
}
