import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {
	GenericList<T>.Node<T> curr;
	GLLIterator(GenericList<T>.Node<T> head) {
        curr = head;
    }
	@Override
	public boolean hasNext() {
		if (curr.getNext() != null)
		{
			return true;
		}
		return false;
	}

	@Override
	// Advances to the next node and returns the data.
	public T next() {
		curr = curr.getNext();
		return curr.getData();
	}

}
