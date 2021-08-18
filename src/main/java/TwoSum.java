import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> diff = new HashMap<>();

    for (int i = 0; i < nums.length ; i++) {
      if(diff.containsKey(target - nums[i]))
        return new int[]{i,diff.get(target - nums[i])};

      diff.put(nums[i],i);
    }

    return null;
  }
}
