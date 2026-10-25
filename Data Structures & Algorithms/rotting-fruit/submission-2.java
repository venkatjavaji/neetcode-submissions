class Solution {
    public int orangesRotting(int[][] grid) {

        //implement using BFS - Queue

        Queue<int[]> queue = new ArrayDeque<>();
        int freshFruits = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }

        if(freshFruits == 0) return 0;
        int count = 0;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty() && freshFruits>0) {
            count++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] cur = queue.poll();
                for(int[] dir : directions) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if(nr<0 || nr>=grid.length 
                        || nc<0 || nc>=grid[0].length) continue;
                    if(grid[nr][nc]==2 || grid[nr][nc] == 0) continue;
                    grid[nr][nc] = 2;
                    freshFruits--;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return  freshFruits == 0 ? count : -1;
        
        
    }
}
