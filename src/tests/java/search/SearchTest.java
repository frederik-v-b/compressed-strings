package tests.java.search;

import main.java.search.ApproximateSearch;
import main.java.search.LSH;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    @Test
    public void central1()
    {
        String[] strings = {"aaaa", "aaaa", "AAAA", "bbbb"};
        LSH lsh = new LSH(1, 4);
        ApproximateSearch as = new ApproximateSearch();
        assertEquals(as.central(strings, lsh), "aaaa");
    }

    @Test
    public void central2()
    {
        String[] strings = {"AAAA", "aaaa", "aaaa", "bbbb"};
        LSH lsh = new LSH(1, 4);
        ApproximateSearch as = new ApproximateSearch();
        assertEquals(as.central(strings, lsh), "aaaa");
    }

    @Test
    public void central3()
    {
        String[] strings = {"AAAA", "cccc", "bbbb", "cccc"};
        LSH lsh = new LSH(1, 4);
        ApproximateSearch as = new ApproximateSearch();
        assertEquals(as.central(strings, lsh), "cccc");
    }

    @Test
    public void central4()
    {
        String[] strings = {"AAAA", "cccc", "bbbb", "cccc"};
        LSH lsh = new LSH(2, 4);
        ApproximateSearch as = new ApproximateSearch();
        assertEquals(as.central(strings, lsh), "cccc");
    }

    @Test
    public void central5()
    {
        String[] strings = {"AAAA", "cccc", "bbbb", "cccc"};
        LSH lsh = new LSH(4, 4);
        ApproximateSearch as = new ApproximateSearch();
        assertEquals(as.central(strings, lsh), "cccc");
    }
}
