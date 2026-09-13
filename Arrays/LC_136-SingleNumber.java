/*
 * LeetCode 136 - Single Number
 * Difficulty: Easy
 *
 * Approach:
 * Use XOR to find the number that appears only once.
 *
 * XOR properties:
 * - a ^ a = 0
 * - a ^ 0 = a
 * - XOR is commutative and associative
 *
 * Therefore, all duplicate numbers cancel each other out,
 * leaving only the number that appears once.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}


//Another method to solve the question

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i += 2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

//very easy solution almost similar to finding the duplicate in an array.
