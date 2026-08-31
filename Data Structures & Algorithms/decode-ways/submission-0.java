class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1]; //memorize the result
        dp[0] = 1; //not selecting the ways is one of the way :) || empty string -> 1 way (do nothing)

        for(int i=1;i<=n;i++) {
            //take last 1 digit
            if(s.charAt(i-1)!='0') {
                dp[i] += dp[i-1];
            }

            if(i>=2) {
                int twoDigit = Integer.parseInt(s.substring(i-2,i));
                if(twoDigit >= 10 && twoDigit <=26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
/**
s = "226"

Start: dp = [1,0,0,0]
        idx: 0 1 2 3

i=1: char = '2' (index 0)
  last 1 digit = '2' -> not '0' -> dp[1] += dp[0] -> dp[1] = 0+1 = 1
  i<2, skip 2-digit check

dp = [1,1,0,0]

i=2: char = '2' (index 1), substring(0,2) = "22"
  last 1 digit = '2' -> not '0' -> dp[2] += dp[1] -> dp[2] = 0+1 = 1
  last 2 digits = "22" = 22 -> in [10,26] -> dp[2] += dp[0] -> dp[2] = 1+1 = 2

dp = [1,1,2,0]

i=3: char = '6' (index 2), substring(1,3) = "26"
  last 1 digit = '6' -> not '0' -> dp[3] += dp[2] -> dp[3] = 0+2 = 2
  last 2 digits = "26" = 26 -> in [10,26] -> dp[3] += dp[1] -> dp[3] = 2+1 = 3

dp = [1,1,2,3]

Result: dp[3] = 3 -> {2|2|6}, {22|6}, {2|26}


---
Edge case worth remembering: s = "100"

dp = [1,0,0,0]
        0 1 2 3

i=1: char='1' -> not '0' -> dp[1] += dp[0] -> dp[1] = 1
dp = [1,1,0,0]

i=2: char='0', substring="10"
  last 1 digit = '0' -> SKIP (can't stand alone)
  last 2 digits = "10" = 10 -> in [10,26] -> dp[2] += dp[0] -> dp[2] = 0+1 = 1
dp = [1,1,1,0]

i=3: char='0', substring="00"
  last 1 digit = '0' -> SKIP
  last 2 digits = "00" = 0 -> NOT in [10,26] -> SKIP
dp = [1,1,1,0]

Result: dp[3] = 0 -> "100" is UNDECODABLE
(the trailing 0 can't attach to anything -> confirms why the '0' checks matter)
**/
