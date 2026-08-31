class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //implementing using the stack

        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            int cur = temperatures[i];
            // check if cur temp is hotter than previous day and iterate until stack is empty
            while(!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; 
            }
            stack.push(i); //push the index of the current temp
        }
        return result;
    }
}
