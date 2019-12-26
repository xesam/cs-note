package dev.xesam.foundation.ds.queue;

/**
 * Created by x on 2015/3/6.
 */
public interface MockQueue<T> {

    default void inspect(T[] elements){
        System.out.print("[");
        for (T t : elements) {
            System.out.print(t == null ? "null" : t.toString());
            System.out.print(",");
        }
        System.out.print("]");
        System.out.println("");
    }

    void add(T t);

    T remove();

    T peek();
}
