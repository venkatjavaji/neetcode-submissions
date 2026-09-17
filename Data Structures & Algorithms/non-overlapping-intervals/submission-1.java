class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

       /*
        sort based on the end_times..
        now, compare the start_time with end_time
       */
       Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
       int removal = 0;
       int last_end = Integer.MIN_VALUE;

       for(int[] interval : intervals) {
            if(interval[0] >= last_end) {
                //no-overlap, just re-assign last_end
                last_end = interval[1];
            } else {
                removal++;
            }
       }
        return removal;

        
    }
}
