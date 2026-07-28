class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;
        Deque<int[]> que = new ArrayDeque<>();
        for(int i=0;i<grid.length; i++) {
            for(int j=0; j< grid[0].length; j++ ) {
                if(grid[i][j] == 0) {
                    que.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()) {
            int[] treasure = que.poll();
            int r = treasure[0];
            int c = treasure[1];

            
            for(int[] dir : directions) {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr<0 || nr>=grid.length ||
                    nc<0 || nc>=grid[0].length) {
                    continue;
                }
                if(grid[nr][nc]!=INF)  {
                    //this cell is already visited
                    continue; 
                }
                grid[nr][nc] = 1 + grid[r][c];
                que.offer(new int[]{nr,nc});
            }
        }
        
    }
}
