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

        int meetings_length = intervals.size();

        int[] meeting_start_times = new int[meetings_length];
        int[] meeting_end_times = new int[meetings_length];

        //now add times accordingly
        for(int i=0;i<meetings_length;i++) {
            meeting_start_times[i] = intervals.get(i).start;
            meeting_end_times[i] = intervals.get(i).end;
        }
        Arrays.sort(meeting_start_times);
        Arrays.sort(meeting_end_times);

        //now find out the min.num of rooms needed for all the meetings
        //[0,5,15]
        //[10,20,40]
        int max_rooms_count = 0;
        int meeting_start_index = 0;
        int meeting_end_index = 0;
        int room_counter = 0;

        while(meeting_start_index < meetings_length) {

            if(meeting_start_times[meeting_start_index] < meeting_end_times[meeting_end_index]) {
                room_counter++;
                meeting_start_index++;
            } else {
                room_counter--; //a meeting would have finished.. decrement room_counter
                meeting_end_index++;
            }
            max_rooms_count = Math.max(max_rooms_count, room_counter);
        }

        return max_rooms_count;
    }
}
