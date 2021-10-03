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
	public T next() {
		System.out.println("This is the current node: " + curr.getData() + "This is the next one: " + curr.getNext().getData());
		
		curr.setNext(curr.getNext());
		System.out.println("Now this is the current: " + curr.getData());
		return curr.getData();
	}

}
