public class MiddleOfTheLinkedList {
   
   static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }

   public ListNode middleNode(ListNode head) {

      if(head == null) return null;

      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;
   }

   public static void main(String[] args) {

      MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
      // 1 -> 2 -> 3 -> 4 -> 5
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode middleNode = middleOfTheLinkedList.middleNode(head);
      System.out.println("Middle node value: " + middleNode.val); // 3

      MiddleOfTheLinkedList middleOfTheLinkedList2 = new MiddleOfTheLinkedList();
      // 1 -> 2 -> 3 -> 4
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      // Even number of nodes, should return the second middle node

      ListNode middleNode2 = middleOfTheLinkedList2.middleNode(head2);
      System.out.println("Middle node value: " + middleNode2.val); // 3

      MiddleOfTheLinkedList middleOfTheLinkedList3 = new MiddleOfTheLinkedList();
      // empty list
      ListNode head3 = null; // Empty list

      ListNode middleNode3 = middleOfTheLinkedList3.middleNode(head3);
      System.out.println("Middle node value: " + (middleNode3 != null ? middleNode3.val : "null")); // null
   }
}
