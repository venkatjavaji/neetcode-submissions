class Solution {
    public int leastInterval(char[] tasks, int n) {
        //this solution is based on the math formula and not with the priority queue

        //find the freq_count for each char
        int[] freq = new int[26];
        for(char ch : tasks) {
            freq[ch - 'A']++;
        }

        //find the max_freq
        int max_freq = 0;
        for(int f : freq) {
            max_freq = Math.max(f, max_freq);
        }

        // max_freq count
        int max_freq_count = 0;
        for(int fc : freq) {
            if( fc == max_freq) {
                max_freq_count++;
            }
        }
        int interval = (max_freq-1)*(n+1) + max_freq_count;

        return Math.max(interval, tasks.length);
        
    }
}
