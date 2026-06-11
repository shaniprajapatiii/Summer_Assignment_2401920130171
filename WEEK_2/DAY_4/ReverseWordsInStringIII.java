public class ReverseWordsInStringIII {
   
   public static String reverseWords(String s) {

      String[] words = s.split(" ");
      StringBuilder result = new StringBuilder();

      for (String word : words) {
         StringBuilder reversed = new StringBuilder(word);
         result.append(reversed.reverse().toString()).append(" ");
      }

      return result.toString().trim();
   }

   public static void main(String[] args) {
      String s1 = "Let's take LeetCode contest";
      System.out.println(reverseWords(s1)); // "s'teL ekat edoCteeL tsetnoc"

      String s2 = "Hello World";
      System.out.println(reverseWords(s2)); // "olleH dlroW"

      String s3 = "Java Programming";
      System.out.println(reverseWords(s3)); // "avaJ gnimmargorP"
   }
}
