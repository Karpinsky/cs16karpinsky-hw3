package main.java.ua.edu.ucu.smartarr;

public interface SmartArray<T> {

    void setOriginal(T[] newOri);
    T[] passOriginal(); // return original array with access to it's elements.

    T[] toArray(); // return array with SmartArray elements
    String[] toStringArray();

    String operationDescription(); // return current operation name applied to SmartArray
    
    int size(); // return SmartArray size
   
}
