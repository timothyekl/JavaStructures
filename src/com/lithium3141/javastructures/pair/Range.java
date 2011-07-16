package com.lithium3141.javastructures.pair;

public class Range<E extends Comparable<E>> extends Pair<E> {

    public Range(E first, E second) {
        super(first, second);
        
        if(this.first.compareTo(this.second) > 0) {
            throw new IllegalArgumentException("Ranges must be defined such that first < second");
        }
    }
    
    /**
     * Check that this range contains the given object
     * 
     * @param arg The object to check
     * @return True if the object falls within this range; false otherwise
     */
    public boolean contains(E arg) {
        return (this.first.compareTo(arg) <= 0 && arg.compareTo(this.second) <= 0);
    }

    /**
     * Check that this range contains the entirety of the given range
     * 
     * @param range The range to check
     * @return True if the given range is entirely contained (i.e. is a subset)
     *         of this range; false otherwise
     */
    public boolean contains(Range<E> range) {
        return (this.first.compareTo(range.getFirst()) <= 0 && range.getSecond().compareTo(this.second) <= 0);
    }

    public boolean intersects(Range<E> range) {
        return (this.contains(range) || this.contains(range.getFirst()) || this.contains(range.getSecond()) || range.contains(this));
    }

}
