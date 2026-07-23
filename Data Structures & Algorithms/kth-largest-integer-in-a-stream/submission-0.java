class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        //priorityQueue default minHeap
        this.pq = new PriorityQueue<>(k);

        for(int n : nums) {
            add(n); //add nums to the pq
        }

        
    }
    
    public int add(int val) {

        //always add the val to queue
        this.pq.offer(val);

        if(this.pq.size() > this.k) {
            this.pq.poll(); //removes the  min - the smallest value
        }
        return this.pq.peek(); // top of the queue is the kth largest of given stream..      
    }
}
