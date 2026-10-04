class Solution {
    public int countComponents(int n, int[][] edges) {

        //if we are using the bfs.. we need to iterate over the bfs to identify how my times the loop iterates..

        //build the graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        
        //looping the nodes
        //build the queue
        //increment the number of components...
        int num_comp = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i])  {
                visited[i] = true;
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(i);
                num_comp++;
                while(!q.isEmpty()) {
                    int e = q.poll();
                    for(int nei : adj.get(e)) {
                        if(!visited[nei]) {
                            q.offer(nei);
                            visited[nei] = true;
                        }
                        
                    }
                }
            }
            
        }
        return num_comp;
        

    }
}
