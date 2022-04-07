import RecurringObjects.ListNode;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode head = result;

    if(l1 == null)
      return l2;
    if(l2 == null)
      return l1;

    while(l1 != null || l2 != null){
      if(l1 == null){
        head.next = l2;
        return result;
      }
      if(l2 == null){
        head.next = l1;
        return result;
      }

      if(l1.val < l2.val){
        head.val = l1.val;
        l1 = l1.next;
      } else {
        head.val = l2.val;
        l2 = l2.next;
      }

      if(l1 != null && l2 != null){
        head.next = new ListNode();
        head = head.next;
      }

    }
    return result;
  }
}
