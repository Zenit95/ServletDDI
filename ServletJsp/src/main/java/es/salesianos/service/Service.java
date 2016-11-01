package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;

import es.salesianos.model.User;
import es.salesianos.model.assembler.UserAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.ConvertDate;
import es.salesianos.utils.DateConverter;

public class Service {
	
	
	private ConvertDate converter = new ConvertDate();
	private Repository repository = new Repository();
	
	
	public User assembleUserFromRequest(HttpServletRequest req) {
		return UserAssembler.assembleUserFrom(req);
	}
	
	public User SearchUser(User user) {
		return repository.search(user);
	}

	public void insertOrUpdate(User userFormulario) {
		
		Repository repository = new Repository();
		User userInDatabase = repository.search(userFormulario);
		
		if(null == userInDatabase){
			repository.insert(userFormulario);
		}else{
			repository.update(userFormulario);
		}
		
	}
	
	public void delete(User userFormulario) {
		User userInDatabase = repository.search(userFormulario);
		if(null == userInDatabase){
			insertOrUpdate(userFormulario);
		}else{
			repository.delete(userFormulario.getName());
		}
	}

	public void calculateAgeAndAddIntoRequest(HttpServletRequest req, Date date) {
		Integer yearNac = converter.getAge(date);
		req.setAttribute("age", yearNac.toString());
	}
	
	
	public ConvertDate getConverter() {
		return converter;
	}
	public void setConverter(ConvertDate converter) {
		this.converter = converter;
	}
	
	
	

}
