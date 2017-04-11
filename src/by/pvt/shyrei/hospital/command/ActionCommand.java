package by.pvt.shyrei.hospital.command;

import java.io.IOException;

import javax.servlet.ServletException;
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
	 * @throws IOException 
	 * @throws ServletException 
	 */
	String execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException;
}
