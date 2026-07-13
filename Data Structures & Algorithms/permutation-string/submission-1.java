class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;
        char[] s1arr = new char[26];
        char[] s2arr = new char[26];
      

        for(char c : s1.toCharArray()) {
            s1arr[c - 'a']++;
        }

        int left = 0;
        // right is initialised with left because, left always points to new index for every window check
        int incount = 0;
        for(int right = 0; right<s2.length();right++) {
               char s2c = s2.charAt(right);
               s2arr[s2c-'a']++;
               incount++;
               if(incount>s1.length()){
                    char leftMost = s2.charAt(left);
                    s2arr[leftMost-'a']--;
                    left++;
                    incount--;
               }
               if(incount == s1.length()) {
                boolean matched = true;
                for(int k =0; k<26;k++) {
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
