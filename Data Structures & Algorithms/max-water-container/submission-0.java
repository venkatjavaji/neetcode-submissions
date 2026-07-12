class Solution {
    public int maxArea(int[] heights) {

        int lc = 0;
        int rc = heights.length-1;
        int maxArea = 0;
        while(lc<rc) {
            int width = rc-lc;
            int minHeight = Math.min(heights[lc],heights[rc]);
            maxArea = Math.max(width*minHeight, maxArea);
            if(heights[lc]< heights[rc]){
                lc++;
            } else {
                rc--;
            }
        }
        return maxArea;
    }
}
