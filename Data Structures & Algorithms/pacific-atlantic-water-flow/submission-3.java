class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int r = heights.length;
        int c = heights[0].length;
        boolean[][] p_cells = new boolean[r][c];
        boolean[][] a_cells = new boolean[r][c];
        Queue<int[]> p_q = new ArrayDeque<>();
        Queue<int[]> a_q = new ArrayDeque<>();
        //p_cells top row and left column
        //a_cells bottom row and right column
        for(int i=0;i<c;i++) {
            p_cells[0][i] = true; //top_row
            p_q.offer(new int[]{0,i});
            a_cells[r-1][i] = true; //bottom_row
            a_q.offer(new int[]{r-1,i});
        }

        for(int j=0;j<r;j++) {
            p_cells[j][0] = true; //left col
            p_q.offer(new int[]{j,0});
            a_cells[j][c-1] = true; //right col
            a_q.offer(new int[]{j,c-1});
        }

        bfs(heights,p_cells,p_q);
        bfs(heights,a_cells,a_q);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {

                if(p_cells[i][j] && a_cells[i][j]) {
                    result.add(List.of(i,j));
                }

            }
        }
        return result;
        
    }

    void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : directions) {
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];

                if(nr<0 || nr>=heights.length ||
                    nc<0 || nc>=heights[0].length) continue;
                
                if(visited[nr][nc]) continue;
                if(heights[nr][nc] < heights[cur[0]][cur[1]]) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc});
            }
        }
    }
}
