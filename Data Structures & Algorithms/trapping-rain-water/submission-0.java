class Solution {
    public int trap(int[] height) {

        //calcualte the leftMaxHeights seen at the index
        int[] leftMaxHeights = new int[height.length];
        leftMaxHeights[0] = height[0];
        for(int left=1; left<height.length; left++) {
            leftMaxHeights[left] = Math.max(height[left], leftMaxHeights[left-1]);
        }
        System.out.println("leftMaxHeights : "+ Arrays.toString(leftMaxHeights));
        //calcualte the rightMaxHeights seen at the index
        int[] rightMaxHeights = new int[height.length];
        rightMaxHeights[height.length-1]= height[height.length-1];
        for(int right = height.length-2; right>=0 ; right--) {
            rightMaxHeights[right] = Math.max(height[right], rightMaxHeights[right+1]);
        }
        System.out.println("rightMaxHeights : "+ Arrays.toString(rightMaxHeights));

        //calculate the maxArea of trapping Rain water
        int maxWater = 0;
        for(int i=0; i<height.length; i++) {
            int amountOfWaterAtIndex = Math.min(leftMaxHeights[i], rightMaxHeights[i]) - height[i];
            System.out.println("amountOfWaterAtIndex : "+ i + " is : "+amountOfWaterAtIndex);
            maxWater = maxWater+amountOfWaterAtIndex;
        }
        return maxWater;
    }
}
