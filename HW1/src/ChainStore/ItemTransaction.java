package ChainStore;

/**
 * ItemTransaction object class.
 * @author Onur Cihangir 250201049
 * @author Uğur Baran Özer 250201034
 */
public class ItemTransaction {
	private Item item;
	private Transaction[][] transactions;
	
	public ItemTransaction(Item item, Transaction[][] transactions) {
		this.item = item;
		this.transactions = transactions;
	}

	public Item getItem() {
		return item;
	}

	public Transaction[][] getTransactions() {
		return transactions;
	}

}
