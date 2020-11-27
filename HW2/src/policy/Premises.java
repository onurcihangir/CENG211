package policy;

public class Premises extends InsuredValue {
	
	private int floorNumber;
	private int constructionYear;
	private String constructionType;
	private int surfaceArea;
	
	public Premises() {
		super();
		floorNumber = 0;
		constructionYear = 0;
		constructionType = "No construction type";
		surfaceArea = 0;
	}
	
	public Premises(String insuranceNumber, int insuranceYear, String city, int floorNumber, int constructionYear,
			String constructionType, int surfaceArea) {
		super(insuranceNumber, insuranceYear, city);
		this.setFloorNumber(floorNumber);
		this.setConstructionYear(constructionYear);
		this.setConstructionType(constructionType);
		this.setSurfaceArea(surfaceArea);
	}

	public Premises(Premises originalObject) {
		super(originalObject);
		floorNumber = originalObject.floorNumber;
		constructionYear = originalObject.constructionYear;
		constructionType = originalObject.constructionType;
		surfaceArea = originalObject.surfaceArea;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(String constructionType) {
		this.constructionType = constructionType;
	}

	public int getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(int surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	
	/**
	 * Returns risk factor of premises city.
	 * @return Risk factor of premises city.
	 */
	protected double getRiskFactorOfPremisesCity() {
		double factor = 0;
		if(getCity().contentEquals("Izmir")) {
			factor = 0.4;
		}
		else if(getCity().contentEquals("Istanbul")) {
			factor = 0.6;
		}
		else if(getCity().contentEquals("Ankara")) {
			factor = 0.15;
		}
		else {
			factor = 0.25;
		}
		return factor;
	}
	
	/**
	 * Returns risk factor of floor number.
	 * @return Risk factor of floor number.
	 */
	protected double getRiskFactorOfFloor() {
		double factor = 0;
		int floor = getFloorNumber();
		if(floor < 4) {
			factor = 0.1;
		}
		else if(floor >= 4 && floor < 8) {
			factor = 0.25;
		}
		else if(floor >= 8 && floor < 19) {
			factor = 0.5;
		}
		else {
			factor = 0.85;
		}
		return factor;
	}
	
	/**
	 * Returns risk factor of construction year.
	 * @return Risk factor of construction year.
	 */
	protected double getRiskFactorOfConstructionYear() {
		double factor = 0;
		int year = getConstructionYear();
		if(year < 1975) {
			factor = 0.58;
		}
		else if(year >= 1975 && year <= 1999) {
			factor = 0.32;
		}
		else {
			factor = 0.1;
		}
		return factor;
	}
	
	/**
	 * Returns risk factor of construction type.
	 * @return Risk factor of construction type.
	 */
	protected double getRiskFactorOfConstructionType() {
		double factor = 0;
		String type = getConstructionType();
		if(type.contentEquals("steel")) {
			factor = 0.1;
		}
		else if(type.contentEquals("concrete")) {
			factor = 0.37;
		}
		else if(type.contentEquals("wood")) {
			factor = 0.58;
		}
		else {
			factor = 0.92;
		}
		return factor;
	}
	
	public Premises clone() {
		return new Premises(this);
	}
}
