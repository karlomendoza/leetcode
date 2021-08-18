import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int smallest = Integer.MAX_VALUE-1000;

    for (int i = 0; i < nums.length-2 ; i++) {
      if( i > 0 && nums[i] == nums[i-1])
        continue;

      int j = i+1;
      int k = nums.length -1;
      while( j < k){
        if(j > i+1 && nums[j] == nums[j-1] ) {
          j++;
          continue;
        }
        if(k < nums.length-1 && nums[k] == nums[k+1]){
          k--;
          continue;
        }
        if(nums[i] + nums[j] + nums[k] - target == 0)
          return target;

        if( Math.abs(nums[i] + nums[j] + nums[k] - target)  < Math.abs(smallest - target) ){
          smallest = nums[i] + nums[j] + nums[k];
        }
        if( nums[i] + nums[j] + nums[k] - target > 0 )
          k--;
        else if ( nums[i] + nums[j] + nums[k] - target < 0 )
          j++;
      }
    }
    return smallest;
  }
}
