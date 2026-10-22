class Solution {
    public int numIslands(char[][] grid) {
        // I need to iterate the graph and do dfs/bfs when I encounter 1
        int result = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    result++;
                    dfs(grid,i,j);
                }
            }
        }  
        return result;
    }

    void dfs(char[][] grid,int i, int j) {
       
        if(i<0 || i>=grid.length
            || j<0 || j>=grid[0].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
