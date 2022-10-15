import java.util.Iterator;

public class IteratorAdyacentes<T> implements Iterator<Integer> {
	private Iterator<Arco<T>> iterator;

	public IteratorAdyacentes(Iterator<Arco<T>> iterator) {
		this.iterator = iterator;
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

	public Integer next() {
		return iterator.next().getVerticeDestino();
	}

}