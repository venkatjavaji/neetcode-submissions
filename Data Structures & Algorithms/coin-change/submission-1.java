class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        if(amount == 0) return 0;

        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1); //fill all the amounts from 0 to amount+1 (this is to make the highest number of coins later fill it with right number)

        dp[0] = 0; //0 coin would make 0 amount

        // iterate until the given amount
        // calculate the number of coins needed for each amount from 1 to amount
        for(int j=1;j<=amount; j++) {
            for(int coin : coins) {
                if(coin <= j) {
                    // if the amount greater than or equal to the coin then only coins can be picked!!
                    dp[j] = Math.min(dp[j], dp[j-coin]+1);
                }
            }
        }
        // check for the given amount if the coins can form the amount else return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/**
amount = 11, coins = [1, 2, 5]

Start: dp[0] = 0, everything else = 12 (sentinel = amount+1)

j=1: coin=1 -> dp[1]=min(12, dp[0]+1)=1
j=2: coin=1 -> dp[2]=min(12, dp[1]+1)=2
     coin=2 -> dp[2]=min(2,  dp[0]+1)=1
j=3: coin=1 -> dp[3]=min(12, dp[2]+1)=2
     coin=2 -> dp[3]=min(2,  dp[1]+1)=2
j=4: coin=1 -> dp[4]=min(12, dp[3]+1)=3
     coin=2 -> dp[4]=min(3,  dp[2]+1)=2
j=5: coin=1 -> dp[5]=min(12, dp[4]+1)=3
     coin=2 -> dp[5]=min(3,  dp[3]+1)=3
     coin=5 -> dp[5]=min(3,  dp[0]+1)=1
...
j=11: best combo ends up 5+5+1 -> dp[11]=3

Result: dp[11] = 3 → 5 + 5 + 1

**/
