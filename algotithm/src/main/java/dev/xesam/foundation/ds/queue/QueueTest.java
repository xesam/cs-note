package dev.xesam.foundation.ds.queue;

/**
 * Created by xe on 2014/12/10.
 */
public class QueueTest {

    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();
        queue.inspect();
        queue.add(10);
        queue.inspect();
        queue.add(11);
        queue.inspect();
        queue.add(12);
        queue.inspect();
//        queue.insert(13);
//        queue.inspect();

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());//error
    }
}
