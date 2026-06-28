public class SerializeAndDeserializeBinaryTree {
   
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }

   public String serialize(TreeNode root) {
      if (root == null) {
         return "null";
      }
      return root.val + "," + serialize(root.left) + "," + serialize(root.right);
   }

   public TreeNode deserialize(String data) {
      String[] nodes = data.split(",");
      int[] index = {0}; // Use an array to keep track of the current index
      return deserializeHelper(nodes, index);
   }

   private TreeNode deserializeHelper(String[] nodes, int[] index) {
      String val = nodes[index[0]++];
      if (val.equals("null")) {
         return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(val));
      root.left = deserializeHelper(nodes, index);
      root.right = deserializeHelper(nodes, index);
      return root;
   }

   public static void main(String[] args) {

      SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();

      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(5);

      String serializedData = solution.serialize(root);
      System.out.println("Serialized Data: " + serializedData); // Output: 1,2,null,null,3,4,null,null,5,null,null

      TreeNode deserializedRoot = solution.deserialize(serializedData);
      System.out.println("Deserialized Root Value: " + deserializedRoot.val); // Output: 1
   }
}
