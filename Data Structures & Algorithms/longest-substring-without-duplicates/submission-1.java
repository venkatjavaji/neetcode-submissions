class Solution {
    public int lengthOfLongestSubstring(String s) {
// Tracks the distinct characters currently inside the window [l, r]
        Set<Character> countSet = new HashSet<>();

        int l = 0;// left edge of the sliding window
        int longest = 0; // best (max) window size found so far
        for(int r=0; r< s.length(); r++) {
            // If s.charAt(r) is already in the window, it's a duplicate.
            // Keep shrinking from the left — removing one char at a time —
            // until the duplicate is actually gone from the window.
            // (Must be a while loop, not an if: one removal isn't always
            // enough, since the duplicate could be anywhere in the window,
            // not just at the left edge.)
            while(countSet.contains(s.charAt(r))) {
                countSet.remove(s.charAt(l));
                l++;
            }

            // Now s.charAt(r) is guaranteed unique within [l, r], safe to add
            countSet.add(s.charAt(r));
            // Current window [l, r] has no repeats — check if it's the longest so far
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}
