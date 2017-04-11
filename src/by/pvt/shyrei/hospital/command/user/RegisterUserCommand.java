package by.pvt.shyrei.hospital.command.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.ClientType;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.dao.UserDAO;
import by.pvt.shyrei.hospital.entity.User;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;
import by.pvt.shyrei.hospital.resources.MessageManager;
import static by.pvt.shyrei.hospital.utils.FormDataValidator.namePattern;
import static by.pvt.shyrei.hospital.utils.FormDataValidator.loginPattern;
import static by.pvt.shyrei.hospital.utils.FormDataValidator.passwordPattern;
import static by.pvt.shyrei.hospital.utils.FormDataValidator.emailPattern;

/**
 * @author Shyrei Uladzimir
 * Register new user and check if this user in base
 */
public class RegisterUserCommand implements ActionCommand {

	private final String NAME = "name";
	private final String LOGIN = "login";
	private final String PASSWORD = "password";
	private final String EMAIL = "email";
	String errMessage = null;
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = ConfigurationManager.getProperty("path.page.login");
		User user = new User();
		String login = request.getParameter(LOGIN);

		user.setName(request.getParameter(NAME).trim());
		user.setLogin(request.getParameter(LOGIN).trim());
		user.setPassword(request.getParameter(PASSWORD).trim());
		user.setEmail(request.getParameter(EMAIL).trim());

		if ((errMessage = validate(user)) != null) {
			request.setAttribute("errorFormDataMessage", validate(user));
			request.getRequestDispatcher(page).forward(request, response);
			return null;
		}
		UserDAO userDAO = UserDAO.getInstance();
		try {
			if (!userDAO.checkLogin(user.getLogin())) {
				request.setAttribute("errorLoginMessage", MessageManager.getProperty("message.loginerror"));
				request.getSession().setAttribute("userType", ClientType.GUEST);
				request.getRequestDispatcher(page).forward(request, response);
				return null;
			} else
				userDAO.register(user);
			HttpSession session = request.getSession(true);
			session.setAttribute("userType", ClientType.USER);
			session.setAttribute("user", login);
			page = ConfigurationManager.getProperty("path.page.user");
		} catch (SQLException e) {
			logger.log(Level.FATAL, "SQLException - can't login user : " + e.toString());
			request.setAttribute("errorDBMessage", MessageManager.getProperty("message.DBerror"));
			request.getRequestDispatcher(page).forward(request, response);
			return null;
		}
		
		return page;
	}

	/**
	 * @param user
	 * User
	 * @return
	 * User verification on the data entered 
	 */
	private String validate(User user) {

		if (!namePattern.matcher(user.getName()).matches()) {
			return MessageManager.getProperty("message.nameerror");
		}

		if (!loginPattern.matcher(user.getLogin()).matches()) {
			return MessageManager.getProperty("message.loginregerror");
		}

		if (!passwordPattern.matcher(user.getPassword()).matches()) {
			return MessageManager.getProperty("message.passworderror");
		}

		if (!emailPattern.matcher(user.getEmail()).matches()) {
			return MessageManager.getProperty("message.emailerror");
		}

		return null;
	}

}
