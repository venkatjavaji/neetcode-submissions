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
    public int minMeetingRooms(List<Interval> intervals) {

        //sort the start and end times and compare the start with end times and increment the pointers
        int n = intervals.size();
        int start_times[] = new int[n];
        int end_times[] = new int[n];

        for(int i=0;i<n;i++) {
            start_times[i] = intervals.get(i).start;
            end_times[i] = intervals.get(i).end;
        }

        Arrays.sort(start_times); //[0,5,15]
        Arrays.sort(end_times); // [10,20,40]

        int rooms = 0;
        int max_rooms = 0;
        int start_m = 0;
        int end_m = 0;
        while(start_m < n) {
            if(start_times[start_m] < end_times[end_m]) {
                start_m++;
                rooms++;
            } else {
                rooms--;
                end_m++;
            }
            max_rooms = Math.max(rooms, max_rooms);
        }
        return max_rooms;

    }
}
