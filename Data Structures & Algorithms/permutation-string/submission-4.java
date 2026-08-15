class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        char[] s1arr = new char[26];
        char[] s2arr = new char[26];
      

        for(char c : s1.toCharArray()) {
            s1arr[c - 'a']++;
        }

        int left = 0;
        int windowSize = 0;
        for(int right = 0; right<s2.length();right++) {
               char s2c = s2.charAt(right);
               s2arr[s2c-'a']++;
               windowSize++;
               //if the windowSize is > s1 then shrink the window
               if(windowSize>s1.length()){
                    char leftMost = s2.charAt(left);
                    s2arr[leftMost-'a']--;
                    left++;
                    windowSize--;
               }
               //if windowSize is equal, compare the s1 with s2[window]
               if(windowSize == s1.length()) {
                boolean matched = true;
                for(int k=0; k<26;k++) {
                    if(s1arr[k]!=s2arr[k]) {
                        matched = false;
                        break;
                    }
                }
                if(matched) {
                    return true;
                }
            }
        }
        return false;   
    }
}
