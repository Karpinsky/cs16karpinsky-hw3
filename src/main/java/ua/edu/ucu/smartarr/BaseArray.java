package main.java.ua.edu.ucu.smartarr;

import main.java.ua.edu.ucu.Student;

// Base array for decorators
public class BaseArray<T> implements SmartArray<T> {

    private T[] internalArray;
    private int freeSlotIndex;


    public BaseArray(T[] initialArray)
    {
        this.internalArray = initialArray;
        this.freeSlotIndex = initialArray.length;
    }

    @Override
    public void setOriginal(T[] newOri) {
        this.internalArray = newOri;
    }

    @Override
    public T[] passOriginal() {
        return this.internalArray;
    }

    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[this.internalArray.length];

        System.arraycopy(this.internalArray, 0, newArray, 0, this.internalArray.length);

        return newArray;
    }

    @Override
    public String[] toStringArray() {
        String[] newArray = new String[this.internalArray.length];

        for (int i = 0; i < this.internalArray.length; ++i)
        {
            newArray[i] = this.internalArray[i].toString();
        }

        return newArray;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return this.freeSlotIndex;
    }
}
