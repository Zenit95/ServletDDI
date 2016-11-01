package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;

import es.salesianos.model.User;

public class UserAssembler {

	public static User assembleUserFrom(HttpServletRequest req) {
		User user = new User();
		String nombre = req.getParameter("name");
		String course = req.getParameter("course");
		String dateOfBirth = req.getParameter("dob");
		if (!StringUtils.isNullOrEmpty(nombre))
			user.setName(nombre);
		if (!StringUtils.isNullOrEmpty(course))
			user.setCourse(course);
		if (!StringUtils.isNullOrEmpty(dateOfBirth))
			user.setDateOfBirth(dateOfBirth);
		return user;
	}
}