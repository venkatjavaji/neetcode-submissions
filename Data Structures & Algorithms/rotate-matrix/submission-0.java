class Solution {
    public void rotate(int[][] matrix) {

        /*
        2x2 analogy
            [00,01]
            [10,11]
            becomes
            [10,00]
            [11,01]

            step1 - transpose ==>01 -> 10
            step2 - horizontal relfection ==> reverse each row
        */
        int n = matrix.length; //nxn matrix

        //transpose
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) { // j starts at i+1 to avoid re-swapping / swapping diagonal with itself
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the each row
        for(int row=0;row<n;row++) {
            int left=0;int right =n-1; //for each column
            while(left<right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }
    }
}
