import java.util.*; 

public class AllAnagramsInString {

   public List<Integer> findAnagrams(String s, String p) {

      List<Integer> result = new ArrayList<>();
      if (s == null || p == null || s.length() < p.length()) {
         return result;
      }

      Map<Character, Integer> map = new HashMap<>();
      for (char c : p.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }

      int left = 0, right = 0, count = map.size();

      while (right < s.length()) {

         char rightChar = s.charAt(right);

         if(map.containsKey(rightChar)) {
            map.put(rightChar, map.get(rightChar) - 1);
            if(map.get(rightChar) == 0) {
               count--;
            }
         }
         right++;

         while(count == 0) {

            if(right - left == p.length()) {
               result.add(left);
            }

            char leftChar = s.charAt(left);
            
            if(map.containsKey(leftChar)) {
               map.put(leftChar, map.get(leftChar) + 1);
               if(map.get(leftChar) > 0) {
                  count++;
               }
            }
            left++;
         }
      }

      return result;
   }

   public static void main(String[] args) {

      String s1 = "cbaebabacd";
      String p1 = "abc";
      List<Integer> anagramIndices = new AllAnagramsInString().findAnagrams(s1, p1);
      System.out.println(anagramIndices); // [0, 6]

      String s2 = "abab";
      String p2 = "ab";
      anagramIndices = new AllAnagramsInString().findAnagrams(s2, p2);
      System.out.println(anagramIndices); // [0, 1, 2]
   }
}