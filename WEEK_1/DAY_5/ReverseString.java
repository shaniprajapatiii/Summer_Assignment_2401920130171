public class ReverseString {

   public static void reverseString(char[] s) {

      int left = 0;
      int right = s.length - 1;

      while(left < right) {
         char temp = s[left];
         s[left] = s[right];
         s[right] = temp;
         left++;
         right--;
      }
   }

   public static void main(String[] args) {

      char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
      ReverseString.reverseString(s1);
      System.out.println(s1);

      char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
      ReverseString.reverseString(s2);
      System.out.println(s2);
   }
}