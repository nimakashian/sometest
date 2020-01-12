package performance;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SynchronizedMyLinkedList<E> {
    transient Node<E> first;
    transient Node<E> last;
    transient int size = 0;
    protected transient int modCount = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public synchronized E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();

        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    public synchronized void addLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public synchronized int size() {
        return size;
    }
}
