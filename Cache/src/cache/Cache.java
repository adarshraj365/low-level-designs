package cache;

import cache.exception.DataNotFoundException;
import cache.exception.StorageFullException;
import cache.policy.EvictionPolicy;
import cache.storage.Storage;

public class Cache<K, V> {
    private final Storage<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public Cache(Storage<K, V> storage, EvictionPolicy<K> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(K key, V value) throws DataNotFoundException {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            K keyToRemove = this.evictionPolicy.removeKey();
            System.out.println("We have removed key : " + keyToRemove);
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected state. Storage full and key is not evicting.");
            }
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public V get(K key) throws DataNotFoundException{
        V value = null;
        try {
            value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
        } catch (DataNotFoundException e) {
            System.out.println("Key you are looking for, is not present in storage.");
        }

        return value;
    }
}
