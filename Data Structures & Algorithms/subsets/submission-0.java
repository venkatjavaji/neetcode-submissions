class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        buildSubsets(result,new ArrayList<>(), nums, 0);
        return result;
        
    }

    public void buildSubsets(List<List<Integer>> result , List<Integer> temp, int[] nums,int counter) {
        result.add(new ArrayList<>(temp));
        for(int i=counter; i< nums.length;i++)
        {
            temp.add(nums[i]);
            buildSubsets(result,temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
