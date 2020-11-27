package insurance;

import java.util.Random;

import policy.InsuredValue;

public class Traffic extends Insurance {

private int fixedFee;
	
	public Traffic() {
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
		double policyCharge = 0;
		double riskFactor = value.calculateRiskFactor();
		int ranking = 2020- value.getInsuranceYear();
		policyCharge = (fixedFee * 0.9) + (fixedFee * Math.sqrt(riskFactor));
		if(ranking > 1) {
			policyCharge *= 0.8;
		}
		return policyCharge;
	}
}
