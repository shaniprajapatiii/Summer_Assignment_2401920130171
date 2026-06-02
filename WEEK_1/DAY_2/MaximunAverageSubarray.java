// import java.util.*;

public class MaximunAverageSubarray {

   public static double findMaxAverage(int[] nums, int k) {

      int n = nums.length;
      int sum = 0;

      for(int i = 0; i < k; i++) {
         sum += nums[i];
      }

      int maxSum = sum;
      for(int i = k; i < n; i++) {
         sum = sum - nums[i - k] + nums[i];
         maxSum = Math.max(maxSum, sum);
      }
      return (double)maxSum / k;
   }

   public static void main(String[] args) {
      int[] nums1 = {1,12,-5,-6,50,3};
      int k1 = 4;

      int[] nums2 = {5};
      int k2 = 1;

      System.out.println(findMaxAverage(nums1, k1));
      System.out.println(findMaxAverage(nums2, k2));
   }
}