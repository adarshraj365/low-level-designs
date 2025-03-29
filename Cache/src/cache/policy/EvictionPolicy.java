package cache.policy;

/*
Interface for defining EvictionPolicy.
 */
public interface EvictionPolicy<Key> {

    /*
    Method to make any key accessed.
     */
    public void keyAccessed(Key key);

    /*
    Method to remove any key, in case of cache size increase the limit.
     */
    public Key removeKey();
}
