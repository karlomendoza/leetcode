public class PartitionArrayIntoDisjointIntervals {
  public int partitionDisjoint(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    int maxLeft = nums[0];
    while(left < right){

      if(nums[right] >= maxLeft){
        right--;
      } else {
        while(left < right) {
          left++;
          maxLeft = maxLeft < nums[left] ? nums[left] : maxLeft;
        }
        right = nums.length-1;
      }
    }
    return left+1;
  }
}
