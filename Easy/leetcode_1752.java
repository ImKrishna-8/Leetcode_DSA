// 1752. Check if Array Is Sorted and Rotated
// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

// There may be duplicates in the original array.

// Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
// Example 2:

// Input: nums = [2,1,3,4]
// Output: false
// Explanation: There is no sorted array once rotated that can make nums.
// Example 3:

// Input: nums = [1,2,3]
// Output: true
// Explanation: [1,2,3] is the original sorted array.
// You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.


class Solution {
    public boolean check(int[] nums) {

        // Optimal - O(n)
        //When we are cheacking the element the peak element should be only spike one time 
        int peak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                peak++;
            }
            if (peak > 1)
                return false;
        }

        return true;

        //Brute Force - O(n^2)
        //Trying to compare all the rotated array with sorted array 
        // int[] newarr = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     newarr[i] = nums[i];
        // }

        // Arrays.sort(newarr);
        // for (int r = 0; r < nums.length; r++) {
        //     boolean isSorted = true;
        //     for (int i = 0; i < nums.length; i++) {
        //         if (newarr[i] != nums[(i + r) % nums.length]) {
        //             isSorted = false;
        //             break;
        //         }
        //     }
        //     if (isSorted)
        //         return true;
        // }
        // return false;
    }
}
