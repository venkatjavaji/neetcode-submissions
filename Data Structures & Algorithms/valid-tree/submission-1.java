class Solution {
    public boolean validTree(int n, int[][] edges) {
        //using bfs
        // A valid tree must have exactly n-1 edges
        if(n-1!=edges.length) return false;
        // now build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        //build the graph with neighbours
        // 0 - [1,2,3]
        // 1 - [0,4]
        //2 - [0]
        //3 - [0]
        //4 - [1]
        for(int[] edg : edges) {
            graph.get(edg[0]).add(edg[1]);
            graph.get(edg[1]).add(edg[0]);
        }

        //now take a queue and build the visited array
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(0); //start from node - 0
        visited[0] = true;
        int noEdges = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            noEdges++;
            List<Integer> nodeges = graph.get((Integer) node);
            for(int i : nodeges){
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println("noOfEdges : "+ noEdges);
        return  n == noEdges;
    }
}
