package fr.jeremy.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int solution(String s) {
        int n = s.length();
        int maxLength = 0;
        //Map to store the character and its potential next index
        HashMap<Character, Integer> map = new HashMap<>();

        //i = left pointer; j= right pointer
        for (int j = 0, i = 0; j < n; j++) {
            char currentChar = s.charAt(j);

            if (map.containsKey(currentChar)) {
                //We move i at the index after the repeating character
                //But only if it's further than its current position
                i = Math.max(map.get(currentChar), i);
            }

            //Compute the current length (j-i+1)
            maxLength = Math.max(maxLength, j - i + 1);

            //Update the character index for the next "jump"
            map.put(currentChar, j + 1);
        }

        return maxLength;
    }
}
