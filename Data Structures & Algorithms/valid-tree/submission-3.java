class Solution {
    public boolean validTree(int n, int[][] edges) {


        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        int nedges = 0;
        while(!q.isEmpty()){
            int ed = q.poll();
            nedges++;
            
            for(int neighbor : adj.get(ed)) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[ed] = true;
                }
            }
        }

        return n == nedges;
        

    }
}
