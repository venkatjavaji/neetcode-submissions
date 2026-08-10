class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        //build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] {time[1],time[2]});
        }

        //Min-heap for BFS treaversal.. build it based on the time wieghts!!
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));

    pq.offer(new int[]{k,0});

    Map<Integer,Integer> timeMap = new HashMap<>();

    while(!pq.isEmpty()) {
        int[] cur = pq.poll();

        int node = cur[0], t = cur[1];
        if(timeMap.containsKey(node)) continue; //this path is already visited.. continue...
        timeMap.put(node, t);
        for(int[] neighbour : graph.getOrDefault(node, Collections.emptyList())){
            int nextNode = neighbour[0], ttaken = neighbour[1];
            if(!timeMap.containsKey(nextNode)) {
                //add the node to the PQ.. for BFS traversal
                pq.offer(new int[]{nextNode, t+ttaken});
            }
        }
    }
    if(timeMap.size() != n) return -1; // this directed- graph do not reach all the nodes from the source
        int maxTimeTakenToReachDest = 0;
        for(int timeTakenAtNode : timeMap.values() ) {
            maxTimeTakenToReachDest = Math.max(maxTimeTakenToReachDest, timeTakenAtNode);
        }
        return maxTimeTakenToReachDest;
        
    }
}
