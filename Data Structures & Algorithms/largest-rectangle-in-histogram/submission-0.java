//brute-force approach to better understand what is the minimum way that we can solve the problem

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0 ; i< heights.length; i++) {
            int maxWidth = 0;
            for(int j = i; j< heights.length; j++) {
                if(heights[i] <= heights[j]) {
                    maxWidth = maxWidth+1;
                } else {
                    break;
                }
            }
            for(int k = i-1; k>=0; k--) {
                if(heights[i] <= heights[k]) {
                    maxWidth = maxWidth+1;
                }else {
                    break;
                }
            }
            System.out.println("maxWidth at : "+ i + " is :" +maxWidth);
            int areaAtIndex = heights[i]*maxWidth;
            maxArea = Math.max(maxArea, areaAtIndex);
        }
        return maxArea;
        
    }
}
