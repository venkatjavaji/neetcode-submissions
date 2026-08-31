class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=0;i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        // p -> [0,1,2,3,4]
        // r -> [1,1,1,1,1]

        /**
            Please note : 0th node is dummy one..
            {1,2} => p-> [0,2,2,3,4]
                        r -> [1,1,2,1,1]
            {1,3} => p -> [0,2,2,2,4]
                        r ->[1,1,2,1,1]
            {3,4} => p -> [0,2,2,2,2]
                        r -> [1,1,2,1,1]
            {2,4} => cycle found and returns{2,4}
        **/
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
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(rank));
        // System.out.println("---------------------------");
        int p1 = find(parent, u);
        int p2 = find(parent, v);

        if(p1 == p2) return false; //sharing same parent.. cycle identified
        if(rank[p1] > rank[p2]) {
            // rank[p1] += rank[p2];
            parent[p2] = p1;
        } else if(rank[p1] < rank[p2]){
            // rank[p2] += rank[p1];
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
        return true; //no cycle identified
    }
}
