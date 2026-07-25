class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //same as subset but exclude the duplicate element by removing forming the duplicate subset
        // sort the given array
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        //start/counter=0 - to form the subsets
        subsets2(result, new ArrayList<>(), 0, nums);
        return result;
        
    }

    public void subsets2(List<List<Integer>> result, List<Integer> temp, int counter, int[] nums) {
        result.add(new ArrayList<>(temp));

        for(int i=counter; i<nums.length; i++) {
            //avoide forming the duplicate subset...
            if(i>counter && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]); //take the number
            subsets2(result, temp, i+1, nums);
            temp.remove(temp.size()-1); // dont take the number

        }

    }
}
