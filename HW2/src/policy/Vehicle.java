package policy;

public class Vehicle extends InsuredValue {

	private double engineVolume;
	private int productionYear;
	private String gearType;
	private int fuelVolume;
	
	public Vehicle() {
		super();
		engineVolume = 0;
		productionYear = 0;
		gearType = "No gear Type";
		fuelVolume = 0;
	}
	
	public Vehicle(String insuranceNumber, int insuranceYear, String city, double engineVolume, int productionYear,
			String gearType, int fuelVolume) {
		super(insuranceNumber, insuranceYear, city);
		this.setEngineVolume(engineVolume);
		this.setProductionYear(productionYear);
		this.setGearType(gearType);
		this.setFuelVolume(fuelVolume);
	}
	
	public Vehicle(Vehicle originalObject) {
		super(originalObject);
		engineVolume = originalObject.engineVolume;
		productionYear = originalObject.productionYear;
		gearType = originalObject.gearType;
		fuelVolume = originalObject.fuelVolume;
	}

	public double getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(double engineVolume) {
		this.engineVolume = engineVolume;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public int getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(int fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	
	/**
	 * Returns risk factor of plate city.
	 * @return Risk factor of plate city.
	 */
	protected double getRiskFactorOfPlateCity() {
		double factor = 0;
		if(getCity().contentEquals("Izmir")) {
			factor = 0.78;
		}
		else if(getCity().contentEquals("Istanbul")) {
			factor = 0.97;
		}
		else if(getCity().contentEquals("Ankara")) {
			factor = 0.85;
		}
		else {
			factor = 0.65;
		}
		return factor;
	}
	
	/**
	 * Returns risk factor of gear type.
	 * @return Risk factor of gear type.
	 */
	protected double getRiskFactorOfGearType() {
		double factor = 0;
		if(getGearType().contentEquals("manual")) {
			factor = 0.47;
		}
		else if(getGearType().contentEquals("automatic")) {
			factor = 0.98;
		}
		return factor;
	}
	
	public Vehicle clone() {
		return new Vehicle(this);
	}
}
