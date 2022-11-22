public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pivotsRight = new int[n+1];
        int[] pivotsLeft = new int[n+1];

        pivotsRight[0] = 0;
        pivotsRight[1] = nums[0];
        pivotsLeft[n] = 0;
        pivotsLeft[n-1] = nums[n-1];

        for(int i = 2; i <= n; i++){
            pivotsRight[i] = pivotsRight[i-1] + nums[i-1];
            pivotsLeft[n-i] = pivotsLeft[n-i+1] + nums[n-i];
        }

        for(int i = 0; i < n; i++){
            if(pivotsRight[i] == pivotsLeft[i+1])
                return i;
        }
        return -1;
    }
}
