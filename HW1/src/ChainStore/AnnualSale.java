package ChainStore;

import java.io.IOException;

import FileAccess.FileIO;

/**
 * AnnualSale class converts String array to Object array
 */
public class AnnualSale {
	private FileIO file;
	private Item[] items;
	private Transaction[][] transactions;
	
	/**
	 * Constructor for AnnualSale.
	 * @throws IOException
	 */
	public AnnualSale() throws IOException { 
		file=new FileIO();
		initializeStringDataToObjectArray();
	}
	
	/**
	 * Converts String data arrays to item arrays.
	 */
	public void initializeStringDataToObjectArray() {
		String[][] fItems = file.getItems();
		
		items = new Item[fItems.length];
		
		for(int i = 0; i < items.length; i++) {
			String itemName = fItems[i][0];
			int itemId = Integer.parseInt(fItems[i][1]);
			String itemBeverage = fItems[i][2];
			items[itemId - 1] = new Item(itemName, itemId, itemBeverage);
		}
	}
	
	/**
	 * Creates Transaction objects and Transactions arrays from String data arrays.
	 * @return ItemTransaction array.
	 */
	public ItemTransaction[] getItemTransactions() {
		String[][] fTransactions1 = file.getTransactions("HW1_Transactions_Store1.csv");
		String[][] fTransactions2 = file.getTransactions("HW1_Transactions_Store2.csv");
		String[][] fTransactions3 = file.getTransactions("HW1_Transactions_Store3.csv");
		String[][] fTransactions4 = file.getTransactions("HW1_Transactions_Store4.csv");
		
		ItemTransaction[] itemTransactions = new ItemTransaction[items.length];
		for(int i = 0; i < itemTransactions.length; i++) {
			transactions = new Transaction[4][12];
			Transaction[] transactionsStore1 = initializeTransactionObjects(i, fTransactions1);
			Transaction[] transactionsStore2 = initializeTransactionObjects(i, fTransactions2);
			Transaction[] transactionsStore3 = initializeTransactionObjects(i, fTransactions3);
			Transaction[] transactionsStore4 = initializeTransactionObjects(i, fTransactions4);
			transactions[0] = transactionsStore1;
			transactions[1] = transactionsStore2;
			transactions[2] = transactionsStore3;
			transactions[3] = transactionsStore4;
			ItemTransaction itemTransaction = new ItemTransaction(items[i], transactions);
			itemTransactions[i] = itemTransaction;
		}
		return itemTransactions;
	}
	
	/**
	 * Creates Transaction objects from String data append them to the Transaction array.
	 * @param index Index of Item.
	 * @param stringTransactions String transactions arrays from file.
	 * @return Transaction array.
	 */
	private Transaction[] initializeTransactionObjects(int index, String[][] stringTransactions) {
		Transaction[] transactions = new Transaction[12];
		int i = 1;  // We don't start the index from 0 because we don't take the item ID.
		int j = 0;
		while(i < 37 && j <= 11) {
			double purchasePrice = Double.parseDouble(stringTransactions[index][i]);
			double salePrice = Double.parseDouble(stringTransactions[index][i + 1]);
			int saleNumber = Integer.parseInt(stringTransactions[index][i + 2]);
			Transaction transaction = new Transaction(purchasePrice, salePrice, saleNumber);
			transactions[j] = transaction;
			i += 3;
			j++;
		}
		return transactions;
	}
}
