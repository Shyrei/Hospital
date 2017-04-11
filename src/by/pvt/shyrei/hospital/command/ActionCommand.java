package by.pvt.shyrei.hospital.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	String execute(HttpServletRequest request,
            HttpServletResponse response);
}
