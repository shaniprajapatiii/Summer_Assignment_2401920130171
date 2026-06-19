import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
   
   public int[] maxSlidingWindow(int[] nums, int k) {

      if(nums == null || nums.length == 0) return new int[0];
      
      int n = nums.length;
      int[] result = new int[n - k + 1];
      Deque<Integer> deque = new LinkedList<>();
      
      for (int i = 0; i < n; i++) {
         // Remove indices that are out of the current window
         while(!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
         }
         
         // Remove indices whose corresponding values are less than nums[i]
         while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
         }

         deque.offerLast(i);
         
         // The front of the deque is the largest element in the current window
         if(i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
         }
      }
      
      return result;
   }

   public static void main(String[] args) {
      SlidingWindowMaximum solution = new SlidingWindowMaximum();
      int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
      int k = 3;
      int[] result = solution.maxSlidingWindow(nums1, k);
      
      for(int num : result) {
         System.out.print(num + " ");
      }

      int[] nums2 = {1, -1};
      int k2 = 1;
      int[] result2 = solution.maxSlidingWindow(nums2, k2);
      for(int num : result2) {
         System.out.print(num + " ");
      }
   }
}
