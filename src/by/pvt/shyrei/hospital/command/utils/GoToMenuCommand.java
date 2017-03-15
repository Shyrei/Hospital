package by.pvt.shyrei.hospital.command.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.ClientType;
import by.pvt.shyrei.hospital.connectpool.ConnectionPool;
import by.pvt.shyrei.hospital.resources.ConfigurationManager;

/**
 * @author Shyrei Uladzimir
 * This class return menu page for different users
 */
public class GoToMenuCommand implements ActionCommand {
	
	private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

	/* (non-Javadoc)
	 * @see by.pvt.shyrei.hospital.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {
		ClientType userType = (ClientType) request.getSession().getAttribute("userType");
		String page = null;
		try {
			if (userType == ClientType.ADMINISTRATOR) {
				page = ConfigurationManager.getProperty("path.page.main");
			}
			if (userType == ClientType.USER) {
				page = ConfigurationManager.getProperty("path.page.user");
			}
		} catch (Exception e) {
			logger.log(Level.FATAL, "Exception - can't run GoToMenu Command : " + e.toString());
					}
		return page;
	}

}
