package by.pvt.shyrei.hospital.command;

import javax.servlet.http.HttpServletRequest;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir
 *
 */
public class EmptyCommand implements ActionCommand {

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	public String execute(HttpServletRequest request) {

		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}
}
