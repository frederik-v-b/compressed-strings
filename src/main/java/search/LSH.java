package main.java.search;

import java.util.Random;

/**
 * Class for locality-sensitive hashing.
 */
public class LSH {

    private int[] indexes;

    private int range;

    public int getRange() {
        return range;
    }

    /**
     * Calculates the indexes to use for hashing.
     * @param count the number of indexes used while hashing.
     * @param range the minimum size of the strings.
     */
    public LSH(int count, int range)
    {
        // TODO: Idea - use modulo in hash to eliminate parameter 'range'.
        indexes = new int[count];
        this.range = range;

        Random r = new Random();

        for (int i = 0; i < count; i++)
        {
            indexes[i] = r.nextInt(this.range);
        }
    }

    /**
     * Calculates the LSH of a string.
     */
    public String hash(String str)
    {
        if (str.length() != range)
            throw new IllegalArgumentException("String must be at least of length " + range + ".");

        StringBuilder builder = new StringBuilder();
        for (int i : indexes)
        {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
