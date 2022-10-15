import java.util.Iterator;

public class IteratorVertice<T> implements Iterator<Integer> {
	private Iterator<Vertice<T>> iterator;

	public IteratorVertice(Iterator<Vertice<T>> iterator) {
		this.iterator = iterator;
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public Integer next() {
		return iterator.next().getVerticeId();
	}
}
