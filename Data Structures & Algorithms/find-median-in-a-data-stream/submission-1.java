class MedianFinder {
        /** 1,2,3,4,5
        // max - 1
        //min - 2
        // min - 2,3
        // max.size < min ==> max.offer(min.pop) ==> max - 2,1
        //min - 3

        --> adding 4
        max - 2,1
        min - 3
        checking if max.peek = 3<=2 ? no
        add to min - 3,4

        size check
        max.size -> 2 > 3 no
        min.size -> 2 > 2 no

        ---> adding 5 max [2,1] min [3,4]
        5<=2 no
        add to min-heap => [3,4,5]
        -> size check
            -> 2 > = 4 no
            -> 2 < 3 yes => max[3,2,1] min[4,5]

        find median 
            -> 3 == 2 n0
            -> max.peek() ==> 3

        -- for suppose adding 6
        6<= 3 no
        add to min heap => [4,5,6]

        -> size check
            -> max.size => 3> 3+1 => no
            -> 3 < 3 => no

        -> find median
            -> 
        **/
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        
    }
    
    public void addNum(int num) {

        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); //lower numbers in decreasing order
        } else {
            minHeap.offer(num); // greatest nums in ascending order
        }

        // size check to re-balance
        if(maxHeap.size() > minHeap.size()+1) {
            //rebalance the minHeap
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            //rebalance the maxHeap
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        double median = 0.0;
        // if sizes are equal, poll the top most and average
        if(minHeap.size()==maxHeap.size()) {
            median = (minHeap.peek() + maxHeap.peek())/ 2.0;
        } else {
            median = (double) maxHeap.peek();
        }
        return median;
    }
}
