class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=0;i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!union(parent, rank, edge[0], edge[1])) {
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[0];
    }

    public int find(int[] parent, int v) {
        if(parent[v] != v) {
            //iterate until find the parent
            parent[v] = find(parent, parent[v]);
        }
        return parent[v];
    }

    public boolean union(int[] parent, int[] rank, int u, int v) {
        int p1 = find(parent, u);
        int p2 = find(parent, v);

        if(p1 == p2) return false; //sharing same parent.. cycle identified
        if(rank[p1] > rank[p2]) {
            rank[p1] += rank[p2];
            parent[p2] = p1;
        } else {
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }
        return true; //no cycle identified
    }
}
