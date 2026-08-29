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

/*
 * DRY RUN — s = "babad"
 * Initial: maxs = s.substring(0,1) = "b"
 *
 * i=0 (center 'b')
 *   odd  = expand(0,0): (0,0)'b'='b'->(-1,1) stop -> substring(0,1)="b"   -> len 1 > 1? No
 *   even = expand(0,1): (0,1) 'b'!='a' -> stop     -> substring(1,1)=""  -> len 0 > 1? No
 *   maxs = "b"
 *
 * i=1 (center 'a')
 *   odd  = expand(1,1): (1,1)'a'='a'->(0,2)'b'='b'->(-1,3) stop -> substring(0,3)="bab" -> len 3 > 1? YES
 *   even = expand(1,2): (1,2) 'a'!='b' -> stop -> substring(2,2)="" -> len 0 > 3? No
 *   maxs = "bab"
 *
 * i=2 (center 'b')
 *   odd  = expand(2,2): (2,2)'b'='b'->(1,3)'a'='a'->(0,4)'b'!='d' stop -> substring(1,4)="aba" -> len 3 > 3? No (not strictly greater)
 *   even = expand(2,3): (2,3) 'b'!='a' -> stop -> substring(3,3)="" -> len 0 > 3? No
 *   maxs = "bab"  (still; "aba" is equally valid but not strictly longer)
 *
 * i=3 (center 'a')
 *   odd  = expand(3,3): (3,3)'a'='a'->(2,4)'b'!='d' stop -> substring(3,4)="a" -> len 1 > 3? No
 *   even = expand(3,4): (3,4) 'a'!='d' -> stop -> substring(4,4)="" -> len 0 > 3? No
 *   maxs = "bab"
 *
 * i=4 (center 'd')
 *   odd  = expand(4,4): (4,4)'d'='d'->(3,5) right OOB stop -> substring(4,5)="d" -> len 1 > 3? No
 *   even = expand(4,5): right=5 OOB immediately -> substring(5,5)="" -> len 0 > 3? No
 *   maxs = "bab"
 *
 * FINAL RESULT: "bab"
 * (Note: "aba" at i=2 is also a valid length-3 palindrome; the algorithm keeps
 *  the first one found on ties since the comparison is strict '>'.)
 */
