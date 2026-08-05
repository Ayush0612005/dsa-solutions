/*
LeetCode 3310 - Remove Methods From Project

Difficulty: Medium

Approach:
- Build a directed graph where an edge u -> v means method u invokes method v.
- Starting from the suspicious method k, perform DFS to mark all reachable
  methods as suspicious.
- Check whether any non-suspicious method invokes a suspicious method.
  - If such an edge exists, the suspicious methods cannot be removed.
- Otherwise, return all non-suspicious methods.
- If removal is impossible, return all methods.

Time Complexity: O(n + m)

where:
- n = number of methods
- m = number of invocations

Space Complexity: O(n + m)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> remainingMethods(int n,
                                          int k,
                                          int[][] invocations) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] invocation : invocations) {
            graph[invocation[0]].add(invocation[1]);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        boolean canRemove = true;

        for (int[] invocation : invocations) {

            if (!suspicious[invocation[0]] &&
                 suspicious[invocation[1]]) {

                canRemove = false;
                break;
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!canRemove || !suspicious[i]) {
                answer.add(i);
            }
        }

        return answer;
    }

    private void dfs(int node,
                     List<Integer>[] graph,
                     boolean[] suspicious) {

        suspicious[node] = true;

        for (int neighbor : graph[node]) {

            if (!suspicious[neighbor]) {
                dfs(neighbor, graph, suspicious);
            }
        }
    }
}
