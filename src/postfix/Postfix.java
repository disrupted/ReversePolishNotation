package postfix;

import stack.LinkedListStack;

public class Postfix {
  LinkedListStack<String> stack;

  public Postfix() {
    stack = new LinkedListStack<>();
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    Postfix pf = new Postfix();
    pf.evaluate("Test1");
  }

  public String infixToPostfix(String infix) {
    // TODO Auto-generated method stub
    return null;
  }

  public double evaluate(String postfix) {
    // TODO Auto-generated method stub
    for (int i = 0; i < postfix.length(); i++) {
      String c = String.valueOf(postfix.charAt(i));
      System.out.println(c);
      if (isInt(c)) {
        stack.push(c);
      }
    }
    return 0;
  }

  public static boolean isInt(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    // only got here if we didn't return false
    return true;
  }

}
