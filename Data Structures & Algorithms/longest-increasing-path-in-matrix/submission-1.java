class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max_path = 0;
        dp = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0; j< cols;j++) {
                dp[i][j] = -1;
            }
        }
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                max_path = Math.max(max_path, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return max_path;
        
    }

    int dfs(int[][] matrix, int r, int c, int prev_val) {
        //at each cell.. traverse all the directions..
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(r<0 || r>=rows || c<0 || c>=cols || matrix[r][c] <= prev_val ) return 0;
        if(dp[r][c]!=-1) return dp[r][c]; //return memorized value...
        int res =1;
        for(int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            res = Math.max(res,1+dfs(matrix, nr, nc, matrix[r][c]));
        } 
        dp[r][c] = res;
        return dp[r][c];
    }
}
