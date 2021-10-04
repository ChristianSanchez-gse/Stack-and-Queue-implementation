import java.util.Iterator;

public class GenericStack < T > extends GenericList < T > {
    Node < T > tail;

    // constructors
    GenericStack() {
        super();
        tail = null;
    }

    GenericStack(T data) {
        super(data);
        tail = getHead();
    }
    public T removeTail() {
        T returnVal = tail.getData();
        if (this.getHead() == tail) {
            this.setHead(null);
            return returnVal;
        } else {
            Node <T> temp = this.getHead();
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            tail = temp;
            tail.setNext(null);
            return returnVal;
        }

    }

    public void push(T data) {
        // calls add
        this.add(data);
    }

    public T pop() {
        setLength(getLength() - 1);
        return this.delete();
        // calls delete
    }

    @Override
    public void add(T data) {
        Node < T > newVal = new Node < T > (data);
        // if the stack is empty, just set the new node to the head.
        if (getHead() == null) {
            this.setHead(newVal);
            tail = newVal;
        } else {
            // The new  value will be added behind the head.
            newVal.setNext(this.getHead());
            this.setHead(newVal);

        }
        setLength(getLength() + 1);
    }


    @Override
    public Iterator < T > iterator() {
        return new GLLIterator < T > (this.getHead());
    }
}