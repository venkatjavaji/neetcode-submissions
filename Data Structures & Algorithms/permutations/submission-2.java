class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //seen

        boolean[] seen = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,seen,new ArrayList<>(), result);
        return result;
        
    }

    void backtrack(int[] nums, boolean[] seen, List<Integer> temp, List<List<Integer>> result) {

        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i <nums.length;i++) {
            if(seen[i]) continue;
            seen[i] = true;
            temp.add(nums[i]);
            backtrack(nums,seen,temp,result);
            temp.remove(temp.size()-1);
            seen[i] =  false;
        }

    }
}
