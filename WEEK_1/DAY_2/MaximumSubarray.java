public class MaximumSubarray {

   // Kadane's Algorithm
   public static int maxSubArray2(int[] nums) {
      int sum = 0;
      int maxSum = Integer.MIN_VALUE;

      for(int i = 0; i < nums.length; i++) {

         if(sum < 0) sum = 0;

         sum += nums[i];
         maxSum = Math.max(sum, maxSum);
      }
      return maxSum;
   }
   
   // divide and conquer approach
   public static int maxSubArray(int[] nums) {



      return -1;
   }


   public static void main(String[] args) {
      int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
      int[] nums2 = {1};
      int[] nums3 = {5,4,-1,7,8};
      System.out.println(maxSubArray2(nums1)); // Output: 6
      System.out.println(maxSubArray2(nums2)); // Output: 1
      System.out.println(maxSubArray2(nums3)); // Output: 23
   }
}