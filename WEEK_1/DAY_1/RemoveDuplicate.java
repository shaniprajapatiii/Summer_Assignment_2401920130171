import java.util.*;
public class RemoveDuplicate {

   public static int[] removeDuplicates(int[] arr) {

      int insertIdx = 1; // Start from second element

      for (int i = 1; i < arr.length; i++) {

         if (arr[i] != arr[insertIdx - 1]) {
            arr[insertIdx] = arr[i];
            insertIdx++;
         }
      }
      return Arrays.copyOf(arr, insertIdx);
   }

   public static void main(String[] args) {

      int[] arr1 = { 1, 1, 2, 2, 3 };
      int[] result1 = removeDuplicates(arr1);
      System.out.println(Arrays.toString(result1));

      int[] arr2 = { 1, 1, 1, 1, 1 };
      int[] result2 = removeDuplicates(arr2);
      System.out.println(Arrays.toString(result2));

      int[] arr3 = { 1, 2, 3, 4, 5, 5, 5, 6 };
      int[] result3 = removeDuplicates(arr3);
      System.out.println(Arrays.toString(result3));
   }

}