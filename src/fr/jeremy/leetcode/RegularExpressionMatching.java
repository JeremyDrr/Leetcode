package fr.jeremy.leetcode;

public class RegularExpressionMatching {

    public boolean solution(String s, String p){
        int m = s.length();
        int n = p.length();
        //dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        //Empty string matches empty pattern
        dp[0][0] = true;

        //Handle patterns like a*, a*b*, a*b*c* which can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    //Characters match or pattern has '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //Case 1: '*' matches zero occurrences of the preceding element
                    dp[i][j] = dp[i][j - 2];

                    //Case 2: '*' matches one or more occurrences
                    //The preceding element must match the current string character
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}