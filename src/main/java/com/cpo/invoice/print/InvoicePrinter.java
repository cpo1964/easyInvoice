package com.cpo.invoice.print;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.cpo.invoice.control.AdressControl;
import com.cpo.invoice.gui.InvoiceUI;
import com.cpo.invoice.gui.SettingsHelper;
import com.cpo.invoice.model.INVOICE;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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

	public static void writeStringUsingBufferedWritter(String str) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Invoice_A4.jrxml"));
		writer.write(str);
		writer.close();
	}

	/**
	 * Gets the jasper print.
	 *
	 * @param compiledReport the compiled report
	 * @param parameter      the parameter
	 * @param dataSource     the data source
	 * @return the jasper print
	 */
	private static JasperPrint getJasperPrint(final InputStream compiledReport, final HashMap<String, String> parameter,
			final JRMapCollectionDataSource dataSource) {
		JasperPrint jasperPrint = null;
		try {
			if (compiledReport == null) {
				// use report template (compile it first)
				String template = "/com/cpo/invoice/print/Invoice_A4.jrxml";
				String stream = template;
				final InvoicePrinter pr = new InvoicePrinter();
				InputStream inputStream = pr.getClass().getResourceAsStream(stream);
				if (inputStream == null) {
					stream = "src" + template;
					inputStream = pr.getClass().getResourceAsStream(stream);
				}

				String report = "";
				try {
					InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
					BufferedReader in = new BufferedReader(streamReader);

					for (String line; (line = in.readLine()) != null;) {
						report += new String(line);
					}
					System.out.print(report);

					writeStringUsingBufferedWritter(report);
					
					String jasperReport = JasperCompileManager.compileReportToFile("Invoice_A4.jrxml");
//					JasperReport jasperReport = JasperCompileManager.compileReport(report);
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
				} catch (IOException e) {
					return null;
				}
			} else {
				// use compiled report
				jasperPrint = JasperFillManager.fillReport(compiledReport, parameter, dataSource);

			}

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
		InputStream report = pr.getClass().getResourceAsStream(stream);
		if (report == null) {
			stream = "src" + STREAM_INVOICE_A4_JASPER;
			report = pr.getClass().getResourceAsStream(stream);
		}
		final JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(MapHelper.getMap(pInvoice));
		final HashMap<String, String> parameter = ParameterHelper.getParameters(pInvoice);

		JasperPrint jasperPrint = null;
//		if (report == null) {
//			log.error("stream not found: " + STREAM_INVOICE_A4_JASPER);
//			return;
//		}

		// fill some parameter from Java code
//		jasperPrint = getJasperPrint(null, parameter, dataSource);
		jasperPrint =
				getJasperPrint(report, parameter, dataSource);

		// export to pdf
//			JasperExportManager.exportReportToPdfFile(jasperPrint,
//					ParameterHelper.TXT_INV_DATE + ".pdf");

		// show standard print dialog
//		 JasperPrintManager.printReport(jasperPrint, true);

		// show print preview
		if (jasperPrint != null) {
			JasperViewer.viewReport(jasperPrint, false);
		}
		InvoiceUI.getGui().setBundle(bundle);
	}
}
