class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> countSet = new HashSet<>();

        int l = 0;
        int longest = 0;
        for(int r=0; r< s.length(); r++) {
            while(countSet.contains(s.charAt(r))) {
                countSet.remove(s.charAt(l));
                l++;
            }
            countSet.add(s.charAt(r));
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}
