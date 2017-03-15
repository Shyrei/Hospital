package by.pvt.shyrei.hospital.resources;

import java.util.ResourceBundle;

/**
 * @author Shyrei Uladzimir
 * This class give data in file messages.properties
 */
public class MessageManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}