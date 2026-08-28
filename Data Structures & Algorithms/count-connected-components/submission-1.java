class Solution {
    public int countComponents(int n, int[][] edges) {
        //DFS
        List<List<Integer>> graph = new ArrayList<>();

        //build the graph
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        //build the edges 
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components=0;
        //now loop over the edges
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }

        }
        return components;
    }

    public void dfs(int node,  List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for(int neighbour : graph.get(node)) {
           if(!visited[neighbour]) {
            dfs(neighbour, graph, visited);
           }
        }

    }
}
