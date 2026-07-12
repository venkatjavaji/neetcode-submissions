class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> nset = new HashSet<>();

        for(int n : nums) {
            nset.add(n);
        }

        int longest = 0;
        for(Integer ns : nset) {
            if(!nset.contains(ns-1)) {
                // longestConsective is reset to 1
                int lsc = 1;

                //pointing the current to current num from set
                int cur = ns;
                while(nset.contains(cur+1)) {
                    //until the next consective number is found
                   cur++; // go to next number
                   lsc++; //increase longestConsective
                }
                 longest = Math.max(longest,lsc);
            }
        }
        return longest;
    }
}
