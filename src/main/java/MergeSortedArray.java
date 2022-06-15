class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m-1, j = n-1, k=n+m-1;
        
        while(j >= 0){
            
            if(i < 0 || nums1[i] <= nums2[j]){
                nums1[k] = nums2[j];
                k--;
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        //[1,2,2,3,5,6]
        //[1,2,3,0,0]
        //[5,6]
    }
}
