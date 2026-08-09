class Solution {
    public String longestPalindrome(String s) {

        int resLen = 0;
        String res = "";
        for(int i=0;i<s.length();i++) {
            for (int j=i;j<s.length();j++) {
                int l = i;
                int r = j;
                //iterate until the characters are equal!!
                while(l<r &&s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                if(l>=r && resLen< (j-i+1)) {
                    res = s.substring(i,j+1);
                    resLen = j-i+1;
                }
            }
        }
        return res;
        
    }
}
