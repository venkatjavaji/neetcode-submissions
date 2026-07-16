class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1; //low should start at 1.. we are not finding an element but calculating the speed from the given piles.
        int r = 0;
        for(int p : piles ) {
            r = Math.max(r,p); //finding the highest pile
        }

        while(l<r) {

            int mid = l + (r-l)/2;

            if(canFinish(piles,mid,h)) {
                r = mid; // faster, see if lower number can finish the piles
            } else {
                l = mid+1; //slower, find the bigger value for speed
            }
        }

        return l;
    }

    public boolean canFinish(int[] piles,int speed, int totalHours) {
        int timeTaken = 0;
        for(int pile : piles) {
            timeTaken += (pile+speed-1)/speed; //this is equivalent to Math.ceil.. not using ceil to avoid the double precision
        }
        return timeTaken <= totalHours;
    }
}
