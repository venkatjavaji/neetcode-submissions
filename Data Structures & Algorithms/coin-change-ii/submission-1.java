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

/**
amount = 5, coins = [1, 2, 5]

Start: dp = [1,0,0,0,0,0]

coin = 1:

j=1: dp[1] += dp[0] -> dp[1]=1
j=2: dp[2] += dp[1] -> dp[2]=1
j=3: dp[3] += dp[2] -> dp[3]=1
j=4: dp[4] += dp[3] -> dp[4]=1
j=5: dp[5] += dp[4] -> dp[5]=1

dp = [1,1,1,1,1,1]

coin = 2:

j=2: dp[2] += dp[0] -> dp[2]=2
j=3: dp[3] += dp[1] -> dp[3]=2
j=4: dp[4] += dp[2] -> dp[4]=3
j=5: dp[5] += dp[3] -> dp[5]=3

dp = [1,1,2,2,3,3]

coin = 5:

j=5: dp[5] += dp[0] -> dp[5]=4

dp = [1,1,2,2,3,4]

Result: dp[5] = 4 → {1+1+1+1+1}, {1+1+1+2}, {1+2+2}, {5}

**/
