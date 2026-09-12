class Solution {
    public int countPalindromicSubsequence(String s) {

        int len = 3;
        //left and right pointer
        // move it and skip if it is not palindrome

        /*
        aabca

        aab
        aac
        aaa
        abc
        aba
        aca

        abc
        aba
        aca

        bca


        */

        int result = 0;
       for(char c = 'a'; c<='z' ;c++) {
            int fi = s.indexOf(c);
            int li = s.lastIndexOf(c);

            if(fi < 0 || (li-fi) < 2) {
                continue; //cannot use thi char for length-2 palindrom
            }
            Set<Character> set = new HashSet<>();
            for(int i=fi+1;i<li;i++) {
                set.add(s.charAt(i));
            }
            result += set.size();
           
       }
         return result;
        
    }
}