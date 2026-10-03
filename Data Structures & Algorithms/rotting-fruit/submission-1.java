class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new ArrayDeque<>();
        int fresh_fruits = 0;
        // 1. Initialize queue with initially rotten oranges and count fresh ones
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh_fruits++;
                }
            }
        }
        // Edge case: If there are no fresh oranges to begin with, 0 minutes have passed
        if (fresh_fruits == 0) return 0;

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int time = 0;
        // 2. Process layer-by-layer (minute-by-minute)
        while(!q.isEmpty() && fresh_fruits>0) {

            int qsize = q.size(); // Capture the number of oranges rotting in THIS current minute
            for(int i=0; i<qsize; i++) {
               int[] rotten = q.poll();
                int nr = rotten[0];
                int nc = rotten[1];

                for(int[] dir : directions) {
                    int dr = nr + dir[0];
                    int dc = nc + dir[1];
                    // Boundary validation
                    if(dr<0 || dr>=grid.length ||
                        dc<0 || dc>=grid[0].length) continue;
                     // Skip empty spaces or already rotten oranges
                    if(grid[dr][dc] == 0 || grid[dr][dc]==2) continue;

                    grid[dr][dc] = 2;
                    fresh_fruits--;
                    q.offer(new int[] {dr,dc});
                }
            }
            // Increment time only AFTER processing the entire current layer (1 full minute)
            time++;

        }
        return fresh_fruits==0 ? time : -1;
    }
}
