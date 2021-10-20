package main.java.search;

import java.util.HashMap;
import java.util.Map;

public class ApproximateSearch {

    /**
     * Returns a string among the string(s) with the most LSH collisions.
     * 'strings' must contain at least one item.
     */
    public String central(String[] strings, LSH lsh)
    {
        // lsh hash value -> number of occurrences
        Map<String, Integer> buckets = new HashMap<>();

        // lsh hash -> a string with that hash value
        Map<String, String> representatives = new HashMap<>();

        for (String str : strings) {
            String hash = lsh.hash(str);
            Integer c = buckets.get(hash);
            int count = c==null?0:c;
            buckets.put(hash, count + 1);
            representatives.put(hash, str);
        }

        return representatives.get(keyOfGreatestMappingValue(buckets));
    }


    /**
     * Returns the key which maps to the greatest value in the map.
     */
    private <T> T keyOfGreatestMappingValue(Map<T, Integer> buckets)
    {
        if (buckets.isEmpty())
            throw new IllegalArgumentException("Must contain at least one element.");

        int greatestCount = 0;
        T hash = null;
        for (Map.Entry<T, Integer> entry : buckets.entrySet())
        {
            int count = entry.getValue();

            if (count > greatestCount)
            {
                greatestCount = count;
                hash = entry.getKey();
            }
        }
        return hash;
    }
}
