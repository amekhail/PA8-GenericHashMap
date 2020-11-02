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
		initEmptyList();
		this.size = 0;
	}
	
	/**
	 * Removes all of the mappings from this map.
	 */
	public void clear() {
		initEmptyList();
		this.size = 0;
	}
	
	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key 
	 * 				- The key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key.
	 */
	public boolean containsKey(K key) {
		HashNode<K,V> entry = buckets.get(hash(key));

		while (entry != null) {
			if (entry.getKey().equals(key)) {
				return true;
			}
			entry = entry.getNext();
		}
		return false;
	}
	
	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * @param val 
	 * 				- value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	public boolean containsValue(V val) {
		
		for (int i = 0; i < buckets.size(); i++) {
			HashNode<K,V> entry = buckets.get(i);
			while (entry != null) {
				if (entry.getValue().equals(val)) {
					return true;
				}
				entry = entry.getNext();
			}
		}
		
		
		return false;
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

		HashNode<K,V> entry = buckets.get(hash(key));

		while (entry != null) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
			entry = entry.getNext();
		}
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
		int totalConflicts = 0;
		for (int i = 0; i < buckets.size(); i++) {
			String currBucket = "[";
			HashNode<K,V> entry = buckets.get(i);
			int conflicts = 0;
			while (entry != null) {
				currBucket += entry.getKey() + ", ";
				entry = entry.getNext();
				if (entry != null) {
					conflicts ++;
					totalConflicts++;
				}
			}
			currBucket += "]";
			System.out.println("Index " + i + ": (" + conflicts + " conflicts), " + currBucket); 
		}
		System.out.println("Total # of conflicts: " + totalConflicts);
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
		HashNode<K,V> entry = new HashNode<>(key, val);
		HashNode<K,V> existingVal = buckets.get(hashIndex);
		if (existingVal == null) {
			buckets.set(hashIndex, entry);
			this.size++;
		} else { // all nodes before the last node
			while (existingVal.getNext() != null) {
				if (existingVal.getKey().equals(key)) {
					V value = existingVal.getValue();
					existingVal.setValue(val);
					return value;
				}
				existingVal = existingVal.getNext();
			}
			// last node
			if (existingVal.getKey().equals(key)) {
				V value = existingVal.getValue();
				existingVal.setValue(val);
				return value;
			} else {
				existingVal.setNext(entry);
				this.size++;
			}
		}
		return null;
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
				this.size--;
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
	
	/**
	 * Returns the index for the hashmap which is the hashcode for the
	 * key object modulo numBuckets (8)
	 * @param key - key with which the hash index will be calculated from
	 * @return
	 * an integer which is the index specifiying which bucket this HashNode
	 * object will be in
	 */
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return Math.abs(index);
	}

	/**
	 * Inilizes the ArrayList 'buckets' to have all null values. 
	 * Called on creation and when list is emptied
	 */
	private void initEmptyList() {
		buckets = new ArrayList<>();

		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
	}


}
