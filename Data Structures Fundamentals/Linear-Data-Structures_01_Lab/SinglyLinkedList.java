package LinearDataStructures_01_Lab.ArrayList_01.SinglyLinkedList;

import java.util.Iterator;

class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> firstNode;

    private int size;

    public SinglyLinkedList() {
        this.firstNode = null;
        this.size = 0;
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            this.firstNode = node;
        } else {
            node.next = this.firstNode;
            this.firstNode = node;
        }
        this.size++;
    }

    public void addLast(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            this.firstNode = node;
        } else {
            Node<E> current = this.firstNode;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }

    public E removeFirst() {
        ensureNonEmpty();
        E element = firstNode.element;
        this.firstNode = this.firstNode.next;
        this.size--;
        return element;
    }

    public E removeLast() {
        ensureNonEmpty();
        Node<E> preLastNode = this.firstNode;
        while (preLastNode.next.next != null) {
            preLastNode = preLastNode.next;
        }
        E lastElement = preLastNode.next.element;
        preLastNode.next = null;
        this.size--;
        return lastElement;
    }

    public E getFirst() {
        ensureNonEmpty();
        return this.firstNode.element;
    }

    public E getLast() {
        ensureNonEmpty();
        Node<E> lastNode = this.firstNode;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = firstNode;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
