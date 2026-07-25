class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;

    }

    public void backtrack(List<String> result, StringBuilder temp, int left, int right, int len) {

        if(temp.length() == 2*len) {
            result.add(temp.toString());
            return;
        }

        if(left < len) {
            temp.append("(");
            backtrack(result,temp,left+1,right,len);
            temp.deleteCharAt(temp.length()-1);
        }
        if(right < left) {
            temp.append(")");
            backtrack(result,temp,left,right+1,len);
            temp.deleteCharAt(temp.length()-1);
        
        }

    }
}
