class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // sort the intervals based on the end_times and cosider the interval which finished first

        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int removal = 0;
        int lastEnd = Integer.MIN_VALUE;

        for(int[] interval : intervals) {
            //1,2 | 2,4 | 1,4
            if(interval[0] >= lastEnd) {
                // no overlap - keep this interval
                //make the index-1 to the lastEnd
                lastEnd = interval[1];
            } else {
                removal++;
            }
        }
        return removal;
        
    }
}
