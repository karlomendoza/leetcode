public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);
    ListNode tail = result;
    int carryout = 0;
    boolean firstPass = true;
    while(l1 != null || l2 != null){
      int sum = 0;
      if(l1 != null && l2 != null){
        int tmp = l1.val + l2.val + carryout;

        sum = tmp % 10;
        carryout = tmp/10;
        l1 = l1.next;
        l2 = l2.next;
      } else if(l1 == null){
        int tmp = l2.val + carryout;
        sum = tmp%10;
        carryout = tmp/10;
        l2 = l2.next;
      } else if (l2 == null){
        int tmp = l1.val + carryout;
        sum = tmp%10;
        carryout = tmp/10;
        l1 = l1.next;
      }
      if( firstPass ){
        tail.val = sum;
        firstPass = false;
      } else {
        tail.next = new ListNode(sum);
        tail = tail.next;
      }
    }
    if(carryout > 0)
      tail.next = new ListNode(carryout);
    return result;
  }
}
