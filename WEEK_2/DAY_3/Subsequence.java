public class Subsequence {

   public static boolean isSubsequence(String str, String sub) {
      int strIndex = 0;
      int subIndex = 0;

      while (strIndex < str.length() && subIndex < sub.length()) {
         
         if (str.charAt(strIndex) == sub.charAt(subIndex)) {
            subIndex++; 
         }
         strIndex++;
      }

      return subIndex == sub.length();
   }

   public static void main(String[] args) {
      String str1 = "hello world";
      String sub1 = "hlo";
      System.out.println("Is '" + sub1 + "' a subsequence of '" + str1 + "'? " + isSubsequence(str1, sub1));

      String str2 = "programming";
      String sub2 = "pgm";
      System.out.println("Is '" + sub2 + "' a subsequence of '" + str2 + "'? " + isSubsequence(str2, sub2));

      String str3 = "data structures";
      String sub3 = "dts";
      System.out.println("Is '" + sub3 + "' a subsequence of '" + str3 + "'? " + isSubsequence(str3, sub3));
   }
}