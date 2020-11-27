package insurance;

import java.util.Random;

import policy.InsuredValue;

public class Health extends Insurance {
	
	private int fixedFee;
	
	public Health() {
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
		if(riskFactor > 50 && ranking < 3) {
			policyCharge = 1000000000;
		}
		else {
			policyCharge = (fixedFee * (riskFactor * riskFactor * riskFactor)) / 208;
		}
		return policyCharge;
	}
}
