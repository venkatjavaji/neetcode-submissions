class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //BFS using queue - timecomplexity O(n2)

        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n ; i++) graph.add(new ArrayList<>());

       
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if(bfs(graph, u, v, n)) return edge;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[]{-1,-1};
    }

    public boolean bfs(List<List<Integer>> graph,int start, int target,int n) {
        //we need to find the cycle from any node, so the queue and visited are here..
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == target) {
                //if a graph has cycle.. curr will be equilant to target
                return true;
            }
            for(int neighbour : graph.get(curr)) {
                if(!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        return false;
    }
}
