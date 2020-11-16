package ChainStore;

/**
 * Item object class.
 * @author Onur Cihangir 250201049
 * @author Uğur Baran Özer 250201034
 */
public class Item {
	private String name;
	private int id;
	private String category;
	
	public Item(String name, int id, String category) {
		this.name = name;
		this.id = id;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCategory() {
		return category;
	}
}
