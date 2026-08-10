class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        if(amount == 0) return 0;

        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1); //fill all the amounts from 0 to amount+1 (this is to make the highest number of coins later fill it with right number)

        dp[0] = 0; //0 coin would make 0 amount

        // iterate until the given amount
        // calculate the number of coins needed for each amount from 1 to amount
        for(int i=1;i<=amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    // if the amount greater than or equal to the coin then only coins can be picked!!
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        // check for the given amount if the coins can form the amount else return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
