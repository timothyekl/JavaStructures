package com.lithium3141.javastructures.test.pair;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.javastructures.pair.Pair;


public class PairTest {
    private Pair<String> sPair;
    private Pair<Integer> iPair;
    
    @Before
    public void setUp() {
        this.sPair = new Pair<String>("a", "b");
        this.iPair = new Pair<Integer>(1, 42);
    }
    
    @Test
    public void testConstructor() {
        Pair<String> target = new Pair<String>("a", "b");
        Assert.assertNotNull(target);
        
        Pair<Integer> target2 = new Pair<Integer>(1, 42);
        Assert.assertNotNull(target2);
    }
    
    @Test
    public void testGetters() {
        Assert.assertEquals("a", this.sPair.getFirst());
        Assert.assertEquals("b", this.sPair.getSecond());
        
        Assert.assertEquals(new Integer(1), this.iPair.getFirst());
        Assert.assertEquals(new Integer(42), this.iPair.getSecond());
    }
    
    @Test
    public void testSetters() {
        this.sPair.setFirst("c");
        this.sPair.setSecond("d");
        
        Assert.assertEquals("c", this.sPair.getFirst());
        Assert.assertEquals("d", this.sPair.getSecond());
        
        this.iPair.setFirst(2);
        this.iPair.setSecond(84);
        
        Assert.assertEquals(new Integer(2), this.iPair.getFirst());
        Assert.assertEquals(new Integer(84), this.iPair.getSecond());
    }
    
    @After
    public void tearDown() {
        this.sPair = null;
        this.iPair = null;
    }
}
