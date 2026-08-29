class Solution {
    public String longestPalindrome(String s) {

        if(s.length() <= 1) return s;

        String maxs = s.substring(0,1); //maxString 

        for(int i=0;i<s.length();i++) {

            String odd = expand(s, i, i);
            String even = expand(s,i, i+1);

            if(odd.length()> maxs.length()) {
                maxs = odd;
            }

            if(even.length() > maxs.length()) {
                maxs=even;
            }

        }
        return maxs;
    }

    public String expand(String s, int left, int right) {

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //left can go -1 so, add +1
        return s.substring(left+1, right);
    }
}
