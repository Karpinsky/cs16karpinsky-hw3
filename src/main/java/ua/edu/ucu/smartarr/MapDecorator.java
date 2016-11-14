package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator<T> implements SmartArray<T> {

    public MapDecorator(SmartArray<T> smartArray, MyFunction myFunction)
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
