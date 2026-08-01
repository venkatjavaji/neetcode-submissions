class Solution {
    public void solve(char[][] board) {

        // mark the boundary and its connected '0' to safe char '#'

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++) {
            markSafe(board, i, 0);  //fixing the left col
            markSafe(board, i, cols-1); //fixing the right col
        }

        for(int j=0;j<cols;j++) {
            markSafe(board,0,j);    //fixing the top row
            markSafe(board,rows-1,j); //fixing the bottom row
        }
        
        for(int i=0; i< rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j] =='O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    void markSafe(char[][]board, int r, int c) {
        if(r<0|| r>=board.length || c<0 || c>=board[0].length) return;
        if(board[r][c]!='O') return;//if it is not 0 break the dfs
        board[r][c] = '#';
        markSafe(board, r+1,c);
        markSafe(board,r-1,c);
        markSafe(board,r,c+1);
        markSafe(board,r,c-1);
    }
}
