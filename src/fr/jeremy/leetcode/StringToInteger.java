package fr.jeremy.leetcode;

public class StringToInteger{

    public int solution(String s) {

        if(s == null || s.isEmpty())
            return 0;

        int n = s.length();
        int i = 0;
        int sign = 1;
        int result = 0;

        //Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        //Check if string is only spaces
        if (i == n) return 0;

        //Check for sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //Conversion and Overflow handling
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check overflow before multiplying
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
