import RecurringObjects.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode steps2 = head;
        ListNode steps1 = head;

        while(steps2 != null && steps2.next != null){
            steps2 = steps2.next.next;
            steps1 = steps1.next;
        }
        return steps1;
    }
}
