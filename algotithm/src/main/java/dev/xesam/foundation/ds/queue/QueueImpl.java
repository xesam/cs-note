package dev.xesam.foundation.ds.queue;

/**
 * Created by x on 2015/3/6.
 */
public class QueueImpl<T> implements MockQueue<T>{

    private int capacity = 3;
    private T[] elements = (T[]) new Object[capacity];
    private int posTobeRemove = 0;
    private int posTobeInsert = 0; //下一个待插入的新元素位置

    private int size = 0;

    public QueueImpl() {

    }

    private int getNextPosition(int position) {
        int newPos = position + 1;
        return newPos == capacity ? 0 : newPos;
    }

    public void inspect() {
        inspect(elements);
        System.out.print(";posTobeRemove:" + posTobeRemove);
        System.out.print(";");
        System.out.print("posTobeInsert:" + posTobeInsert);
        System.out.println("");
    }

    public void add(T t) {
        if (isFull()) {
            throw new RuntimeException("full");
        }
        elements[posTobeInsert] = t;
        posTobeInsert = getNextPosition(posTobeInsert);
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        T t = elements[posTobeRemove];
        posTobeRemove = getNextPosition(posTobeRemove);
        size--;
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        return elements[posTobeRemove];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
