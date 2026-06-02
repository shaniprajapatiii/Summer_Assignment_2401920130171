import java.util.*;

public class ContainsDuplicate {

   public static boolean containsDuplicate(int[] nums) {

      HashSet<Integer> set = new HashSet<>();
      for(int num : nums) {
         if(set.contains(num)) return true;
         set.add(num);
      }
      return false;
   }

   public static void main(String[] args) {
      int[] nums1 = {1, 2, 3, 1};
      int[] nums2 = {1, 2, 3, 4};
      int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

      System.out.println(containsDuplicate(nums1));
      System.out.println(containsDuplicate(nums2));
      System.out.println(containsDuplicate(nums3));
   }
}