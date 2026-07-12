class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> nset = new HashSet<>();

        for(int n : nums) {
            nset.add(n);
        }

        int longest = 0;
        for(Integer ns : nset) {
            if(!nset.contains(ns-1)) {
                
                int lsc = 1;
                int cur = ns;
                while(nset.contains(cur+1)) {
                   cur++;
                   lsc++;
                }
                 longest = Math.max(longest,lsc);
            }
        }
        return longest;
    }
}
