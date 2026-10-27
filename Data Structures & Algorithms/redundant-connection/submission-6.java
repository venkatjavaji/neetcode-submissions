class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int count = edges.length;
        DSU dsu = new DSU(count);
        for(int[] e : edges) {
            if(!dsu.union(e[0],e[1])) {
                return new int[] {e[0],e[1]};
            }
        }
        return new int[]{-1,-1};
        
    }
}

class DSU {
    int[] rank;
    int[] parent;
    public DSU(int n) {
        rank = new int[n+1];
        parent = new int[n+1];

        for(int i=1;i<=n;i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {

        int px = find(x);
        int py = find(y);

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
