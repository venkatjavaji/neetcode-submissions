class Solution {
    public void setZeroes(int[][] matrix) {

        //in-place replacement solution

        //step-1 mark if first-row or first-col can be 0's

        int row_len = matrix.length;
        int col_len = matrix[0].length;
        boolean first_row = false;
        boolean first_col = false;

        //for in-place replacement, mark the first-row and first_col values with 0, the inner matrix can be replaced in the next step
        for(int i=0;i<row_len;i++) {
            for(int j=0;j<col_len;j++) {
                if(matrix[i][j] == 0) {
                    if(i==0) first_row = true;
                    if(j==0) first_col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //start from index-1 and compared with 0th row and col to mark the inner matrix cells with 0's
        for(int i=1;i<row_len;i++) {
            for(int j=1;j<col_len;j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] =0;
                }
            }
        }

        //now replace the 0th index row and col with 0's if applicable

        if(first_row) {
            for(int i=0;i<col_len;i++) {
                matrix[0][i] = 0;
            }
        }

        if(first_col) {
            for(int j=0;j<row_len;j++) {
                matrix[j][0] =0;
            }
        }
        
    }
}
