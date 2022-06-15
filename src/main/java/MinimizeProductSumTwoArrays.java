class MinimizeProductSumTwoArrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] s1 = new int[101];
        int[] s2 = new int[101];
        for(int i = 0; i < nums1.length; i++){
            s1[ nums1[i]]++;
            s2[ nums2[i]]++;
        }
        
        int sum = 0;
        int ind1 = 1;
        int ind2 = 100;
        
        while(ind1 < 101 && ind2 > 0){
            
            while(ind1 < 101 && s1[ind1] <= 0)
                ind1++;
            while(ind2 > 0 && s2[ind2] <= 0)
                ind2--;
            if(ind1 >= 101)
                break;
            
            s1[ind1]--;
            s2[ind2]--;
            sum += ind1*ind2;
        }
        
        return sum;
    }
}
