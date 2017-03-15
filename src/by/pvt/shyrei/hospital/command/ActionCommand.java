package by.pvt.shyrei.hospital.command;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Shyrei Uladzimir
 * ActionCommand Interface
 */
public interface ActionCommand {
	/**
	 * Return target page
	 * @param request
	 * Request
	 * @return
	 * Request 
	 */
	String execute(HttpServletRequest request);
}
