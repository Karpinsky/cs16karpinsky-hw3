package main.java.ua.edu.ucu.smartarr.decorators;

import main.java.ua.edu.ucu.functions.MyPredicate;
import main.java.ua.edu.ucu.smartarr.BaseArray;
import main.java.ua.edu.ucu.smartarr.SmartArray;

import java.util.Arrays;
import java.util.LinkedList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator<T> extends SmartArrayDecorator<T>
{
    private SmartArray<T> smartArray;
    private MyPredicate predicate;
    private T[] filteredArray;

    public FilterDecorator(SmartArray<T> smartArray, MyPredicate myPredicate)
    {
        this.smartArray = smartArray;
        this.predicate = myPredicate;
        this.filteredArray = this.filterArray(smartArray.toArray(), myPredicate);
    }

    public static void main(String... args)
    {
        SmartArray<Integer> arr = new BaseArray<>(new Integer[] {5, 2, 1, 7, 2, 3});

        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (Integer)t > 4;
            }
        };

        FilterDecorator<Integer> FD = new FilterDecorator<>(arr, predicate);
        System.out.println(Arrays.toString(FD.filteredArray));
    }

    public T[] getFilteredArray()
    {
        return this.filteredArray;
    }

    public T[] filterArray(T[] filteringArray, MyPredicate predicate)
    {
        LinkedList<T> filteredList = new LinkedList<>();

        for (T filter_el : filteringArray)
        {
            if (predicate.test(filter_el))
            {
                filteredList.addLast(filter_el);
            }
        }

        return (T[])filteredList.toArray();
    }
}
