package app;

import java.util.ArrayList;
import java.util.Scanner;

import insurance.Health;
import insurance.Household;
import insurance.Insurance;
import insurance.Traffic;
import policy.InsuredValue;
import policy.PolicyRecord;

public class Simulation {
	private PolicyRecord policy;

	/**
	 * Does the operations of the application.
	 */
	public void run() {
		policy = new PolicyRecord();
		System.out.println("1 All insured values, 2 Workplaces, 3 Housings, 4 Persons, 5 Automobiles, 6 Truck.");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your choice: ");
		int choice = keyboard.nextInt();
		keyboard.close();
		if(choice == 1) {
			printAllValues();
		}
		else if(choice == 2) {
			printWorkplaceValues();
		}
		else if(choice == 3) {
			printHousingValues();
		}
		else if(choice == 4) {
			printPersonValues();
		}
		else if(choice == 5) {
			printAutomobileValues();
		}
		else if(choice == 6) {
			printTruckValues();
		}
		else {
			System.out.println("Please enter a valid number.");
		}
	}
	
	/**
	 * Prints all insured values and their policy charges.
	 */
	private void printAllValues() {
		ArrayList<InsuredValue> values = policy.getInsuredValueList();
		for(InsuredValue value : values) {
			if(value.getInsuranceNumber().substring(0,1).contentEquals("W") || value.getInsuranceNumber().substring(0,1).contentEquals("H")) {
				Insurance insurance = new Household();
				double policyCharge = insurance.calculatePolicyCharge(value);
				System.out.println(value.toString());
				System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
			}
			else if(value.getInsuranceNumber().substring(0,1).contentEquals("A") || value.getInsuranceNumber().substring(0,1).contentEquals("T")) {
				Insurance insurance = new Traffic();
				double policyCharge = insurance.calculatePolicyCharge(value);
				System.out.println(value.toString());
				System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
			}
			else if(value.getInsuranceNumber().substring(0,1).contentEquals("P")) {
				Insurance insurance = new Health();
				double policyCharge = insurance.calculatePolicyCharge(value);
				System.out.println(value.toString());
				System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
			}
		}
	}
	
	/**
	 * Prints all workplaces and their policy charges.
	 */
	private void printWorkplaceValues() {
		ArrayList<InsuredValue> values = policy.getWorkplaceList();
		for(InsuredValue value: values) {
			Insurance insurance = new Household();
			double policyCharge = insurance.calculatePolicyCharge(value);
			System.out.println(value.toString());
			System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
		}
	}
	
	/**
	 * Prints all housings and their policy charges.
	 */
	private void printHousingValues() {
		ArrayList<InsuredValue> values = policy.getHousingList();
		for(InsuredValue value: values) {
			Insurance insurance = new Household();
			double policyCharge = insurance.calculatePolicyCharge(value);
			System.out.println(value.toString());
			System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
		}
	}
	
	/**
	 * Prints all people and their policy charges.
	 */
	private void printPersonValues() {
		ArrayList<InsuredValue> values = policy.getPersonList();
		for(InsuredValue value: values) {
			Insurance insurance = new Health();
			double policyCharge = insurance.calculatePolicyCharge(value);
			System.out.println(value.toString());
			System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
		}
	}
	
	/**
	 * Prints all automobiles and their policy charges.
	 */
	private void printAutomobileValues() {
		ArrayList<InsuredValue> values = policy.getAutomobileList();
		for(InsuredValue value: values) {
			Insurance insurance = new Traffic();
			double policyCharge = insurance.calculatePolicyCharge(value);
			System.out.println(value.toString());
			System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
		}
	}
	
	/**
	 * Prints all trucks and their policy charges.
	 */
	private void printTruckValues() {
		ArrayList<InsuredValue> values = policy.getTruckList();
		for(InsuredValue value: values) {
			Insurance insurance = new Traffic();
			double policyCharge = insurance.calculatePolicyCharge(value);
			System.out.println(value.toString());
			System.out.println("The policy charge of " + value.getInsuranceNumber() + ": " + policyCharge + " TL");
		}
	}
}
