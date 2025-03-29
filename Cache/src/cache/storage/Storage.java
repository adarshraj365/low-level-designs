package cache.storage;

/**
 * Interface representing Storage.
 */
public interface Storage<Key, Value> {

    /*
    add method to add a key,value pair into the Storage.
     */
    public void add(Key key, Value value);

    /*
    get method will return Value for given key.
     */
    public Value get(Key key);

    /*
    remove will remove element from storage for a given key
     */
    public void remove(Key key);
}
