package dev.xesam.foundation.ds.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xe on 2014/12/4.
 * xesamguo@gmail.com
 */
public class StackTest {
    public static void main(String[] args) {
        String expr = "1 2 + 3 4 * + 5 -";
        StackTest stackTest = new StackTest();
        stackTest.processExpress(expr);
    }

    public void processExpress(String expr) {
        StackImpl<String> stack = new StackImpl<>();
        String[] all = expr.split("\\s+");
        for (String s : all) {
            switch (s) {
                case "+":
                    stack.push((Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop())) + "");
                    break;
                case "-":
                    stack.push((Integer.valueOf(stack.pop()) * (-1) + Integer.valueOf(stack.pop())) + "");
                    break;
                case "*":
                    stack.push((Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop())) + "");
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        System.out.println(stack.pop());
    }

    final static class StackImpl<T> {
        private List<T> elements = new LinkedList<>();

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException();
            }
            return elements.remove(elements.size() - 1);
        }

        public void push(T element) {
            elements.add(element);
        }

        public boolean isEmpty() {
            return elements.size() == 0;
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException();
            }
            return elements.get(elements.size() - 1);
        }
    }
}
