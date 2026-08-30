class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        //build the graph
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> t : tickets) {
            graph.computeIfAbsent(t.get(0), v -> new PriorityQueue<>()).offer(t.get(1));
        }

        List<String> result = new ArrayList<>();

        dfs("JFK", graph, result);

        return result;
        
    }

    public void dfs(String airport,Map<String, PriorityQueue<String>> graph,List<String> result  ) {
        PriorityQueue<String> cur = graph.getOrDefault(airport, new PriorityQueue<>());

        while(cur!=null && !cur.isEmpty()) {
            String next = cur.poll();
            dfs(next, graph, result);
        }
        result.addFirst(airport);
    }
}

/*
 * tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 *
 * Graph (each list is a min-heap, lexical order):
 *   JFK -> [MUC]
 *   MUC -> [LHR]
 *   LHR -> [SFO]
 *   SFO -> [SJC]
 *
 * route = []
 *
 * dfs("JFK")
 *   destinations = [MUC] -> poll "MUC"
 *   dfs("MUC")
 *     destinations = [LHR] -> poll "LHR"
 *     dfs("LHR")
 *       destinations = [SFO] -> poll "SFO"
 *       dfs("SFO")
 *         destinations = [SJC] -> poll "SJC"
 *         dfs("SJC")
 *           destinations = null -> no edges
 *           route.addFirst("SJC")   -> route = [SJC]
 *         route.addFirst("SFO")     -> route = [SFO, SJC]
 *       route.addFirst("LHR")       -> route = [LHR, SFO, SJC]
 *     route.addFirst("MUC")         -> route = [MUC, LHR, SFO, SJC]
 *   route.addFirst("JFK")           -> route = [JFK, MUC, LHR, SFO, SJC]
 *
 * Final route: ["JFK","MUC","LHR","SFO","SJC"]
 */
