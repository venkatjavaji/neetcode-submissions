class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        //build the graph using the map, key as the source - value [dest, timetaken]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] t : times) {
            graph.computeIfAbsent(t[0], v -> new ArrayList<>()).add(new int[]{t[1],t[2]});
        }

        //take a pq to traverse the graph..
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        pq.offer(new int[]{k,0}); //intial value is starting point - k and time-taken to reach k is 0

        Map<Integer,Integer> timeMap = new HashMap<>(); //timeMap is needed to calculate time-taken at each node from the start

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curTime = cur[1];
            if(timeMap.containsKey(curNode)) continue; //this node is already visited...
            timeMap.put(curNode, curTime);
            for(int[] neighbours : graph.getOrDefault(curNode, List.of())) {
                int next = neighbours[0];
                int nextTime = neighbours[1]; //PQ alreadys sorted the times.. smallest will be on top...
                if(timeMap.containsKey(next)) continue; //this node is already visited...
                pq.offer(new int[]{next, curTime + nextTime});
            }
        }

        if(timeMap.size() != n) return -1;

        /*
        1 - 0
        2 - 1
        3 - 2
        4 - 3
        */
        int max_time_taken = 0;
        for(Integer tt : timeMap.values()) {
            max_time_taken = Math.max(tt , max_time_taken);
        }
            return max_time_taken;
        
    }
}
