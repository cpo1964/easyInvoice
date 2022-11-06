package com.cpo.invoice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.FileAppender;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

// TODO: Auto-generated Javadoc
/**
 * Appender that periodically compress current log. You need only pass one
 * setting - period after that log should compress. Available periods are
 * MINUTLY, HOURLY, DAILY, WEEKLY, MONTHLY.
 * 
 * @author Pokidov.Dmitry Date: 27.08.2009
 */
public final class CompressingRollingFileAppender extends FileAppender {

	/**
	 * The Enum Period.
	 */
	enum Period {

		/** The MINUTLY. */
		MINUTLY,
		/** The HOURLY. */
		HOURLY,
		/** The DAILY. */
		DAILY,
		/** The WEEKLY. */
		WEEKLY,
		/** The MONTHLY. */
		MONTHLY
	}

	/** The roll date. */
	private GregorianCalendar rollDate;

	/** The period. */
	private Period period = Period.HOURLY;

	/** The date format. */
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd-HH-mm");

	/**
	 * Instantiates a new compressing rolling file appender.
	 */
	public CompressingRollingFileAppender() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.log4j.FileAppender#activateOptions()
	 */
	@Override
	public void activateOptions() {
		super.activateOptions();
		setAppend(false);
	}

	/**
	 * Period for rolling. By default - {@code HOURLY}
	 * 
	 * @param pPeriod
	 *            new period. Available values: MINUTLY, HOURLY, DAILY, WEEKLY,
	 *            MONTHLY.
	 */
	public void setPeriod(final String pPeriod) {
		try {
			this.period = Period.valueOf(pPeriod);
		} catch (IllegalArgumentException e) {
			LogLog.warn("No period with name [" + pPeriod + "]", e);
		}
		LogLog.debug("Set roll period to [" + this.period + "]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.log4j.FileAppender#setAppend(boolean)
	 */
	@Override
	public void setAppend(final boolean flag) {
		// LogLog.warn("Compression rolling appender doesn't "+
		// "support append option(always set to false)");
	}

	/**
	 * Roll over.
	 */
	protected void rollOver() {
		final String currentFileName = getFile();
		final File currentFile = new File(currentFileName);
		final File zipFile = new File(currentFileName + "." +
				dateFormat.format(new Date()) + ".gz");
		try {
			final FileInputStream stream = new FileInputStream(currentFile);
			final byte[] content = new byte[stream.available()];
			stream.read(content);
			final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(
					new FileOutputStream(zipFile));
			gzipOutputStream.write(content, 0, content.length);
			gzipOutputStream.finish();
			gzipOutputStream.flush();
			gzipOutputStream.close();
			setFile(currentFileName, false, getBufferedIO(), getBufferSize());
			rollDate.add(getDateFieldByPeriod(), 1);
		} catch (IOException e) {
			LogLog.error("Error compress current log file [" + currentFile +
					"] to zip file [" + zipFile + "]", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.log4j.WriterAppender#subAppend(org.apache.log4j.spi.LoggingEvent
	 * )
	 */
	@Override
	protected void subAppend(final LoggingEvent event) {
		if (rollDate == null) {
			rollDate = new GregorianCalendar();
			rollDate.add(getDateFieldByPeriod(), 1);
		}
		final GregorianCalendar now = new GregorianCalendar();
		if (rollDate.before(now)) {
			rollOver();
		}
		super.subAppend(event);
	}

	/**
	 * Gets the date field by period.
	 * 
	 * @return the date field by period
	 */
	private int getDateFieldByPeriod() {
		int res = GregorianCalendar.MINUTE;
		switch (period) {
		case MINUTLY:
			res = GregorianCalendar.MINUTE;
			break;
		case HOURLY:
			res = GregorianCalendar.HOUR;
			break;
		case DAILY:
			res = GregorianCalendar.DAY_OF_MONTH;
			break;
		case WEEKLY:
			res = GregorianCalendar.WEEK_OF_MONTH;
			break;
		case MONTHLY:
			res = GregorianCalendar.MONTH;
			break;
		default:
			res = GregorianCalendar.MINUTE;
		}
		return res;
	}
}
