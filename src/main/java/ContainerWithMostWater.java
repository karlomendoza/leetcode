public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length-1;

    while (left < right){
      maxArea = Math.max(maxArea, (right-left)*Math.min(height[right],height[left]));
      if(height[right] < height[left])
        right--;
      else
        left++;
    }

    return maxArea;
  }
}
