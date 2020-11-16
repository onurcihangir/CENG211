package FileAccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * FileIO class' job is to read files.
 * @author Onur Cihangir 250201049
 * @author Uğur Baran Özer 250201034
 */
public class FileIO {
	
	private String line;
	
	/**
	 * Creates String arrays from item file.
	 * @return String array of items
	 */
	public String[][] getItems() {
		int countRow = 0;
		int countColumn = 0;
		
		String[][] items = null;
		
		try {
			int count = findNumberOfLines("HW1_Items.csv");
			
			if(count > 0) {
				items = new String[count][3];
				
				initializeDataToStringArray(items, "HW1_Items.csv", countRow, countColumn);
			}
		} catch(FileNotFoundException exception) {
			System.out.println("Item file not found"); 
		} catch(IOException exception) {
			System.out.println(exception);
		}
		
		return items;
	}
	
	/**
	 * Creates String arrays from store file.
	 * @param file File name.
	 * @return String array of transactions.
	 */
	public String[][] getTransactions(String file) {
		int countRow = 0;
		int countColumn = 0;
		
		String[][] transactions = null;
		
		try {
			int count = findNumberOfLines(file);
			
			if(count > 0) {
				transactions = new String[count][37];
				
				initializeDataToStringArray(transactions, file, countRow, countColumn);
			}
		} catch(FileNotFoundException exception) {
			System.out.println("Store file not found"); 
		} catch(IOException exception) {
			System.out.println(exception);
		}
		
		return transactions;
	}
	
	/**
	 * Reads file and adds String data to array.
	 * @param dataArray 2-D String array.
	 * @param fileName Name of file.
	 * @param countRow Counting Row
	 * @param countColumn Counting Column
	 * @throws IOException
	 */
	private void initializeDataToStringArray(String[][] dataArray, String fileName, int countRow, int countColumn) throws IOException {
		FileReader secondFr = new FileReader(fileName);
		BufferedReader secondBr = new BufferedReader(secondFr);
		
		while ((line=secondBr.readLine()) != null) {
		    countColumn=0;
			StringTokenizer st=new StringTokenizer(line,",");
			while(st.hasMoreElements()) {
				dataArray[countRow][countColumn++]=st.nextElement().toString();
			}
			
			countRow++;
		}
		
		secondBr.close();
		secondFr.close();
	}
	
	/**
	 * Finds number of lines in a file.
	 * @param fileName String file name.
	 * @return Number of lines.
	 * @throws IOException
	 */
	private int findNumberOfLines(String fileName) throws IOException {
		int numberOfLines = 0;
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		while ((line=br.readLine()) !=null) {
			numberOfLines++;
		}
		fr.close();
		br.close();
		return numberOfLines;
	}
}
