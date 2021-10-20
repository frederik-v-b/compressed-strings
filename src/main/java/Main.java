package main.java;

import main.java.compression.CompressedStringList;
import main.java.search.ApproximateSearch;
import main.java.search.LSH;

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        String alphabet = "ab";
        String[] strings = {"aaab", "baab", "aabb", "bbbb"};

        // For calculating the LSH of a string.
        LSH lsh = new LSH(2, 4);

        // Finding a string among 'strings'' with the most lsh collisions.
        // This can be used as reference string for the compressed list.
        ApproximateSearch as = new ApproximateSearch();
        String reference = as.central(strings, lsh);

        // The alphabet is appended to the reference string.
        // Otherwise errors may when compressing a string which contains characters that are not in the reference string.
        reference += alphabet;

        CompressedStringList list = new CompressedStringList(reference);
        list.addAll(Arrays.asList(strings));

        // Printing and comparing the result.
        System.out.println("Printing (strings[i], list.get(i))...");
        for (int i = 0; i < strings.length; i++)
            System.out.println("i = " + i + ": (" + strings[i] + ", " + list.get(i) + ")");
    }
}
