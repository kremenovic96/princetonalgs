package queues;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testRandomizedQueue {

    @Test
    public void testSize(){
        RandomizedQueue<Integer> tst = new RandomizedQueue<>();
        assertTrue(tst.isEmpty());
        tst.enqueue(1);
        assertEquals(1, tst.size());
        tst.dequeue();
        assertTrue(tst.isEmpty());
        tst.enqueue(2);
        tst.enqueue(1);
        tst.enqueue(5);
        assertEquals(3, tst.size());
        tst.dequeue();
        assertEquals(2, tst.size());
    }

    @Test
    public void testIterator(){
        RandomizedQueue<Integer> tst = new RandomizedQueue<>();
        tst.enqueue(1);
        tst.enqueue(2);
        tst.enqueue(3);
        tst.enqueue(4);
        tst.enqueue(5);
        tst.enqueue(6);
        Iterator<Integer> iterator = tst.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
