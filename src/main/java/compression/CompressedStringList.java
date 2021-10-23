package main.java.compression;

import main.java.strings.KMP;
import main.java.tuple.Tuple2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompressedStringList {

    // The string used as reference for compression.
    private String reference;

    // The compressed string data.
    // Each tuple stores (start index, end index).
    private List<List<Tuple2<Integer, Integer>>> data;

    public CompressedStringList(String reference)
    {
        this.reference = reference;
        data = new ArrayList<>();
    }

    /**
     * Returns the character of the specified strings without decompressing.
     * @param strIndex The index of the string in the list.
     * @param i the character index of the string.
     */
    public char charAt(int strIndex, int i)
    {
        int index = 0;
        for (Tuple2<Integer, Integer> tup : data.get(strIndex))
        {
            if (index + len(tup) > i)
            {
                int start = tup.getItem1();
                return reference.charAt(start + i - index);
            }
            index += len(tup);
        }
        throw new IllegalArgumentException("Index out of bounds.");
    }

    /**
     * Decompresses and returns the string stored at the given index.
     */
    public String get(int strIndex)
    {
        List<Tuple2<Integer, Integer>> compressedData = data.get(strIndex);
        return decompress(compressedData);
    }

    /**
     * Adds a string.
     */
    public void add(String str)
    {
        List<Tuple2<Integer, Integer>> compressedData = compress(str);
        data.add(compressedData);
    }

    /**
     * Adds multiple strings.
     */
    public void addAll(Iterable<String> iterable)
    {
        for (String str : iterable)
        {
            add(str);
        }
    }

    /**
     * Checks if a string is contained in the list.
     */
    public boolean contains(String str)
    {
        return data.contains(compress(str));
    }

    /**
     * Calculates the compression of the string.
     */
    private List<Tuple2<Integer, Integer>> compress(String str)
    {
        List<Tuple2<Integer, Integer>> ret = new LinkedList<>();
        int i = 0;
        while (i < str.length())
        {
            Tuple2<Integer, Integer> tup = KMP.longestPrefixSearch(str.substring(i),reference);
            if (len(tup) == 0)
                throw new IllegalArgumentException("Failed to compress string. The reference string does not contain the character '" + str.charAt(i) + "'.");

            ret.add(tup);
            i += len(tup);
        }
        return ret;
    }

    /**
     * Calculates the decompression of a compressed string.
     */
    private String decompress(List<Tuple2<Integer, Integer>> compressedData)
    {
        StringBuilder builder = new StringBuilder();
        for (Tuple2<Integer, Integer> pair : compressedData)
        {
            int start = pair.getItem1();
            int end = pair.getItem2();

            String substring = reference.substring(start, end);
            builder.append(substring);
        }
        return builder.toString();
    }


    private int len(Tuple2<Integer, Integer> tup)
    {
        return tup.getItem2() - tup.getItem1();
    }
}
