import RecurringObjects.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode steps2 = head;
        ListNode steps1 = head;
        while(steps2 != null && steps2.next != null){
            steps2 = steps2.next.next;
            steps1 = steps1.next;
            if(steps2 == steps1)
                break;
        }
        if(steps2 == null || steps2.next == null)
            return null;
        while(steps1 != head){
            steps1 = steps1.next;
            head = head.next;
        }
        return head;
    }
}
