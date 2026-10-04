class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //build the graph with pre-req as index and courses as values

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[numCourses];
        for(int[] preq : prerequisites) {
            int p = preq[1];
            int c = preq[0];
            adj.get(p).add(c);
            degree[c]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(degree[i] == 0) {
                q.offer(i);
            }
        }

        int complete = 0;
        while(!q.isEmpty()) {
            int cc = q.poll();
            complete++;
            for(int next : adj.get(cc)) {
                degree[next]--;
                if(degree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return numCourses == complete;
        
    }
}
