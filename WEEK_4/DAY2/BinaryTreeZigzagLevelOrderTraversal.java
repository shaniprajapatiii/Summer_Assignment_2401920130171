import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

      List<List<Integer>> result = new ArrayList<>();
      if(root == null) {
         return result;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      boolean leftToRight = true;

      while(!queue.isEmpty()) {

         int levelSize = queue.size();
         List<Integer> currLevel = new ArrayList<>(levelSize);

         for (int i = 0; i < levelSize; i++) {
            TreeNode currNode = queue.poll();

            if(leftToRight) {
               currLevel.add(currNode.val);
            }
            else {
               currLevel.add(0, currNode.val); // Add to the front for right-to-left order
            }

            if(currNode.left != null) {
               queue.offer(currNode.left);
            }
            if(currNode.right != null) {
               queue.offer(currNode.right);
            }
         }

         result.add(currLevel);
         leftToRight = !leftToRight;
      }

      return result;
   }

   public static void main(String[] args) {

      BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      List<List<Integer>> result = solution.zigzagLevelOrder(root);

      System.out.println(result); // Output: [[3], [20, 9], [15, 7]]
   }
}
