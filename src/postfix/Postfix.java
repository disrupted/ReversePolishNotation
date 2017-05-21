package postfix;

import stack.LinkedListStack;
import stack.Stack;
import stack.Underflow;

import java.util.Scanner;

public class Postfix {
  Stack<Double> stack;

  public Postfix() {
    stack = new LinkedListStack<>();
  }

  public static void main(String[] args) {
    Postfix pf = new Postfix();
    pf.userInput();
  }

  public static boolean isInt(String s) {
    try {
      Integer.parseInt(s);
    } catch (NumberFormatException | NullPointerException e) {
      return false;
    }
    return true;
  }

  public static boolean isOperator(String s) {
    return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
  }

  public static boolean isLowerPrecedence(String topOfStack, String currentToken) {
    switch (topOfStack) {
      case "+":
      case "-":
        return currentToken.equals("*") || currentToken.equals("/");
      case "*":
      case "/":
        return false;
    }
    return true; // digits are always of lower precedence than operators
  }

  public String infixToPostfix(String infix) {
    // TODO Auto-generated method stub
    if (infix.length() > 0) {
      String output = "";
      Stack<String> stack = new LinkedListStack<>();
      String[] operands = infix.split(" ");
      for (String operand : operands) {
        if (isInt(operand)) {
          output += operand + " ";
        } else if (operand.equals("(")) {
          stack.push(operand);
        } else if (operand.equals(")")) {
          try {
            while (stack.peek() != null && !stack.peek().equals("(")) {
              output += stack.pop() + " ";
            }
            stack.pop(); // remove open paranthesis
          } catch (Underflow ignored) {
          }
        } else if (isOperator(operand)) {
          while (stack.peek() != null && !isLowerPrecedence(stack.peek(), operand)) {
            System.out.println("topOfStack (" + stack.peek() + ") is of higher precedence than current token (" + operand + ")");
            try {
              output += stack.pop() + " ";
            } catch (Underflow underflow) {
              underflow.printStackTrace();
            }
          }
          stack.push(operand); // operator
        } //else {
        //throw new IllegalArgumentException();
        //}
      }

      output += stack.toString().replace(",", ""); // append content of Stack
      return output.trim(); // remove trailing spaces from result
    }
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

  public void userInput() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("\nPlease type in an infix String: ");
      String input = sc.nextLine();
      if (input.equals("quit")) break;
      String postfix = infixToPostfix(input);
      System.out.println("→ postfix: " + postfix);
      System.out.println("→ evaluation: " + evaluate(postfix));
    }
  }
}
