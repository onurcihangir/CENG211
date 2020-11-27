package policy;

public class Workplace extends Premises {

	private int revenue;
	
	public Workplace() {
		super();
		revenue = 0;
	}

	public Workplace(String insuranceNumber, int insuranceYear, String city, int floorNumber, int constructionYear,
			String constructionType, int surfaceArea, int revenue) {
		super(insuranceNumber, insuranceYear, city, floorNumber, constructionYear, constructionType, surfaceArea);
		this.setRevenue(revenue);
	}

	public Workplace(Workplace originalObject) {
		super(originalObject);
		revenue = originalObject.revenue;
	}
	
	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
	/**
	 * Calculates risk factor of workplace and returns it.
	 */
	public double calculateRiskFactor() {
		double riskFactor = (getRiskFactorOfPremisesCity() * getRiskFactorOfFloor() * getRiskFactorOfConstructionYear()
				* getRiskFactorOfConstructionType()) * (getSurfaceArea() * 0.2) * (getRevenue() * 0.003);
		return riskFactor;
	}
	
	public Workplace clone() {
		return new Workplace(this);
	}
	
	public String toString() {
		return ("Insured Value: Workplace Insurance Number: " + getInsuranceNumber()
		+ " Year of Insurance: " + getInsuranceYear());
	}
}
