import java.util.Stack;

public class EvaluateReversePolishNotation {
   
   public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      
      for(String token : tokens) {
         if(token.equals("+")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a + b);
         }
         else if(token.equals("-")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a - b);
         }
         else if(token.equals("*")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a * b);
         }
         else if(token.equals("/")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a / b);
         } else {
            stack.push(Integer.parseInt(token));
         }
      }
      
      return stack.pop();
   }

   public static void main(String[] args) {
      EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
      String[] tokens1 = { "2", "1", "+", "3", "*" };
      System.out.println(erpn.evalRPN(tokens1)); // 9

      String[] tokens2 = { "4", "13", "5", "/", "+" };
      System.out.println(erpn.evalRPN(tokens2)); // 6

      String[] tokens3 = { "10", "6", "9", "3", "/", "-", "*" };
      System.out.println(erpn.evalRPN(tokens3)); // 30
   }
}
