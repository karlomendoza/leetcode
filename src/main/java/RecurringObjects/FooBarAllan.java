package RecurringObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FooBarAllan {

  public static void main(String[] args) {
    FooBarAllan fba = new FooBarAllan();

    int[] solution = solution(4, new int[]{7, 3, 5, 1});

    Arrays.stream(solution).forEach(System.out::println);
  }
  public static int[] solution(int h, int[] q) {

    Map<Integer, Integer> magicNumbers = new HashMap();
    magicNumbers.put(1, 3);
    magicNumbers.put(2, 3);
    magicNumbers.put(3, 7);
    magicNumbers.put(7, 15);
    //magicNumbers.put(15, 31);
    magicNumbers.put(31, 63);
    magicNumbers.put(63, 127);
    magicNumbers.put(Integer.MAX_VALUE - 1, -1);
    int[] p = new int[q.length];

    for (int i = 0; i < q.length; i++) {
      int child = q[i];
      if (magicNumbers.containsKey(child)) {
        p[i] = magicNumbers.get(child);
        continue;
      }
      int maxValue = Integer.MAX_VALUE - 1;
      maxValue = maxValue >> 1;
      while (maxValue > child) {
        maxValue = maxValue >> 1;
      }
      int offset = 0;
      while (!magicNumbers.containsKey(child)) {
        while (maxValue > child) {
          maxValue = maxValue >> 1;
        }
        offset += maxValue;
        child -= maxValue;
        maxValue = maxValue >> 1;
      }

      if (child > 3 && magicNumbers.containsKey(magicNumbers.get(child))) {
        p[i] = magicNumbers.get(magicNumbers.get(child));
      } else {
        p[i] = magicNumbers.get(child) + offset;
      }
    }
    return p;
  }
}
