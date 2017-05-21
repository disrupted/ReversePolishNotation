package stack;

public class LinkedListStack<T> implements Stack<T> {

  private Node<T> first;


  public LinkedListStack() {
    first = null;

  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public T top() throws Underflow {
    if (isEmpty())
      throw new Underflow("Stack is empty.");
    return first.getElement();

  }

  @Override
  public void push(T element) {
    first = new Node<T>(element, first);
  }

  @Override
  public T pop() throws Underflow {
    if (isEmpty())
      throw new Underflow("Stack is empty.");
    T temp = first.getElement();
    first = first.getNext();
    return temp;
  }

  @Override
  public String toString() {
    String result = "";  // iteration : collecting all informations from list-nodes
    if (first != null) {
      result += first.toString();
      Node<T> nextNode = first.getNext();
      while (nextNode != null) {
        result += ", " + nextNode.toString();
        nextNode = nextNode.getNext();
      }
    }
    return result;
  }

  @Override
  public T peek() {
    if (isEmpty())
      return null;
    return first.getElement();
  }
}
