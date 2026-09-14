class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize)   {

        Map<Integer,Integer> map = new HashMap<>();

        for(int h : hand) {
            map.put(h, map.getOrDefault(h,0)+1);
        }

        for(int h : hand) {
            int start = h;
            //start will be the lowest possible number
            while(map.getOrDefault(start-1,0)>0) start--;
            //once start is identified as lowest possible number
            if(map.getOrDefault(start,0)>0) {

                for(int i=start; i<start+groupSize; i++) {

                    if(map.getOrDefault(i,0) == 0) return false;

                    map.put(i, map.get(i)-1);
                }
            }
        }

       return true;
        
    }
}
