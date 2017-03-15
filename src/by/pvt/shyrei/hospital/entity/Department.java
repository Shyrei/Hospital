package by.pvt.shyrei.hospital.entity;

/**
 * @author Shyrei Uladzimir
 * Bin class of department of hospital only with getters and setters
 */
public class Department {
	
	private String name;
	private int depId;
	private int numberOfChambers;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getNumberOfChambers() {
		return numberOfChambers;
	}
	public void setNumberOfChambers(int numberOfChambers) {
		this.numberOfChambers = numberOfChambers;
	}
	
		

}
