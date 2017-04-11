package by.pvt.shyrei.hospital.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.ClientType;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir
 * Logout command set user type to guest
 */
public class LogoutUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse responce) {
		HttpSession session = request.getSession();
		session.setAttribute("userType", ClientType.GUEST);
		return ConfigurationManager.getProperty("path.page.login");
	}

}
