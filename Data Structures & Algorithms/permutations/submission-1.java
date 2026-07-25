class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        backtrack(nums,result, new ArrayList<>(),seen);
        return result;
        
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] seen) {

        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        
        for(int i=0;i<nums.length; i++) {
           if(seen[i]) continue;
            seen[i] = true;
            temp.add(nums[i]);
            backtrack(nums,result,temp,seen);
            temp.remove(temp.size()-1);
            seen[i] =false;
        }
    }
}
