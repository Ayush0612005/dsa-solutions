/*
LeetCode 3781 - Path Existence Queries in a Graph I

Difficulty: Medium

Approach:
- The array is sorted, so adjacent elements whose difference is
  less than or equal to maxDiff belong to the same connected component.
- Traverse the array once and assign a group ID to each index.
- Whenever the difference between consecutive elements exceeds maxDiff,
  start a new group.
- For each query:
  - Two indices are connected if they belong to the same group.

Time Complexity: O(n + q)
where:
- n = number of elements
- q = number of queries

Space Complexity: O(n)
*/

class Solution {

    public boolean[] pathExistenceQueries(int n,
                                          int[] nums,
                                          int maxDiff,
                                          int[][] queries) {

        int[] group = new int[n];
        int groupId = 0;

        // Assign connected component IDs
        for (int i = 1; i < n; i++) {

            if (nums[i] - nums[i - 1] > maxDiff) {
                groupId++;
            }

            group[i] = groupId;
        }

        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            answer[i] = (group[u] == group[v]);
        }

        return answer;
    }
}
