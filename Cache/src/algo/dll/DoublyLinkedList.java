package algo.dll;

public class DoublyLinkedList<T> {
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void deleteNode(DoublyLinkedListNode<T> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.prev.prev = node.prev;
        }
    }

    public void addNodeToTail(DoublyLinkedListNode<T> node) {
        DoublyLinkedListNode<T> temp = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public DoublyLinkedListNode<T> addElementToLast(T key) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(key);
        addNodeToTail(node);
        return node;
    }


    public boolean isEmpty() {
        return this.head.next == tail;
    }

    public DoublyLinkedListNode<T> getFirstNode() {
        if (isEmpty()) {
            return null;
        }
        return this.head.next;
    }

    public DoublyLinkedListNode<T> getLastNode() {
        if (isEmpty()) {
            return null;
        }
        return this.tail.prev;
    }
}
