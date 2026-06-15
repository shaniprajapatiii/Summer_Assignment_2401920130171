public class LinkedListCycle {

   static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }

   public boolean hasCycle(ListNode head) {

      if (head == null || head.next == null) {
         return false;
      }

      ListNode slow = head;
      ListNode fast = head.next;
      while (fast != null && fast.next != null) {
         if (slow == fast) {
            return true;
         }
         slow = slow.next;
         fast = fast.next.next;
      }
      return false;
   }

   public static void main(String[] args) {
      
      LinkedListCycle linkedListCycle = new LinkedListCycle();
      ListNode head = new ListNode(3);
      head.next = new ListNode(2);
      head.next.next = new ListNode(0);
      head.next.next.next = new ListNode(-4);
      head.next.next.next.next = head.next; // Create a cycle

      boolean hasCycle = linkedListCycle.hasCycle(head);
      System.out.println("Linked list has cycle: " + hasCycle); // Output: true

      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      // No cycle in this list

      boolean hasCycle2 = linkedListCycle.hasCycle(head2);
      System.out.println("Linked list has cycle: " + hasCycle2); // Output: false
   }
}