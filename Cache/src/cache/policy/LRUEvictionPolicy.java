package cache.policy;

import algo.dll.DoublyLinkedList;
import algo.dll.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DoublyLinkedListNode<Key>> nodeMap;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.nodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(nodeMap.containsKey(key)) {
            dll.deleteNode(nodeMap.get(key));
            dll.addNodeToTail(nodeMap.get(key));
        }
        else {
            DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key);
            dll.addNodeToTail(node);
            nodeMap.put(key, node);
        }
    }

    @Override
    public Key removeKey() {
        DoublyLinkedListNode<Key> firstNode = dll.getFirstNode();
        if(firstNode == null) {
            return null;
        }
        dll.deleteNode(firstNode);
        return firstNode.getElement();
    }
}
