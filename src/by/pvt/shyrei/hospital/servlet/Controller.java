package by.pvt.shyrei.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.factory.ActionFactory;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir Controller
 */

@SuppressWarnings("serial")
@WebServlet("/controller")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = ConfigurationManager.getProperty("path.page.index");
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		page = command.execute(request, response);
		if (page != null) {
			response.sendRedirect(page);
		} 
		
		
//		if (page == null) {
//			page = ConfigurationManager.getProperty("path.page.index");
//			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
//			response.sendRedirect(request.getContextPath() + page);
//		} else {
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//			dispatcher.forward(request, response);
//		}
	}
}
