package cache.storage;

import cache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{

    private final Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) {
        if (isStorageFull()) {
            System.out.println("Storage is full");
            throw new StorageFullException();
        }
        this.storage.put(key, value);
    }

    private boolean isStorageFull() {
        return capacity.equals(storage.size());
    }

    @Override
    public Value get(Key key) {
        return this.storage.get(key);
    }

    @Override
    public void remove(Key key) {
        this.storage.remove(key);
    }
}
