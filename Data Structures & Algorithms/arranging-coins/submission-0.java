class Solution {
    public int arrangeCoins(int n) {
        //arrange coins
        // 1 - 1,  2 -2, 3-3
        //4-1 =3
        //3-2=1
        //
        int temp = n;
        int r = 0;
        for(int i=1;i<=n;i++) {
             temp = (temp-i);
              
            if(temp<0) {
                break;
            } else {
                r=i;
            }
           
        }
        return r;
    }  
}