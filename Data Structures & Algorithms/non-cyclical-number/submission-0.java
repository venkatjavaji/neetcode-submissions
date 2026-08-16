class Solution {
    public boolean isHappy(int n) {

        int t = n;
        Set<Integer> set = new HashSet<>();
        while(t != 1) {
            int sum = 0;
            while(t>0) {
                int q = t/10;
                int r = t%10;
                t = q;
                sum += (r*r);   
            }
            if(!set.add(sum)) return false;
            t = sum;
        }
        return true;
    }
}
