class MedianFinder {
    //define minHeap - stores maximum numbers
    // define maxheap = store min numbers
    
    //maxHeap size should be +1 of minHeap

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {

        //alway check the maxHeap first and go to minHeap
        // and insert minNumbers in maxHeap
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        //size comaparision and balance
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); //push to minHeap from maxHeap
        } else if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll()); //push to maxHeap from minHeap
        }
        
    }
    
    public double findMedian() {

        // if the totalSize is odd.. peek from the MaxHeap else peek from both and send half
       
        if(minHeap.size() == maxHeap.size()) {
            //even
            return (double)(minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            return (double)maxHeap.peek();
        }
        
    }
}
