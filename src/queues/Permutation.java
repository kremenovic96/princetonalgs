package queues;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        Integer num = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomized = new RandomizedQueue<>();
        while (!StdIn.isEmpty()){
            randomized.enqueue(StdIn.readString());
        }
        int i = 0;
        while (i< num){
            System.out.println(randomized.dequeue());
            i++;
        }
    }
}
