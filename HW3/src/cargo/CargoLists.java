package cargo;

import java.util.ArrayList;

import exceptions.CodeFormatIncorrectException;
import exceptions.IDNotCorrectException;
import file.Reader;

/**
 * CargoLists class keeps cargos in lists for each cargo type.
 */
public class CargoLists {
	private Reader reader;
	private ArrayList<NormalCargo> normalCargoList;
	private ArrayList<EcommerceCargo<?>> ecommerceCargoList;
	private int amazonAccepted = 0;
	private int amazonNotAccepted = 0;
	private int n11Accepted = 0;
	private int n11NotAccepted = 0;
	private int hepsiAccepted = 0;
	private int hepsiNotAccepted = 0;
	private int trendyolAccepted = 0;
	private int trendyolNotAccepted = 0;
	
	public CargoLists() {
		reader = new Reader();
		try {
			initializeCargoList();
		} catch (IDNotCorrectException e) {
			// TODO Auto-generated catch block
			String message = e.getMessage();
			System.out.println(message);
			System.exit(0);
		} catch (CodeFormatIncorrectException e) {
			// TODO Auto-generated catch block
			String message = e.getMessage();
			System.out.println(message);
			System.exit(0);
		}
	}
	
	/**
	 * Reads file and initializes array lists for each cargo type.
	 * @throws IDNotCorrectException
	 * @throws CodeFormatIncorrectException
	 */
	public void	initializeCargoList() throws IDNotCorrectException, CodeFormatIncorrectException {
		String[][] fValues = reader.readCsv();
		normalCargoList = new ArrayList<NormalCargo>();
		ecommerceCargoList = new ArrayList<EcommerceCargo<?>>();
		for(int i = 0; i < fValues.length; i++) {
			if(fValues[i][0].contentEquals("Normal")) {
				NormalCargo normal = new NormalCargo(fValues[i][0], fValues[i][1], fValues[i][2], fValues[i][3],
						fValues[i][4], Integer.parseInt(fValues[i][5]), Integer.parseInt(fValues[i][6]),
						Integer.parseInt(fValues[i][7]), Integer.parseInt(fValues[i][8]));
				normalCargoList.add(normal);
				if(normal.getSenderId().length() != 11) {
					throw new IDNotCorrectException();
				}
			}
			else if(fValues[i][0].contentEquals("Ecommerce")) {
				if(fValues[i][1].contentEquals("Trendyol")) {
					EcommerceCargo<Integer> ecommerce = new EcommerceCargo<Integer>(fValues[i][0], fValues[i][1], 
							Integer.parseInt(fValues[i][2]), Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]),
							Integer.parseInt(fValues[i][5]), Integer.parseInt(fValues[i][6]));
					ecommerceCargoList.add(ecommerce);
					// here checks code format if it is 7 digit integer.
					if(ecommerce.getCargoCode() > ecommerce.TRENDYOL_MAX_CODE || ecommerce.getCargoCode() < ecommerce.TRENDYOL_MIN_CODE) {
						throw new CodeFormatIncorrectException("Incorrect Trendyol cargo code!!!");
					}
					if(trendyolAccepted == ecommerce.TRENDYOL_DAILY_LIMIT) { // checks daily limit for Trendyol.
						trendyolNotAccepted = getTrendyolNotAccepted() + 1;
						ecommerce.setStatus("Not Accepted");
					}
					else if(trendyolAccepted < ecommerce.TRENDYOL_DAILY_LIMIT) {
						trendyolAccepted += 1;
						ecommerce.setStatus("Accepted");
					}
				}
				else if(fValues[i][1].contentEquals("Amazon")) {
					EcommerceCargo<Integer> ecommerce = new EcommerceCargo<Integer>(fValues[i][0], fValues[i][1], 
							Integer.parseInt(fValues[i][2]), Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]),
							Integer.parseInt(fValues[i][5]), Integer.parseInt(fValues[i][6]));
					ecommerceCargoList.add(ecommerce);
					// here checks code format if it is 8 digit integer.
					if(ecommerce.getCargoCode() > ecommerce.AMAZON_MAX_CODE || ecommerce.getCargoCode() < ecommerce.AMAZON_MIN_CODE) {
						throw new CodeFormatIncorrectException("Incorrect Amazon cargo code!!!");
					}
					if(amazonAccepted == ecommerce.AMAZON_DAILY_LIMIT) {
						amazonNotAccepted = getAmazonNotAccepted() + 1;
						ecommerce.setStatus("Not Accepted");
					}
					else if(amazonAccepted < ecommerce.AMAZON_DAILY_LIMIT) {
						amazonAccepted += 1;
						ecommerce.setStatus("Accepted");
					}
				}
				else if(fValues[i][1].contentEquals("Hepsiburada")) {
					EcommerceCargo<String> ecommerce = new EcommerceCargo<String>(fValues[i][0], fValues[i][1], 
							fValues[i][2], Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]),
							Integer.parseInt(fValues[i][5]), Integer.parseInt(fValues[i][6]));
					ecommerceCargoList.add(ecommerce);
					// here checks code format if it is string with 8 characters.
					if(ecommerce.getCargoCode().length() != ecommerce.HEPSIBURADA_CODE_LEN) {
						throw new CodeFormatIncorrectException("Incorrect Hepsiburada cargo code!!!");
					}
					if(hepsiAccepted == ecommerce.HEPSIBURADA_DAILY_LIMIT) {
						hepsiNotAccepted = getHepsiNotAccepted() + 1;
						ecommerce.setStatus("Not Accepted");
					}
					else if(hepsiAccepted < ecommerce.HEPSIBURADA_DAILY_LIMIT) {
						hepsiAccepted += 1;
						ecommerce.setStatus("Accepted");
					}
				}
				else if(fValues[i][1].contentEquals("N11")) {
					EcommerceCargo<String> ecommerce = new EcommerceCargo<String>(fValues[i][0], fValues[i][1], 
							fValues[i][2], Integer.parseInt(fValues[i][3]), Integer.parseInt(fValues[i][4]),
							Integer.parseInt(fValues[i][5]), Integer.parseInt(fValues[i][6]));
					ecommerceCargoList.add(ecommerce);
					// here checks code format if it is string with 7 characters.
					if(ecommerce.getCargoCode().length() != ecommerce.N11_CODE_LEN) {
						throw new CodeFormatIncorrectException("Incorrect N11 cargo code!!!");
					}
					if(n11Accepted == ecommerce.N11_DAILY_LIMIT) {
						n11NotAccepted = getN11NotAccepted() + 1;
						ecommerce.setStatus("Not Accepted");
					}
					else if(n11Accepted < ecommerce.N11_DAILY_LIMIT) {
						n11Accepted += 1;
						ecommerce.setStatus("Accepted");
					}
				}
			}
		}
		normalCargoList.trimToSize();
		ecommerceCargoList.trimToSize();
	}
	
	public ArrayList<NormalCargo> getNormalCargoList() {
		return normalCargoList;
	}

	public ArrayList<EcommerceCargo<?>> getEcommerceCargoList() {
		return ecommerceCargoList;
	}

	public int getAmazonNotAccepted() {
		return amazonNotAccepted;
	}

	public int getN11NotAccepted() {
		return n11NotAccepted;
	}

	public int getHepsiNotAccepted() {
		return hepsiNotAccepted;
	}

	public int getTrendyolNotAccepted() {
		return trendyolNotAccepted;
	}
	
	public int getAmazonAccepted() {
		return amazonAccepted;
	}

	public int getN11Accepted() {
		return n11Accepted;
	}

	public int getHepsiAccepted() {
		return hepsiAccepted;
	}

	public int getTrendyolAccepted() {
		return trendyolAccepted;
	}
}
