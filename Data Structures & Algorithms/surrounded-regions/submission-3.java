class Solution {
    public void solve(char[][] board) {

        //mark the bordeer 0 as temp char '#' and traverse until it is surrounder with 0 then mark all other 0's with X

        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        // rows
        for(int i=0;i<board.length;i++) {
            //left-col
            if(board[i][0] == 'O') {
                board[i][0] = '#';
                q.offer(new int[]{i,0});
            }

            if(board[i][cols-1] == 'O') {
                //right-col
                board[i][cols-1] = '#';
                q.offer(new int[]{i,cols-1});
            }
        }

        for(int j=0;j<cols;j++) {
            //top-row
            if(board[0][j] == 'O') {
                board[0][j] = '#';
                q.offer(new int[]{0,j});
            }

            //bottom-row
            if(board[rows-1][j] == 'O') {
                board[rows-1][j] = '#';
                q.offer(new int[]{rows-1,j});
            }
        }
        bfs(board,q);

        for(int i=0; i< rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    void bfs(char[][] board, Queue<int[]> q) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(nr<0 || nr>=board.length ||
                    nc<0 || nc>=board[0].length) continue;
                if(board[nr][nc] != 'O') continue;
                board[nr][nc] = '#';
                q.offer(new int[]{nr,nc});
            }
        }
    }
}
