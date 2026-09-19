class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size()>1) {
            int f = pq.poll();
            int s = pq.poll();
            int r = f-s;
            pq.offer(r);
        }

        return pq.peek();
        
    }
}
