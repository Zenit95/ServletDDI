package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.User;

public class Repository {
	private static final String jdbcUrl = null;
	ConnectionH2 manager = new ConnectionH2();

	//manager.close(conn);

	public User search(User userFormulario) {
		User userInDataBase = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM USER WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				userInDataBase = new User();
				userInDataBase.setName(resultSet.getString(0));
				userInDataBase.setCourse(resultSet.getString(1));
				userInDataBase.setDateOfBirth(resultSet.getString(2));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
		return userInDataBase;
	}
	public void insert(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO USER (name, course, dateOfBirth) VALUES ('"+userFormulario.getName()+"', '"+userFormulario.getCourse()+"', '"+userFormulario.getDateOfBirthForDatabase()+"');");
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);

	}
	public void update(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		try {

			PreparedStatement prepareStatement = conn.prepareStatement("(UPDATE USER SET ('"+userFormulario.getCourse()+"', '"+userFormulario.getDateOfBirth()+"')) FROM USER WHERE name=?;");
			prepareStatement.setString(1, userFormulario.getName());
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
	}
}
