public class BinaryTreeMaximumPathSum {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   static int maxSum = Integer.MIN_VALUE;

   public int maxPathSum(TreeNode root) {
      maxSum = Integer.MIN_VALUE;
      maxGain(root);
      return maxSum;
   }

   private int maxGain(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int leftGain = Math.max(maxGain(node.left), 0);
      int rightGain = Math.max(maxGain(node.right), 0);

      int currentPathSum = node.val + leftGain + rightGain;

      maxSum = Math.max(maxSum, currentPathSum);

      return node.val + Math.max(leftGain, rightGain);
   }

   public static void main(String[] args) {

      BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      int result = solution.maxPathSum(root);
      System.out.println("Maximum Path Sum: " + result); // 42
   }
}
