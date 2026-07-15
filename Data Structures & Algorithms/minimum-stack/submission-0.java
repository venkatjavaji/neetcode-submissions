class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
       stack.push(val);
       if(minStack.isEmpty()) {
            minStack.push(val);
       } else if(minStack.peek() < val) {
        //if the top of the minStack is less than the incoming val, just re-insert the top value again
        minStack.push(minStack.peek());
       } else {
        //if the val is less than the top of the minStack, we got the new minimum
        minStack.push(val);
       }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
