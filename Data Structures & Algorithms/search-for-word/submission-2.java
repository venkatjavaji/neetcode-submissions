class Solution {

    int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {

        // iterate over the word character by character..
        // identify the start of the word cell
        // traverse through all the cells in 4-dirs
        // if found true else false

        char ch = word.charAt(0);
        for(int i=0;i<board.length; i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == ch) {
                     if(dfs(board,word, i,j,0)) {
                        return true;
                     } // start from the 0.. we need to backtrack..
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int index) {

        if(index == word.length()) return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length ||
        board[i][j] != word.charAt(index)) return false;

        // memorize the visited cell
        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
             if(dfs(board, word, ni, nj, index+1)) {
                board[i][j] = temp;
                return true;
             }
        }
        //traversed all directions, set back the temp
        board[i][j] = temp;
        return false;

    }
}
