import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorderHelper(root, result);
      return result;
   }

   private void inorderHelper(TreeNode node, List<Integer> result) {
      if (node == null) {
         return;
      }
      inorderHelper(node.left, result);
      result.add(node.val);
      inorderHelper(node.right, result);
   }

   public static void main(String[] args) {
      BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

      // Create a sample binary tree
      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(3);

      List<Integer> result = solution.inorderTraversal(root);

      System.out.println(result); // Output: [1, 3, 2]
   }
}
