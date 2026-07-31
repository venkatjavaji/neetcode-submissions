class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] result = new int[numCourses];

        int[] cdegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] preq : prerequisites) {
            int course = preq[0];
            int prereq = preq[1];
            graph.get(prereq).add(course);
            cdegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int j=0;j<numCourses;j++) {
            if(cdegree[j] == 0) {
                queue.offer(j);
            }
        }

        int idx = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            result[idx++] = current;
            for(int next : graph.get(current)) {
                cdegree[next]--;
                if(cdegree[next]==0) {
                    queue.offer(next);
                }
            }
        }

        return idx==numCourses ? result : new int[0];
        
    }
}
