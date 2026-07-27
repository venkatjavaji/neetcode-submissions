class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();
        
        
        for(String word : words) {
            boolean found = false;
            for(int i=0;i<rows & !found; i++) {
                for(int j=0;j<cols && !found;j++) {
                    if(backtrack(board,word,i,j,0)) {
                        result.add(word);
                        found = true;
                    }
                }
            }
        }
        return result;
        
    }

    public boolean backtrack(char[][] board, String word, int row, int col,int idx){

        if(idx == word.length()) return true;
        char ch = word.charAt(idx);
        if(row<0 ||row >= board.length || 
            col<0 || col>= board[0].length ||
            board[row][col]!= ch
        ) {
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] ='#';

        boolean found = backtrack(board,word,row+1, col,idx+1) ||
                        backtrack(board,word,row-1,col,idx+1)  ||
                        backtrack(board,word,row,col+1,idx+1)  ||
                        backtrack(board,word,row,col-1,idx+1);
        
        board[row][col] = temp;
        return found;


    }
}
