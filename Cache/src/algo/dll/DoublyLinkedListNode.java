package algo.dll;

public class DoublyLinkedListNode<T> {
    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    DoublyLinkedListNode<T> prev;
    DoublyLinkedListNode<T> next;
    private T element;

    public DoublyLinkedListNode(T element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public T getElement() {
        return this.element;
    }
}
