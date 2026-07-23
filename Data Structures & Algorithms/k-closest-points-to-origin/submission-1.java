class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        //intution MAX-HEAP
        //a=[0,2] b=[1,2]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));

        for(int[] point : points) {
            pq.offer(point);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while(!pq.isEmpty()) {
            int[] pntr = pq.poll();
            result[counter++] = pntr;
        }

        return result;
    }
}
