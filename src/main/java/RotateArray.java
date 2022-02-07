class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;

        voltear(nums, 0, nums.length-1);
        voltear(nums, 0, k-1);
        voltear(nums,k,nums.length-1);            
    }
    
    private void voltear(int[] nums, int left, int right){
        int tmp = 0;
        
        while(left < right){
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
         }
    }
}
