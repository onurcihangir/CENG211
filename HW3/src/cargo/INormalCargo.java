package cargo;

/**
 * Interface for NormalCargo object.
 */
public interface INormalCargo {

	/**
	 * Calculate cargo's price and returns it.
	 * @return double Cargo price.
	 */
	public double calculatePrice();
	/**
	 * Generates random cargo code and returns it.
	 * @return int Cargo code.
	 */
	public int generateCargoCode();
}
