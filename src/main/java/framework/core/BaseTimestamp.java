package framework.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.log4j.Logger;

public class BaseTimestamp {
	static Logger logger = Logger.getLogger(BaseTimestamp.class);

	public static long nowTimeStamp() {
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		return timeStampSeconds;
	}

	public static long nextDaysTimeStamp(int days) {
		Instant instant = Instant.now().plus(days, ChronoUnit.DAYS);
		long timeStampSeconds = instant.getEpochSecond();
		return timeStampSeconds;
	}

	public static long dateToTimeStamp(String date) {
		SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeStamp = -1;
		try {
			Date cdate = spd.parse(date);
			timeStamp = cdate.getTime() / 1000;
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return timeStamp;
	}
}