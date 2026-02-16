package fr.jeremy.leetcode;

public class LongestCommonPrefix {

    public String solution(String[] strs){

        if (strs == null || strs.length == 0) return "";

        //Start with the first string as the initial prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            //Shorten the prefix until it matches the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                //If the prefix is empty, no need to continue
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
