
// This project creates a stack and queue class
// Similar to the Java built in classes.
// Email: csanch84@uic.edu
// UIN: 674514106
// Christian Sanchez
public class GLProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to project 1");
		
		GenericQueue<Integer> myQueue = new GenericQueue<Integer>();
		myQueue.enqueue(8);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(6);
		for(int i : myQueue)
		{
			System.out.println(i);
		}
		//myQueue.dequeue();
		//System.out.println(myQueue.dumpList());
		System.out.println("This should be 8:"+ myQueue.get(0));
		System.out.println("This should be 4:"+ myQueue.get(1));
		System.out.println("This should be 5:"+ myQueue.get(2));
		System.out.println("This should be 6:"+ myQueue.get(3));
		System.out.println("This should be null:"+ myQueue.get(4));
		
		GenericStack<Integer> myStack = new GenericStack<Integer>();
		myStack.push(5);
		myStack.push(4);
		myStack.push(34);
		myStack.set(1, 420);
		System.out.println(myStack.dumpList());
		

	}
}
   