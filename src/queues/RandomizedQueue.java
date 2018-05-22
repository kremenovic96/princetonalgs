package queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private Item[] items;
    private int n;

    public RandomizedQueue(){
    items = (Item[]) new Object[6];
    n = 0;
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    public void enqueue(Item item){
        if(item == null) throw new IllegalArgumentException();
        items[n++] = item;
        if(n == items.length) resizeArray(2*items.length);

    }
    public Item dequeue(){
        if(this.size() == 0) throw new NoSuchElementException();
        int randomArrayIndex = StdRandom.uniform(n);
        Item returnItem = items[randomArrayIndex];
        items[randomArrayIndex] = items[n-1];
        items[n-1] = null;
        n--;
        if(n> 0 && n == items.length/4) resizeArray(items.length/2);
        return returnItem;
    }
    public Item sample(){
        if(this.size() == 0) throw new NoSuchElementException();
        int randomArrayIndex = StdRandom.uniform(n);
        return items[randomArrayIndex];
    }
    public Iterator<Item> iterator(){return new randomIterator();}

    private class randomIterator implements Iterator<Item>{

        int k = size();
        int m = 0;
        @Override
        public boolean hasNext() {
            return m < k;
        }

        @Override
        public Item next() {
            if(m == k) throw new NoSuchElementException();
            m++;
            return sample();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }


    private void resizeArray(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0;i<n; i++){
            copy[i] = items[i];
        }
        items = copy;
    }
}
