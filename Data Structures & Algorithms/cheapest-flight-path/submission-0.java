class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //build the graph
        // soure -> [dest, cost]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] f : flights) {
            graph.computeIfAbsent(f[0], v -> new ArrayList<>()).add(new int[]{f[1],f[2]});
        }

        //create a priority-queue to store the cost and number of halts

        // min heap, flight with min-cost will be at the top!!
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        // pq holds -> [destination, cost, numberofhalts]
        pq.offer(new int[]{src, 0, 0});

        Map<Integer,Integer> best_stops_map=new HashMap<>();
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];

            if(node == dst) return cost;
            if(stops > k) continue; // max num of stops reached.. go to next

 // prune: if we've already reached this node with <= stops previously, skip
            if(best_stops_map.containsKey(node) && best_stops_map.get(node)<= stops) continue;
            best_stops_map.put(node,stops);

            for(int[] curdest : graph.getOrDefault(node, Collections.emptyList())) {
                int nextnode = curdest[0];
                int price = curdest[1];
                pq.offer(new int[]{nextnode, price+cost, stops+1});
            }

        }

        return -1;

    }
}
