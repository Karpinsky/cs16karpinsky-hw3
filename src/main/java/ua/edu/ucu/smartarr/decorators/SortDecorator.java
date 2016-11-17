package main.java.ua.edu.ucu.smartarr.decorators;

import main.java.ua.edu.ucu.functions.MyComparator;
import main.java.ua.edu.ucu.smartarr.BaseArray;
import main.java.ua.edu.ucu.smartarr.SmartArray;

import java.util.Arrays;
import java.util.Comparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator<T> extends SmartArrayDecorator<T>
{
    private SmartArray<T> smartArray;
    private MyComparator comparator;
    private T[] sortedArray;

    public SortDecorator(SmartArray<T> smartArray, MyComparator myComparator)
    {
        this.smartArray = smartArray;
        this.comparator = myComparator;
        this.sortedArray = (T[])insertionSort(this.smartArray.passOriginal(), this.comparator);
    }

    public T[] getSortedArray()
    {
        return this.sortedArray;
    }

    public static void main(String... args)
    {
        SmartArray<Integer> arr = new BaseArray<>(new Integer[] {5, 2, 1, 7, 2, 3});

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)o1 - (Integer)o2;
            }

            @Override
            public boolean compareBool(Object o1, Object o2) {
                return false;
            }
        };

        SortDecorator<Integer> SD = new SortDecorator<>(arr, cmp);
        System.out.println(Arrays.toString(SD.sortedArray));
    }

    public static void mergeSort(Object[] arrayToSort, Comparator<Object> comparator)
    {

    }

    public static void quickSort(Object[] arrayToSort, Comparator<Object> comparator)
    {

    }

    public static Object[] insertionSort(Object[] arrayToSort, Comparator<Object> comparator)
    {
        Object[] sortingArray = new Object[arrayToSort.length];
        System.arraycopy(arrayToSort, 0, sortingArray, 0, arrayToSort.length);

        for (int i = 1; i < sortingArray.length; ++i)
        {
            for (int j = i; j > 0; --j)
            {
                if (comparator.compare(sortingArray[j], sortingArray[j - 1]) < 0)
                {
                    Object savedObj = sortingArray[j];
                    sortingArray[j] = sortingArray[j - 1];
                    sortingArray[j - 1] = savedObj;
                }
                else
                {
                    break;
                }
            }
        }

        return sortingArray;
    }
}
