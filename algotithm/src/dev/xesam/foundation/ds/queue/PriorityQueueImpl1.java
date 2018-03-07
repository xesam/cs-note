package dev.xesam.foundation.ds.queue;

/**
 * Created by x on 2015/3/6.
 */
public class PriorityQueueImpl1 implements MockQueue<Integer> {

    private int capacity = 3;
    private Integer[] elements = new Integer[capacity];
    private int size = 0;

    public void inspect() {
        inspect(elements);
    }

    @Override
    public void add(Integer t) {
        if (isFull()) {
            throw new RuntimeException("full");
        }

        if (isEmpty()) {
            elements[size] = t;
        } else if (t < elements[size - 1]) { //为了避免最坏情况
            elements[size] = t;
        } else {
            for (int i = 0; i < size; i++) {
                if (t > elements[i]) {
                    for (int j = size - 1; j >= i; j--) {
                        elements[j + 1] = elements[j];
                    }
                    elements[i] = t;
                    break;
                }
            }
        }
        size++;
    }

    @Override
    public Integer remove() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        int pos = size - 1;
        size--;
        return elements[pos];
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return elements[size - 1];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
