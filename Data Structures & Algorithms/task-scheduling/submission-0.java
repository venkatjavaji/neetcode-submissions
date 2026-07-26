class Solution {
    public int leastInterval(char[] tasks, int n) {
        // this approach is logic based, not using the Heap
        int[] freqcount = new int[26];
        for(char c : tasks) {
            freqcount[c-'A']++;
        }

        int maxfreq = 0;
        for(int f : freqcount) {
            maxfreq = Math.max(maxfreq, f);
        }

        System.out.println("maxfreq: " + Arrays.toString(freqcount));
        int maxfreqcount = 0;
        for(int count : freqcount) {
            if(count == maxfreq) {
                maxfreqcount++;
            }
        }
        System.out.println("maxfreqcount: " + maxfreqcount);
        int intervalcount = (maxfreq-1)* (n+1) + maxfreqcount;
        return Math.max(intervalcount,tasks.length);
    }
}
