package com.lithium3141.javastructures.test.trie;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.javastructures.trie.Trie;
import com.lithium3141.javastructures.trie.TrieNode;

public class TrieTest {
    
    protected Trie<String, Integer> siTrie;
    
    protected List<String> one = new ArrayList<String>() {{ add("one"); }};
    protected List<String> two = new ArrayList<String>() {{ add("two"); }};
    protected List<String> oneOne = new ArrayList<String>() {{ add("one"); add("one"); }};
    protected List<String> oneTwo = new ArrayList<String>() {{ add("one"); add("two"); }};
    protected List<String> twoOne = new ArrayList<String>() {{ add("two"); add("one"); }};
    protected List<String> oneTwoThreeFour = new ArrayList<String>() {{ add("one"); add("two"); add("three"); add("four"); }};
    
    @Before
    public void setUp() {
        this.siTrie = new Trie<String, Integer>();
        
        TrieNode<String, Integer> root = this.siTrie.getRoot();
        root.setChild("one", 1);
        root.setChild("two", 2);
        
        TrieNode<String, Integer> one = root.getChild("one");
        one.setChild("one", 11);
        one.setChild("two", 12);
    }

    @Test
    public void testDeepestMatch() {
        Assert.assertEquals(this.oneTwo, this.siTrie.getDeepestMatch(this.oneTwo));
        Assert.assertEquals(this.one, this.siTrie.getDeepestMatch(this.one));
        Assert.assertEquals(this.two, this.siTrie.getDeepestMatch(this.two));
        
        Assert.assertEquals(this.oneTwo, this.siTrie.getDeepestMatch(this.oneTwoThreeFour));
        Assert.assertEquals(this.two, this.siTrie.getDeepestMatch(this.twoOne));
    }
    
    @Test
    public void testFind() {
        Assert.assertEquals(new Integer(1), this.siTrie.find(this.one));
        Assert.assertEquals(new Integer(2), this.siTrie.find(this.two));
        Assert.assertEquals(new Integer(11), this.siTrie.find(this.oneOne));
        Assert.assertEquals(new Integer(12), this.siTrie.find(this.oneTwo));
        
        Assert.assertEquals(new Integer(12), this.siTrie.find(this.oneTwoThreeFour));
        Assert.assertEquals(new Integer(2), this.siTrie.find(this.twoOne));
    }
    
    @Test
    public void testGetValid() {
        Assert.assertEquals(new Integer(1), this.siTrie.get(this.one));
        Assert.assertEquals(new Integer(2), this.siTrie.get(this.two));
        Assert.assertEquals(new Integer(11), this.siTrie.get(this.oneOne));
        Assert.assertEquals(new Integer(12), this.siTrie.get(this.oneTwo));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid1234() {
        Assert.assertEquals(null, this.siTrie.get(this.oneTwoThreeFour));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid21() {
        Assert.assertEquals(null, this.siTrie.get(this.twoOne));
    }
    
    @Test
    public void testPutShort() {
        List<String> three = new ArrayList<String>() {{ add("three"); }};
        List<String> four = new ArrayList<String>() {{ add("four"); }};
        
        this.siTrie.put(three, 3);
        this.siTrie.put(four, 4);
        
        Assert.assertEquals(new Integer(3), this.siTrie.get(three));
        Assert.assertEquals(new Integer(4), this.siTrie.get(four));
    }
    
    @Test
    public void testPutLong() {
        List<String> path = new ArrayList<String>() {{ add("five"); add("six"); add("seven"); add("eight"); }};
        
        this.siTrie.put(path, 5678);
        
        Assert.assertEquals(new Integer(5678), this.siTrie.get(path));
        Assert.assertEquals(null, this.siTrie.get(new ArrayList<String>() {{ add("five"); add("six"); }}));
    }
    
    @After
    public void tearDown() {
        this.siTrie = null;
    }

}
