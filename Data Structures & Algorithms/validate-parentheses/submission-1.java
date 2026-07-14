class Solution {
    public boolean isValid(String s) {
        
        Map<Character,Character> pMap = new HashMap<>();
        pMap.put(')','(');
        pMap.put(']', '[');
        pMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(pMap.containsValue(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.pop()!=pMap.get(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    
    }
}
