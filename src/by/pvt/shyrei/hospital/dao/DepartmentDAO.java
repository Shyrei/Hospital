package by.pvt.shyrei.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import by.pvt.shyrei.hospital.entity.Department;
import by.pvt.shyrei.hospital.resources.SqlManager;


/**
 * @author Shyrei Uladzimir
 * Department DAO class
 */
public class DepartmentDAO extends DAO {

	private static DepartmentDAO instance;
	private final String COLUMN_NAME_NAME = "name";
	private final String COLUMN_NAME_ID = "id";
	private final String COLUMN_NAME_NOC = "numberOfChambers";

	private DepartmentDAO() {
		super();
	}

	public static DepartmentDAO getInstance() {
		if (instance == null) {
			instance = new DepartmentDAO();
		}
		return instance;
	}

	/**
	 * This method return list of department of hospital
	 * @return list of departments
	 * @throws SQLException SQLException
	 */
	public ArrayList<Department> showDepartment() throws SQLException {
		Connection connection = poolInstance.getConnection();
		PreparedStatement ps = null;
		ArrayList<Department> list = new ArrayList<Department>();
		String query = SqlManager.getProperty("sql.show.departments");
		ps = connection.prepareStatement(query);
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			Department department = new Department();
			department.setNumberOfChambers(Integer.parseInt(result.getString(COLUMN_NAME_NOC)));
			department.setName(result.getString(COLUMN_NAME_NAME));
			department.setDepId(Integer.parseInt(result.getString(COLUMN_NAME_ID)));
			list.add(department);
		}
		poolInstance.freeConnection(connection);
		return list;
	}	
	
	public ArrayList<Department> showOneDepartment(int depId) throws SQLException {
		Connection connection = poolInstance.getConnection();
		PreparedStatement ps = null;
		ArrayList<Department> list = new ArrayList<Department>();
		String query = SqlManager.getProperty("sql.show.one.departments");
		ps = poolInstance.getConnection().prepareStatement(query);
		ps = connection.prepareStatement(query);
		ps.setInt(1, depId);
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			Department department = new Department();
			department.setNumberOfChambers(Integer.parseInt(result.getString(COLUMN_NAME_NOC)));
			department.setName(result.getString(COLUMN_NAME_NAME));
			System.out.println(department);
			list.add(department);
		}
		poolInstance.freeConnection(connection);
		return list;
	}	
	
	/**
	 * This method add department in to hospital DB
	 * @param department department of hospital
	 * @throws SQLException SQLException
	 */
	public void addDepartment(Department department) throws SQLException {
		Connection connection = poolInstance.getConnection();
		String query = "INSERT INTO hosp.department (name, numberOfChambers) VALUES (?,?);";
		PreparedStatement ps = null;
		ps = connection.prepareStatement(query);
		ps.setString(1, department.getName());
		ps.setInt(2, department.getNumberOfChambers());
		ps.executeUpdate();
		poolInstance.freeConnection(connection);
	}
}
