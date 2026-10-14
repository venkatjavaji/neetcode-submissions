class Solution {
    // 0 and 1 index are empty
    String[] mapping = new String[] {
        "", "","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() ==0 ) return result;
        backtrack(digits,new StringBuilder(), result,0);
        return result;

    }

    void backtrack(String digits, StringBuilder temp, List<String> result, int index) {

        if(index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // "34" ==> "def" | "ghi"
        String letters = mapping[digits.charAt(index)-'0'];
        for(char c : letters.toCharArray()) {
            temp.append(c);
            backtrack(digits,temp,result,index+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
