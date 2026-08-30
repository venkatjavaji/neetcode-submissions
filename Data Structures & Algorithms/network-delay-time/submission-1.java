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

/*
 * DRY RUN:
 * times = [[1,2,1],[2,3,1],[1,4,4],[3,4,1]], n = 4, k = 1
 *
 * Graph built:
 *   1 -> [(2,1), (4,4)]
 *   2 -> [(3,1)]
 *   3 -> [(4,1)]
 *
 * PQ starts: [(1,0)]
 * timeMap = {}
 *
 * Step 1: poll (1,0) -> not visited -> timeMap={1:0}
 *         push neighbours: (2, 0+1=1), (4, 0+4=4)
 *         PQ: [(2,1), (4,4)]
 *
 * Step 2: poll (2,1) -> not visited -> timeMap={1:0, 2:1}
 *         push neighbour: (3, 1+1=2)
 *         PQ: [(3,2), (4,4)]
 *
 * Step 3: poll (3,2) -> not visited -> timeMap={1:0, 2:1, 3:2}
 *         push neighbour: (4, 2+1=3)
 *         PQ: [(4,3), (4,4)]   // two entries for node 4 now sit in the heap
 *
 * Step 4: poll (4,3) -> not visited -> timeMap={1:0, 2:1, 3:2, 4:3}
 *         node 4 has no outgoing edges
 *         PQ: [(4,4)]
 *
 * Step 5: poll (4,4) -> timeMap already contains 4 -> SKIP (stale/lazy-deleted entry)
 *         PQ: []
 *
 * timeMap.size() == 4 == n -> all nodes reached
 * max value in timeMap = 3 -> answer = 3
 *
 * Note: this trace shows exactly why the containsKey check matters —
 * node 4 was reached via the shorter path (1->2->3->4, cost 3) before
 * the longer direct edge (1->4, cost 4) got popped, so the stale (4,4)
 * entry is correctly discarded instead of overwriting the answer.
 */
