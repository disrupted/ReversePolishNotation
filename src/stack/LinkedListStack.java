package stack;

public class LinkedListStack<T> implements Stack<T> { //Stack ist ein Interface

	private Node<T> first;

	public LinkedListStack(String string){
			//leere Liste
			first = null;
	}

	//main Methode zum Testen
	public static void main(String [ ] args){
		LinkedListStack<String> list = new LinkedListStack<String>("first Element");
		list.test();
	}

 private void test(){
	 Node<String> node1 = new Node<String>("Node 1");
	 Node<String> node2 = new Node<String>("Node 2");
	 Node<String> node3 = new Node<String>("Node 3");
	 Node<String> node4 = new Node<String>("Node 4");

	 System.out.println(listToString());
 }

	@Override
	public boolean isEmpty() {
		if (first == null){
			return true;
		} else{
		return false;
		}
	}

	@Override
	public T top() throws Underflow {

		return null;
	}

	@Override
	public Stack <T> push(T elementToAdd) { 			//praktisch das selbe wie add().
		elementToAdd.setNext(this.first);
		this.first = elementToAdd;
		return null;
	}

	@Override
	public Stack<T> pop() throws Underflow {		//= getFirst().
		String firstElement = first.toString();
		return firstElement;


	}

	@Override
	public void removeFirst(){
		first = first.nextNode();
	}

	@Override
	public String listToString(){
		String result = "";
		result += first.toString();
		Node <T> nextNode = first.getNext();
		while (nextNode != null){
			result += nextNode.toString();
			nextNode = nextNode.getNext();
		}
	}

}
