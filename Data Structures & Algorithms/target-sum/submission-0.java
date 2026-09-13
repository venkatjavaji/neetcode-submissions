class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return recursive(nums, target, new HashMap<>(), 0,0);
    }

    int recursive(int[] nums, int target, Map<String,Integer> map, int index, int cursum) {


        if(index == nums.length) {
            return cursum == target ? 1 : 0;
        }

        String key = index + ":" + cursum;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int add = recursive(nums,target, map, index+1, cursum + nums[index]);
        int sub = recursive(nums,target, map, index+1, cursum - nums[index]);

        map.put(key, add+sub);
        return add+sub;
    }
}
