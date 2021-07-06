package LinearDataStructures_01_Lab.ArrayList_01.ArrayList_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayList<E> {

    private static final int INIT_CAPACITY = 4;

    private Object[] elements;

    private int size;

    public ArrayList() {
        this.elements = new Object[INIT_CAPACITY];
        this.size = 0;
    }

    public boolean add(E element) {
        growIfNeeded();
        elements[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, E element) {
        ensureValidIndex(index);
        growIfNeeded();
        shiftRight(index);
        elements[index] = element;
        size++;
        return true;
    }

    public E get(int index) {
        ensureValidIndex(index);
        return (E) elements[index];
    }

    public E set(int index, E element) {
        ensureValidIndex(index);
        E replacedElement = (E) elements[index];
        elements[index] = element;
        return replacedElement;
    }

    public E remove(int index) {
        ensureValidIndex(index);
        E removedElement = (E) elements[index];
        elements[index] = null;
        shiftLeft(index);
        size--;
        shrinkIfNeeded();
        return removedElement;
    }

    public int size() {
        return size;
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size ; i++) {
            if (elements[i].equals(element)){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                E element = (E) elements[index];
                index++;
                return element;
            }
        };
    }

    private void growIfNeeded() {
        if (maxCapacityReached()) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private boolean maxCapacityReached() {
        return size == elements.length;
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    private void ensureValidIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void shrinkIfNeeded() {
        if (elements.length / 3 > size) {
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
    }
}