class Solution {
    public String longestCommonPrefix(String[] strs) {

        int counter = 0;
        while(counter<strs[0].length()) {
            for(String s : strs) {
                char ch = strs[0].charAt(counter);
                if(counter>=s.length() || ch!=s.charAt(counter)) {
                    return strs[0].substring(0,counter);
                }
            }
            counter++;
        }
        return strs[0].substring(0,counter);
    }
}