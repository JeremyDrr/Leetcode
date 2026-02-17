package fr.jeremy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //Sort the array to use two pointers and handle duplicates
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //Skip the same element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //Skip duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    //Sum too small, move left pointer to increase it
                    left++;
                } else {
                    //Sum too large, move right pointer to decrease it
                    right--;
                }
            }
        }
        return res;
    }
}
