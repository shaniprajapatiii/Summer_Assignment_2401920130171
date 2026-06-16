public class MergeTwoSortedLists {

   static class ListNode {
      int val;
      ListNode next;

      ListNode(int val) {
         this.val = val;
         this.next = null;
      }
   }

   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

      if(list1 == null) return list2;
      if (list2 == null) return list1;

      ListNode head = new ListNode(0);
      ListNode curr = head;

      while(list1 != null && list2 != null) {

         if(list1.val < list2.val) {
            curr.next = list1;
            list1 = list1.next;
         }
         else {
            curr.next = list2;
            list2 = list2.next;
         }
         curr = curr.next;
      }

      if(list1 != null) {
         curr.next = list1;
      }
      else {
         curr.next = list2;
      }

      return head.next; //skipping the dummy node
   }

   public static void main(String[] args) {
      MergeTwoSortedLists solution = new MergeTwoSortedLists();

      // 1 -> 2 -> 4
      ListNode list1 = new ListNode(1);
      list1.next = new ListNode(2);
      list1.next.next = new ListNode(4);

      // 1 -> 3 -> 4
      ListNode list2 = new ListNode(1);
      list2.next = new ListNode(3);
      list2.next.next = new ListNode(4);

      // merged list be 1 -> 1 -> 2 -> 3 -> 4 -> 4
      ListNode mergedList = solution.mergeTwoLists(list1, list2);

      while (mergedList != null) {
         System.out.print(mergedList.val + " ");
         mergedList = mergedList.next;
      }
   }
}