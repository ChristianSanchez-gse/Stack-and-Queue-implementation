import java.util.Iterator;
/*

The steps for the reverse iterator using a ****singly linked list******:
-Find the length of the overall list in the constructor by traversing the nodes until null is
encountered.

- The hasNext will return true when the length is greater than 0.

- The next function will iterate from the head up until 1 node before the total length.
then it will decrease the length by one so the next iteration will give return nodes in descending order




*/
public class ReverseGLLIterator < T > implements Iterator < T > {
    private int length;
    GenericList < T > .Node < T > curr;
    ReverseGLLIterator(GenericList < T > .Node < T > head) {
        curr = head;

        // finding the length of the list
        GenericList < T > .Node < T > temp = head;
        while (temp.getNext() != null) {
            length++;
            temp = temp.getNext();
        }
        length++;
    }

    @Override
    public boolean hasNext() {
        if (length > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        for (int i = 0; i < length - 2; i++) {
            curr = curr.getNext();
        }
        length--;
        return curr.getData();
    }

}