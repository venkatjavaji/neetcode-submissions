class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

            //build the map
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0;i<numCourses;i++) {
                adj.add(new ArrayList<>());
            }
            int[] degree = new int[numCourses];
            for(int[] pre : prerequisites) {
                adj.get(pre[1]).add(pre[0]);
                degree[pre[0]]++;
            }
            
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i=0;i<numCourses;i++) {
                if(degree[i]==0) {
                    queue.offer(i);
                }
            }

            int count = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                for(int next : adj.get(cur)) {
                    degree[next]--;
                    if(degree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            return count == numCourses;

            
        
    }
}
