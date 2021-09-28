package hu.tamas.ruszka.planetary.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtil {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");

	private DateTimeUtil() {

	}

	public static String formatTime(LocalDateTime time) {
		return DATE_TIME_FORMATTER.format(time);
	}

}
