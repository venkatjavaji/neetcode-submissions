class Solution {

    private final String[] mapping = new String[] {
        "", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        backtrack(result,new StringBuilder(), digits,0);
        return result;
    }
    
    public void backtrack(List<String> result, StringBuilder temp, String digits,int idx) {
        
        if(idx == digits.length()){
            result.add(temp.toString());
            return;
        }
        String letters = mapping[digits.charAt(idx)-'0'];
        for(char c : letters.toCharArray()){
            temp.append(c);
            backtrack(result,temp,digits,idx+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
