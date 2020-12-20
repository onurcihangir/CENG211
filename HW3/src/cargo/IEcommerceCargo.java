package cargo;

/**
 * Interface for EcommerceCargo object.
 */
public interface IEcommerceCargo {
	
	public static final int AMAZON_MAX_CODE = 9999999;
	public static final int AMAZON_MIN_CODE = 1000000;
	public static final int AMAZON_DAILY_LIMIT = 5;
	
	public static final int HEPSIBURADA_CODE_LEN = 8;
	public static final int HEPSIBURADA_DAILY_LIMIT = 7;
	
	public static final int N11_CODE_LEN = 7;
	public static final int N11_DAILY_LIMIT = 6;
	
	public static final int TRENDYOL_MAX_CODE = 99999999;
	public static final int TRENDYOL_MIN_CODE = 10000000;
	public static final int TRENDYOL_DAILY_LIMIT = 9;

}
