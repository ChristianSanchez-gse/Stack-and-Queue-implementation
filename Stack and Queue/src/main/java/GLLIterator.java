import java.util.Iterator;

public class GLLIterator < T > implements Iterator < T > {
    GenericList < T > .Node < T > curr;
    GLLIterator(GenericList < T > .Node < T > head) {
        curr = head;
    }
    GLLIterator(GenericList < T > .Node < T > head, int index) {
        curr = head;
        // advancing to the index
        for (int i = 0; i < index; i++) {
            if (curr.getNext() != null) {
                curr = curr.getNext();
            }
        }

    }
    @Override
    public boolean hasNext() {
        // checks if there are more elements available
        if (curr != null && curr.getNext() != null) {
            //System.out.println("There is a an node and a next node");
            return true;
        }
        // Checks if we are at the end of the linked list and there is no other
        // Node next to the current. Then, the next() will set the current to null so it
        // can return false.
        else if (curr != null && curr.getNext() == null) {
            //System.out.println("There is a node and no next node");
            return true;
        }
        // Only return false when the node itself is null
        return false;
    }

    @Override
    // Advances to the next node and returns the data.
    public T next() {
        if (curr.getNext() != null) {
            //System.out.println("Advancing and returning the current value");
            T val = curr.getData();
            curr = curr.getNext();
            return val;
        }
        // sets current to null so that the next hasNext() call returns false.
        T val = curr.getData();
        curr = null;
        return val;
    }

}