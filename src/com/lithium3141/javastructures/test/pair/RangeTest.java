package com.lithium3141.javastructures.test.pair;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lithium3141.javastructures.pair.Range;

public class RangeTest {
    
    private Range<Integer> range;
    
    @Before
    public void setUp() {
        this.range = new Range<Integer>(2, 4);
    }
    
    @Test
    public void testConstructorValid() {
        Range<Integer> target;
        
        target = new Range<Integer>(1, 3);
        Assert.assertNotNull(target);
        
        target = new Range<Integer>(1, 1);
        Assert.assertNotNull(target);
        
        target = new Range<Integer>(-1, 1);
        Assert.assertNotNull(target);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testConstructorInvalid() {
        new Range<Integer>(1, -1);
    }
    
    @Test
    public void testContainsInteger() {
        Assert.assertTrue(this.range.contains(2));
        Assert.assertTrue(this.range.contains(3));
        Assert.assertTrue(this.range.contains(4));
        
        Assert.assertFalse(this.range.contains(1));
        Assert.assertFalse(this.range.contains(5));
    }
    
    @Test
    public void testContainsPair() {
        Assert.assertTrue(this.range.contains(new Range<Integer>(2, 4)));
        Assert.assertTrue(this.range.contains(new Range<Integer>(3, 3)));
        
        Assert.assertFalse(this.range.contains(new Range<Integer>(1, 3)));
        Assert.assertFalse(this.range.contains(new Range<Integer>(3, 5)));
        Assert.assertFalse(this.range.contains(new Range<Integer>(1, 5)));
        
        Assert.assertFalse(this.range.contains(new Range<Integer>(-1, 1)));
        Assert.assertFalse(this.range.contains(new Range<Integer>(5, 7)));
    }
    
    @Test
    public void testIntersects() {
        Assert.assertTrue(this.range.intersects(new Range<Integer>(2, 4)));
        Assert.assertTrue(this.range.intersects(new Range<Integer>(3, 3)));
        
        Assert.assertTrue(this.range.intersects(new Range<Integer>(1, 3)));
        Assert.assertTrue(this.range.intersects(new Range<Integer>(3, 5)));
        Assert.assertTrue(this.range.intersects(new Range<Integer>(1, 5)));
        
        Assert.assertFalse(this.range.intersects(new Range<Integer>(-1, 1)));
        Assert.assertFalse(this.range.intersects(new Range<Integer>(5, 7)));
    }
    
    @After
    public void tearDown() {
        this.range = null;
    }
    
}
