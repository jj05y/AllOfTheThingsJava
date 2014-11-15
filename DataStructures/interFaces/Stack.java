package interFaces;

public interface Stack<E> {
		
	//return number of elements in stack
	public int size();
	
	//returns boolean,  true for empty
	public boolean isEmpty();
	
	
	//return top element in stack, if empty, returns empty stack exception
	public E top();
	
	//push element onto stack
	public void push(E element);
	
	//removes and returns top element.
	//empty stack exception if empty
	public E pop();
}
