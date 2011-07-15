package com.lithium3141.javastructures.test.trie;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.javastructures.trie.Trie;
import com.lithium3141.javastructures.trie.TrieNode;

public class TrieTest {
    
    protected Trie<Integer> trie;
    
    @Before
    public void setUp() {
        this.trie = new Trie<Integer>();
        
        TrieNode<Integer> root = this.trie.getRoot();
        root.setChild("one", 1);
        root.setChild("two", 2);
        
        TrieNode<Integer> one = root.getChild("one");
        one.setChild("one", 11);
        one.setChild("two", 12);
    }

    @Test
    public void testDeepestMatch() {
        Assert.assertArrayEquals(new String[] {"one", "two"}, this.trie.getDeepestMatch(new String[] {"one", "two"}));
        Assert.assertArrayEquals(new String[] {"one"}, this.trie.getDeepestMatch(new String[] {"one"}));
        Assert.assertArrayEquals(new String[] {"two"}, this.trie.getDeepestMatch(new String[] {"two"}));
        
        Assert.assertArrayEquals(new String[] {"one", "two"}, this.trie.getDeepestMatch(new String[] {"one", "two", "three", "four"}));
        Assert.assertArrayEquals(new String[] {"two"}, this.trie.getDeepestMatch(new String[] {"two", "one"}));
    }
    
    @Test
    public void testFind() {
        Assert.assertEquals(new Integer(1), this.trie.find(new String[] {"one"}));
        Assert.assertEquals(new Integer(2), this.trie.find(new String[] {"two"}));
        Assert.assertEquals(new Integer(11), this.trie.find(new String[] {"one", "one"}));
        Assert.assertEquals(new Integer(12), this.trie.find(new String[] {"one", "two"}));
        
        Assert.assertEquals(new Integer(12), this.trie.find(new String[] {"one", "two", "three", "four"}));
        Assert.assertEquals(new Integer(2), this.trie.find(new String[] {"two", "one"}));
    }
    
    @Test
    public void testGetValid() {
        Assert.assertEquals(new Integer(1), this.trie.get(new String[] {"one"}));
        Assert.assertEquals(new Integer(2), this.trie.get(new String[] {"two"}));
        Assert.assertEquals(new Integer(11), this.trie.get(new String[] {"one", "one"}));
        Assert.assertEquals(new Integer(12), this.trie.get(new String[] {"one", "two"}));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid1234() {
        Assert.assertEquals(null, this.trie.get(new String[] {"one", "two", "three", "four"}));
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetInvalid21() {
        Assert.assertEquals(null, this.trie.get(new String[] {"two", "one"}));
    }
    
    @After
    public void tearDown() {
        this.trie = null;
    }

}
