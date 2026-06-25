public class DiameterOfBinaryTree {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   static int maxDiameter = 0;

   public int diameterOfBinaryTree(TreeNode root) {
      maxDiameter = 0;
      depth(root);
      return maxDiameter;
   }

   private int depth(TreeNode node) {
      if(node == null) {
         return 0;
      }

      int leftDepth = depth(node.left);
      int rightDepth = depth(node.right);

      maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

      return Math.max(leftDepth, rightDepth) + 1;
   }

   public static void main(String[] args) {

      DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);

      int result = solution.diameterOfBinaryTree(root);
      System.out.println("Diameter of Binary Tree: " + result); // 3
   }
}
