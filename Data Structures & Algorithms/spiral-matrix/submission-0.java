class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        /*
            row -> col -> row -> col
            1 - rowBegin, rowEnd
            2 - colBegin, colEnd
        */

        List<Integer> result = new ArrayList<>();

        int row_begin = 0;
        int row_end = matrix.length-1;
        int col_begin = 0;
        int col_end = matrix[0].length-1;
        
        while(row_begin<=row_end && col_begin<=col_end) {

            //direction >>>>>>>>>>
            for(int i=col_begin;i<=col_end;i++) {
                result.add(matrix[row_begin][i]);
            }
            row_begin++;
            //direction vvvvvvvvv
            for(int i=row_begin;i<=row_end;i++) {
                result.add(matrix[i][col_end]);
            }
            col_end--;

            if(row_begin<=row_end) {
                //direction <<<<<<<<<
                for(int i=col_end;i>=col_begin;i--) {
                    result.add(matrix[row_end][i]);
                }
               
            }
             row_end--;
            
            if(col_begin<=col_end) {
                //direction ^^^^^^^^^^^^^^
                for(int i = row_end;i>=row_begin;i--){
                    result.add(matrix[i][col_begin]);
                }
               
            }
             col_begin++;
            
        }
        return result;
        
    }
}
