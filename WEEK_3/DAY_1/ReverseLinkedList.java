public class ReverseLinkedList {
   
   static class ListNode {
      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }

   public ListNode reverseList(ListNode head) {

      ListNode prev = null;
      ListNode current = head;

      while(current != null) {
         ListNode nextTemp = current.next;
         current.next = prev;
         prev = current;
         current = nextTemp;
      }
      return prev;
   }

   public static void main(String[] args) {

      ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);

      ListNode reversedHead = reverseLinkedList.reverseList(head);
      printList(reversedHead); // 5 -> 4 -> 3 -> 2 -> 1

      ReverseLinkedList reverseLinkedList2 = new ReverseLinkedList();
      ListNode head2 = new ListNode(1);
      ListNode reversedHead2 = reverseLinkedList2.reverseList(head2);
      printList(reversedHead2); // 1

      ReverseLinkedList reverseLinkedList3 = new ReverseLinkedList();
      ListNode head3 = null;
      ListNode reversedHead3 = reverseLinkedList3.reverseList(head3);
      printList(reversedHead3); // (empty list)
   }

   private static void printList(ListNode head) {
      ListNode current = head;

      while(current != null) {
         System.out.print(current.val);
         if(current.next != null) {
            System.out.print(" -> ");
         }
         current = current.next;
      }
      System.out.println();
   }
}
