package by.pvt.shyrei.hospital.command.admin;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.dao.DoctorDAO;
import by.pvt.shyrei.hospital.entity.Doctor;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir
 * Show doctor command
 */
public class ShowDoctorCommand implements ActionCommand {
	
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	public String execute(HttpServletRequest request) {
		String page = null;
		ArrayList<Doctor> list;
		try {
			list = DoctorDAO.getInstance().showDoctors();
			int listSize = list.size();
			request.setAttribute("list", list);
			request.setAttribute("listSize", listSize);
			page = ConfigurationManager.getProperty("path.page.showdoctor");

		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't show list of doctors : " + e.toString());	
		}
		return page;
	}

}
