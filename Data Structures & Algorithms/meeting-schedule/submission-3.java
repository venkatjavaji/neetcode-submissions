/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.isEmpty()) return true;
        
// sort the times based on the start index.
        intervals.sort((i,j) -> i.start - j.start);
        intervals.stream().forEach(i -> System.out.println(i.start + " " + i.end));
       
        
        for(int i=1;i<intervals.size();i++) {
            Interval prev = intervals.get(i-1);
            Interval cur = intervals.get(i);
            if(cur.start < prev.end) { 
                return false;
            }

        }
        return true;

    }
}
