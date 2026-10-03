class Solution {


    public void islandsAndTreasure(int[][] grid) {

        int INF = 2147483647; 
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] treasure = q.poll();
            int r = treasure[0];
            int c = treasure[1];

            for(int[] dir : directions) {
                int nr = r+dir[0];
                int nc = c + dir[1];

                if(nr<0 || nr>=grid.length ||
                    nc<0 || nc>=grid[0].length) continue;
                
                if(grid[nr][nc] != INF) continue;

                if(grid[nr][nc] == INF) {
                    grid[nr][nc] = 1+grid[r][c];
                    q.offer(new int[]{nr,nc});
                } 
                // else {
                //     grid[nr][nc] = Math.min(grid[nr][nc],grid[r][c]);
                // }

            }
        }
        
    }
}
