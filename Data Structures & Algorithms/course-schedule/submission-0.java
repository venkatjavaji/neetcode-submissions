class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //course -> list of courses
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // [a,b] => must take b  before taking a
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            // building inDegree to check for any prereq dependency
            inDegree[course]++;
        }

        Deque<Integer> bfs = new ArrayDeque<>();
        for(int j=0; j<numCourses;j++) {
            if(inDegree[j] == 0) {
                bfs.offer(j);
            }
        }

        int complete = 0;
        while(!bfs.isEmpty()) {
            int current = bfs.pop();
            complete++;
            for(int next : graph.get(current)) {
                inDegree[next]--;
                if(inDegree[next]==0) {
                    bfs.offer(next);
                }
            }
        }
        //if all courses are completed, mo cycle exists
        return complete == numCourses;

        
    }
}
