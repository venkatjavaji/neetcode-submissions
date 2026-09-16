class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //see if new interval merge occurs 
        //merge
        //add remaining interval
        List<int[]> result = new ArrayList<>(); // we dont the result size, so take arrayList and convert to 2d array
        int counter = 0;
        int len = intervals.length;
        
        while(counter<len && intervals[counter][1] < newInterval[0]) {
            //no overlap
            result.add(intervals[counter]);
            counter++;
        }

        //merge the interval now, counter tells where to insert the new interval
        while(counter<len && (intervals[counter][0]<=newInterval[1] && intervals[counter][1]>=newInterval[0])) {
            newInterval[0] = Math.min(intervals[counter][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[counter][1],newInterval[1]);
            counter++;
        }
        result.add(newInterval);

        while(counter<len) {
            result.add(intervals[counter]);
            counter++;
        }

        return result.toArray(new int[result.size()][]);
        
    }
}
