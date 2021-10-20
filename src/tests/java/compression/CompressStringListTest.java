package tests.java.compression;

import main.java.compression.CompressedStringList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CompressStringListTest {

    private void assertEqv(String[] strings, CompressedStringList list)
    {
        for (int i = 0; i < strings.length; i++)
        {
            String str1 = strings[i];
            String str2 = list.get(i);
            assertEquals(str1, str2);
        }
    }

    @Test
    public void eqv1()
    {
        String[] strings = {};
        CompressedStringList list = new CompressedStringList("abcdefg");
        assertEqv(strings, list);
    }

    @Test
    public void eqv2()
    {
        String[] strings = {"abcde"};
        CompressedStringList list = new CompressedStringList("abcde");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }

    @Test
    public void eqv3()
    {
        String[] strings = {"", "", ""};
        CompressedStringList list = new CompressedStringList("");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }

    @Test
    public void eqv4()
    {
        String[] strings = {"", "", ""};
        CompressedStringList list = new CompressedStringList("abcde");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }

    @Test
    public void eqv5()
    {
        String[] strings = {"aabb", "abba", "aaaa", "bbbb"};
        CompressedStringList list = new CompressedStringList("aabb");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }

    @Test
    public void eqv6()
    {
        String[] strings = {"aBc", "Bca", "caB"};
        CompressedStringList list = new CompressedStringList("aBc");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }

    @Test
    public void eqv7()
    {
        String[] strings = {"abccc", "aababccaccccca", "bb", ""};
        CompressedStringList list = new CompressedStringList("abccc");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }
    @Test
    public void eqv8()
    {
        String[] strings = {"abccc", "aababccaccccca", "bb", "", ""};
        CompressedStringList list = new CompressedStringList("fedcab");
        list.addAll(Arrays.asList(strings));
        assertEqv(strings, list);
    }
    @Test
    public void failOnMissingCharacters()
    {
        String[] strings = {"abccc", "aababccaccccca", "bb", "", ""};
        boolean failed = false;
        try {
            CompressedStringList list = new CompressedStringList("ab");
            list.addAll(Arrays.asList(strings));
        }catch (Exception e){
            failed = true;
        }
        assertTrue(failed);
    }

    @Test
    public void charAt1()
    {
        String[] strings = {"abc", "aaa", "aab"};
        CompressedStringList list = new CompressedStringList("abc");
        list.addAll(Arrays.asList(strings));
        for (int i = 0; i < strings.length; i++)
        {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++)
            {
                char c = str.charAt(j);
                assertEquals(list.charAt(i,j), c);
            }
        }
    }

    @Test
    public void contains1()
    {
        String[] strings = {"abc", "aaa", "aab"};
        CompressedStringList list = new CompressedStringList("abc");
        list.addAll(Arrays.asList(strings));
        assertTrue(list.contains("abc"));
    }

    @Test
    public void contains2()
    {
        String[] strings = {"abc", "aaa", "aab"};
        CompressedStringList list = new CompressedStringList("abc");
        list.addAll(Arrays.asList(strings));
        assertFalse(list.contains("abb"));
    }

    @Test
    public void contains3()
    {
        String[] strings = {"abc", "aaa", "aab"};
        CompressedStringList list = new CompressedStringList("abc");
        list.addAll(Arrays.asList(strings));
        assertFalse(list.contains(""));
    }

}
