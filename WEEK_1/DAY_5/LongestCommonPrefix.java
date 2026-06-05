import java.util.Arrays;

public class LongestCommonPrefix {

   public static String longestCommonPrefix(String[] strs) {

      StringBuilder ans = new StringBuilder();
      Arrays.sort(strs);

      String first = strs[0];
      String last = strs[strs.length - 1];

      for (int i = 0; i < Math.min(first.length(), last.length()); i++) {

         if (first.charAt(i) != last.charAt(i)) {
            return ans.toString();
         }
         ans.append(first.charAt(i));
      }
      return ans.toString();
   }

   public static void main(String[] args) {

      String[] strs1 = { "flower", "flow", "flight" };
      System.out.println(LongestCommonPrefix.longestCommonPrefix(strs1));

      String[] strs2 = { "dog", "racecar", "car" };
      System.out.println(LongestCommonPrefix.longestCommonPrefix(strs2));

      String[] strs3 = { "interspecies", "interstellar", "interstate" };
      System.out.println(LongestCommonPrefix.longestCommonPrefix(strs3));
   }
}