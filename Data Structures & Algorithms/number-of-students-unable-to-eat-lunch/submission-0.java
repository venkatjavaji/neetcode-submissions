class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        // 1,1,0,0 -> 0,1,0,1
        //if the student matches sanwitch poll-out the student and sandwitch else poll the student and add it again
        Deque<Integer> stuq = new ArrayDeque<>();
        int len = students.length;
        int san_pointer = 0;
        for(int i=0;i< len;i++) {
            stuq.offer(students[i]);
        }

        int counter = 0;
        while(!stuq.isEmpty() && counter < len) {
            int cur_stu = stuq.poll();
            if( cur_stu == sandwiches[san_pointer]) {
                san_pointer++;
                counter = 0;
            } else {
                stuq.offer(cur_stu);
                counter++;
            }
        }
        return stuq.size();
        
    }
}