package com.lithium3141.javastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie<K,V> {
	protected TrieNode<K,V> root;
	
	public Trie() {
		this.root = new TrieNode<K,V>(null);
	}
	
	public TrieNode<K,V> getRoot() {
		return this.root;
	}
	
	/**
	 * Find the best match for the given key path through this trie.
	 * 
	 * @param keys The ordered sequence of keys to use when walking
	 *             the trie
	 * @return The longest matched sequence of keys existing in this
	 *         trie
	 */
    public List<K> getDeepestMatch(List<K> keys) {
		TrieNode<K,V> current = this.root;
		List<K> matched = new ArrayList<K>();
		
		for(int i = 0; i < keys.size(); i++) {
			current = current.getChild(keys.get(i));
			if(current == null) {
				break;
			}
			matched.add(keys.get(i));
		}
		
		// Return last located command
		return matched;
	}
	
	/**
	 * Get the value stored at the given key path in this trie.
	 * 
	 * @param path The precise path to use when walking the trie
	 * @return The object associated with the given path in the trie
	 * @throws IndexOutOfBoundsException if no object exists for the given path
	 */
	public V get(List<K> path) {
	    TrieNode<K,V> current = this.root;
	    for(int i = 0; i < path.size(); i++) {
	        current = current.getChild(path.get(i));
	        if(current == null) {
	            throw new IndexOutOfBoundsException("Key " + path.get(i) + " not in trie");
	        }
	    }
	    return current.getValue();
	}
	
	/**
	 * Locate the best matching value in this trie for the given key path.
	 * 
	 * @param keys The key path to use when walking the trie
	 * @return The value corresponding to the longest matched sequence in
	 *         the trie
	 */
	public V find(List<K> keys) {
	    return this.get(this.getDeepestMatch(keys));
	}
	
	/**
	 * Insert the given value at the end of the given key path. Any empty
	 * intermediate nodes will be assigned null values.
	 * 
	 * @param keys The key path to walk
	 * @param val The value to insert
	 */
	public void put(List<K> keys, V val) {
	    TrieNode<K, V> current = this.root;
	    for(int i = 0; i < keys.size(); i++) {
	        if(current.getChild(keys.get(i)) == null) {
	            current.setChild(keys.get(i), (V)null);
	        }
	        current = current.getChild(keys.get(i));
	    }
	    current.setValue(val);
	}
}
