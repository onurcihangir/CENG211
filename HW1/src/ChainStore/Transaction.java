package ChainStore;

/**
 * Transaction object class
 */
public class Transaction {
	private double purchasePrice;
	private double salePrice;
	private int saleNumber;
	
	public Transaction(double purchasePrice, double salePrice, int saleNumber) {
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.saleNumber = saleNumber;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public int getSaleNumber() {
		return saleNumber;
	}
	
}
