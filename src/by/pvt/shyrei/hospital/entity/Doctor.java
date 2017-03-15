package by.pvt.shyrei.hospital.entity;

/**
 * @author Shyrei Uladzimir
 * Bin class of doctor of hospital only with getters and setters
 */
public class Doctor {

	private int docId;
	private String depId;
	private String name;
	private String specialization;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor docId = " + docId + ", depId = " + depId + ", name = " + name + ", specialization = "
				+ specialization;
	}

}
