import java.util.*;

public class GenerateParentheses {
   
   public static List<String> generateParenthesis(int n) {

      List<String> result = new ArrayList<>();
      backtrack(result, "", 0, 0, n);
      return result;
   }

   private static void backtrack(List<String> result, String curr, int open, int close, int n) {

      if (curr.length() == 2 * n) {
         result.add(curr);
         return;
      }

      // add (
      if(open < n) {
         backtrack(result, curr + "(", open + 1, close, n);
      }
      // add )
      if(close < open) {
         backtrack(result, curr + ")", open, close + 1, n);
      }
   }

   public static void main(String[] args) {
      int n1 = 3;
      List<String> result = generateParenthesis(n1);
      System.out.println(result); 
      // output ["((()))","(()())","(())()","()(())","()()()"]

      int n2 = 1;
      result = generateParenthesis(n2);
      System.out.println(result); 
      // output ["()"]

      int n3 = 2;
      result = generateParenthesis(n3);
      System.out.println(result); 
      // output ["(())","()()"]
   }
}
