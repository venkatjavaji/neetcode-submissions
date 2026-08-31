class Solution {

    class DSU {
        int[] parent;
        int[] rank;
        public DSU(int n) {
            parent = new int[n+1];
            rank = new int[n+1];

            for(int i=0; i <=n ; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // find the parent of the given vertex
        public int find(int[] parent, int x) {
            if(parent[x]!=x) {
                parent[x] = find(parent, parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(parent, x);
            int py = find(parent, y);

            if(px == py) return false;

            if(rank[px] < rank[py]) {
                parent[px] = py;
            } else if(rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {

        int count = n;

        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            if(dsu.union(edge[0], edge[1])) {
                count--;
            }
        }

        return count;

    }
}
