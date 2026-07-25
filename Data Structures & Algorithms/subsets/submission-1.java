class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        //For each element, you either include it or exclude it
        // that binary choice for n elements naturally generates all 2(n) subsets, 
        //whether you build it with backtracking or by iterating bits.
        buildSubsets(result,new ArrayList<>(), nums, 0);
        return result;
        
    }

    public void buildSubsets(List<List<Integer>> result , List<Integer> temp, int[] nums,int counter) {
        result.add(new ArrayList<>(temp)); // every state is a valid subset
        for(int i=counter; i< nums.length;i++)
        {
            temp.add(nums[i]); // include nums[i]
            buildSubsets(result,temp, nums, i+1);
            temp.remove(temp.size()-1); // exclude nums[i], backtrack
        }
        
    }
}
