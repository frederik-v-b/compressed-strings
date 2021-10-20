package main.java.strings;

import main.java.tuple.Tuple2;

public class KMP {

    /**
     * Calculates the the indexes of the substring in text of the largest possible largest prefix of pattern which is in text.
     */
    public static Tuple2<Integer, Integer> longestPrefixSearch(String pattern, String text)
    {
        int start = 0;
        int end = 0;
        if (pattern.length() == 0)
            return new Tuple2<>(start, end);

        int m = pattern.length();
        int n = text.length();

        int lps[] = lpsArray(pattern, m);

        // j is pattern index and i is text index.
        int j = 0, i = 0;

        while (i < n)
        {
            if (pattern.charAt(j) == text.charAt(i))
            {
                j++; i++;
            }
            if (j >= end - start)
            {
                end = i; start = i - j;
            }
            if (j == m) {
                end = i; start = i - j;
                return new Tuple2<>(start, end);
            }
            else if (i < n && pattern.charAt(j) != text.charAt(i))
            {
                if (j != 0)
                {
                    j = lps[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
        return new Tuple2<>(start,end);
    }

    private static int[] lpsArray(String pat, int m)
    {
        int[] lps = new int[m];
        lps[0] = 0;

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
}
