class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }
        //build the graph
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int e = queue.poll();
            count++;
            for(int c : graph.get(e)) {
                if(visited.add(c)) queue.offer(c);
            }
        }
        return n == count;


    }
}
