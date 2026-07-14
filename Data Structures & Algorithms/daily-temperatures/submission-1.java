class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        for(int i=0;i<len; i++) {
           int j = i+1; // start from the immediate next element index...
           int count = 0;
           while(j<len) {
                if(temperatures[j]>temperatures[i]){
                    count = j-i; //index difference gives number of days...
                    break;
                } else {
                    j++;
                }
           }
           result[i]= count;
        }

        return result;
        
    }
}
