package fr.jeremy.leetcode;

public class LongestPalindromicSubstring {

    public String solution(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            //Odd case: "aba" (center upon i)
            int len1 = expandAroundCenter(s, i, i);
            //Even case: "abba" (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Si on trouve un palindrome plus long, on met à jour les indices
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //Return the palindrome's length
        return right - left - 1;
    }
}
