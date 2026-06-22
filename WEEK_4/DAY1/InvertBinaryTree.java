public class InvertBinaryTree {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public TreeNode invertTree(TreeNode root) {
      if(root == null) {
         return null;
      }

      TreeNode left = invertTree(root.left);
      TreeNode right = invertTree(root.right);

      root.left = right;
      root.right = left;

      return root;
   }

   public static void main(String[] args) {

      InvertBinaryTree solution = new InvertBinaryTree();

      // root = [4,2,7,1,3,6,9]
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(9);

      TreeNode invertedRoot = solution.invertTree(root);
      // inverted tree will be [4,7,2,9,6,3,1]
      System.out.println("Inverted Tree Root: " + invertedRoot.val); // 4
      System.out.println("Left Child of Root: " + invertedRoot.left.val); // 7
      System.out.println("Right Child of Root: " + invertedRoot.right.val); // 2
      System.out.println("Left Child of Left Child: " + invertedRoot.left.left.val); // 9
      System.out.println("Right Child of Left Child: " + invertedRoot.left.right.val); // 6
      System.out.println("Left Child of Right Child: " + invertedRoot.right.left.val); // 3
      System.out.println("Right Child of Right Child: " + invertedRoot.right.right.val); // 1
   }

}
