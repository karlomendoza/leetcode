import RecurringObjects.ListNode;

public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode tail = head;
    ListNode delayedHead = head;

    // only one node case
    if (head.next == null)
      return null;

    //two node case
    if (head.next.next == null){
      if(n == 1){
        tail.next = null;
        return tail;
      } else {
        return head.next;
      }
    }

    boolean deleteFirstOne = false;
    for(int i =0; i < n ; i++){
      head = head.next;
      if ( head.next == null && i +1 < n){
        // since we hit the last node and we still should going
        deleteFirstOne = true;
        break;
      }
    }

    while(head.next != null){
      delayedHead = delayedHead.next;
      head = head.next;
    }

    if(deleteFirstOne)
      tail = tail.next;
    delayedHead.next = delayedHead.next.next;

    return tail;
  }
}
