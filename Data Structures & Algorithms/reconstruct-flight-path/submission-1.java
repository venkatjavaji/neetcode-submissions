class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //you are given with from-to and form the list of string with 
        // JFK as the start point then sort the destinations in lexographical order....

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> tks : tickets) {
            graph.computeIfAbsent(tks.get(0), k -> new PriorityQueue<>()).offer(tks.get(1));
        }

        List<String> itinerary = new LinkedList<>();

        dfs("JFK", graph, itinerary);
        return itinerary;

    }

    void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> pq = graph.get(airport);

        while(null!=pq && !pq.isEmpty()) {
            dfs(pq.poll(), graph, itinerary);
        }
        itinerary.addFirst(airport);
    }
}
