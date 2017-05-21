package postfix;

import stack.LinkedListStack;
import stack.Stack;

import java.util.ArrayList;

public class Postfix {
  Stack<String> stack;

  public Postfix() {
    stack = new LinkedListStack<>();
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    Postfix pf = new Postfix();
    pf.evaluate("Test1+2");
  }

  public String infixToPostfix(String infix) {
    // TODO Auto-generated method stub
    return null;
  }

  public double evaluate(String postfix) {
    // TODO Auto-generated method stub
    ArrayList<Integer> arr = new ArrayList<>();
    double result = 0;
    for (int i = 0; i < postfix.length(); i++) {
      String c = String.valueOf(postfix.charAt(i));
      if (isInt(c)) {
        arr.add(Integer.parseInt(c));
      } else {
        switch (c) { // find operator
          case "+":
            System.out.println("Addition");
            for (int e : arr
                    ) {
              result += e;
            }
            break;
          case "-":
            System.out.println("Subtraction");
            result = arr.get(0);
            for (int j = 1; j < arr.size(); j++) {
              result -= arr.get(j);
            }
            break;
          case "*":
            System.out.println("Multiplication");
            result = 1;
            for (int e : arr
                    ) {
              result *= e;
            }
            break;
          case "/":
            System.out.println("Division");
            result = arr.get(0);
            for (int j = 1; j < arr.size(); j++) {
              result /= arr.get(j);
            }
            break;
          default:
            break;
        }
      }
    }
    return result;
  }

  public static boolean isInt(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    return true;
  }

}
