package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Deque data structure capable of removing and adding elements both at the start and at the end
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    public Deque(){
       first = new Node();
       first.next = first;
       first.prev = first;
       last = first;

    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void addFirst(Item item){
        if(item == null) throw new IllegalArgumentException();
        else if(n == 0){
            first.item = item;
            n++;
        }
        else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
            first.prev = last;
            n++;
        }
    }

    public void addLast(Item item){
        if(item == null) throw new IllegalArgumentException();
        else if(n == 0){
            first.item = item;
            n++;
        }
        else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            oldLast.next = last;
            last.prev = oldLast;
            last.next = first;
            n++;
        }
    }

    public Item removeFirst(){
        if(n == 0) throw new NoSuchElementException();
        Item firstItem = first.item;
        first = first.next;
        first.prev = last;
        n--;
        return firstItem;
    }

    public Item removeLast(){
        if(n == 0) throw new NoSuchElementException();
        Item lastItem = last.item;
        last = last.prev;
        last.next = first;
        n--;
        return lastItem;
    }

    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{

        private Node current = first;
        int i = 0;
        @Override
        public boolean hasNext() {
            //return current.next != first;
            return i < n;
        }

        @Override
        public Item next() {
            if(i>=n) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
