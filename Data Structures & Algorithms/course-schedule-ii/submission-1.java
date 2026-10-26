class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //build the graph 
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[numCourses];
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            degree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(degree[i]==0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result[count++] = cur;
            for(int next : graph.get(cur)) {
                degree[next]--;
                if(degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses ? result : new int[0];
        
    }
}
