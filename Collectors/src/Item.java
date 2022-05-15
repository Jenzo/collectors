import java.util.Comparator;

public class Item {

	public static final Comparator<Item> COMPARE_BY_NAME = Comparator.comparing(Item::getName);
	public static final Comparator<Item> COMPARE_BY_POSITION = Comparator.comparing(Item::getPosition);

	private String name;
	private int position;

	public Item(int pos, String name) {
		this.name = name;
		this.position = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", position=" + position + "]";
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
