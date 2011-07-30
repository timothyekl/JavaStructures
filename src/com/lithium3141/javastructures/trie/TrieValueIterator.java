package com.lithium3141.javastructures.trie;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator for a Trie with values of type V.
 * 
 * @param <V> The value type of the Trie being iterated.
 */
public class TrieValueIterator<V> implements Iterator<V> {
    private Iterator<V> valuesIter;
    
    public TrieValueIterator(Trie<? extends Object, V> trie) {
        List<V> values = trie.root.valueList();
        this.valuesIter = values.iterator();
    }

    @Override
    public boolean hasNext() {
        return this.valuesIter.hasNext();
    }

    @Override
    public V next() {
        return this.valuesIter.next();
    }

    @Override
    public void remove() {
        // TODO Implement!
    }
}
