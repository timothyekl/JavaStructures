package com.lithium3141.javastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode<K,V> {
	protected Map<K, TrieNode<K,V>> children;
	protected V value;
	
	public TrieNode(V value) {
		this.children = new HashMap<K, TrieNode<K,V>>();
		this.value = value;
	}
	
	/**
	 * Get the value associated with this node.
	 * 
	 * @return The OWCommand for this node 
	 */
	public V getValue() {
		return this.value;
	}
	
	/**
	 * Set a new value for this node.
	 * 
	 * @param value The new value
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
	/**
	 * Add a new child node to this node for the given key.
	 * 
	 * @param key The key for the new child
	 * @param child The new OWCommandTrieNode to add as a child
	 */
	public void setChild(K key, TrieNode<K,V> child) {
		this.children.put(key, child);
	}
	
	/**
	 * Add a new child node to this node for the given key.
	 * 
	 * @param key The key for the new child
	 * @param command The new OWCommand to add as a child. Autoboxed
	 *                in an OWCommandTrieNode before adding
	 */
	public void setChild(K key, V value) {
		this.children.put(key, new TrieNode<K,V>(value));
	}
	
	/**
	 * Get the child for the given key.
	 * 
	 * @param key The search key for this node's children
	 * @return The matching OWCommandTrieNode for the given key, or
	 *         null if no such key exists
	 */
	public TrieNode<K,V> getChild(K key) {
		return this.children.get(key);
	}
	
	/**
	 * Convert the trie rooted at this node to a List of values. The ordering
	 * is not guaranteed, except that a parent node will always appear before
	 * all its children.
	 * 
	 * @return a List of unique values contained in this node and its children.
	 */
	public List<V> valueList() {
	    List<V> result = new ArrayList<V>();
	    
	    if(this.value != null) {
	        result.add(this.value);
	    }
	    
	    for(TrieNode<K, V> child : this.children.values()) {
	        List<V> filtered = child.valueList();
	        filtered.removeAll(result);
	        result.addAll(filtered);
	    }
	    
	    return result;
	}
}
