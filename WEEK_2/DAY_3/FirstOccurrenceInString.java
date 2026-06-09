public class FirstOccurrenceInString {
   
   public static int firstOccurrence(String str, char target) {
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) == target) {
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      String str1 = "hello world";
      char target = 'o';
      int index = firstOccurrence(str1, target);
      if (index != -1) {
         System.out.println("First occurrence of '" + target + "' is at index: " + index);
      } else {
         System.out.println("Character '" + target + "' not found in the string.");
      }

      String str2 = "programming";
      char target2 = 'z';
      int index2 = firstOccurrence(str2, target2);
      if (index2 != -1) {
         System.out.println("First occurrence of '" + target2 + "' is at index: " + index2);
      } else {
         System.out.println("Character '" + target2 + "' not found in the string.");
      }
   }
}