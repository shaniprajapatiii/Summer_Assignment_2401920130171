import java.util.*;

public class GroupAnagrams {
   
   public static List<List<String>> groupAnagram(String[] strs) {

      Map<String, List<String>> map = new HashMap<>();

      for(String str : strs) {

         char[] ch = str.toCharArray();
         Arrays.sort(ch);
         String sortedStr = new String(ch);

         if(!map.containsKey(sortedStr)) {
            map.put(sortedStr, new ArrayList<>());
         }
         map.get(sortedStr).add(str);
      }

      return new ArrayList<>(map.values());
   }

   public static void main(String[] args) {

      String[] strs1  = {"eat","tea","tan","ate","nat","bat"};
      List<List<String>> result1 = groupAnagram(strs1);
      System.out.println(result1);

      String[] strs2  = {""};
      List<List<String>> result2 = groupAnagram(strs2);
      System.out.println(result2);

      String[] strs3  = {"a"};
      List<List<String>> result3 = groupAnagram(strs3);
      System.out.println(result3);
   }
}
