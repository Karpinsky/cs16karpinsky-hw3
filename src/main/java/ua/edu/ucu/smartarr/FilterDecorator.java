package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator<T> implements SmartArray<T>{

    public FilterDecorator(SmartArray<T> smartArray, MyPredicate myPredicate)
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
