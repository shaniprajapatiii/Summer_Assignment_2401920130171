public class PathSum {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
         return false;
      }

      if (root.left == null && root.right == null) {
         return targetSum == root.val;
      }

      int newTargetSum = targetSum - root.val;
      return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
   }

   public static void main(String[] args) {

      PathSum solution = new PathSum();

      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(11);
      root.right.left = new TreeNode(13);
      root.right.right = new TreeNode(4);
      root.left.left.left = new TreeNode(7);
      root.left.left.right = new TreeNode(2);
      root.right.right.right = new TreeNode(1);

      int targetSum = 22;
      boolean result = solution.hasPathSum(root, targetSum);
      System.out.println("Has Path Sum: " + result); // true
   }
}
