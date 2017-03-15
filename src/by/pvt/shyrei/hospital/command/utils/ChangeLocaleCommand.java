package by.pvt.shyrei.hospital.command.utils;

import javax.servlet.http.HttpServletRequest;

import by.pvt.shyrei.hospital.command.ActionCommand;

/**
 * @author Shyrei Uladzimir
 * Change locale
 */
public class ChangeLocaleCommand implements ActionCommand{

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = request.getHeader("referer");
		return page;
	}

}
