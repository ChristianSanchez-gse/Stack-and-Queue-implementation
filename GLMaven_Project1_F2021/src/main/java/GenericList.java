import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public abstract class GenericList<T> implements Iterable<T>
{
	private Node<T> head;
	private int length;
	
	// Constructors for creating new nodes
	public GenericList()
	{
		head = null;
		length = 0;
	}
	
	public GenericList(T data)
	{
		head = new Node<T>(data);
		length = 1;
	}
	
	public class Node<T>
	{
		private T data;
		private Node<T> next;
		public Node(T val)
		{
			data = val;
			next = null;
			
		}
		public T getData()
		{
			return data;
		}
		
		public Node<T> getNext()
		{
			return next;
		}
		
		public void setData(T val)
		{
			data = val;
		}
		
		public void setNext(Node<T> curr)
		{
			this.next = curr;
		}
	}
	
	public void print()
	{
		if (length == 0)
		{
			System.out.println("Empty List");
		}
		for(int i = 0; i< length;i++)
		{
			// iterate through the list.
		}
	}
	public abstract void add(T data);
	public T delete() {
		T val = head.getData();
		head = head.getNext();
		return val;
	}
	
	// iterates through the array, inputs the value into an ArrayList
	// and deletes the linked list value.
	public ArrayList<T> dumpList()
	{
		ArrayList<T> myList = new ArrayList<T>();
		while (head.getNext() != null)
		{
			myList.add(head.getData());
			head = head.getNext();
		}
		myList.add(head.getData());
		return myList;
		
	}
	
	// returns a value at the specified index
	public T get( int index)
	{
		Node<T> temp = head;
		if (index >= getLength() || index < 0)
		{
			return null;
		}
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		return temp.getData();
		
		
	}
	public T set(int index, T element)
	{
		T oldVal;
		Node<T> temp = head;
		if (index >= getLength() || index < 0)
		{
			return null;
		}
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		oldVal = temp.getData();
		temp.setData(element);
		return oldVal;
		
		
	}
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int len)
	{
		length = len;
	}
	public Node<T> getHead()
	{
		return head;
		
	}
	public void setHead(Node<T> newVal) 
	{
		head = newVal;
	}
	public GLLIterator<T> listIterator( int index)
	{
		GLLIterator<T> iter = new GLLIterator<T>(this.getHead());
		return iter;
	}
	
	public Iterator<T> descendingIterator( )
	{
		return null;
		
	}
}
