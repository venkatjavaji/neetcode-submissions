class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[] mindist = new int[n];
        Arrays.fill(mindist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        
        mindist[0] = 0;
        int totalcost = 0;

        for(int i=0; i<n ; i++) {
            int u = -1;
            for(int j=0; j<n; j++) {
                if(!visited[j] && (u==-1 || mindist[j]<mindist[u])) {
                    u = j;
                }
            }

            visited[u] = true;
            totalcost += mindist[u];

            for(int v=0;v<n;v++) {
                if(!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) +
                                Math.abs(points[u][1] - points[v][1]);
                    mindist[v] = Math.min(mindist[v],dist);
                }
            }
            
        }
        return totalcost;
    }
}
