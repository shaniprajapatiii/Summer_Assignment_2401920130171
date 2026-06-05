public class ValidPalindrome {

   public static boolean isPalindrome(String s) {

      StringBuilder sb = new StringBuilder();

      for(char c : s.toCharArray()) {

         if (Character.isLetterOrDigit(c)) {
            sb.append(Character.toLowerCase(c));
         }
      }

      String cleaned = sb.toString();
      int left = 0;
      int right = cleaned.length() - 1;
      
      while (left < right) {
         if (cleaned.charAt(left) != cleaned.charAt(right)) {
            return false;
         }
         left++;
         right--;
      }
      
      return true;
   }

   public static void main(String[] args) {

      String s1 = "A man, a plan, a canal: Panama";
      System.out.println(ValidPalindrome.isPalindrome(s1)); 

      String s2 = "race a car";
      System.out.println(ValidPalindrome.isPalindrome(s2));

      String s3 = " ";
      System.out.println(ValidPalindrome.isPalindrome(s3));
   }
}