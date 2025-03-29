import cache.Cache;
import cache.policy.LRUEvictionPolicy;
import cache.storage.HashMapStorage;
import cache.storage.Storage;

public class Main {
    public static void main(String[] args) {
        final HashMapStorage<String, String> storage
                = new HashMapStorage<>(4);
        final LRUEvictionPolicy<String> lruEvictionPolicy = new LRUEvictionPolicy<>();
        final Cache<String, String> cache = new Cache<>(storage, lruEvictionPolicy);

        cache.put("First", "Adarsh");
        cache.put("Second", "Akash");
        cache.put("Third", "Rahul");
        cache.put("Fourth", "Aman");
        cache.put("Fifth", "Anand");
        System.out.println(cache.get("First"));
    }
}