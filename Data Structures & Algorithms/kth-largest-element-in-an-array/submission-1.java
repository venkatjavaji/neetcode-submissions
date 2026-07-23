class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
            if(pq.size()>k) {
                pq.poll(); //removes the lowest element
            }
        }
        return pq.peek(); // returns the kth largest element [top is the smallest in the queue but kth largest]
        
    }
}
