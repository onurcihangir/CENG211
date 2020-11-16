package ChainStore;

import java.io.IOException;

/**
 * StoreQuery class has methods to answer homework questions.
 * @author Onur Cihangir 250201049
 * @author Uğur Baran Özer 250201034
 */
public class StoreQuery {
	private ItemTransaction[] itemTransactions;
	private AnnualSale annualSale;
	
	/**
	 * Constructor for StoreQuery.
	 * @throws IOException
	 */
	public StoreQuery() throws IOException {
		annualSale = new AnnualSale();
		itemTransactions = annualSale.getItemTransactions();
	}
	
	/**
	 * Finds the most profitable item for the whole year.
	 * @return Item name.
	 */
	public String mostProfitableItemForWholeYear() {
		Item item = itemTransactions[0].getItem();
		double highProfit = profitOfFirstItem();
		for(int i = 1; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			double profitOfItem = 0;
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					profitOfItem += profit(j, k, transactions);
				}
			}
			if(profitOfItem > highProfit) {
				highProfit = profitOfItem;
				item = itemTransactions[i].getItem();
			}
		}
		return item.getName();
	}
	
	/**
	 * Finds the most profitable category for the whole year.
	 * @return Category name.
	 */
	public String mostProfitableCategoryForWholeYear() {
		double beverageProfit = 0;
		double foodProfit = 0;
		double snackProfit = 0;
		double homeProfit = 0;
		double personalProfit = 0;
		String category = "";
		for(int i = 0; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					if(itemTransactions[i].getItem().getCategory().contentEquals("Beverage")) {
						beverageProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Food")) {
						foodProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Snack")) {
						snackProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Home")) {
						homeProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Personal")) {
						personalProfit += profit(j, k, transactions);
					}
				}
			}
		}
		double highestCategory = findTheHigh(beverageProfit, foodProfit, snackProfit, homeProfit, personalProfit);
		if(highestCategory == beverageProfit) {
			category = "Beverage";
		}
		if(highestCategory == foodProfit) {
			category = "Food";
		}
		if(highestCategory == snackProfit) {
			category = "Snack";
		}
		if(highestCategory == homeProfit) {
			category = "Home";
		}
		if(highestCategory == personalProfit) {
			category = "Personal";
		}
		return category;
	}
	
	/**
	 * Finds least profitable item for whole year.
	 * @return Item name.
	 */
	public String leastProfitableItemForWholeYear() {
		Item item = itemTransactions[0].getItem();
		double lowProfit = profitOfFirstItem();
		for(int i = 1; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			double profitOfItem = 0;
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					profitOfItem += profit(j, k, transactions);
				}
			}
			if(profitOfItem < lowProfit) {
				lowProfit = profitOfItem;
				item = itemTransactions[i].getItem();
			}
		}
		return item.getName();
	}
	
	/**
	 * Finds the least profitable category for the whole year.
	 * @return String category name
	 */
	public String leastProfitableCategoryForWholeYear() {
		double beverageProfit = 0;
		double foodProfit = 0;
		double snackProfit = 0;
		double homeProfit = 0;
		double personalProfit = 0;
		String category = "";
		for(int i = 0; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					if(itemTransactions[i].getItem().getCategory().contentEquals("Beverage")) {
						beverageProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Food")) {
						foodProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Snack")) {
						snackProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Home")) {
						homeProfit += profit(j, k, transactions);
					}
					if(itemTransactions[i].getItem().getCategory().contentEquals("Personal")) {
						personalProfit += profit(j, k, transactions);
					}
				}
			}
		}
		
		double lowestCategory = findTheLow(beverageProfit, foodProfit, snackProfit, homeProfit, personalProfit);
		if(lowestCategory == beverageProfit) {
			category = "Beverage";
		}
		if(lowestCategory == foodProfit) {
			category = "Food";
		}
		if(lowestCategory == snackProfit) {
			category = "Snack";
		}
		if(lowestCategory == homeProfit) {
			category = "Home";
		}
		if(lowestCategory == personalProfit) {
			category = "Personal";
		}
		return category;
	}
	
	/**
	 * Finds the most profitable item for a single sale.
	 * @return Item name.
	 */
	public String mostProfitableItemForSingleSale() {
		Item item = new Item("None", 0, "None");
		double profit = 0;
		for(int i = 0; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					double salePrice = transactions[j][k].getSalePrice();
					double purchasePrice = transactions[j][k].getPurchasePrice();
					double singleProfit = salePrice - purchasePrice;
					if(singleProfit > profit) {
						profit = singleProfit;
						item = itemTransactions[i].getItem();
					}
				}
			}
		}
		return item.getName();
	}
	
	/**
	 * Finds the best selling item.
	 * @return Item name.
	 */
	public String bestSellingItem() {
		Item item = new Item("None", 0, "None");
		int highestSaleNumber = 0;
		for(int i = 0; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			int actualSaleNumber = 0;
			for(int j = 0; j < transactions.length; j++) {
				for(int k = 0; k < 12; k++) {
					actualSaleNumber += transactions[j][k].getSaleNumber();
				}
			}
			if(actualSaleNumber > highestSaleNumber) {
				item = itemTransactions[i].getItem();
				highestSaleNumber = actualSaleNumber;
			}
		}	
		return item.getName();
	}
	
	/**
	 * Finds the most profitable store for each month and prints store name.
	 */
	public void mostProfitableStoreForEachMonth() {
		for(int i = 0; i < 12; i++) {
			double firstStoreProfit = findMonthlyProfitOfStore(0, i);
			double secondStoreProfit = findMonthlyProfitOfStore(1, i);
			double thirdStoreProfit = findMonthlyProfitOfStore(2, i);
			double fourthStoreProfit = findMonthlyProfitOfStore(3, i);
			if(firstStoreProfit > secondStoreProfit && firstStoreProfit > thirdStoreProfit && firstStoreProfit > fourthStoreProfit) {
				System.out.println("Month " + (i+1) + ": Store 1");
			}
			else if(secondStoreProfit > firstStoreProfit && secondStoreProfit > thirdStoreProfit && secondStoreProfit > fourthStoreProfit) {
				System.out.println("Month " + (i+1) + ": Store 2");
			}
			else if(thirdStoreProfit > firstStoreProfit && thirdStoreProfit > secondStoreProfit && thirdStoreProfit > fourthStoreProfit) {
				System.out.println("Month " + (i+1) + ": Store 3");
			}
			else {
				System.out.println("Month " + (i+1) + ": Store 4");
			}
		}
	}
	
	/**
	 * Finds monthly profit of store.
	 * @param store int index of store.
	 * @param month int index of month.
	 * @return double monthly profit of store.
	 */
	private double findMonthlyProfitOfStore(int store, int month) {
		double profit = 0;
		for(int i = 0; i < itemTransactions.length; i++) {
			Transaction[][] transactions = itemTransactions[i].getTransactions();
			profit += profit(store, month, transactions);
		}
		return profit;
	}
	
	/**
	 * Finds profit of item for a transaction.
	 * @param store int Index of store.
	 * @param month int Index of month.
	 * @param transactions 2-Dimensional Transaction array.
	 * @return Profit of item.
	 */
	private double profit(int store, int month, Transaction[][] transactions) {
		double salePrice = transactions[store][month].getSalePrice();
		double purchasePrice = transactions[store][month].getPurchasePrice();
		int saleNumber = transactions[store][month].getSaleNumber();
		double profit = (salePrice - purchasePrice) * saleNumber;
		return profit;
	}
	
	/**
	 * Finds profit of first item in ItenTransaction array.
	 * @return Profit of first item.
	 */
	private double profitOfFirstItem() {
		Transaction[][] transactions = itemTransactions[0].getTransactions();
		double profitOfItem = 0;
		for(int j = 0; j < transactions.length; j++) {
			for(int k = 0; k < 12; k++) {
				profitOfItem += profit(j, k, transactions);
			}
		}
		return profitOfItem;
	}
	
	/**
	 * Finds the highest out of 5 numbers.
	 * @param num1 First double number.
	 * @param num2 Second double number.
	 * @param num3 Third double number.
	 * @param num4 Fourth double number.
	 * @param num5 Fifth double number.
	 * @return The highest number.
	 */
	private double findTheHigh(double num1, double num2, double num3, double num4, double num5) {
		if(num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5) {
			return num1;
		}
		else if(num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5) {
			return num2;
		}
		else if(num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5) {
			return num3;
		}
		else if(num4 > num1 && num4 > num2 && num4 > num3 && num4 > num5) {
			return num4;
		}
		else {
			return num5;
		}
	}
	
	/**
	 * Finds the lowest out of 5 numbers.
	 * @param num1 First double number.
	 * @param num2 Second double number.
	 * @param num3 Third double number.
	 * @param num4 Fourth double number.
	 * @param num5 Fifth double number.
	 * @return The lowest number.
	 */
	private double findTheLow(double num1, double num2, double num3, double num4, double num5) {
		if(num1 < num2 && num1 < num3 && num1 < num4 && num1 < num5) {
			return num1;
		}
		else if(num2 < num1 && num2 < num3 && num2 < num4 && num2 < num5) {
			return num2;
		}
		else if(num3 < num1 && num3 < num2 && num3 < num4 && num3 < num5) {
			return num3;
		}
		else if(num4 < num1 && num4 < num2 && num4 < num3 && num4 < num5) {
			return num4;
		}
		else {
			return num5;
		}
	}
}
