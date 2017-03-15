package by.pvt.shyrei.hospital.command.utils;

import javax.servlet.http.HttpServletRequest;
import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir
 * This class return add doctor page
 */
public class GoToAddDoctorCommand implements ActionCommand {

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	public String execute(HttpServletRequest request) {
		String page;
		page = ConfigurationManager.getProperty("path.page.adddoctor");
		return page;
	}

}
