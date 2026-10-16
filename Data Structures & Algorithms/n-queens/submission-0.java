class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        //track the cols, diag, antiDiag
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();

        int[] queens = new int[n];
        backtrack(0, n, queens, result, cols,diags,antiDiags);
        return result;
        
    }

    void backtrack(int row, int n, int[] queens, List<List<String>> result, Set<Integer> cols, Set<Integer> diags, Set<Integer>antiDiags) {

        if(row == n) {
            //all queens are place on the right columns, build the board..
            result.add(buildBoard(queens,n));
            return;
        }

        for(int col = 0; col<n; col++) {
            int diag = row-col;
            int antiDiag = row+col;
            if(cols.contains(col) 
                || diags.contains(diag)
                || antiDiags.contains(antiDiag)){
                    //cannot place on this col.. since it gets attacked by other queen
                    continue;
                }
            queens[row] = col;
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);
            backtrack(row+1,n,queens,result,cols,diags,antiDiags);
            cols.remove(col);
            antiDiags.remove(antiDiag);
            diags.remove(diag);
        }

    }

    List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++) {
            char[] queenRow = new char[n];
            Arrays.fill(queenRow,'.');
            queenRow[queens[i]] = 'Q'; //place Queen on the right column
            board.add(new String(queenRow));
        }
        return board;
    }
}
