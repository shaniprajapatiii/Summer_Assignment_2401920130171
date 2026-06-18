import java.util.Stack;

public class DailyTemperatures {

   public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      int[] answer = new int[n];
      Stack<Integer> stack = new Stack<>();

      for(int i = 0; i < n; i++) {
         while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            int index = stack.pop();
            answer[index] = i - index;
         }
         stack.push(i);
      }

      return answer;
   }

   public static void main(String[] args) {

      DailyTemperatures dt = new DailyTemperatures();
      int[] temperatures1 = { 73, 74, 75, 71, 69, 72, 76, 73 };
      int[] result = dt.dailyTemperatures(temperatures1);

      for(int days : result) {
         System.out.print(days + " ");
      }

      int[] temperatures2 = { 30, 40, 50, 60 };
      result = dt.dailyTemperatures(temperatures2);
      for(int days : result) {
         System.out.print(days + " ");
      }
   }
}
