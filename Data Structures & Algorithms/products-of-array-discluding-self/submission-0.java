class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i=1;i<nums.length;i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));
        int[] sufix = new int[nums.length];
        sufix[nums.length-1] = 1;
        for(int j=nums.length-2;j>=0;j--) {
            sufix[j] = sufix[j+1]*nums[j+1];
        }
         System.out.println(Arrays.toString(sufix));

        int[] result = new int[nums.length];
        for(int k=0;k<nums.length;k++) {
            result[k] = prefix[k]*sufix[k];
        }
        return result;
    }
}  
