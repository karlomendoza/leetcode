class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        
        int pivot = 0;
        
        if(nums[0] < 0)
            pivot = findPivot(nums);
        
        int left = pivot-1;
        int right = pivot;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(left < 0){
                ans[i] = (int) Math.pow(nums[right],2);
                right++;
            } else if ( right >= nums.length){
                ans[i] = (int) Math.pow(nums[left],2);
                left--;
            } else {
                if(Math.abs(nums[left]) > Math.abs(nums[right])){
                    ans[i] = (int) Math.pow(nums[right],2);
                    right++;
                } else {
                    ans[i] = (int) Math.pow(nums[left],2);
                    left--;
                }
            }
        }
        return ans;
        
    }
    
    private int findPivot(int[] nums){
        int pivot = 0;
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            pivot = left + (right-left)/2;
            if(nums[pivot] == 0)
                return pivot;
            if(nums[pivot] < 0)
                left = pivot+1;
            else
                right = pivot;
        }
        return right;
    }
    
}
