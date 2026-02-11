package fr.jeremy.leetcode;

public class ContainerWithMostWater {

    public int solution(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            //Calculate the width between pointers
            int width = right - left;
            //The height is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            //Update maxArea if current volume is larger
            maxArea = Math.max(maxArea, width * currentHeight);

            //Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
