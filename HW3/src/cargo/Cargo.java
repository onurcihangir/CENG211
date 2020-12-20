package cargo;

/**
 * Abstract Cargo object class.
 */
public abstract class Cargo implements ICargo {

	private String type;
	private int weight;
	private int width;
	private int length;
	private int height;
	
	public Cargo(String type, int weight, int width, int length, int height) {
		this.setType(type);
		this.setWeight(weight);
		this.setWidth(width);
		this.setLength(length);
		this.setHeight(height);
	}
	
	public double calculateDesi() {
		// TODO Auto-generated method stub
		double desi = (double)(width*length*height) / 3000;
		return desi;
	}

	public int calculateSize() {
		// TODO Auto-generated method stub
		int size = Math.max((int)this.calculateDesi(), weight);
		return size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
