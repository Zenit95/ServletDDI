package es.salesianos.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConvertDate {

	public Integer getAge(Date date) {
		Integer age = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		Calendar ActualCalendar = new GregorianCalendar();
		age = ActualCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		if (ActualCalendar.get(Calendar.MONTH) < calendar.get(Calendar.MONTH)) {
			return age - 1;
		}
		if (ActualCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && ActualCalendar.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH)) {
			return age - 1;
		}
		return age;
	}
}
