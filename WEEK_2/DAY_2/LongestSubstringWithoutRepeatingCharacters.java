import java.util.*; 

public class LongestSubstringWithoutRepeatingCharacters {

   public int lengthOfLongestSubstring(String s) {

      Set<Character> seen = new HashSet<>();
      int left = 0, maxLength = 0;

      for (int i = 0; i < s.length(); i++) {
         char currChar = s.charAt(i);

         while (seen.contains(currChar)) {
            seen.remove(s.charAt(left));
            left++;
         }

         seen.add(currChar);
         maxLength = Math.max(maxLength, i - left + 1);
      }

      return maxLength;
   }

   public static void main(String[] args) {

      LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

      System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
      System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // 1
      System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // 3
   }
}