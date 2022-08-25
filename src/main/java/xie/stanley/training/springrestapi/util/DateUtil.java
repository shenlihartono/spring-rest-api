package xie.stanley.training.springrestapi.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public LocalDate parseDate(String date) {
		return LocalDate.parse(date, DATE_FORMATTER);
	}
}
