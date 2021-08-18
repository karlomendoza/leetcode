import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < nums.length-2 ; i++) {
      if( i > 0 && nums[i] == nums[i-1])
        continue;

      int j = i+1;
      int k = nums.length -1;
      int target = nums[i];
      while( j < k){

        if(j > i+1 && nums[j] == nums[j-1] ) {
          j++;
          continue;
        }
        if(k < nums.length-1 && nums[k] == nums[k+1]){
          k--;
          continue;
        }

        if(target + nums[j] + nums[k] == 0){
          triplets.add(Arrays.asList(target,nums[j],nums[k]));
          k--; j++;
        }
        else if( target + nums[j] + nums[k] > 0 )
          k--;
        else if ( target + nums[j] + nums[k] < 0 )
          j++;
      }
    }
    return triplets;
  }
}
