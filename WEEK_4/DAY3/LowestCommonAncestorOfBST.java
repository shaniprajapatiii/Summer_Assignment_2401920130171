public class LowestCommonAncestorOfBST {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

      while(root != null) {
         
         if(p.val < root.val && q.val < root.val) {
            root = root.left;
         }
         else if (p.val > root.val && q.val > root.val) {
            root = root.right;
         }
         else {
            return root;
         }
      }
      return null;
   }

   public static void main(String[] args) {

      LowestCommonAncestorOfBST lca = new LowestCommonAncestorOfBST();

      TreeNode root = new TreeNode(6);
      root.left = new TreeNode(2);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(0);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(7);
      root.right.right = new TreeNode(9);
      root.left.right.left = new TreeNode(3);
      root.left.right.right = new TreeNode(5);

      TreeNode p = root.left; // Node with value 2
      TreeNode q = root.left.right; // Node with value 4

      TreeNode ancestor = lca.lowestCommonAncestor(root, p, q);
      System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + ancestor.val);
   }
}
