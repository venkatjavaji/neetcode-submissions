class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();

        int count = 0;
        int len = intervals.length;
        int[] cur = intervals[0];
        result.add(cur); //if there is a overlap - cur gets modified.. since we are starting from the start of the array
        //[[1,3],[1,5],[6,7]]
        /*
        cur -> intervals[0] and move it when no overlap else merge and make merged-interval to current
        */

        for(int[] interval : intervals) {
            if(cur[1] >= interval[0]) {
                //3>=1 - first cur and interval are same...
                //3>=1 - second cur=[1,3] interval=[1,5]
                cur[0] = Math.min(cur[0], interval[0]);
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                cur = interval;
                result.add(cur);
            }
        }

        return result.toArray(new int[result.size()][]);

    
    }
}
