package stack;

public class Node <T> {


  private T value;
  private Node next;

  public Node(T value){
    this.value = value;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T value){
    this.value = value;
  }

  public Node getNext(){
    return next;
  }

  public void setNext(Node nextNode){
    this.next = nextNode;
  }

  public String nodeToString(){
    String v = "Value: " + value;
    if(next == null){
      v += "null";
    } else {
      v += next.toString();
    }
    return v;
  }

}
