class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int row=0; row<9;row++) {
            Set<Integer> rowSet = new HashSet<>();
            for(int col=0;col<9;col++) {
                if(board[row][col] == '.') continue;
                if(!rowSet.add(board[row][col]-'0')) return false;
            }
        }

        for(int col=0; col<9;col++) {
            Set<Integer> colSet = new HashSet<>();
            for(int row=0;row<9;row++) {
                if(board[row][col] == '.') continue;
                if(!colSet.add(board[row][col]-'0')) return false;
            }
        }

        for(int square=0;square<9;square++) {
            Set<Integer> sqSet = new HashSet<>();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int row = (square/3) * 3 + i;
                    int col = (square%3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(!sqSet.add(board[row][col]-'0')) return false;
                }
            }
        }

        return true;
    }
}
