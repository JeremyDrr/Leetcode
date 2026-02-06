package fr.jeremy.leetcode;

public class ZigzagConversion {

    public String solution(String s, int numRows) {

        //Edge case: if only one row, no zigzag possible
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        //Initialise rows
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        //Simulate the zigzag
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            //Reverse direction if we hit top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        //Combine all rows into one final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
