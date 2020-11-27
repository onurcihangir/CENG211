package policy;

public class Housing extends Premises {

	private String residentSituation;
	
	public Housing() {
		super();
		residentSituation = "No resident situation";
	}

	public Housing(String insuranceNumber, int insuranceYear, String city, int floorNumber, int constructionYear,
			String constructionType, int surfaceArea, String residentSituation) {
		super(insuranceNumber, insuranceYear, city, floorNumber, constructionYear, constructionType, surfaceArea);
		this.setResidentSituation(residentSituation);
	}
	
	public Housing(Housing originalObject) {
		super(originalObject);
		residentSituation = originalObject.residentSituation;
	}

	public String getResidentSituation() {
		return residentSituation;
	}

	public void setResidentSituation(String residentSituation) {
		this.residentSituation = residentSituation;
	}
	
	/**
	 * Returns risk factor of resident situation.
	 * @return Risk factor of resident situation.
	 */
	private double getRiskFactorOfResidentSituation() {
		double factor = 0;
		if(getResidentSituation().contentEquals("tenant")) {
			factor = 0.18;
		}
		else if(getResidentSituation().contentEquals("landlord")) {
			factor = 0.42;
		}
		return factor;
	}
	
	/**
	 * Calculates risk factor of housing and returns it
	 */
	public double calculateRiskFactor() {
		double riskFactor = (getRiskFactorOfPremisesCity() * getRiskFactorOfFloor() * getRiskFactorOfConstructionYear() * 
				getRiskFactorOfConstructionType() * getSurfaceArea()) / getRiskFactorOfResidentSituation() ;
		return riskFactor;
	}
	
	public Housing clone() {
		return new Housing(this);
	}
	
	public String toString() {
		return ("Insured Value: Housing Insurance Number: " + getInsuranceNumber()
		+ " Year of Insurance: " + getInsuranceYear());
	}
}
