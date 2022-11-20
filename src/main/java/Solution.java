import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public static void main(String[] args) {
    TwoCityScheduling s = new TwoCityScheduling();

    int[][] test1 = new int[][]{new int[]{10,20}, new int[]{30,200},
            new int[]{400,50},new int[]{30,20}};

    int[][] test2 = new int[][]{new int[]{10,20}, new int[]{30,200},
            new int[]{400,50},new int[]{30,20}};
    int[][] test3 = new int[][]{new int[]{10,20}, new int[]{30,200},
            new int[]{400,50},new int[]{30,20}};
    int ans = s.twoCitySchedCost(test1);
    System.out.println(ans);
  }
}
