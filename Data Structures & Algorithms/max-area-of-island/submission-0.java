class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    maxarea = Math.max(maxarea, dfs(grid,i,j));
                }  
            }
        }
        return maxarea;
        
    }

    public int dfs(int[][] grid, int r, int c) {

        if(r<0 || r>=grid.length ||
            c<0 || c >=grid[0].length ||
            grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0; //reset to '0' to avoid re-calculation of land

        return 1 + dfs(grid,r+1,c) + dfs(grid,r-1,c) +
                    dfs(grid,r,c+1) + dfs(grid,r,c-1);

    }
}
