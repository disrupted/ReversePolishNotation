package stack;

public interface Stack<E> {

	public boolean isEmpty();

	public E top() throws Underflow;

	public Stack<E> push(E element);

	public Stack<E> pop() throws Underflow;

}
