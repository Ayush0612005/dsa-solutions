/*
LeetCode 2492 - Minimum Score of a Path Between Two Cities

Difficulty: Medium

Approach:
- Represent the roads as an adjacency list.
- Perform a DFS starting from city 1.
- During traversal:
  - Visit every city reachable from city 1.
  - For every road encountered, update the global minimum edge weight.
- Since the graph is connected between city 1 and city n,
  the minimum edge in the connected component containing city 1
  is the minimum possible score of any valid path.

Time Complexity: O(n + m)
where:
- n = number of cities
- m = number of roads

Space Complexity: O(n + m)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int distance = road[2];

            graph.computeIfAbsent(u, k -> new ArrayList<>())
                 .add(new int[]{v, distance});

            graph.computeIfAbsent(v, k -> new ArrayList<>())
                 .add(new int[]{u, distance});
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return minScore;
    }

    private void dfs(int node,
                     Map<Integer, List<int[]>> graph,
                     boolean[] visited) {

        visited[node] = true;

        if (!graph.containsKey(node)) {
            return;
        }

        for (int[] neighbor : graph.get(node)) {

            int nextNode = neighbor[0];
            int distance = neighbor[1];

            minScore = Math.min(minScore, distance);

            if (!visited[nextNode]) {
                dfs(nextNode, graph, visited);
            }
        }
    }
}
