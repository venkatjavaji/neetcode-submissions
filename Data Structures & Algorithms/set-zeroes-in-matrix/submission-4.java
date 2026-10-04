class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        // Trackers to see if the original 0th row or 0th column need to be zeroed out later
        boolean fr = false;
        boolean fc = false;

// Step 1: Scan the matrix and use the 0th row and 0th column as tracking arrays
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                // Save whether the original 0th row/col had zeros before overwriting them
                if(matrix[i][j] == 0) {
                    if(i==0) fr = true;
                    if(j==0) fc = true;

                     // Mark the head of the current row and column as 0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

// Step 2: Use the marks in the 0th row/col to set the inner matrix cells to 0
        for(int i=1;i<rows;i++) {
            for(int j=1;j<cols;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
 // Step 3: Handle the 0th row separately based on the tracking flag
        if(fr) {
            for(int i=0;i<cols;i++) {
                matrix[0][i] = 0;
            }
        }
        
// Step 4: Handle the 0th column separately based on the tracking flag
        if(fc) {
            for(int j=0;j<rows;j++) {
                matrix[j][0] = 0;
            }
        }
        
    }
}
