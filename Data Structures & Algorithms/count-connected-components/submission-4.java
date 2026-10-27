class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        DSU dsu = new DSU(n);
        for(int[] e : edges) {
            if(dsu.union(e[0],e[1])) {
                count--;
            }
        }
        return count;

    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        this.parent = new int[n+1];
        this.rank = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(parent[x]!=x) {
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
