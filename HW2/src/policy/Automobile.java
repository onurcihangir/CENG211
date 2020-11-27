package policy;

public class Automobile extends Vehicle {

	private String roofType;
	
	public Automobile() {
		super();
		roofType = "No roof type";
	}

	public Automobile(String insuranceNumber, int insuranceYear, String city, double engineVolume, int productionYear,
			String gearType, int fuelVolume, String roofType) {
		super(insuranceNumber, insuranceYear, city, engineVolume, productionYear, gearType, fuelVolume);
		this.setRoofType(roofType);
	}
	
	public Automobile(Automobile originalObject) {
		super(originalObject);
		roofType = originalObject.roofType;
	}

	public String getRoofType() {
		return roofType;
	}

	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	
	/**
	 * Return risk factor of roof type.
	 * @return Risk factor of roof type.
	 */
	private double getRiskFactorOfRoofType() {
		double factor = 0;
		if(getRoofType().contentEquals("regular")) {
			factor = 0.1;
		}
		else if(getRoofType().contentEquals("sunroof")) {
			factor = 0.64;
		}
		else if(getRoofType().contentEquals("moonroof")) {
			factor = 0.48;
		}
		return factor;
	}
	
	/**
	 * Calculates risk factor of automobile and returns it.
	 */
	public double calculateRiskFactor() {
		int age = 2020 - getProductionYear();
		double riskFactor = (getEngineVolume() * (0.004 * getFuelVolume()) * age * (getRiskFactorOfPlateCity() * 0.03)) /
				getRiskFactorOfRoofType();
		return riskFactor;
	}
	
	public Automobile clone() {
		return new Automobile(this);
	}
	
	public String toString() {
		return ("Insured Value: Automobile Insurance Number: " + getInsuranceNumber()
		+ " Year of Insurance: " + getInsuranceYear());
	}
}
