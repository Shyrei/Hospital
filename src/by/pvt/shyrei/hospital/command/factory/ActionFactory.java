package by.pvt.shyrei.hospital.command.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.EmptyCommand;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.resources.MessageManager;

/**
 * @author Shyrei Uladzimir
 * Factory of action command
 */
public class ActionFactory {
	
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
	
	/**
	 * @param request
	 * request
	 * @return
	 * command
	 */
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
			logger.log(Level.FATAL, "Servlet exception - can't find ActionCommand : " + e.toString());	
		}
		return current;
	}
}
