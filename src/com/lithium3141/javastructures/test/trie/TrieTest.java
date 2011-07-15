package com.lithium3141.javastructures.test.trie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.javastructures.trie.Trie;
import com.lithium3141.javastructures.trie.TrieNode;

public class TrieTest {
    
    protected Trie<String, Integer> siTrie;
    
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
        Assert.assertArrayEquals(new String[] {"one", "two"}, this.siTrie.getDeepestMatch(new String[] {"one", "two"}));
        Assert.assertArrayEquals(new String[] {"one"}, this.siTrie.getDeepestMatch(new String[] {"one"}));
        Assert.assertArrayEquals(new String[] {"two"}, this.siTrie.getDeepestMatch(new String[] {"two"}));
        
        Assert.assertArrayEquals(new String[] {"one", "two"}, this.siTrie.getDeepestMatch(new String[] {"one", "two", "three", "four"}));
        Assert.assertArrayEquals(new String[] {"two"}, this.siTrie.getDeepestMatch(new String[] {"two", "one"}));
    }
    
    @Test
    public void testFind() {
        Assert.assertEquals(new Integer(1), this.siTrie.find(new String[] {"one"}));
        Assert.assertEquals(new Integer(2), this.siTrie.find(new String[] {"two"}));
        Assert.assertEquals(new Integer(11), this.siTrie.find(new String[] {"one", "one"}));
        Assert.assertEquals(new Integer(12), this.siTrie.find(new String[] {"one", "two"}));
        
        Assert.assertEquals(new Integer(12), this.siTrie.find(new String[] {"one", "two", "three", "four"}));
        Assert.assertEquals(new Integer(2), this.siTrie.find(new String[] {"two", "one"}));
    }
    
    @Test
    public void testGetValid() {
        Assert.assertEquals(new Integer(1), this.siTrie.get(new String[] {"one"}));
        Assert.assertEquals(new Integer(2), this.siTrie.get(new String[] {"two"}));
        Assert.assertEquals(new Integer(11), this.siTrie.get(new String[] {"one", "one"}));
        Assert.assertEquals(new Integer(12), this.siTrie.get(new String[] {"one", "two"}));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid1234() {
        Assert.assertEquals(null, this.siTrie.get(new String[] {"one", "two", "three", "four"}));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid21() {
        Assert.assertEquals(null, this.siTrie.get(new String[] {"two", "one"}));
    }
    
    @After
    public void tearDown() {
        this.siTrie = null;
    }

}
