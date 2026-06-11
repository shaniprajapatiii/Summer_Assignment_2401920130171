import java.util.Stack;

public class DecodeString {
   
   public static String decodeString(String s) {

      Stack<Integer> countStack = new Stack<>();
      Stack<String> stringStack = new Stack<>();
      String currString = "";
      int k = 0;

      for (char ch : s.toCharArray()) {
         if (Character.isDigit(ch)) {
            k = k * 10 + (ch - '0');
         } 
         else if (ch == '[') {
            countStack.push(k);
            stringStack.push(currString);
            currString = "";
            k = 0;
         } 
         else if(ch == ']') {
            StringBuilder decoded = new StringBuilder(stringStack.pop());
            int count = countStack.pop();
            
            for(int i = 0; i < count; i++) {
               decoded.append(currString);
            }
            currString = decoded.toString();
         } else {
            currString += ch;
         }
      }

      return currString;
   }

   public static void main(String[] args) {
      String s1 = "3[a]2[bc]";
      String s2 = "3[a2[c]]";
      String s3 = "2[abc]3[cd]ef";
      System.out.println(decodeString(s1)); // "aaabcbc"
      System.out.println(decodeString(s2)); // "accaccacc"
      System.out.println(decodeString(s3)); // "abcabccdcdcdef"
   }
}
