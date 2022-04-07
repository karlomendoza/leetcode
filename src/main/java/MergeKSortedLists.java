import RecurringObjects.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0 )
            return null;
        
        int interval = 1;
        
        while(interval < size){
            
            for(int i = 0; i +interval < size; i = i + 2*interval){
                lists[i] = merge2Lists(lists[i], lists[i+interval]);
            }
            interval = interval*2;
        }
        return lists[0];
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode head = ans;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.next = l1;
                ans = ans.next;
                l1 = l1.next;
            } else {
                ans.next = l2;
                ans = ans.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            ans.next = l1;
        if(l2 != null)
            ans.next = l2;
        
        return head.next;
        
    }
}
