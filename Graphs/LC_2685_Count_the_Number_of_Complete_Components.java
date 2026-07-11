/*
LeetCode 2685 - Count the Number of Complete Components

Difficulty: Medium

Approach:
- Represent the graph using an adjacency list.
- Traverse each connected component using DFS.
- During DFS:
  - Count the number of nodes in the component.
  - Count the total degree of all nodes
    (equivalent to twice the number of edges in an undirected graph).
- A connected component is complete if:
      totalDegree == nodes × (nodes - 1)
- Count all such complete components.

Time Complexity: O(n + m)
where:
- n = number of vertices
- m = number of edges

Space Complexity: O(n + m)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] stats = dfs(graph, visited, i);

                int nodeCount = stats[0];
                int totalDegree = stats[1];

                if (nodeCount * (nodeCount - 1) == totalDegree) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private int[] dfs(List<List<Integer>> graph,
                      boolean[] visited,
                      int node) {

        visited[node] = true;

        int nodes = 1;
        int totalDegree = graph.get(node).size();

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                int[] stats = dfs(graph, visited, neighbor);

                nodes += stats[0];
                totalDegree += stats[1];
            }
        }

        return new int[]{nodes, totalDegree};
    }
}
