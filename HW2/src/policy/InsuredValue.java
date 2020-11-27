package policy;

public class InsuredValue {

	private String insuranceNumber;
	private int insuranceYear;
	private String city;
	
	public InsuredValue() {
		insuranceNumber = "No Number";
		insuranceYear = 0;
		city = "No City";
	}
	
	public InsuredValue(String insuranceNumber, int insuranceYear, String city) {
		this.setInsuranceNumber(insuranceNumber);
		this.setInsuranceYear(insuranceYear);
		this.setCity(city);
	}
	
	public InsuredValue(InsuredValue originalObject) {
		if (originalObject == null)
        {
            System.out.println("Error: null InsuredValue object.");
            System.exit(0);
        }
		insuranceNumber = originalObject.insuranceNumber;
		insuranceYear = originalObject.insuranceYear;
		city = originalObject.city;	
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public int getInsuranceYear() {
		return insuranceYear;
	}

	public void setInsuranceYear(int insuranceYear) {
		this.insuranceYear = insuranceYear;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * This method returns risk factor for subclasses and this method will be overridden.
	 * @return Risk factor of insured value.
	 */
	public double calculateRiskFactor() {
		double riskFactor = 0;
		return riskFactor;
	}
	
	public InsuredValue clone() {
		return new InsuredValue(this);
	}
}
