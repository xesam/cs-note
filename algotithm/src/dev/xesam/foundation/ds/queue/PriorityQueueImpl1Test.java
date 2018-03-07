package dev.xesam.foundation.ds.queue;

/**
 * Created by xe on 2014/12/10.
 */
public class PriorityQueueImpl1Test {

    public static void main(String[] args) {
        PriorityQueueImpl1 queue = new PriorityQueueImpl1();
        queue.inspect();
        queue.add(10);
        queue.inspect();
        queue.add(12);
        queue.inspect();
        queue.add(11);
        queue.inspect();
//        queue.add(13);//error

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());//error
        queue.inspect();
    }
}
