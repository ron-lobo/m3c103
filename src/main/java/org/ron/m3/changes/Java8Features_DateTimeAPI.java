package org.ron.m3.changes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Java8Features_DateTimeAPI {

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 8: DateTime API");
		Java8Features_DateTimeAPI j8 = new Java8Features_DateTimeAPI();
		j8.localDate();
		j8.localTime();
		j8.localDateTime();
		j8.instantDurationPeriod();
		j8.utilities();
		j8.formatting();
		j8.parsing();
	}

	public void localDate() {
		Utils.newMethod("localDate");

		LocalDate today = LocalDate.now();
		Utils.print("today =", today);

		LocalDate independenceDay = LocalDate.of(1776, Month.JULY, 4);
		Utils.print("independenceDay =", independenceDay);

		// bad data causes a RuntimeException
		try {
			LocalDate badDate = LocalDate.of(2000, Month.FEBRUARY, 30);
		} catch (DateTimeException e) {
			Utils.printerr("No bad dates with Java 8:", e.getMessage());  // unless you date a software engineer
		}

		LocalDate todayInOz = LocalDate.now(ZoneId.of("Australia/Sydney"));
		Utils.print("today In Oz =", todayInOz);
		Utils.print("today In Tokyo =", LocalDate.now(ZoneId.of("Asia/Tokyo")));
		Utils.print("today In NY=", LocalDate.now(ZoneId.of("America/New_York")));
		Utils.print("today In Anchorage =", LocalDate.now(ZoneId.of("America/Anchorage")));

		// Misc
		LocalDate day0 = LocalDate.ofEpochDay(0);
		Utils.print("beginning of epoch =", day0);

		int day = 100;
		int year = today.getYear();
		LocalDate hundredDayOfThisYear = LocalDate.ofYearDay(year, day);
		Utils.print("day", day, "of", year, "is", hundredDayOfThisYear);

		Utils.print("today is", today.getDayOfWeek(), ": day", today.getDayOfYear(),
				"of the year", today.getYear(), "and day", today.getDayOfMonth(),
				"of the month of", today.getMonth());
		Utils.print("today is", today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA_FRENCH));
	}

	public void localTime() {
		Utils.newMethod("localTime");

		LocalTime timeNow = LocalTime.now();
		Utils.print("timeNow =", timeNow);

		LocalTime specificTime = LocalTime.of(11, 59, 59, 987654321);
		Utils.print("Specific Time =", specificTime);
		LocalTime noon = LocalTime.of(12, 0);
		Utils.print("noon =", noon);

		// bad data causes a RuntimeException
		try {
			LocalTime badTime = LocalTime.of(24, 60);
		} catch (DateTimeException e) {
			Utils.printerr("No bad times with Java 8:", e.getMessage());  // except for Monday mornings
		}

		// Timezones
		LocalTime timeInOz = LocalTime.now(ZoneId.of("Australia/Sydney"));
		Utils.print("timeInOz =", timeInOz);
		Utils.print("timeInTokyo =", LocalTime.now(ZoneId.of("Asia/Tokyo")));
		Utils.print("timeInNYC =", LocalTime.now(ZoneId.of("America/New_York")));
		Utils.print("timeInLA =", LocalTime.now(ZoneId.of("America/Los_Angeles")));
		Utils.print("timeInLon =", LocalTime.now(ZoneId.of("Europe/London")));

		int second = 50_000;
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(second);
		Utils.print("second", second, "of the day =", specificSecondTime);
	}

	public void localDateTime() {
		Utils.newMethod("localDateTime");

		LocalDateTime now = LocalDateTime.now();
		Utils.print("now =", now);

		LocalDateTime localDT = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		Utils.print("localDT =", localDT);

		LocalDateTime specificDateTime = LocalDateTime.of(2017, Month.DECEMBER, 25, 11, 59, 30);
		Utils.print("specificDateTime =", specificDateTime);

		// bad data causes a RuntimeException
		try {
			LocalDateTime badDateTime = LocalDateTime.of(2017, Month.FEBRUARY, 29, 24, -1, 99);
		} catch (DateTimeException e) {
			Utils.printerr("Invalid LocalDateTime:", e.getMessage());
		}

		LocalDateTime dateTimeInOz = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
		Utils.print("dateTime In Oz =", dateTimeInOz);
		Utils.print("dateTime In Tokyo =", LocalDateTime.now(ZoneId.of("Asia/Tokyo")));
		Utils.print("dateTime In NYC =", LocalDateTime.now(ZoneId.of("America/New_York")));
		Utils.print("dateTime In LA =", LocalDateTime.now(ZoneId.of("America/Los_Angeles")));

		// misc
		long second = 1_000_000_000_000L;
		LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.UTC);
		Utils.print("Second", second, "from start of epoch =", dateFromBase);

		Utils.print("now is", now.getMinute(), "past", now.getHour(), "on", now.getDayOfWeek(),
				", day", now.getDayOfYear(), "of the year", now.getYear(),
				"and day", now.getDayOfMonth(), "of the month of", now.getMonth(),
				"or", now.toLocalDate(), now.toLocalTime(), "or", now.toString());
	}

	public void instantDurationPeriod() {
		Utils.newMethod("instantDurationPeriod");

		Instant now = Instant.now();
		Utils.print("now =", now);

		long secondsLater = 10_000_000L;
		long totalSinceEpoch = now.toEpochMilli() / 1000 + secondsLater;
		Instant laterInstant = Instant.ofEpochSecond(totalSinceEpoch);
		Utils.print("laterInstant =", laterInstant);
		Utils.print("laterInstant =", now.plusSeconds(secondsLater));


		Duration duration = Duration.ofDays(7);
		Utils.print("7 day duration =", duration);
		Utils.print("14 day duration =", duration.plus(duration));
		Utils.print("1.5 day duration =", duration.minusDays(6).plusHours(12));
		Utils.print("6 hour duration =", duration.minusDays(6).minusHours(18));
		Utils.print("5 mins 30 secs duration =", Duration.ofMinutes(5).plusSeconds(30));


		LocalDate today = LocalDate.now();
		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());


		Period period = today.until(lastDayOfYear);
		Utils.print("period =", period);
		Utils.print("Remaining in this year:", period.getMonths(), "month(s) and", period.getDays(), "days");

		Period randomPeriod = period
				.minusMonths(Utils.getRandomInt(2, 5))
				.minusDays(Utils.getRandomInt(7, 28))
				.plusYears(Utils.getRandomInt(0, 12));
		Utils.print("random period =", randomPeriod, ": remaining months =", randomPeriod.toTotalMonths());
	}

	public void utilities() {
		Utils.newMethod("utilities");

		LocalDate today = LocalDate.now();

		Utils.print("Year", today.getYear(), "is a leap year:", today.isLeapYear());

		LocalDate java9ReleaseDay = LocalDate.of(2017, 9, 21);
		LocalDate java11ReleaseDay = LocalDate.of(2018, 9, 25);
		Utils.print("java9ReleaseDay is", java9ReleaseDay.isBefore(java11ReleaseDay) ? "before" : "after", "java11ReleaseDay");
		Utils.print("Today is", today.isBefore(java11ReleaseDay) ? "before" : "after",
				"and not", today.isAfter(java11ReleaseDay) ? "before" : "after", java11ReleaseDay);

		LocalDateTime noonToday = today.atTime(12, 0);
		Utils.print("noonToday =", noonToday);

		Utils.print("21 days after today:", today.plusDays(21));
		Utils.print("13 weeks after today:", today.plusWeeks(13));
		Utils.print("18 months after today:", today.plusMonths(18));
		Utils.print("21 days before today:", today.minusDays(21));
		Utils.print("13 weeks before today:", today.minusWeeks(13));
		Utils.print("21 months before today:", today.minusMonths(21));

		Utils.print("t1 = ", today.plus(3, ChronoUnit.CENTURIES));
		Utils.print("t2 = ", today.plus(Period.ofDays(3)));
		// Utils.print("t3 = ", today.minus(Duration.ofHours(24)));

		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		Utils.print("Last day of this year =", lastDayOfYear);
		Utils.print("First day of this month =", today.with(TemporalAdjusters.firstDayOfMonth()));
		Utils.print("First Friday of this month =", today.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)));
		Utils.print("Next Friday =", today.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		Utils.print("Previous/Same Friday =", today.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY)));
	}

	public void formatting() {
		Utils.newMethod("formatting");

		LocalTime time = LocalTime.now();
		Utils.print("LocalTime format 0:", time); // default format
		Utils.print("LocalTime format 1a:", time.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
		Utils.print("LocalTime format 1b:", time.format(DateTimeFormatter.ofPattern("HH,mm,ss.SSS")));
		Utils.print("LocalTime format 2:", time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		Utils.print();

		LocalDate date = LocalDate.now();
		Utils.print("LocalDate format 0:", date); // default format
		Utils.print("LocalDate format 1:", date.format(DateTimeFormatter.ofPattern("d / MMM / uuuu")));
		Utils.print("LocalDate format 2:", date.format(DateTimeFormatter.BASIC_ISO_DATE));
		Utils.print("LocalDate format 3:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		Utils.print("LocalDate format 4:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		Utils.print("LocalDate format 5:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		Utils.print("LocalDate format 6:", date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		Utils.print();

		LocalDateTime dateTime = LocalDateTime.now();
		Utils.print("LocalDateTime format 0:", dateTime); // default format
		Utils.print("LocalDateTime format 1:", dateTime.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy HH::mm::ss")));
		Utils.print("LocalDateTime format 2:", dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		Utils.print("LocalDateTime format 3:", dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		Utils.print("LocalDateTime format 4:", dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		Utils.print("LocalDateTime format 5:", dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
	}

	public void parsing() {
		Utils.newMethod("parsing");

		String timeStr = "11/59/30";
		String dateStr = "29:Feb:2000";
		String dateTimeStr = dateStr + "-" + timeStr;

		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH/mm/ss");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd:MMM:yyyy");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd:MMM:yyyy-HH/mm/ss");

		Utils.print("parsed time:", LocalTime.parse(timeStr, timeFormatter));
		Utils.print("parsed date:", LocalDate.parse(dateStr, dateFormatter));
		Utils.print("parsed dateTime:", LocalDateTime.parse(dateTimeStr, dateTimeFormatter));
	}
}
