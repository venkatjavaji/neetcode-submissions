class Solution {
    public int[][] merge(int[][] intervals) {

        //first soer the intervals based on the start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        List<int[]> result = new ArrayList<>();
        result.add(cur); // if there is a merge then the index will update the result array
        for(int[] interval: intervals) {
            if(cur[1] >= interval[0]) {
                cur[0] = Math.min(cur[0],interval[0]);
                cur[1] = Math.max(cur[1], interval[1]);
               
            } else {
                // if no overlap identified.. update cur..
                cur = interval;
                result.add(cur);
               
            }
        }
        return result.toArray(new int[result.size()][]);
         
    }
}
