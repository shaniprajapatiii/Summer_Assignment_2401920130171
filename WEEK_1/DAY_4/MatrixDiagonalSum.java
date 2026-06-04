public class MatrixDiagonalSum {

   public static int diagonalSum(int[][] mat) {
      int n = mat.length;
      int sum = 0;

      for(int i = 0; i < n; i++) {
         sum += mat[i][i];
         sum += mat[i][n - 1 - i];
      }

      // subtract the middle element which was added twice when n is odd
      if(n % 2 == 1) {
         sum -= mat[n / 2][n / 2];
      }

      return sum;
   }
   
   public static void main(String[] args) {
      
      int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

      int[][] mat2 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

      System.out.println("Diagonal Sum of Matrix 1: " + diagonalSum(mat1)); // 25
      System.out.println("Diagonal Sum of Matrix 2: " + diagonalSum(mat2)); // 9
   }
}