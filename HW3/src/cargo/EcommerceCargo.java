package cargo;

/**
 * E-commerce cargo object class.
 * @param <T> Cargo code.
 */
public class EcommerceCargo<T> extends Cargo implements IEcommerceCargo {
	
	private String siteName;
	private T cargoCode;
	private String status;
	
	public EcommerceCargo(String type, String siteName, T cargoCode, int weight, int width, int length, int height) {
		super(type, weight, width, length, height);
		this.setCargoCode(cargoCode);
		this.setSiteName(siteName);
	}

	public T getCargoCode() {
		return cargoCode;
	}

	public void setCargoCode(T cargoCode) {
		this.cargoCode = cargoCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
