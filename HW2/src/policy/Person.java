package policy;

public class Person extends InsuredValue {

	private String name;
	private String id;
	private String gender;
	private int birthYear;
	private String illness;
	
	public Person() {
		super();
		name = "No Name";
		id = "No id";
		gender = "No gender";
		birthYear = 0;
		illness = "No illness";
	}
	
	public Person(String insuranceNumber, int insuranceYear, String city, String name, String id, String gender,
			int birthYear, String illness) {
		super(insuranceNumber, insuranceYear, city);
		this.setName(name);
		this.setId(id);
		this.setGender(gender);
		this.setBirthYear(birthYear);
		this.setIllness(illness);
	}
	
	public Person(Person originalObject) {
		super(originalObject);
		name = originalObject.name;
		id = originalObject.id;
		gender = originalObject.gender;
		birthYear = originalObject.birthYear;
		illness = originalObject.illness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	
	/**
	 * Returns risk factor of illness.
	 * @return Risk factor of illness.
	 */
	private double getRiskFactorOfIllness() {
		double factor = 0;
		if(getIllness().contentEquals("cardiovascular")) {
			factor = 1.85;
		}
		else if(getIllness().contentEquals("diabetes")) {
			factor = 1.84;
		}
		else if(getIllness().contentEquals("respiratory")) {
			factor = 1.86;
		}
		else if(getIllness().contentEquals("none")) {
			factor = 0.1;
		}
		else {
			factor = 1.8;
		}
		return factor;
	}
	
	/**
	 * Calculates risk factor of person and returns it.
	 */
	public double calculateRiskFactor() {
		int age = 2020 - getBirthYear();
		double riskFactor = (age*age) / (getRiskFactorOfIllness() * 18);
		return riskFactor;
	}
	
	public Person clone() {
		return new Person(this);
	}
	
	public String toString() {
		return ("Insured Value: Person Insurance Number: " + getInsuranceNumber()
		+ " Year of Insurance: " + getInsuranceYear());
	}
	
}
