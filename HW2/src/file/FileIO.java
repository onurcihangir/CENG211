package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO {

private String line;
	
	/**
	 * Creates String arrays from insured value file.
	 * @return String array of insured values.
	 */
	public String[][] readFile() {
		int countRow = 0;
		int countColumn = 0;
		
		String[][] values = null;
		
		try {
			int count = findNumberOfLines("HW2_InsuredValues.csv");
			
			if(count > 0) {
				values = new String[count][8];
				
				initializeDataToStringArray(values, "HW2_InsuredValues.csv", countRow, countColumn);
			}
		} catch(FileNotFoundException exception) {
			System.out.println("Item file not found"); 
		} catch(IOException exception) {
			System.out.println(exception);
		}
		
		return values;
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
