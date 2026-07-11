class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new TreeMap<>();

        for(int n : nums) {
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }
        System.out.println(countMap);


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) 
                    -> countMap.get(a)-countMap.get(b));

        for(int num : countMap.keySet()) {
            pq.offer(num);
            if(pq.size()>k) pq.poll();
        }
        System.out.println(pq);
         System.out.println(pq.size());

        int result[] = new int[k];
        for(int i=k-1; i>=0; i--) {
            result[i] = pq.poll();
        }

        return result;
        
    }
}
