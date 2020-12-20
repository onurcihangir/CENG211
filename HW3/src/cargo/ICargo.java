package cargo;

/**
 * Interface for Cargo object.
 */
public interface ICargo {

	/**
	 * Calculates cargo's size and returns it.
	 * @return int Cargo size.
	 */
	public int calculateSize();
	/**
	 * Calculates cargo's desi and returns it.
	 * @return double Cargo desi.
	 */
	public double calculateDesi();
}
