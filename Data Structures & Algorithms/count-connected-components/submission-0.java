class Solution {
    public int countComponents(int n, int[][] edges) {

        //edge case
        if(n==1) return 1;
        //using BFS
        //build the graph first
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n ;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        boolean[] seen = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!seen[i]) {
                components++; //count component at each component completion
                bfs(i, graph, seen);
            }
            
        }
        return components;
        
    }

    public void bfs(int start, List<List<Integer>> graph, boolean[] seen) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);

            while(!queue.isEmpty()) {
                int node = queue.poll();
                seen[node] = true;
                for(int neighbour : graph.get(node)) {
                    if(!seen[neighbour]) {
                        seen[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }

    }

}
