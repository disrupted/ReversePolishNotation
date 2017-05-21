package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

public class Postfix {
  Stack<Double> stack;

  public Postfix() {
    stack = new LinkedListStack<>();
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    Postfix pf = new Postfix();
    pf.evaluate("Test1+2");
  }

  public static boolean isInt(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    return true;
  }

  public String infixToPostfix(String infix) {
    // TODO Auto-generated method stub
    return null;
  }

  public double evaluate(String postfix) {
    // TODO Auto-generated method stub
    double val1 = 0;
    double val2 = 0;
    String[] operands = postfix.split(" ");
    for (String operand : operands) {
      if (isInt(operand)) {
        stack.push(Double.parseDouble(operand));
      } else {
        try {
          val1 = stack.pop();
          val2 = stack.pop();
        } catch (Underflow ignored) {
        }
        switch (operand) { // find operator
          case "+":
            System.out.println("Addition");
            stack.push(val2 + val1);
            break;
          case "-":
            System.out.println("Subtraction");
            stack.push(val2 - val1);
            break;
          case "*":
            System.out.println("Multiplication");
            stack.push(val2 * val1);
            break;
          case "/":
            System.out.println("Division");
            stack.push(val2 / val1);
            break;
          default:
            break;
        }
      }
    }
    try {
      return stack.pop();
    } catch (Underflow underflow) {
      underflow.printStackTrace();
    }
    return 0;
  }

}
