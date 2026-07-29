class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights[0].length <=0) return result;

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Deque<int[]> pacificq = new ArrayDeque<>();
        Deque<int[]> atlanticq = new ArrayDeque<>();

        // pacific - left-colum & top-row
        // atlantic - right-colum & bottom-row

        for(int i=0;i<rows;i++) {
            pacificq.offer(new int[]{i,0}); //left-column
            pacific[i][0] = true;

            atlanticq.offer(new int[]{i,cols-1}); // right-column
            atlantic[i][cols-1] = true;
        }

        for(int j=0;j<cols;j++) {
            pacificq.offer(new int[]{0,j});//top-row
            pacific[0][j] = true;

            atlanticq.offer(new int[]{rows-1,j}); //bottom-row
            atlantic[rows-1][j] = true;
        }

        bfs(heights,pacificq,pacific); //traverse the pacific cells
        bfs(heights,atlanticq,atlantic); //traverse the atlantic cells

        for(int r =0 ; r<rows; r++) {
            for(int c = 0; c<cols;c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    public void bfs(int[][] heights, Deque<int[]> deq, boolean[][] visited) {

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!deq.isEmpty()) {
            int[] cell = deq.pop();
            int row = cell[0];
            int col = cell[1];


            for(int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                
                if(nr<0 || nr >= heights.length ||
                    nc<0 || nc >= heights[0].length) continue;
                if(visited[nr][nc]) continue; // skip already visited cell
                if(heights[nr][nc] < heights[row][col]) continue; // must be non-decreasing inland
                visited[nr][nc] = true; // make this cell visited, to avoid re-consideration
                deq.offer(new int[]{nr,nc}); // add this cell to the queue to traverse BFS
            }
        }





    }
}
