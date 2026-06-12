import java.util.*;

public class StringCompression {
   
   public static int compress(char[] chars) {

      int index = 0;

      for(int i = 0; i < chars.length; i++) {

         char currentChar = chars[i];
         int count = 1;

         while(i + 1 < chars.length && chars[i] == chars[i + 1]) {
            count++;
            i++;
         }

         chars[index++] = currentChar;

         if(count > 1) {
            String countStr = Integer.toString(count);
            for(char c : countStr.toCharArray()) {
               chars[index++] = c;
            }
         }
      }

      return index;
   }

   public static void main(String[] args) {

      char[] chars1 = {'a','a','b','b','c','c','c'};
      int result1 = compress(chars1);
      System.out.println(result1);
      System.out.println(Arrays.toString(chars1));

      char[] chars2 = {'a'};
      int result2 = compress(chars2);
      System.out.println(result2);
      System.out.println(Arrays.toString(chars2));

      char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
      int result3 = compress(chars3);
      System.out.println(result3);
      System.out.println(Arrays.toString(chars3));
   }
}
