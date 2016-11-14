package main.java.ua.edu.ucu.smartarr;

public interface SmartArray<T> {

    T[] toArray(); // return array with SmartArray elements

    String operationDescription(); // return current operation name applied to SmartArray
    
    int size(); // return SmartArray size
   
}
