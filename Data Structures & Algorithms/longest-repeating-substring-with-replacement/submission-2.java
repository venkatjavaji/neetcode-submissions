class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character,Integer> freqCountMap = new HashMap<>();
        int maxLen = 0;
        int maxFrequency = 0;//update the maxFrequency to track and replace other chars
        int left = 0; //left pointer at the start of the string

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


/**

Dry Run

Input: s = "AABABBA", k = 1

Goal: longest substring where you can replace at most k characters to make all characters the same.

right	c	freqCountMap (after put)	windowSize	maxFrequency	windowSize-maxFrequency > k?	action	left	maxLen
0	A	{A:1}	1	1	1-1=0 > 1? No	—	0	1
1	A	{A:2}	2	2	2-2=0 > 1? No	—	0	2
2	B	{A:2,B:1}	3	2	3-2=1 > 1? No	—	0	3
3	A	{A:3,B:1}	4	3	4-3=1 > 1? No	—	0	4
4	B	{A:3,B:2}	5	3	5-3=2 > 1? Yes	shrink: s[left]='A' → freq A: 3-1=2; left=1	1	max(4, 4-1+1=4)=4
5	B	{A:2,B:3}	5-1+1=5	max(3,3)=3	5-3=2 > 1? Yes	shrink: s[left]='A' (left=1) → freq A: 2-1=1; left=2	2	max(4, 5-2+1=4)=4
6	A	{A:2,B:3}	6-2+1=5	max(3,2)=3	5-3=2 > 1? Yes	shrink: s[left]='B' (left=2) → freq B: 3-1=2; left=3	3	max(4, 6-3+1=4)=4

Final maxLen = 4

**/
