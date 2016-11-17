package main.java.ua.edu.ucu.smartarr.decorators;

import main.java.ua.edu.ucu.functions.MyFunction;
import main.java.ua.edu.ucu.smartarr.BaseArray;
import main.java.ua.edu.ucu.smartarr.SmartArray;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator<T> extends SmartArrayDecorator<T>
{
    private SmartArray<T> smartArray;
    private MyFunction function;
    private T[] appliedArray;

    public MapDecorator(SmartArray<T> smartArray, MyFunction myFunction)
    {
        this.smartArray = smartArray;
        this.function = myFunction;
        this.appliedArray = (T[])applyAll(smartArray.toArray(), myFunction);
    }

    public static void main(String... args)
    {
        SmartArray<Integer> arr = new BaseArray<>(new Integer[] {5, 2, 1, 7, 2, 3});

        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return (Integer)t + 1000;
            }
        };

        MapDecorator<Integer> MD = new MapDecorator<>(arr, function);
        System.out.println(Arrays.toString(MD.appliedArray));
    }

    public T[] getAppliedArray()
    {
        return this.appliedArray;
    }

    public Object[] applyAll(Object[] arrayToApply, MyFunction function)
    {
        Object[] applyingArray = new Object[arrayToApply.length];

        for (int i = 0; i < applyingArray.length; ++i)
        {
            applyingArray[i] = function.apply(arrayToApply[i]);
        }

        return applyingArray;
    }

}
