import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Starter {

	public static void main(String[] args) {
		List<Item> items = createItems(5);
		print(items);

		items.sort(Item.COMPARE_BY_POSITION);
		print(items);

		Set<String> positions = items.stream().map(Item::getName).collect(Collectors.toSet());
		print(positions);
		Set<String> positions2 = items.stream().map(Item::getName).collect(MyCollectors.toSortedSet());
		print(positions2);

		List<Item> filteredByNameLength = items.stream().filter(lengthFilter(5)).sorted(Item.COMPARE_BY_POSITION)
				.collect(Collectors.toList());
		print(filteredByNameLength);
	}

	private static Predicate<Item> lengthFilter(int l) {
		return i -> i.getName().length() >= l;
	}

	private static void print(Collection<?> items) {
		System.out.println(items);
	}

	private static List<Item> createItems(int i) {
		List<Item> items = new ArrayList<>();
		int[] positions = { 2, 3, 1, 6, 5, 4 };
		String[] names = { "Aris", "Bud", "Christian", "Dennis", "Ethaniel", "Filip" };
		for (int p = 0; p < positions.length; ++p) {
			items.add(new Item(positions[p], names[p]));
		}
		return items;
	}

}
