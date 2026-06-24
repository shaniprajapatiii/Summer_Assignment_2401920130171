

public class SearchInABinarySearchTree {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public TreeNode searchBST(TreeNode root, int val) {

      if(root == null || root.val == val) {
         return root;
      }
      if(val < root.val) {
         return searchBST(root.left, val);
      }
      else {
         return searchBST(root.right, val);
      }
   }

   public static void main(String[] args) {

      SearchInABinarySearchTree searchBST = new SearchInABinarySearchTree();

      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);

      int valToSearch = 2;
      TreeNode result = searchBST.searchBST(root, valToSearch);

      if(result != null) {
         System.out.println("Node with value " + valToSearch + " found: " + result.val);
      }
      else {
         System.out.println("Node with value " + valToSearch + " not found.");
      }
   }
}
