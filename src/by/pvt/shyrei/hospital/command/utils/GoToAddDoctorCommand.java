package by.pvt.shyrei.hospital.command.utils;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.dao.DepartmentDAO;
import by.pvt.shyrei.hospital.entity.Department;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir This class return add doctor page
 */
public class GoToAddDoctorCommand implements ActionCommand {
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse responce) {
		String page;
		ArrayList<Department> departmentList;

		try {
			departmentList = DepartmentDAO.getInstance().showDepartment();
			HttpSession session = request.getSession(true);
			session.setAttribute("departmentList", departmentList);
		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't show list of departments : " + e.toString());
		}
		page = ConfigurationManager.getProperty("path.page.adddoctor");
		return page;
	}

}
