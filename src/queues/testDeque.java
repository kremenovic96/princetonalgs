package queues;
/*
 *  Tests for Deque data structure
 */
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testDeque {

    @Test
    public void testEmpty(){
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddFirstandSize(){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(5);
        deque.addFirst(4);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        Integer num = 1;
        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()){
            assertEquals(num, i.next());
            num ++;
        }
        assertEquals(5, deque.size());
        //System.out.println(" addFirst");
    }

    @Test
    public void testAddLastandSize(){
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Integer num = 1;
        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()){
            assertEquals(num, i.next());
            num ++;
        }
        assertEquals(5, deque.size());
        //System.out.println(" addLast");
    }

    @Test
    public void testAddLastThenAddFirst(){
        Deque<Integer> deque = new Deque<>();
        deque.addLast(2);
        deque.addFirst(1);
        Integer num = 1;
        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()){
            assertEquals(num, i.next());
            num++;
        }
        num = 1;
        deque = new Deque<>();
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        i = deque.iterator();

        while (i.hasNext()){
            assertEquals(num, i.next());
            num++;
            //System.out.println(num);
        }
    }

    @Test
    public void testAddFirstThenAddLast(){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        Integer num = 1;
        Iterator<Integer> i = deque.iterator();
        while (i.hasNext()){
            assertEquals(num, i.next());
            num++;
        }
        num = 1;
        deque = new Deque<>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        i = deque.iterator();

        while (i.hasNext()){
            assertEquals(num, i.next());
            num++;
            //System.out.println(num);
        }
    }

    @Test
    public void testRemoveFirst(){
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        Integer n = 1;
        assertEquals(n, deque.removeFirst());
        deque = new Deque<>();
        deque.addLast(n);
        assertEquals(n, deque.removeFirst());
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        assertEquals(3, deque.size());
        assertEquals(n, deque.removeFirst());
        n = 2;
        assertEquals(2, deque.size());
        assertEquals(n, deque.removeFirst());
        n = 3;
        assertEquals(1, deque.size());
        assertEquals(n, deque.removeFirst());
        assertEquals(0, deque.size());

    }

    @Test
    public void testRemoveLast(){
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        Integer n = 1;
        assertEquals(n, deque.removeLast());
        deque = new Deque<>();
        deque.addLast(n);
        assertEquals(n, deque.removeLast());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
        n = 3;
        assertEquals(n, deque.removeLast());
        n = 2;
        assertEquals(n, deque.removeLast());
        n = 1;
        assertEquals(n, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void testRemoveLastThenRemoveFirst(){
        Deque<Integer> deque = new Deque<>();
        deque.addLast(2);
        deque.addFirst(1);
        Integer n = 2;
        assertEquals(n, deque.removeLast());
        n = 1;
        assertEquals(n, deque.removeFirst());
        deque = new Deque<>();
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        n = 1;
        assertEquals(n, deque.removeFirst());
        n = 6;
        assertEquals(n, deque.removeLast());
        n = 2;
        assertEquals(n, deque.removeFirst());
        n = 5;
        assertEquals(n, deque.removeLast());
        assertEquals(2, deque.size());
    }

}
