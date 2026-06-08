import java.util.*;

public class RansomNote {

   public static boolean canConstruct(String ransomNote, String magazine) {

      Map<Character, Integer> map = new HashMap<>();

      for(char c : magazine.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }

      for(char c : ransomNote.toCharArray()) {
         if(!map.containsKey(c) || map.get(c) == 0) {
            return false;
         }
         map.put(c, map.get(c) - 1);
      }

      return true;
   }

   public static void main(String[] args) {
      String ransomNote1 = "a";
      String magazine1 = "b";
      System.out.println(canConstruct(ransomNote1, magazine1)); // false

      String ransomNote2 = "aa";
      String magazine2 = "ab";
      System.out.println(canConstruct(ransomNote2, magazine2)); // false

      String ransomNote3 = "aa";
      String magazine3 = "aab";
      System.out.println(canConstruct(ransomNote3, magazine3)); // true
   }

}