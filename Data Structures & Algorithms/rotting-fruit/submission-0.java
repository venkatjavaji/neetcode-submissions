class Solution {
    public int orangesRotting(int[][] grid) {

        Deque<int[]> que = new ArrayDeque<>();
        int freshfruits = 0;
         int totaltime = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    que.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    freshfruits++;
                }
            }
        }
        int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
       
        while(!que.isEmpty() && freshfruits>0) {
            int size = que.size();
            totaltime++;  // count this minute upfront, before rotting this level's fruits
            for(int k=0;k<size;k++ ) {
                int[] rottenfruit = que.poll();
                int row = rottenfruit[0];
                int col = rottenfruit[1];
                for(int[] dir : directions) {
                    int nr = row+dir[0];
                    int nc = col+dir[1];
                    if(nr<0 || nr >= grid.length ||
                        nc < 0 || nc >= grid[0].length) {
                        continue;
                    }

                    if(grid[nr][nc] == 2 || grid[nr][nc] == 0) {
                        // System.out.println("nr,nc is either 2 or 0 so skipping r="+nr + " c="+nc);
                        continue; //already rotten.. skip it
                    } 
                    // System.out.println("new freshfruit cell going to be rotten : r="+nr + " nc="+nc );
                    grid[nr][nc] = 2;
                    freshfruits--;
                    que.offer(new int[]{nr,nc});
                
                }
            }
        }
    return freshfruits == 0 ? totaltime : -1;   
    }
}
