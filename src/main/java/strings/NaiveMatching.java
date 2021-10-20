package main.java.strings;

import main.java.tuple.Tuple2;

/**
 * For testing purposes (not an efficient algorithm).
 */
public class NaiveMatching {

    /**
     * Calculates the the indexes of the substring in text of the largest possible largest prefix of pattern which is in text.
     */
    public static Tuple2<Integer, Integer> longestPrefixSearch(String pattern, String text)
    {
        int startIndex = 0;
        for (int i = startIndex; i <= pattern.length() + 1; i++)
        {
            if (i == pattern.length() + 1){
                String x = pattern.substring(startIndex,i-1);
                int u = text.indexOf(x);
                return new Tuple2<Integer, Integer>(u, u + x.length());
            }
            String s = pattern.substring(startIndex,i);
            if (!text.contains(s))
            {
                String x = pattern.substring(startIndex,i-1);
                int u = text.indexOf(x);
                return new Tuple2<Integer, Integer>(u, u + x.length());
            }
        }
        return new Tuple2<Integer, Integer>(0, 0);
    }


}
