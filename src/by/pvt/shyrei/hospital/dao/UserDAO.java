package by.pvt.shyrei.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.pvt.shyrei.hospital.entity.User;
import by.pvt.shyrei.hospital.resources.SqlManager;

/**
 * @author Shyrei Uladzimir
 * User DAO class
 */
public class UserDAO extends DAO {

	private static UserDAO instance;

	private final String COLUMN_NAME_LOGIN = "login";
	private final String COLUMN_NAME_PASSWORD = "password";
	private final String COLUMN_NAME_ACCESS_LEVEL = "accessLevel";

	private UserDAO() {
		super();
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	/**
	 * 
	 * This method finds the user in the database with the correct username and password
	 * @param login login user
	 * @param password password user
	 * @return user
	 * @throws SQLException
	 * SQLException
	 */
	public User getUser(String login, String password) throws SQLException {
		User user = null;
		Connection connection = poolInstance.getConnection();
		PreparedStatement ps = null;
		String query = SqlManager.getProperty("sql.get.user");
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setString(1, login);
		ps.setString(2, password);
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			user = new User();
			user.setLogin(result.getString(COLUMN_NAME_LOGIN));
			user.setPassword(result.getString(COLUMN_NAME_PASSWORD));
			user.setAccessLevel(result.getInt(COLUMN_NAME_ACCESS_LEVEL));
		}
		poolInstance.freeConnection(connection);
		return user;
	}

	/**
	 * This method check user with login
	 * @param login login 
	 * @return true or false
	 * @throws SQLException
	 * SQLException
	 */
	public boolean checkLogin(String login) throws SQLException {
		Connection connection = poolInstance.getConnection();
		PreparedStatement ps = null;
		String query = SqlManager.getProperty("sql.check.login");
		ps = poolInstance.getConnection().prepareStatement(query);
		ps.setString(1, login);
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			poolInstance.freeConnection(connection);
			return false;
		} else
			poolInstance.freeConnection(connection);
		return true;
	}

	/**
	 * This method registered user into database
	 * @param user
	 * User
	 * @throws SQLException
	 * SQLException
	 */
	public void register(User user) throws SQLException {
		Connection connection = poolInstance.getConnection();
		String query = SqlManager.getProperty("sql.register.user");
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getLogin());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getEmail());
		ps.executeUpdate();
		poolInstance.freeConnection(connection);
	}
}
