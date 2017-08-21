package java8date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * http://mp.weixin.qq.com/s?__biz=MjM5NzMyMjAwMA==&mid=2651478876&idx=1&sn=fa7e64dc5fa1f8266d051f287efbf586&chksm=bd2537238a52be35c495e8f1f27706e9201e3a3a4487bfe40613febd7cd9e99839a9295238ae&mpshare=1&scene=23&srcid=08126agqCT46UnNt6fwkmEp3#rd
 * 
 * @author 琚超超
 *
 */
public class Test {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalDate of = LocalDate.of(2017, 07, 11);
		System.out.println(date);
		System.out.println(of);
		LocalDate parse = LocalDate.parse("2016-06-10");
		System.out.println(parse);
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println(tomorrow);
		LocalDate prevMonth = LocalDate.now().minusMonths(1);
		System.out.println(prevMonth);
		prevMonth = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println(prevMonth);
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		System.out.println(dayOfWeek);
		int dayOfMonth = LocalDate.now().getDayOfMonth();
		System.out.println(dayOfMonth);
		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println(leapYear);
		boolean notBefore = LocalDate.of(2017, 8, 13).isBefore(LocalDate.now());
		System.out.println(notBefore);
		boolean isAfter = LocalDate.of(2017, 8, 13).isAfter(LocalDate.now());
		System.out.println(isAfter);
		System.out.println(date.getChronology());
		System.out.println(date.withDayOfMonth(1));
		System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
		LocalDate birthday = LocalDate.of(2009, 07, 20);
		MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
		MonthDay today = MonthDay.from(LocalDate.now());
		System.out.println("今天是否是我的生日: " + today.equals(birthdayMd));
		LocalTime now = LocalTime.now();
		System.out.println("现在的时间: " + now);
		LocalTime nowTime = LocalTime.parse("15:02");
		System.out.println("时间是: " + nowTime);
		LocalTime nowTime1 = LocalTime.of(15, 02);
		System.out.println("时间是: " + nowTime1);
		LocalTime nextHour = LocalTime.parse("15:02").plus(1, ChronoUnit.HOURS);
		System.out.println("下一个小时: " + nextHour);
		int hour = LocalTime.parse("15:02").getHour();
		System.out.println("小时: " + hour);
		int minute = LocalTime.parse("15:02").getMinute();
		System.out.println("分钟: " + minute);
		boolean isBefore = LocalTime.parse("15:02").isBefore(LocalTime.parse("16:02"));
		boolean isAfter1 = LocalTime.parse("15:02").isAfter(LocalTime.parse("16:02"));
		System.out.println("isBefore: " + isBefore);
		System.out.println("isAfter: " + isAfter1);
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);
		LocalDateTime now1 = LocalDateTime.now();
		System.out.println("现在: " + now1);
		LocalDateTime.of(2017, Month.JULY, 20, 15, 18);
		LocalDateTime.parse("2017-07-20T15:18:00");
		LocalDateTime tomorrow1 = now1.plusDays(1);
		System.out.println("明天的这个时间: " + tomorrow1);
		LocalDateTime minusTowHour = now1.minusHours(2);
		System.out.println("两小时前: " + minusTowHour);
		Month month = now1.getMonth();
		System.out.println("当前月份: " + month);
		LocalDateTime now11 = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("默认格式化: " + now11);
		System.out.println("自定义格式化: " + now11.format(dateTimeFormatter));
		LocalDateTime localDateTime = LocalDateTime.parse("2017-07-20 15:27:44", dateTimeFormatter);
		System.out.println("字符串转LocalDateTime: " + localDateTime);
		DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = dateTimeFormatter1.format(LocalDate.now());
		System.out.println("日期转字符串: " + dateString);
		LocalDate initialDate = LocalDate.parse("2017-07-20");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		System.out.println("初始化日期: " + initialDate);
		System.out.println("加日期之后: " + finalDate);
		long between = ChronoUnit.DAYS.between(initialDate, finalDate);
		System.out.println("差距天数: " + between);
		Date date1 = Date.from(Instant.now());
		Instant instant = date1.toInstant();
		System.out.println(instant);
//		LocalDateTime localDateTime1 = LocalDateTime.from((TemporalAccessor) new Date());
//		System.out.println(localDateTime1);
//		Date date11 = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
//		System.out.println(date11);
//		Date date111 = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//		System.out.println(date111);
	}
}
