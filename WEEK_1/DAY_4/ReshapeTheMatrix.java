public class ReshapeTheMatrix {

   public static int[][] matrixReshape(int[][] mat, int r, int c) {
      int m = mat.length;
      int n = mat[0].length;

      if (m * n != r * c) {
         return mat;
      }

      int[][] reshaped = new int[r][c];

      for(int i = 0; i < m * n; i++) {

         reshaped[i / c][i % c] = mat[i / n][i % n];
      }
      
      return reshaped;
   }
   
   public static void main(String[] args) {
      
      int[][] mat1 = { { 1, 2 }, { 3, 4 } };
      int r1 = 1;
      int c1 = 4;
      
      int[][] mat2 = { { 1, 2 }, { 3, 4 } };
      int r2 = 2;
      int c2 = 4;
      
      int[][] result1 = matrixReshape(mat1, r1, c1);
      int[][] result2 = matrixReshape(mat2, r2, c2);
      
      System.out.println("Reshaped Matrix 1:");
      for(int[] row : result1) {
         for(int num : row) {
            System.out.print(num + " ");
         }
         System.out.println();
      }
      
      System.out.println("Reshaped Matrix 2:");
      for(int[] row : result2) {
         for(int num : row) {
            System.out.print(num + " ");
         }
         System.out.println();
      }
   }
}
// i / c gives the row index in the reshaped matrix.
// i % c gives the column index in the reshaped matrix.
// i / n gives the row index in the original matrix.
// i % n gives the column index in the original matrix.