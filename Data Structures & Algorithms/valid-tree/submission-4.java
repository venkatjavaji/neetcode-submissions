class Solution {
    //dfs solution
    public boolean validTree(int n, int[][] edges) {

        // A valid tree must have exactly n-1 edges
        if (edges.length != n - 1) return false;
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(adj,visited,0);

        return visited.size() == n;

    }

    void dfs(List<List<Integer>> adj, Set<Integer> visited, int edge) {

        if(!visited.add(edge)) return;
        for(Integer e : adj.get(edge)) {
            dfs(adj,visited,e);
        }
    }
}
