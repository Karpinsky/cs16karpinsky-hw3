package main.java.ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray<T> implements SmartArray<T> {

    public BaseArray(T[] initialArray)
    {

    }

    @Override
    public T[] toArray() {
        return (T[]) new Object[0];
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
