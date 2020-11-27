package insurance;

import java.util.Random;

import policy.InsuredValue;

public class Household extends Insurance {
	
private int fixedFee;
	
	public Household() {
		super();
		setFixedFee();
	}

	/**
	 * Assigns random integer between 1000 and 3000 to fixed fee.
	 */
	public void setFixedFee() {
		Random rand = new Random();
		fixedFee = rand.nextInt((3000 - 1000)+1) + 1000;
	}

	public int getFixedFee() {
		return fixedFee;
	}
	
	/**
	 * Calculates and returns policy charge of insured value.
	 */
	public double calculatePolicyCharge(InsuredValue value) {
		int ranking = 2020 - value.getInsuranceYear();
		double policyCharge = 0;
		double riskFactor = value.calculateRiskFactor();
		if(ranking > 2) {
			double actual = fixedFee * (riskFactor * riskFactor);
			policyCharge = actual - (actual * 0.1);
		}
		else {
			policyCharge = fixedFee* (riskFactor * riskFactor);
		}
		return policyCharge;
	}
}
