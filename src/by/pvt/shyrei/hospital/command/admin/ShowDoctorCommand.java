package by.pvt.shyrei.hospital.command.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.dao.DoctorDAO;
import by.pvt.shyrei.hospital.entity.Doctor;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;
import by.pvt.shyrei.hospital.resources.MessageManager;

/**
 * @author Shyrei Uladzimir Show doctor command
 */
public class ShowDoctorCommand implements ActionCommand {

	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = ConfigurationManager.getProperty("path.page.showdoctor");
		ArrayList<Doctor> doctorsList;
		try {
			doctorsList = DoctorDAO.getInstance().showDoctors();
			HttpSession session = request.getSession(true);
			session.setAttribute("doctorsList", doctorsList);
			return page;
		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't show list of doctors : " + e.toString());
			request.setAttribute("errorDBMessage", MessageManager.getProperty("message.DBerror"));
			request.getRequestDispatcher(page).forward(request, response);
			return null;
		}
	}
}
