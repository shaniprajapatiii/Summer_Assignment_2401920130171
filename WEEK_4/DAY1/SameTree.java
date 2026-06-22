public class SameTree {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public static boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null) {
         return true;
      }

      if(p == null || q == null) {
         return false;
      }

      if(p.val != q.val) {
         return false;
      }

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }

   public static void main(String[] args) {

      // Tree 1: [1,2,3]
      TreeNode p = new TreeNode(1);
      p.left = new TreeNode(2);
      p.right = new TreeNode(3);

      // Tree 2: [1,2,3]
      TreeNode q = new TreeNode(1);
      q.left = new TreeNode(2);
      q.right = new TreeNode(3);

      boolean result = isSameTree(p, q);
      System.out.println("Are the two trees the same? " + result); // true

      // Tree 3: [1,2]
      TreeNode r = new TreeNode(1);
      r.left = new TreeNode(2);

      boolean result2 = isSameTree(p, r);
      System.out.println("Are the first and third trees the same? " + result2); // false
   }
}
