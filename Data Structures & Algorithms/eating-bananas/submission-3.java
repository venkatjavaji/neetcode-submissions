class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int right = 0;
        int left =1;//low should start at 1.. we are not finding an element but calculating the speed from the given piles.
        for(int p : piles) {
            right = Math.max(right, p);
        }



        while(left<right) {
            int mid = left + (right-left)/2;
            if(canFinish(piles,h,mid)) {
                right = mid; //can able to finish.. find a smaller size..
            } else {
                left = mid+1; //cannot finish.. increase the pile-size..
            }
        }
        return left;
    }

    boolean canFinish(int[] piles, int hours, int pile_size) {
        //time = distance/speed;
        int total_time = 0;
        for(int p : piles) {
            total_time += (p+pile_size-1)/pile_size;
        }
        return total_time <= hours;
    }
}
