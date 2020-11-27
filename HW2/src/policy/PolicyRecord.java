package policy;
import java.util.ArrayList;

import file.FileIO;

public class PolicyRecord {

	private ArrayList<InsuredValue> insuredValueList;
	private FileIO file;
	
	public PolicyRecord() {
		file = new  FileIO();
		initializeStringDataToObjectList();
	}
	
	/**
	 * Converts String data array to InsuredValue ArrayList.
	 */
	public void initializeStringDataToObjectList() {
		String[][] fValues = file.readFile();
		insuredValueList = new ArrayList<InsuredValue>();
		
		for(int i = 0; i < fValues.length; i++) {
			if(fValues[i][0].substring(0, 1).contentEquals("W")) {
				InsuredValue value = new Workplace(fValues[i][0], Integer.parseInt(fValues[i][1]), fValues[i][2],
						Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]), fValues[i][5], 
						Integer.parseInt(fValues[i][6]), Integer.parseInt(fValues[i][7]));
				insuredValueList.add(value);
			}
			else if(fValues[i][0].substring(0, 1).contentEquals("H")) {
				InsuredValue value = new Housing(fValues[i][0], Integer.parseInt(fValues[i][1]), fValues[i][2],
						Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]), fValues[i][5], 
						Integer.parseInt(fValues[i][6]), fValues[i][7]);
				insuredValueList.add(value);
			}
			else if(fValues[i][0].substring(0, 1).contentEquals("T")) {
				InsuredValue value = new Truck(fValues[i][0], Integer.parseInt(fValues[i][1]), fValues[i][2],
						Double.parseDouble(fValues[i][3]), Integer.parseInt(fValues[i][4]), fValues[i][5], 
						Integer.parseInt(fValues[i][6]), fValues[i][7]);
				insuredValueList.add(value);
			}
			else if(fValues[i][0].substring(0, 1).contentEquals("A")) {
				InsuredValue value = new Automobile(fValues[i][0], Integer.parseInt(fValues[i][1]), fValues[i][2],
						Double.parseDouble(fValues[i][3]), Integer.parseInt(fValues[i][4]), fValues[i][5], 
						Integer.parseInt(fValues[i][6]), fValues[i][7]);
				insuredValueList.add(value);
			}
			else if(fValues[i][0].substring(0, 1).contentEquals("P")) {
				InsuredValue value = new Person(fValues[i][0], Integer.parseInt(fValues[i][1]), fValues[i][2],
						fValues[i][3], fValues[i][4], fValues[i][5], Integer.parseInt(fValues[i][6]), fValues[i][7]);
				insuredValueList.add(value);
			}
		}
		insuredValueList.trimToSize();
	}
	
	/**
	 * Finds all Workplace insured values among all insured values.
	 * @return ArrayList<InsuredValue> All Workplace insured values.
	 */
	public ArrayList<InsuredValue> getWorkplaceList() {
		ArrayList<InsuredValue> workplaceList = new ArrayList<InsuredValue>();
		for(InsuredValue value : insuredValueList) {
			InsuredValue aWorkplace = new Workplace();
			if(value.getClass() == aWorkplace.getClass()) {
				aWorkplace = value.clone();
				workplaceList.add(aWorkplace);
			}
		}
		workplaceList.trimToSize();
		return workplaceList;
	}
	
	/**
	 * Finds all Housing insured values among all insured values.
	 * @return ArrayList<InsuredValue> All Housing insured values.
	 */
	public ArrayList<InsuredValue> getHousingList() {
		ArrayList<InsuredValue> housingList = new ArrayList<InsuredValue>();
		for(InsuredValue value : insuredValueList) {
			InsuredValue aHousing = new Housing();
			if(value.getClass() == aHousing.getClass()) {
				aHousing = value.clone();
				housingList.add(aHousing);
			}
		}
		housingList.trimToSize();
		return housingList;
	}
	
	/**
	 * Finds all Person insured values among all insured values.
	 * @return ArrayList<InsuredValue> All Person insured values.
	 */
	public ArrayList<InsuredValue> getPersonList() {
		ArrayList<InsuredValue> personList = new ArrayList<InsuredValue>();
		for(InsuredValue value : insuredValueList) {
			InsuredValue aPerson = new Person();
			if(value.getClass() == aPerson.getClass()) {
				aPerson = value.clone();
				personList.add(aPerson);
			}
		}
		personList.trimToSize();
		return personList;
	}
	
	/**
	 * Finds all Automobile insured values among all insured values.
	 * @return ArrayList<InsuredValue> All Automobile insured values.
	 */
	public ArrayList<InsuredValue> getAutomobileList() {
		ArrayList<InsuredValue> automobileList = new ArrayList<InsuredValue>();
		for(InsuredValue value : insuredValueList) {
			InsuredValue aAutomobile = new Automobile();
			if(value.getClass() == aAutomobile.getClass()) {
				aAutomobile = value.clone();
				automobileList.add(aAutomobile);
			}
		}
		automobileList.trimToSize();
		return automobileList;
	}
	
	/**
	 * Finds all Truck insured values among all insured values.
	 * @return ArrayList<InsuredValue> All Truck insured values.
	 */
	public ArrayList<InsuredValue> getTruckList() {
		ArrayList<InsuredValue> TruckList = new ArrayList<InsuredValue>();
		for(InsuredValue value : insuredValueList) {
			InsuredValue aTruck = new Truck();
			if(value.getClass() == aTruck.getClass()) {
				aTruck = value.clone();
				TruckList.add(aTruck);
			}
		}
		TruckList.trimToSize();
		return TruckList;
	}

	/**
	 * Returns all insured values.
	 * @return ArrayList<InsuredValue> All insured values.
	 */
	public ArrayList<InsuredValue> getInsuredValueList() {
		return insuredValueList;
	}

}
