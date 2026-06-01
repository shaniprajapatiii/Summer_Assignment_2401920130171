import java.util.*;

public class BuyAndSellStock {

   public static int maxProfit(int[] prices) {

      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

      for (int price : prices) {

         if (price < minPrice) {
            minPrice = price;
         } 
         else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice;
         }
      }
      return maxProfit;
   }

   public static void main(String[] args) {
      
      int[] prices1 = { 7, 1, 5, 3, 6, 4 };
      System.out.println(maxProfit(prices1));

      int[] prices2 = { 1, 2, 3, 4, 5 };
      System.out.println(maxProfit(prices2));

      int[] prices3 = { 7, 6, 4, 3, 1 };
      System.out.println(maxProfit(prices3));
   }

}