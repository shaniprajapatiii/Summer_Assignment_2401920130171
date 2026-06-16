public class RemoveNthNodeFromEndOfList {
   
   static class ListNode {
      int val;
      ListNode next;

      ListNode(int val) {
         this.val = val;
         this.next = null;
      }
   }

   public ListNode removeNthFromEnd(ListNode head, int n) {

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode first = dummy;
      ListNode second = dummy;

      for (int i = 0; i <= n; i++) {
         first = first.next;
      }

      while (first != null) {
         first = first.next;
         second = second.next;
      }

      second.next = second.next.next;

      return dummy.next; //skipping the dummy node
   }

   public static void main(String[] args) {
      RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

      // 1 -> 2 -> 3 -> 4 -> 5
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      int n = 2;
      ListNode modifiedHead = solution.removeNthFromEnd(head, n);

      // modified list should be 1 -> 2 -> 3 -> 5
      while (modifiedHead != null) {
         System.out.print(modifiedHead.val + " ");
         modifiedHead = modifiedHead.next;
      }
   }
}
