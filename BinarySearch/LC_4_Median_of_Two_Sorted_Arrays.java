/*
LeetCode 4 - Median of Two Sorted Arrays

Difficulty: Hard

Approach:
- Always perform binary search on the smaller array.
- Partition both arrays such that:
  - The left partitions contain half of the total elements.
  - Every element in the left partitions is less than or equal to every
    element in the right partitions.
- Handle boundary cases by using Integer.MIN_VALUE and Integer.MAX_VALUE.
- If the correct partition is found:
  - For an even total length, return the average of the two middle values.
  - For an odd total length, return the maximum element of the left partitions.
- Otherwise, adjust the binary search range until the correct partition is found.

Time Complexity: O(log(min(m, n)))

where:
- m = length of nums1
- n = length of nums2

Space Complexity: O(1)
*/

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            int partition1 = (low + high) / 2;
            int partition2 = (n1 + n2 + 1) / 2 - partition1;

            int maxLeft1 =
                    (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int minRight1 =
                    (partition1 == n1)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int maxLeft2 =
                    (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int minRight2 =
                    (partition2 == n2)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            if (maxLeft1 <= minRight2 &&
                maxLeft2 <= minRight1) {

                if ((n1 + n2) % 2 == 0) {

                    return (
                        Math.max(maxLeft1, maxLeft2)
                        + Math.min(minRight1, minRight2)
                    ) / 2.0;
                }

                return Math.max(maxLeft1, maxLeft2);

            } else if (maxLeft1 > minRight2) {

                high = partition1 - 1;

            } else {

                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}
