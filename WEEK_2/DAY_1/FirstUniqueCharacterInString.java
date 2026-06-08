import java.util.*;

public class FirstUniqueCharacterInString {

   public static int firstUniqChar(String s) {

      Map<Character, Integer> map = new HashMap<>();

      for(char c : s.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }

      for(int i = 0; i < s.length(); i++) {
         if (map.get(s.charAt(i)) == 1) {
            return i;
         }
      }

      return -1;
   }
   public static void main(String[] args) {

      String s1 = "leetcode";
      System.out.println(firstUniqChar(s1));

      String s2 = "loveleetcode";
      System.out.println(firstUniqChar(s2));

      String s3 = "aabb";
      System.out.println(firstUniqChar(s3));
   }

}