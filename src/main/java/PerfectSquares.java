import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for(int i = 1; i <= n; i++){
            int j =1;
            int min = Integer.MAX_VALUE;
            while(i - j*j >= 0){
                min = Math.min(min, ans[i-j*j]+1);
                j++;
            }
            ans[i] = min;
        }

        return ans[n];
    }
}
