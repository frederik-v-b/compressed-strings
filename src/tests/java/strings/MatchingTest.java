package tests.java.strings;

import main.java.strings.KMP;
import main.java.tuple.Tuple2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchingTest {

    //private void assertMatch(String text, String str, String result)
    //{
    //    Tuple2<Integer, Integer> ip = NaiveMatching.longestPrefixSearch(str, text);
    //    String calcRes = text.substring(ip.getItem1(), ip.getItem2());
    //    assertEquals(calcRes, result);
    //}

    private void assertMatch(String text, String str, String result)
    {
        Tuple2<Integer, Integer> ip = KMP.longestPrefixSearch(str, text);
        String calcRes = text.substring(ip.getItem1(), ip.getItem2());
        assertEquals(calcRes, result);
    }

    @Test
    public void match1()
    {
        assertMatch("banana", "", "");
    }

    @Test
    public void match2()
    {
        assertMatch("banana", "banana", "banana");
    }

    @Test
    public void match3()
    {
        assertMatch("banana", "anana", "anana");
    }

    @Test
    public void match4()
    {
        assertMatch("banana", "anab", "ana");
    }

    @Test
    public void match5()
    {
        assertMatch("banana", "ban", "ban");
    }

    @Test
    public void match6()
    {
        assertMatch("banana", "banb", "ban");
    }

    @Test
    public void match7()
    {
        assertMatch("banana", "banananab", "banana");
    }

    @Test
    public void match8()
    {
        assertMatch("banana", "a", "a");
    }

    @Test
    public void match9()
    {
        assertMatch("banana", "an", "an");
    }

    @Test
    public void match10()
    {
        assertMatch("", "", "");
    }

    @Test
    public void match11()
    {
        assertMatch("", "bana", "");
    }

    @Test
    public void match12()
    {
        assertMatch("aabb", "abba", "abb");
    }

    @Test
    public void match13()
    {
        assertMatch("aabb", "abbaba", "abb");
    }

}
