import java.util.*;
public class TwoSum {

   public int[] twoSum(int[] nums, int target) {

      Map<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i < nums.length; i++) {
         int y = target - nums[i];

         if (map.containsKey(y)) {
            return new int[] { map.get(y), i };
         }
         map.put(nums[i], i);
      }
      return new int[] { -1, -1 };
   }

   public static void main(String[] args) {

      int[] nums1 = { 2, 7, 11, 15 };
      int[] nums2 = { 3, 2, 4 };
      int[] nums3 = { 3, 3 };
      int target = 9;

      System.out.println(Arrays.toString(new TwoSum().twoSum(nums1, target)));
      System.out.println(Arrays.toString(new TwoSum().twoSum(nums2, target)));
      System.out.println(Arrays.toString(new TwoSum().twoSum(nums3, target)));
   }
}