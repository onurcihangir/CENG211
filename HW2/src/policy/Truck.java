package policy;

public class Truck extends Vehicle {

	private String bedType;

	public Truck() {
		super();
		bedType = "No bed type";
	}
	
	public Truck(String insuranceNumber, int insuranceYear, String city, double engineVolume, int productionYear,
			String gearType, int fuelVolume, String bedType) {
		super(insuranceNumber, insuranceYear, city, engineVolume, productionYear, gearType, fuelVolume);
		this.setBedType(bedType);
	}
	
	public Truck(Truck originalObject) {
		super(originalObject);
		bedType = originalObject.bedType;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	
	/**
	 * Returns risk factor of bed type.
	 * @return Risk factor of bed type.
	 */
	private double getRiskFactorOfBedType() {
		double factor = 0;
		if(getBedType().contentEquals("trailer")) {
			factor = 0.87;
		}
		else if(getBedType().contentEquals("tanker")) {
			factor = 0.84;
		}
		else if(getBedType().contentEquals("regular")) {
			factor = 0.15;
		}
		return factor;
	}
	
	/**
	 * Calculates risk factor of truck and returns it.
	 */
	public double calculateRiskFactor() {
		int age = 2020 - getProductionYear();
		int ageCube = age*age*age;
		double riskFactor = ((ageCube / (0.008 * getFuelVolume())) * getEngineVolume() * (getRiskFactorOfPlateCity()
				* 0.03)) / (getRiskFactorOfBedType() * getRiskFactorOfBedType());
		return riskFactor;
	}
	
	public Truck clone() {
		return new Truck(this);
	}
	
	public String toString() {
		return ("Insured Value: Truck Insurance Number: " + getInsuranceNumber()
		+ " Year of Insurance: " + getInsuranceYear());
	}
}
