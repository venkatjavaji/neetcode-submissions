class Solution {

    //Prism's algorithm
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0,0}); //start at point 0 with cost 0 : {dist,point}
        int totalCost = 0;
        int edgesUsed = 0;


        while(edgesUsed<n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];

            if(visited[u]) continue;
            visited[u] = true;
            totalCost += cost;
            edgesUsed++;

            //push distances from u to all unvisited points
            for(int v=0;v<n;v++) {
                if(!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + 
                                Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{dist, v});
                }
            }
        }
        return totalCost;
    }
}


/*
 * Input: points = [[0,0], [2,2], [3,10], [5,2], [7,0]]
 *
 * Pairwise Manhattan Distances:
 *   0:[0,0] <-> 1:[2,2]  = |0-2| + |0-2| = 4
 *   0:[0,0] <-> 2:[3,10] = |0-3| + |0-10| = 13
 *   0:[0,0] <-> 3:[5,2]  = |0-5| + |0-2| = 7
 *   0:[0,0] <-> 4:[7,0]  = |0-7| + |0-0| = 7
 *   1:[2,2] <-> 2:[3,10] = |2-3| + |2-10| = 9
 *   1:[2,2] <-> 3:[5,2]  = |2-5| + |2-2| = 3
 *   1:[2,2] <-> 4:[7,0]  = |2-7| + |2-0| = 7
 *   3:[5,2] <-> 2:[3,10] = |5-3| + |2-10| = 10
 *   3:[5,2] <-> 4:[7,0]  = |5-7| + |2-0| = 4
 *
 * State:
 *   visited = {}
 *   minHeap = [(cost: 0, point: 0)]   // stores [cost, pointIndex]
 *   totalCost = 0
 *
 * Step 1:
 *   poll (0, 0) -> point 0 not visited
 *   visited = {0}, totalCost = 0 + 0 = 0
 *   push edges from 0: (4, 1), (7, 3), (7, 4), (13, 2)
 *   minHeap = [(4, 1), (7, 3), (7, 4), (13, 2)]
 *
 * Step 2:
 *   poll (4, 1) -> point 1 not visited
 *   visited = {0, 1}, totalCost = 0 + 4 = 4
 *   push edges from 1: (3, 3), (7, 4), (9, 2)
 *   minHeap = [(3, 3), (7, 3), (7, 4), (7, 4), (9, 2), (13, 2)]
 *
 * Step 3:
 *   poll (3, 3) -> point 3 not visited
 *   visited = {0, 1, 3}, totalCost = 4 + 3 = 7
 *   push edges from 3: (4, 4), (10, 2)
 *   minHeap = [(4, 4), (7, 3), (7, 4), (7, 4), (9, 2), (10, 2), (13, 2)]
 *
 * Step 4:
 *   poll (4, 4) -> point 4 not visited
 *   visited = {0, 1, 3, 4}, totalCost = 7 + 4 = 11
 *   push edges from 4: (14, 2)
 *   minHeap = [(7, 3), (7, 4), (7, 4), (9, 2), (10, 2), (13, 2), (14, 2)]
 *
 * Step 5:
 *   poll (7, 3) -> point 3 ALREADY visited (skip)
 *   poll (7, 4) -> point 4 ALREADY visited (skip)
 *   poll (7, 4) -> point 4 ALREADY visited (skip)
 *   poll (9, 2) -> point 2 not visited
 *   visited = {0, 1, 3, 4, 2}, totalCost = 11 + 9 = 20
 *
 * All 5 points visited -> stop early!
 * Final Answer: 20
 */
