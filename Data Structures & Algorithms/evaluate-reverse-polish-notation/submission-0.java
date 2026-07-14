class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {

            if(s.equals("+") 
                || s.equals("-")
                || s.equals("*")
                || s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                switch(s) {
                    case "+" :
                    stack.push(left+right);
                    break;
                    case "-" :
                    stack.push(left-right);
                    break;
                    case "*" :
                    stack.push(left*right);
                    break;
                    case "/" :
                    stack.push(left/right);
                    break;
                }

            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
        
    }
}
