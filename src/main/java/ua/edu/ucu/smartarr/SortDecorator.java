package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator<T> implements SmartArray<T>{

    public SortDecorator(SmartArray<T> smartArray, MyComparator myComparator)
    {

    }

    @Override
    public T[] toArray() {
        return (T[])new Object[0];
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
