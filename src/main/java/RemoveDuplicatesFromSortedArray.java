public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int leftPointer = 0;
    int rightPointer = 1;

    while(rightPointer < nums.length){
      if(nums[leftPointer] == nums[rightPointer]){
        while(rightPointer < nums.length && nums[leftPointer] == nums[rightPointer]){
          rightPointer++;
        }

        if(rightPointer < nums.length) {
          leftPointer++;
          nums[leftPointer] = nums[rightPointer];
        }
      } else {
        leftPointer++;
        rightPointer++;
      }
    }

    return leftPointer+1;
  }
}
