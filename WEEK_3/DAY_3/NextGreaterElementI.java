import java.util.Stack;
import java.util.HashMap;

public class NextGreaterElementI {
   
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {

      HashMap<Integer, Integer> map = new HashMap<>();
      Stack<Integer> stack = new Stack<>();

      for(int i = nums2.length - 1; i >= 0; i--) {

         while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
            stack.pop();
         }

         map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
         stack.push(nums2[i]);
      }

      int[] result = new int[nums1.length];
      for(int i = 0; i < nums1.length; i++) {
         result[i] = map.get(nums1[i]);
      }

      return result;
   }

   public static void main(String[] args) {
      NextGreaterElementI nge = new NextGreaterElementI();
      int[] nums1 = {4, 1, 2};
      int[] nums2 = {1, 3, 4, 2};
      int[] result = nge.nextGreaterElement(nums1, nums2);
      for (int num : result) {
         System.out.print(num + " ");
      }
   }
}
