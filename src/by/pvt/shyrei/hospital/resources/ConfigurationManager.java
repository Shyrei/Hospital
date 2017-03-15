package by.pvt.shyrei.hospital.resources;

import java.util.ResourceBundle;

/**
 * @author Shyrei Uladzimir
 * This class give data in file config.properties
 */
public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

	private ConfigurationManager() {
	}

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}