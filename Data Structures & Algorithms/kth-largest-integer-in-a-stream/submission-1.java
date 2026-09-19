class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);

        for(int num : nums) {
            this.pq.offer(num);
        }
        
    }
    
    public int add(int val) {
        this.pq.offer(val);
        while(pq.size()>k) {
            pq.poll();
        }
        return pq.peek();
    }
}
