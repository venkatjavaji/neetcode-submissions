class MedianFinder {
    // we cant find/access the mid of PriorityQueue
    // so initialise min and max queues
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        // maxHeap will store the smaller elements in descresing order
        //minHeap will store the bigger elements in increasing order
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        //re-balance the heaps
        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // if both min and max heaps are of same size.. then return the max-top+min-top/2 else return maxHeap-top ;

        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return (double) maxHeap.peek();
    }
}
