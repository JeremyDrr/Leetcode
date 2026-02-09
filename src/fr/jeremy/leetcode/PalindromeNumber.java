package fr.jeremy.leetcode;

public class PalindromeNumber {

    public boolean solution(int x) {
        //Negative numbers or numbers ending in 0 (except 0) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revertedNumber = 0;
        //Reverse only the second half of the number
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        //Even length: x == revertedNumber; Odd length: x == revertedNumber/10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}