package by.pvt.shyrei.hospital.resources;

import java.util.ResourceBundle;

/**
 * @author Shyrei Uladzimir
 * This class give data in file sql.properties
 */
public class SqlManager {

	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("sql");

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}

	private SqlManager() {
	}
}
