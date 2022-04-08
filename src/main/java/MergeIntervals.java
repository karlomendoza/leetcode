class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        //sorted 
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        
        LinkedList<int[]> merged = new LinkedList();
        merged.add(intervals[0]);
        
        //iterate over all elements
        for(int i = 1; i < intervals.length; i++){
            if(merged.getLast()[1] >= intervals[i][0]){
                //merge them
                merged.getLast()[1] = Math.max(merged.getLast()[1],intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }
        
        return merged.toArray(new int[merged.size()][2]);
        
    }
}
