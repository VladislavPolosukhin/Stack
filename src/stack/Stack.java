package stack;

import java.util.Arrays;

public class Stack<T> {

    private final T[] buf;
    private int position;

    public Stack(int size) {
        buf = (T[]) new Object[size];
    }

    public void push(T o) {
        if (position > buf.length - 1) throw new ArrayIndexOutOfBoundsException("Stack is full");
        buf[position++] = o;
    }

    public Object pop() {
        if (position <= 0) return null;
        T result = buf[position--];
        buf[position] = null;
        return result;
    }

    public boolean isEmpty() {
        return (position == 0);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(buf);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stack<?> stack) || this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        System.out.println(stack.buf[position-1]);
        System.out.println(buf[position-1]);
        return Arrays.equals(buf, stack.buf);
    }
}
