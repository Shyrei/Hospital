package by.pvt.shyrei.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import by.pvt.shyrei.hospital.entity.Doctor;
import by.pvt.shyrei.hospital.resources.SqlManager;


/**
 * @author Shyrei Uladzimir
 * Doctor DAO class
 */
public class DoctorDAO extends DAO {

	private static DoctorDAO instance;

	private final String COLUMN_NAME_DEPID = "Departments_id";
	private final String COLUMN_NAME_NAME = "name";
	private final String COLUMN_NAME_SPECIALIZATION = "specialization";

	private DoctorDAO() {
		super();
	}

	public static DoctorDAO getInstance() {
		if (instance == null) {
			instance = new DoctorDAO();
		}
		return instance;
	}

	/**
	 * This method added doctor to DB of hospital
	 * @param doctor doctor of hospital
	 * @throws SQLException SQLException
	 */
	public void addDoctor(Doctor doctor) throws SQLException {
		Connection connection = poolInstance.getConnection();
		String query = SqlManager.getProperty("sql.add.doctor");
		PreparedStatement ps = null;
		ps = connection.prepareStatement(query);
		ps.setString(1, doctor.getName());
		ps.setString(2, doctor.getSpecialization());
		ps.setString(3, doctor.getDepId());
		ps.executeUpdate();
		poolInstance.freeConnection(connection);
	}

	/**
	 * This method show all doctors in hospital DB
	 * @return list of doctors
	 * @throws SQLException SQLException
	 */
	public ArrayList<Doctor> showDoctors() throws SQLException {
		Connection connection = poolInstance.getConnection();
		PreparedStatement ps = null;
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		String query = SqlManager.getProperty("sql.show.doctors");
		ps = connection.prepareStatement(query);
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			Doctor doctor = new Doctor();
			doctor.setDepId(result.getString(COLUMN_NAME_DEPID));
			doctor.setSpecialization(result.getString(COLUMN_NAME_SPECIALIZATION));
			doctor.setName(result.getString(COLUMN_NAME_NAME));
			list.add(doctor);
		}
		poolInstance.freeConnection(connection);
		return list;
	}

}
