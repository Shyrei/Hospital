package by.pvt.shyrei.hospital.command.user;

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
import by.pvt.shyrei.hospital.dao.DepartmentDAO;
import by.pvt.shyrei.hospital.entity.Department;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;
import by.pvt.shyrei.hospital.resources.MessageManager;

public class ShowOneDepartmentCommand implements ActionCommand {
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
	private final String DEPID = "depID";

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		ArrayList<Department> oneDepartmentList;
		try {
			int dep = Integer.parseInt(request.getParameter(DEPID));
			oneDepartmentList= DepartmentDAO.getInstance().showOneDepartment(dep);
			HttpSession session = request.getSession(true);
			session.setAttribute("oneDepartmentList", oneDepartmentList);
			page = ConfigurationManager.getProperty("path.page.showonedepartments");

		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't show list of departments : " + e.toString());	
			request.setAttribute("errorDBMessage", MessageManager.getProperty("message.DBerror"));
			request.getRequestDispatcher(page).forward(request, response);
			return null;
		}
		return page;
	}
}
