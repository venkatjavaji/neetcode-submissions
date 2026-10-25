class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int INF = 2147483647;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<grid.length;i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : directions) {
                int nr = cur[0]+dir[0];
                int nc = cur[1]+dir[1];
                if(nr<0 || nr>=grid.length
                    || nc<0 || nc>=grid[0].length) continue;
                
                if(grid[nr][nc]!=INF) continue;
                grid[nr][nc] = Math.min(grid[nr][nc],grid[cur[0]][cur[1]]+1);
                queue.offer(new int[]{nr,nc});
            }

        }

        
    }
}
