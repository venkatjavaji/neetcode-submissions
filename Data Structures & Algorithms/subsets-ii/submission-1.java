class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(), result);
        return result;
    }

    void backtrack(int[] nums, int counter, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for(int i=counter;i<nums.length;i++) {
            if(i>counter && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
        }

    }
}
