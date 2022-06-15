class NextPermutation {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int i = size-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>= 0){
            int j = size-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i,j);
        }
        reverse(nums, i+1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
