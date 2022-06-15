package RecurringObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FooBar {

  public static void main(String[] args) {

    long start = System.currentTimeMillis();
    int[] solution = solution(30, new int[]{15,9,7, 3, 4, 1});
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println(timeElapsed);
    //Arrays.stream(solution).forEach(System.out::println);
  }

  public static int[] solution(int h, int[] q) {
    //  public static int getParent(int target, int height) {
    int[] sol = new int[500001];
    Map<Integer, Integer> sonParentRelationShips = new HashMap<>();
    sonParentRelationShips.put(1,3);
    sonParentRelationShips.put(2,3);
    sonParentRelationShips.put(4,6);
    sonParentRelationShips.put(5,6);
    sonParentRelationShips.put(8,10);
    sonParentRelationShips.put(9,10);
    sonParentRelationShips.put(11,13);
    sonParentRelationShips.put(12,13);
    sonParentRelationShips.put(3,7);
    sonParentRelationShips.put(6,7);
    sonParentRelationShips.put(10,14);
    sonParentRelationShips.put(13,14);
    sonParentRelationShips.put(7,15);
    sonParentRelationShips.put(14,15);
    int i = 0;
    while(i < 500000){
      i++;
      //for (int i = 0; i < q.length; i++) {
      //int target = q[i];
      int target = i;
      int height = h;
      int rootVal = (int) Math.pow(2, height) - 1;
      if(target > rootVal) {
        sol[i] = -1;
        continue;
      }
      if(sonParentRelationShips.containsKey(target)) {
        sol[i] = sonParentRelationShips.get(target);
        continue;
      }

      boolean foundSolution = false;
      while (height > 0) {
        height--;
        int leftIndex = rootVal - (int) Math.pow(2, height);
        int rightIndex = rootVal - 1;
        sonParentRelationShips.put(leftIndex, rootVal);
        sonParentRelationShips.put(rightIndex, rootVal);
        if (target == leftIndex || target == rightIndex) {
          sol[i] = rootVal;
          foundSolution = true;
          break;
        }
        rootVal = (target < leftIndex ? leftIndex : rightIndex);
      }
      if(!foundSolution)
        sol[i] = -1;
    }
    return sol;
  }

}
