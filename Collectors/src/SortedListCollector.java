import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SortedListCollector<T> implements Collector<T, Set<T>, Set<T>> {

	public static <T> SortedListCollector<T> toSortedSet() {
		return new SortedListCollector<>();
	}

	@Override
	public Supplier<Set<T>> supplier() {
		return LinkedHashSet::new;
	}

	@Override
	public BiConsumer<Set<T>, T> accumulator() {
		return Set::add;
	}

	@Override
	public BinaryOperator<Set<T>> combiner() {
		return (left, right) -> {
			left.addAll(right);
			return left;
		};
	}

	@Override
	public Function<Set<T>, Set<T>> finisher() {
		return LinkedHashSet::new;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Set.of(Characteristics.IDENTITY_FINISH);
	}

}
