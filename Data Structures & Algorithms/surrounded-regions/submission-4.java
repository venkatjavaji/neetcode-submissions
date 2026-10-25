class Solution {
    public void solve(char[][] board) {

        int r = board.length;
        int c = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<r; i++) {
            
            //add the cell(i,j) to the queue if it identified as O
            //mark that cell as # and letter turn it to O
            //left col
            if(board[i][0] == 'O') {
                board[i][0] = '#';
                queue.offer(new int[]{i,0});
            }
            //right col
            if(board[i][c-1] == 'O') {
                board[i][c-1] = '#';
                queue.offer(new int[]{i,c-1});
            }
        }

        for(int j=0;j<c;j++) {
            //top-row
            if(board[0][j] == 'O') {
                board[0][j] = '#';
                queue.offer(new int[]{0,j});
            }

            //bottom-row
            if(board[r-1][j] == 'O') {
                board[r-1][j] = '#';
                queue.offer(new int[]{r-1,j});
            }
        }

        bfs(board,queue);

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] =='X')continue;
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    void bfs(char[][] board, Queue<int[]> queue) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int[] dir : directions) {
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];

                if(nr<0 || nr>=board.length ||
                    nc<0 || nc>=board[0].length) continue;
                
                if(board[nr][nc] !='O') continue;
                board[nr][nc] = '#';
                queue.offer(new int[]{nr,nc});
            }
            
        }
    }
}
