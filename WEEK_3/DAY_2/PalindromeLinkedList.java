public class PalindromeLinkedList {
   
   static class ListNode {
      int val;
      ListNode next;

      ListNode(int val) {
         this.val = val;
         this.next = null;
      }
   }

   public boolean isPalindrome(ListNode head) {

      if (head == null || head.next == null) return true;

      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      ListNode prev = null;
      ListNode curr = slow;

      while (curr != null) {
         ListNode nextTemp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = nextTemp;
      }

      ListNode firstHalf = head;
      ListNode secondHalf = prev;

      while (secondHalf != null) {
         if (firstHalf.val != secondHalf.val) {
            return false; // Not a palindrome
         }
         firstHalf = firstHalf.next;
         secondHalf = secondHalf.next;
      }

      return true;
   }

   public static void main(String[] args) {
      PalindromeLinkedList solution = new PalindromeLinkedList();

      // 1 -> 2 -> 2 -> 1
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(2);
      head.next.next.next = new ListNode(1);

      boolean result = solution.isPalindrome(head);
      System.out.println("Is the linked list a palindrome? " + result); // true

      // 1 -> 2
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      boolean result2 = solution.isPalindrome(head2);
      System.out.println("Is the linked list a palindrome? " + result2); // false
   }
}
