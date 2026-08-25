class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();

        int res =0; int max = 0;
        for(int i : nums) {
            countMap.put(i, countMap.getOrDefault(i,0)+1);
            if(countMap.get(i) > max) {
                res = i;
                max = countMap.get(i);
            }
        }
        return res;
    }
}