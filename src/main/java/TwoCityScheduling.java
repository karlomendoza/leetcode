import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] cost){
        int ans = 0;
        if(cost.length == 0)
            return ans;

        for (int[] candidateCost: cost) {
            ans += candidateCost[0];
        }
        int[] diff = new int[cost.length];
        for (int i = 0; i < cost.length; i ++) {
            diff[i] = cost[i][1] - cost[i][0];
        }

        Arrays.sort(diff);

        for (int i = 0; i <cost.length/2 ; i++) {
            ans = ans + diff[i];
        }

        return ans;
    }
}
