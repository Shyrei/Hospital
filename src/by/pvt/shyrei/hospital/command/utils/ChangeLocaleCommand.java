package by.pvt.shyrei.hospital.command.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String execute(HttpServletRequest request, HttpServletResponse responce) {
		String page = request.getHeader("referer");
		System.out.println(page);
		return page;
	}

}
