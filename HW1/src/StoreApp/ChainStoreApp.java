package StoreApp;

import java.io.IOException;
import ChainStore.StoreQuery;

/**
 * ChainStoreApp class is the class with the main method.
 * @author Onur Cihangir 250201049
 * @author Uğur Baran Özer 250201034
 */
public class ChainStoreApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StoreQuery query = new StoreQuery();
		System.out.println("1- "+ query.mostProfitableItemForWholeYear());
		System.out.println("2- "+ query.mostProfitableCategoryForWholeYear());
		System.out.println("3- "+ query.leastProfitableItemForWholeYear());
		System.out.println("4- "+ query.leastProfitableCategoryForWholeYear());
		System.out.println("5- "+ query.mostProfitableItemForSingleSale());
		System.out.println("6- "+ query.bestSellingItem());
		System.out.print("7- ");
		query.mostProfitableStoreForEachMonth();
	}

}
