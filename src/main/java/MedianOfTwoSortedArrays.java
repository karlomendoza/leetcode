public class MedianOfTwoSortedArrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int nums1Counter =0,nums2Counter =0, sortedCounter = 0;
    int totalLength = nums1.length + nums2.length;
    boolean isEven = totalLength % 2 == 0;
    int[] sorted = new int[totalLength/2 + 2];
    while(nums1Counter < nums1.length || nums2Counter < nums2.length){

      if(nums1Counter >= nums1.length){
        sorted[sortedCounter] = nums2[nums2Counter];
        nums2Counter++;
      } else if(nums2Counter >= nums2.length) {
        sorted[sortedCounter] = nums1[nums1Counter];
        nums1Counter++;
      }
      else if(nums1[nums1Counter] < nums2[nums2Counter]){
        sorted[sortedCounter] = nums1[nums1Counter];
        nums1Counter++;
      } else {
        sorted[sortedCounter] = nums2[nums2Counter];
        nums2Counter++;
      }

      if(isEven && sortedCounter >= ((totalLength)/2)){
        return (1.0*(sorted[sortedCounter] + sorted[sortedCounter-1]))/2;
      } else if (!isEven && sortedCounter >= (totalLength) /2){
        return 1.0*sorted[sortedCounter];
      }
      sortedCounter++;
    }
    return 0.0;
  }
}
