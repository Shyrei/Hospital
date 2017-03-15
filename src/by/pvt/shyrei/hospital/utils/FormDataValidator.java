package by.pvt.shyrei.hospital.utils;

import java.util.regex.Pattern;

/**
 * @author Shyrei Uladzimir
 * Validate of input data
 */
public class FormDataValidator {

	/**
	 * Only latin or only russian letters up to 15 symbols
	 */
	public static final Pattern namePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)");

	/**
	 * Latin letters or digits at least 3 symbols up to 15
	 */
	public static final Pattern loginPattern = Pattern.compile("\\A[a-zA-Z0-9]{3,15}\\z");

	/**
	 * Latin letters, digits, *, ! or ^ at least 6 symbols up to 15
	 */
	public static final Pattern passwordPattern = Pattern.compile("\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z");

	/**
	 * Examples: vasia.pupkin@gmail.com.
	 */
	public static final Pattern emailPattern = Pattern
			.compile("\\A[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}\\z");

}
