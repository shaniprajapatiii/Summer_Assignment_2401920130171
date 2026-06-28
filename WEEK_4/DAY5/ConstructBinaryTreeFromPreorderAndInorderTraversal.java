public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null || preorder.length != inorder.length) {
         return null;
      }
      return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
   }

   private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

      if(preStart > preEnd || inStart > inEnd) {
         return null;
      }

      int rootVal = preorder[preStart];
      TreeNode root = new TreeNode(rootVal);

      int rootIndexInInorder = inStart;
      while(rootIndexInInorder <= inEnd && inorder[rootIndexInInorder] != rootVal) {
         rootIndexInInorder++;
      }

      int leftSubtreeSize = rootIndexInInorder - inStart;

      root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndexInInorder - 1);

      root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndexInInorder + 1, inEnd);

      return root;
   }

   public static void main(String[] args) {

      ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

      int[] preorder = {3, 9, 20, 15, 7};
      int[] inorder = {9, 3, 15, 20, 7};

      TreeNode root = solution.buildTree(preorder, inorder);
      System.out.println("Root Value: " + root.val); // Output: 3
   }
}
