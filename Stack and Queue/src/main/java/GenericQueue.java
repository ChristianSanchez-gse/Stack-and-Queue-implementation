import java.util.Iterator;

public class GenericQueue < T > extends GenericList < T > {
    Node < T > tail;
    //constructor
    GenericQueue(T data) {
        // takes in the first element that will be put in the list.
        super(data);
        tail = getHead();
    }
    GenericQueue() {
        super();
        tail = null;
    }


    public T removeTail() {
        T returnVal = tail.getData();
        Node < T > curr = new Node < T > (null);
        curr = this.getHead();

        // if the tail is also the head, make the list null
        if (this.getHead() == tail) {
            returnVal = tail.getData();
            this.setHead(null);
            this.setLength(getLength() - 1);
            return returnVal;
        } else {
            while (curr.getNext() != tail) {
                curr = curr.getNext();
                //System.out.println("iterating through element: " + curr.getData());
            }

            tail = curr;
            curr.setNext(null);
            this.setLength(getLength() - 1);
            return returnVal;
        }

    }

    public void enqueue(T data) {
        // calls add(T data)
        this.add(data);
    }

    public T dequeue() {
        setLength(getLength() - 1);
        return this.delete();
    }

    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        Node < T > newVal = new Node < T > (data);
        // if the queue is empty, just set the new node to the head.
        if (getHead() == null) {
            this.setHead(newVal);
        }
        // If there is a head, but the next is null, add a new one
        // (not sure if this else if statement is necessary)
        else if (getHead().getNext() == null) {
            getHead().setNext(newVal);
        } else {
            // Iterate to the end of the list and add the new node
            Node < T > curr = new Node < T > (data);
            curr = this.getHead();
            // while the list is not empty,
            // iterate through the linked list and finally 
            // add the newVal Node to the end.
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newVal);
            tail = newVal;
        }
        setLength(getLength() + 1);
    }

    @Override
    public Iterator < T > iterator() {
        // TODO Auto-generated method stub

        return new GLLIterator < T > (this.getHead());
    }

}