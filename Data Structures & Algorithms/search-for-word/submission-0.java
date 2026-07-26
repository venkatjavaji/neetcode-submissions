class Solution {
    public boolean exist(char[][] board, String word) {

        int rl = board.length;
        int cl = board[0].length;

        for(int i=0 ;i<rl;i++) {
            for(int j=0; j<cl;j++) {
                if(backtrack(board,word,i,j,0)) return true;
            }
        }
        return false;
        
    }

    public boolean backtrack(char[][] board, String word, int r, int c, int idx) {
        if(idx == word.length()) return true; // traversing is done and word is found in the board

        if(r < 0  || r >= board.length ||
            c <0  || c >= board[0].length ||
            board[r][c] != word.charAt(idx) ) {
                return false;
            }
        char temp = board[r][c];
        board[r][c] = '#'; //to preserve and mark this [r][c] char is already visited
        boolean found = backtrack(board,word, r+1,c,idx+1) ||
                        backtrack(board,word,r-1,c,idx+1) ||
                        backtrack(board,word,r,c+1,idx+1) ||
                        backtrack(board, word, r, c-1, idx+1);
        board[r][c] = temp;
        return found;
    }
}
