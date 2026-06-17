import java.util.Stack;

public class ValidParentheses {
   
   public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();

      for (char c : s.toCharArray()) {
         if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
         } 
         else {
            if (stack.isEmpty()) {
               return false;
            }
            char top = stack.pop();
            if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
               return false;
            }
         }
      }
      return stack.isEmpty();
   }

   public static void main(String[] args) {
      ValidParentheses vp = new ValidParentheses();
      String s1 = "()";
      String s2 = "()[]{}";
      String s3 = "(]";
      System.out.println(vp.isValid(s1)); // true
      System.out.println(vp.isValid(s2)); // true
      System.out.println(vp.isValid(s3)); // false
   }
}
