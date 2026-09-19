class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point : points) {
            pq.offer(point);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while(pq.size()!=0) {
            int[] p = pq.poll();
            result[counter++] = p;
        }
        return result;
    }
}
