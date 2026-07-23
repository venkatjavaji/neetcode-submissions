class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
        // intution : min-Heap
        for(int[] point : points) {
            int dist = point[0]*point[0] + point[1]*point[1];
            //adding dist as the 0th element, based on the comparatore passed to the PriorityQueue, it gets sorted based on the 0th index
            pq.offer(new int[]{dist,point[0],point[1]});
        }

        int[][] res = new int[k][2];

        for(int i=0; i<k; i++) {
            int[] point = pq.poll();
            //pull out the x and y pointer from 1st and 2nd index
            res[i] = new int[] {point[1],point[2]};
        }

        return res;
    }
}
