class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int t1 = text1.length();
        int t2 = text2.length();

        int dp[][] = new int[t1+1][t2+1];

// Match: Characters are same >> Include it >> dp[i-1][j-1] + 1

// No Match: Characters different >> Skip one >> max(dp[i-1][j], dp[i][j-1])
        for(int i=1;i<=t1;i++) {
            for(int j=1;j<=t2;j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        return dp[t1][t2];
        
    }
}
