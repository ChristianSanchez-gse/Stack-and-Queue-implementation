import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
public class GQTest {
	
	@Test
	void constructorTest()
	{
		GenericQueue<Integer> myQueueInt = new GenericQueue<Integer>();
		assertEquals(null, myQueueInt.getHead());
		assertEquals(0, myQueueInt.getLength());
		
		GenericQueue<Integer> myQueue2Int = new GenericQueue<Integer>(8);
		assertEquals(8, myQueue2Int.getHead().getData());
		assertEquals(1, myQueue2Int.getLength());
		
		GenericQueue<String> myQueue3String = new GenericQueue<String>("test");
		assertEquals("test", myQueue3String.getHead().getData());
		assertEquals(1, myQueue3String.getLength());
		
		GenericQueue<Boolean> myQueue4 = new GenericQueue<Boolean>(true);
		assertEquals(true, myQueue4.getHead().getData());
		assertEquals(1, myQueue4.getLength());
		
		GenericQueue<Boolean> myQueue5 = new GenericQueue<Boolean>();
		assertEquals(null, myQueue5.getHead());
		assertEquals(0, myQueue5.getLength());
		
	}
	@Test
	void enqueueTest()
	{
		GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		assertEquals(1, myQueue.get(0));
		assertEquals(2, myQueue.get(1));
		assertEquals(3, myQueue.get(2));
		assertEquals(3, myQueue.getLength());
	}
	
	
	@Test
	void dequeueTest()
	{
		GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
		myQueue.enqueue(34);
		myQueue.enqueue(45);
		for( int i = 0; i < 20; i++)
		{
			myQueue.enqueue(2);
		}
		assertEquals(34, myQueue.dequeue());
		assertEquals(45,myQueue.dequeue());
		assertEquals(20, myQueue.getLength());
	}
	@Test
	void getTest()
	{
		GenericQueue<String> myQueue = new GenericQueue<String>();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		assertEquals("one", myQueue.get(0));
		assertEquals("two", myQueue.get(1));
		assertEquals("three", myQueue.get(2));
		assertEquals(null, myQueue.get(4));
	}
	
	
	@Test
	void setTest()
	{
		GenericQueue<String> myQueue = new GenericQueue<String>();
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		assertEquals("one",myQueue.set(0,"four"));
		assertEquals("two",myQueue.set(1,"five"));
		assertEquals("three",myQueue.set(2,"six"));
		
		assertEquals("four", myQueue.get(0) );
		assertEquals("five", myQueue.get(1));
		assertEquals("six", myQueue.get(2));
	}
	
	@Test
	void deleteTest()
	{
		GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		
		assertEquals(1,myQueue.delete());
		assertEquals(2,myQueue.delete());
		assertEquals(3,myQueue.delete());
	}
	@Test
	void iteratorTestForEach()
	{
		GenericQueue<Double> myQueue = new GenericQueue<Double>();
		double temp;
		int counter = 0;
		ArrayList<Double> arr = new ArrayList<Double>();
		for (int i = 0; i < 50; i++)
		{
			temp = Math.floor(Math.random()*(100-20+1)+20);
			arr.add(temp);
			myQueue.enqueue(temp);
		}
		
		for(Double j :  myQueue)
		{
			assertEquals(arr.get(counter), j);
			counter++;
		}
	}
	
	@Test
	void removeTail()
	{
		GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		
		assertEquals(3,myQueue.removeTail());
		assertEquals(2,myQueue.removeTail());
		assertEquals(1,myQueue.removeTail());
	}

}
