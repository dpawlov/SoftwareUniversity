package LinearDataStructures_01_Lab.ArrayList_01.Stack;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

import java.util.Iterator;

public class Stack<E> {
    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E element) {

        Node<E> node = new Node<>(element);

        if (!isEmpty()) {
            node.next = this.top;
        }

        this.top = node;
        this.size++;
    }

    public E pop() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }

        E topElement = this.top.element;

        if (this.size == 1) {
            this.top = null;
        } else {
            this.top = this.top.next;
        }

        this.size--;
        return topElement;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return this.top.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Stack.Node<E> current = top;

            public boolean hasNext() {
                return this.current != null;
            }

            public E next() {
                E element = this.current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}