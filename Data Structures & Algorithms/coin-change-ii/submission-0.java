class Solution {
    public int change(int amount, int[] coins) {

        //find the total-amount >> so amount goes inner loop
        // for coin change :: Return the fewest number of coins >> coins goes inner loop ** :D:D


        int[] dp = new int[amount+1]; //why extra space.. we need to store not taking/picking any coin

        dp[0] = 1; // 1 combination of not picking any coin 

        for(int coin : coins) {
            for(int i=coin;i<=amount;i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];

        
    }
}
