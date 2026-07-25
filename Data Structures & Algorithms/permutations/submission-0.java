class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>());
        return result;
        
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp) {

        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int n:nums) {
            if(temp.contains(n)) continue;
            temp.add(n);
            backtrack(nums,result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
