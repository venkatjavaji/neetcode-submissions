class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // {1,2} {1,4}
        /**
            - make sure intervals are sorted on the first index
            - c - current , n - new
            - check if c[0]< n[1] -> current start is less than the new-end
            - then compare min of c and max of n then
        **/

        // it is already sorted already mentioned in the question!!

        // consider taking list since you dont the result size..
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int counter = 0;

        //[1,3] - [4,5]
        while(counter<n && intervals[counter][1]<newInterval[0]) {
            //no overlap -> add to the result
            result.add(intervals[counter]);
            counter++;
        }
        //the above step completes no-overlap check

        //[1,3] - [2,5]
        // at this point, if first element is less than the end-elem of newInt then merge all the intermediate intervals
        while(counter<n && intervals[counter][0]<= newInterval[1]) {
            newInterval[0] = Math.min(intervals[counter][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[counter][1], newInterval[1]);
            counter++;
        }
        result.add(newInterval);


        //[[1,2],[2,5]] - [6,7]
        // at this point the result will be [1,5], add the 6,7 to the result
        // add all remainging values

        while(counter<n) {
            result.add(intervals[counter]);
            counter++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
