import java.util.*;

public class PermutationInString {

   public boolean checkInclusion(String s1, String s2) {

      if (s1.length() > s2.length()) {
         return false;
      }

      Map<Character, Integer> map = new HashMap<>();
      for (char c : s1.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }

      int left = 0, right = 0, count = map.size();

      while (right < s2.length()) {

         char rightChar = s2.charAt(right);

         if (map.containsKey(rightChar)) {
            map.put(rightChar, map.get(rightChar) - 1);
            if (map.get(rightChar) == 0) {
               count--;
            }
         }
         right++;

         while (count == 0) {

            if (right - left == s1.length()) {
               return true;
            }

            char leftChar = s2.charAt(left);
            
            if (map.containsKey(leftChar)) {
               map.put(leftChar, map.get(leftChar) + 1);
               if (map.get(leftChar) > 0) {
                  count++;
               }
            }
            left++;
         }
      }

      return false;
   }

   public static void main(String[] args) {

      String s1 = "ab";
      String s2 = "eidbaooo";
      boolean result = new PermutationInString().checkInclusion(s1, s2);
      System.out.println(result); // true

      s1 = "ab";
      s2 = "eidboaoo";
      result = new PermutationInString().checkInclusion(s1, s2);
      System.out.println(result); // false
   }
}