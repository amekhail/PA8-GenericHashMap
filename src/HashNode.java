public class HashNode<K, V>
{
    private K key;
    private V value;
 
    private HashNode<K, V> next;
 
	/**
	 * Constructs a new HashNode object by assigning the key and value
	 * @param key - The key which is mapped to the object
	 * @param value - The value of the objet
	 */
    public HashNode(K key, V value)
    {
        this.setKey(key);
        this.setValue(value);
    }

	/**
	 * Returns the key for this HashNode
	 * @return the key which is used to map this object
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Sets the key for the value to be mapped to
	 * @param key - The key which will map this object
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * Returns the value which is mapped to this object
	 * @return the value to this object
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Sets the value to this object
	 * @param value - The value to be mapped to this object
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * Returns the next HashNode
	 * @return the next HashNode object from this HashNode object
	 */
	public HashNode<K, V> getNext() {
		return next;
	}

	/**
	 * Sets the next HashNode object to this HashNode object
	 * @param next - The HashNode object which will be assigned to next
	 */
	public void setNext(HashNode<K, V> next) {
		this.next = next;
	}
}