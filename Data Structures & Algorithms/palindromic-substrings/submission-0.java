class Solution {
    public int countSubstrings(String s) {
        
        int res = 0;

        //using two pointer with odd and even 

        for(int i=0; i< s.length(); i++) {

            int l=i; int r=i;
            //odd-len pali -> ababa
            // left is decremented and right is incremented
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r))   {
                l--;
                r++;
                res++;
            }

            //even length
                l = i; r=i+1;
                //aabbaa
                while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    res++;
                }
        }

        

         return res;
    }
   
}
