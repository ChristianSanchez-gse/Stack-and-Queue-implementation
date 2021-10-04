import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class GSTest {
	@Test
	void constructorTest()
	{
		GenericStack<Integer> myStackInt = new GenericStack<Integer>();
		assertEquals(null, myStackInt.getHead());
		assertEquals(0, myStackInt.getLength());
		
		GenericStack<Integer> myStack2Int = new GenericStack<Integer>(8);
		assertEquals(8, myStack2Int.getHead().getData());
		assertEquals(1, myStack2Int.getLength());
		
		GenericStack<String> myStack3String = new GenericStack<String>("test");
		assertEquals("test", myStack3String.getHead().getData());
		assertEquals(1, myStack3String.getLength());
		
		GenericStack<Boolean> myStack4 = new GenericStack<Boolean>(true);
		assertEquals(true, myStack4.getHead().getData());
		assertEquals(1, myStack4.getLength());
		
		GenericStack<Boolean> myStack5 = new GenericStack<Boolean>();
		assertEquals(null, myStack5.getHead());
		assertEquals(0, myStack5.getLength());
		
	}
	@Test
	void pushTest()
	{
		GenericStack<Integer> myStack = new GenericStack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		assertEquals(3, myStack.get(0));
		assertEquals(2, myStack.get(1));
		assertEquals(1, myStack.get(2));
		assertEquals(3, myStack.getLength());
	}
	
	
	@Test
	void popTest()
	{
		GenericStack<Integer> myStack = new GenericStack<Integer>();
		
		for( int i = 0; i < 20; i++)
		{
			myStack.push(2);
		}
		myStack.push(34);
		myStack.push(45);
		assertEquals(45, myStack.pop());
		assertEquals(34,myStack.pop());
		assertEquals(20, myStack.getLength());
	}
	@Test
	void getTest()
	{
		GenericStack<String> myStack = new GenericStack<String>();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		assertEquals("three", myStack.get(0));
		assertEquals("two", myStack.get(1));
		assertEquals("one", myStack.get(2));
		assertEquals(null, myStack.get(4));
	}
	
	
	@Test
	void setTest()
	{
		GenericStack<String> myStack = new GenericStack<String>();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		assertEquals("three",myStack.set(0,"four"));
		assertEquals("two",myStack.set(1,"five"));
		assertEquals("one",myStack.set(2,"six"));
		
		assertEquals("four", myStack.get(0) );
		assertEquals("five", myStack.get(1));
		assertEquals("six", myStack.get(2));
	}
	
	@Test
	void deleteTest()
	{
		GenericStack<Integer> myStack = new GenericStack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		
		assertEquals(3,myStack.delete());
		assertEquals(2,myStack.delete());
		assertEquals(1,myStack.delete());
	}
	// fails
	@Test
	void iteratorTest()
	{
		GenericStack<Double> myStack = new GenericStack<Double>();
		double temp;
		int counter = 0;
		ArrayList<Double> arr = new ArrayList<Double>();
		for (int i = 0; i < 50; i++)
		{
			temp = Math.floor(Math.random()*(100-20+1)+20);
			arr.add(temp);
			myStack.push(temp);
		}
		
		for(Double j :  myStack)
		{
			System.out.println(j);
			assertEquals(arr.get(counter), j);
			counter++;
		}
	}
	
	@Test
	void removeTail()
	{
		GenericStack<Integer> myStack = new GenericStack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		
		assertEquals(1,myStack.removeTail());
		assertEquals(2,myStack.removeTail());
		assertEquals(3,myStack.removeTail());
	}
}
