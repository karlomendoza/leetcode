class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int northLimit = 0;
        int eastLimit = n-1;
        int southLimit = n-1;
        int westLimit = 0;
        int x=0, y= -1;
        int count = 1;
        int[][] ans = new int[n][n];
        String direction = "east";
        
        while(count < n*n+1){
            
            if(direction.equals("east")){
                y++;
            } else if(direction.equals("south")){
                x++;
            }else if(direction.equals("west")){
                y--;
            }else if(direction.equals("north")){
                x--;
            }
            
            ans[x][y] = count;
            count++;
            if(direction.equals("east") && y >= eastLimit){
                direction = "south";
                northLimit++;
            } else if("south".equals(direction) && x >= southLimit){
                direction = "west";
                eastLimit--;
            } else if("west".equals(direction) && y <= westLimit){
                direction = "north";
                southLimit--;
            } else if("north".equals(direction) && x <= northLimit){
                direction = "east";
                westLimit++;
            }
        }
        return ans;
    }
}
