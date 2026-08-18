class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int[] best = new int[target.length];

        for(int[] trip : triplets) {
            if(trip[0] > target[0] ||
                trip[1] > target[1] ||
                trip[2] > target[2]) {
                    continue; //dont add the triplet to the best if it contradicts
                }
                best[0] = Math.max(trip[0], best[0]);
                best[1] = Math.max(trip[1], best[1]);
                best[2] = Math.max(trip[2], best[2]);
        }

        return best[0] == target[0] &&
                best[1] == target[1] &&
                best[2] == target[2];
        
    }
}
