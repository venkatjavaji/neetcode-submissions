class Solution {
    public String longestPalindrome(String s) {
        //
        int ll = 0;
        int lr = 0;
        int max = 0;
        for(int i=0; i< s.length(); i++) {
            for(int j =i+1; j<=s.length(); j++) {
                String substr = s.charAt(i) + s.substring(i+1, j); 
                if(isPali(substr)) {
                int prev_max = max;
                max = Math.max(max, substr.length());

                if(max > prev_max) {
                    ll = i;
                    lr = j;
                }
                }
                
            }
        }
        return s.substring(ll, lr);
        
    }

    boolean isPali(String pal) {
        int l=0;int r = pal.length()-1;
        while(l<r) {
            if(pal.charAt(l)!=pal.charAt(r)) return false;
            l++;
            r--;    
        }
        return true;
    }
}
