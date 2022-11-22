public class RunningSum1dArray {

    public int[] runningSum(int[] nums) {
        //No need to have the extra memory of ans. We can do it inplace using same nums
        //int[] ans = new int[nums.length];
        //ans[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
