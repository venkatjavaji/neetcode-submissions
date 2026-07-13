class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character,Integer> freqCountMap = new HashMap<>();
        int maxLen = 0;
        int left = 0; //left pointer at the start of the string
        int maxFrequency = 0;

        for(int right=0;right<s.length(); right++) {
            char c = s.charAt(right);
            freqCountMap.put(c, freqCountMap.getOrDefault(c,0)+1);
            int windowSize = right - left + 1;
            maxFrequency = Math.max(maxFrequency, freqCountMap.get(c));

            //below condition is the baseline of the problem***
            // maxFrequency is calculated to replace no-max characters to determine the longest repeating character**
            if(windowSize - maxFrequency > k ) {
                //reduce the maxFrequency
                int reducedFreq = freqCountMap.get(s.charAt(left))-1;
                freqCountMap.put(s.charAt(left), reducedFreq);
                //shrink the window size;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen;
        
        
    }
}
