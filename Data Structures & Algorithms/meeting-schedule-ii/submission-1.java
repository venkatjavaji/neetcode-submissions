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

        // Separate start times and end times into their own arrays.
        // We no longer need to know which start belongs to which end —
        // we only care about "a meeting started" / "a meeting ended" as
        // independent events on the timeline.
        int[] meeting_start_times = new int[meetings_length];
        int[] meeting_end_times = new int[meetings_length];

        // populate both arrays from the interval list
        for (int i = 0; i < meetings_length; i++) {
            meeting_start_times[i] = intervals.get(i).start;
            meeting_end_times[i] = intervals.get(i).end;
        }

        // Sort both independently. Once sorted, meeting_start_times[i] is
        // simply the i-th earliest "start" event chronologically, and
        // same for meeting_end_times[i] with "end" events.
        Arrays.sort(meeting_start_times);
        Arrays.sort(meeting_end_times);

        // now find out the min. num of rooms needed for all the meetings
        // [0,5,15]
        // [10,20,40]

        int max_rooms_count = 0;   // tracks the peak concurrent room usage seen so far

        // Two pointers walking through the sorted start/end arrays —
        // like merging two sorted lists, always process whichever
        // event (start or end) happens next in time.
        int meeting_start_index = 0;
        int meeting_end_index = 0;

        int room_counter = 0;      // rooms currently in use at this point in the sweep

        // We only need to advance while there are still starts left to process —
        // once every meeting has started, no new room will ever be needed,
        // so any remaining ends can only decrease room_counter (irrelevant to the max).
        while (meeting_start_index < meetings_length) {

            // Compare the next unprocessed start time vs. the next unprocessed end time.
            // Strict "<" (not "<=") is important: if a meeting starts exactly when
            // another ends, we treat the end as happening first, so the freed-up
            // room gets reused instead of allocating an unnecessary new one.
            if (meeting_start_times[meeting_start_index] < meeting_end_times[meeting_end_index]) {
                // A meeting starts before the earliest ongoing one ends
                // → need an additional room right now.
                room_counter++;
                meeting_start_index++;
            } else {
                // A meeting has ended at or before this point
                // → free up a room.
                room_counter--;
                meeting_end_index++;
            }

            // After processing this event, check if we've hit a new peak.
            max_rooms_count = Math.max(max_rooms_count, room_counter);
        }

        return max_rooms_count;
    }
}
