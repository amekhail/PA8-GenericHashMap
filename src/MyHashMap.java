import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHashMap<K,V> {
	
	private List<HashNode<K,V>> buckets;
	private static int numBuckets = 8;
	private int size;
	
	/**
	 * Constructs an empty HashMap with the default initial capacity (8).
	 */
	public MyHashMap() {
		this.buckets = new ArrayList<>();
		this.size = 0;
	}
	
	/**
	 * Removes all of the mappings from this map.
	 */
	public void clear() {
		this.buckets = new ArrayList<>();
	}
	
	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key 
	 * 				- The key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key.
	 */
	public boolean containsKey(K key) {
		return true;
	}
	
	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param val 
	 * 				- value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	public boolean containsValue(V val) {
		return true;
	}
	
	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 *  map contains no mapping for the key.
	 * @param key 
	 * 				- the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this 
	 * map contains no mapping for the key
	 */
	public V get(K key) {
		return null;
	}
	
	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return true if this map contains no key-value mappings
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns a Set view of the keys contained in this map.
	 * @return a set view of the keys contained in this map
	 */
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for (int i = 0; i < buckets.size(); i++) {
			HashNode<K,V> temp = buckets.get(i);
			while (temp != null) {
				keySet.add(temp.getKey());
				temp = temp.getNext();
			}
		}
		return keySet;
	}
	
	/**
	 * Outputs how many conflicts occur at each bucket and list the keys in
	 * that bucket.<br> 
	 * Example output for this method:
	 * <ul>
	 * <li>Index 0: (0 conflicts), []</li>
	 * <li>Index 1: (0 conflicts), []</li>
	 * <li>Index 3: (0 conflicts), []</li>
	 * <li>Index 2: (0 conflicts), []</li>
	 * <li>Index 4: (0 conflicts), []</li>
	 * <li>Index 5: (0 conflicts), [ExampleKeyX, ]</li>
	 * <li>Index 6: (0 conflicts), [ExampleKeyY, ]</li>
	 * <li>Index 7: (0 conflicts), []</li>
	 * <li>Total # of conflicts: 0</li>
	 * </ul>
	 */
	public void printTable() {
		
	}
	
	/**
	 * Associates the specified value with the specified key in this map.
	 * @param key - key with which the specified value is to be associated
	 * @param val - value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no
	 * mapping for key. (A null return can also indicate that the map 
	 * previously associated null with key.)
	 */
	public V put(K key, V val) {
		int hashIndex = hash(key);
		if (buckets.get(hashIndex) == null) {
			HashNode<K,V> node = new HashNode<>(key, val);
			buckets.add(hashIndex, node);
			return null;
		} else {
			HashNode<K,V> node = new HashNode<>(key, val);
			V returnVal = this.addToEnd(hashIndex, node);
			return returnVal;
		}
		
	}
	
	/**
	 * Removes the mapping for the specified key from this map if present.
	 * @param key - whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no 
	 * mapping for key. (A null return can also indicate that the map 
	 * previously associated null with key.)
	 */
	public V remove(K key) {
		int hashCode = hash(key);
		HashNode<K,V> temp = buckets.get(hashCode);
		HashNode<K,V> prev = null;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				V val = temp.getValue();
				if (prev == null) {
					buckets.add(hashCode, temp.getNext());
				} else {
					prev.setNext(temp.getNext());
				}
				return val;
			} else {
				prev = temp;
				temp = temp.getNext();
			}
		}
		return null;
	}
	
	/**
	 * Returns the number of key-value mappings in this map.
	 * @return
	 * the number of key-value mappings in this map
	 */
	public int size() {
		return this.size;
	}
	
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return Math.abs(index);
	}

	private V addToEnd(int bucket, HashNode<K,V> h) {
		HashNode<K,V> temp = buckets.get(bucket);
		V returnVal = null;
		while (temp.getNext() != null) {
			if (h.getKey().equals(temp.getKey())) {
				returnVal = temp.getValue();
				temp.setValue(h.getValue());
				return returnVal;
				
			}
			temp = temp.getNext();
		}
		temp.setNext(h);
		return returnVal;
	}
}
