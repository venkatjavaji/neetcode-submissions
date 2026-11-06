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

/*
 * tickets = [["HOU","JFK"],["SEA","JFK"],["JFK","SEA"],["JFK","HOU"]]
 *
 * Graph (each list is a min-heap, lexical order):
 *   JFK -> [HOU, SEA]
 *   HOU -> [JFK]
 *   SEA -> [JFK]
 *
 * route = []
 *
 * dfs("JFK")
 *   destinations = [HOU, SEA] -> poll "HOU" (remaining: [SEA])
 *   dfs("HOU")
 *     destinations = [JFK] -> poll "JFK" (remaining: [])
 *     dfs("JFK")
 *       destinations = [SEA] -> poll "SEA" (remaining: [])
 *       dfs("SEA")
 *         destinations = [JFK] -> poll "JFK" (remaining: [])
 *         dfs("JFK")
 *           destinations = [] -> no edges left
 *           route.addFirst("JFK")   -> route = [JFK]
 *         route.addFirst("SEA")     -> route = [SEA, JFK]
 *       route.addFirst("JFK")       -> route = [JFK, SEA, JFK]
 *     route.addFirst("HOU")         -> route = [HOU, JFK, SEA, JFK]
 *   route.addFirst("JFK")           -> route = [JFK, HOU, JFK, SEA, JFK]
 *
 * Final route: ["JFK","HOU","JFK","SEA","JFK"]
 */

