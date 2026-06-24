public class ValidateBinarySearchTree {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public boolean isValidBST(TreeNode root) {
      return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
   }

   private boolean isValidBSTHelper(TreeNode node, long min, long max) {
      if(node == null) {
         return true;
      }
      if(node.val <= min || node.val >= max) {
         return false;
      }
      return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
   }

   public static void main(String[] args) {

      ValidateBinarySearchTree validateBST = new ValidateBinarySearchTree();

      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);

      boolean isValid = validateBST.isValidBST(root);
      System.out.println("Is the binary tree a valid BST? " + isValid);
   }
}
