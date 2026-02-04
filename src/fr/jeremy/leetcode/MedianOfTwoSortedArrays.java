package fr.jeremy.leetcode;

public class MedianOfTwoSortedArrays {

    public double solution(int[] nums1, int[] nums2) {
        //Make sure that nums1 is the smallest array
        if (nums1.length > nums2.length) {
            return solution(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            //If partitionX is 0, there's nothing on the left
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We find the good partition
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                //We're too much on the right in nums1, we go to the left
                high = partitionX - 1;
            } else {
                //We're too much on the left in nums1, we go to the right
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("The arrays are not sorted...");
    }
}
