package edu.pnu.collection;

public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList () {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(Object newData) {
        if (size == DEFAULT_SIZE) return;
        data[size] = (T)newData;
        size = size + 1;
    }

    public T getNext(int index) {
        if (index > size) return null;
        return (T) data[index];
    }

    public int getSize() {
        return size;
    }

    public T find(Object o) {
        T t = (T) o;
        for (Object dt : data) {
            if (o == (T) dt) return (T)dt;
            else if (t.equals((T)dt)) return (T) dt;
        }
        return null;
    }
}
