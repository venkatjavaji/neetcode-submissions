class Solution {
    public int[] plusOne(int[] digits) {
        
       int len = digits.length;

       for(int i = len-1; i>=0; i--) {
            if(digits[i] < 9) {
                //just increment
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
       }
       //if it comes here.. then the array has carried the sum
       int[] result = new int[len+1];
       result[0] = 1;
       return result;
    }
}
