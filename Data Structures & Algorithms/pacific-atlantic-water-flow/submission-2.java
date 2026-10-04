class Solution {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int cols = heights[0].length;
        int rows = heights.length;
        //build the pacificQ and atlanticQ
        Queue<int[]> pacific_q = new ArrayDeque<>(); //top-row and left-column
        Queue<int[]> atlantic_q = new ArrayDeque<>(); //bottom-row and right-col
        boolean[][] pacific_v = new boolean[rows][cols];
        boolean[][] atlantic_v = new boolean[rows][cols];
    
        for(int i=0;i<rows;i++) {
            pacific_q.offer(new int[]{i,0}); //left-col
            pacific_v[i][0] = true;

            atlantic_q.offer(new int[]{i,cols-1});
            atlantic_v[i][cols-1] = true;
        }

        for(int j=0;j<cols;j++) {
            pacific_q.offer(new int[]{0,j}); //top-row
            pacific_v[0][j] = true;

            atlantic_q.offer(new int[]{rows-1,j}); //botton-row
            atlantic_v[rows-1][j] = true;
        }

        bfs(heights,pacific_v,pacific_q);
        bfs(heights,atlantic_v, atlantic_q);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(atlantic_v[i][j] && pacific_v[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q) {

        while(!q.isEmpty()) {

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            
            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr<0 || nr>=heights.length ||
                    nc<0 || nc>=heights[0].length) continue;

                if(visited[nr][nc]) continue;

                if(heights[nr][nc] < heights[r][c]) continue;
                
                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc});
            }
        }
    }
}
