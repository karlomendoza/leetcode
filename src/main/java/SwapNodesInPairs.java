import RecurringObjects.ListNode;
import java.util.Stack;

public class SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.add(head);
      head = head.next;
    }
    boolean firstTime = true;

    ListNode tmpPop = null;
    ListNode pop = null;
    Boolean isOdd = false;
    if (stack.size() == 1)
      return stack.pop();
    if (stack.size() % 2 != 0) {
      tmpPop = stack.pop();
      isOdd = true;
    }

    while (!stack.isEmpty()) {
      pop = stack.pop();
      ListNode pop1 = stack.pop();

      if (firstTime) {
        if (isOdd) {
          pop1.next = tmpPop;
        } else {
          pop1.next = null;
        }
        firstTime = false;
      } else {
        pop1.next = tmpPop;
      }
      pop.next = pop1;
      tmpPop = pop;
    }
    return pop;

  }
}
