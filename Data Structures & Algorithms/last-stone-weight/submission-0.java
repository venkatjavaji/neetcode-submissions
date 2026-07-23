class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int n : stones) {
             maxHeap.offer(n);
        }
        while(maxHeap.size()>1) {
            int y = maxHeap.poll(); //largest
            int x = maxHeap.poll(); //second largest
          if(x!=y) {
                maxHeap.offer(y-x);
            }
        }
      return  maxHeap.isEmpty() ? 0 : maxHeap.poll();
        
    }
}
