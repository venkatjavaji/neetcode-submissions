class Solution {
    public int diagonalSum(int[][] mat) {

        int max_sum = 0;
        int d_sum = 0;
        int rl = mat.length;
        int cl = mat[0].length;
        for(int i=0; i<rl; i++) {
            for(int j=0;j<cl;j++) {
                if(i==j) {
                    d_sum += mat[i][j];
                }
                // 00, 11,22
                //00,11,22,33
               //02 , 11, 20
               //03, 12, 21, 30
            }
        }
        int dcl = cl-1;
        for(int i=0;i<rl;i++) {
            if(i == dcl) {
                dcl--;
                continue;
            }
            d_sum += mat[i][dcl--];
        }
        

        return d_sum;
        
    }
}