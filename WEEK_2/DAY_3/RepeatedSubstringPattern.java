public class RepeatedSubstringPattern {
   
   public static boolean repeatedSubstringPattern(String s) {
      int n = s.length();
      for (int i = 1; i <= n / 2; i++) {
         if (n % i == 0) {
            String substring = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n / i; j++) {
               sb.append(substring);
            }
            if (sb.toString().equals(s)) {
               return true;
            }
         }
      }
      return false;
   }

   public static void main(String[] args) {
      String s1 = "abcabc";
      boolean result = repeatedSubstringPattern(s1);
      System.out.println(result); // Output: true

      String s2 = "aba";
      result = repeatedSubstringPattern(s2);
      System.out.println(result); // Output: false

      String s3 = "abcdabcd";
      result = repeatedSubstringPattern(s3);
      System.out.println(result); // Output: true
   }
}
