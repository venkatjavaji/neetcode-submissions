class Solution {
    public boolean isPalindrome(String s) {
        int l =0; 
        int r = s.length()-1;

        while(l<r) {
            while(l<r && !isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l<r && !isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isLetterOrDigit(char c) {
        return (c <= 'Z' && c>='A') || (c<='z' && c>='a') || (c<='9' && c>='0');
    }
}
