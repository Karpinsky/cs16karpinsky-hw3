package main.java.ua.edu.ucu.smartarr.decorators;

import main.java.ua.edu.ucu.functions.MyComparator;
import main.java.ua.edu.ucu.smartarr.BaseArray;
import main.java.ua.edu.ucu.smartarr.SmartArray;

import java.util.Arrays;
import java.util.LinkedList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator<T> extends SmartArrayDecorator<T>
{
    private SmartArray<T> smartArray;
    private MyComparator myComparator;
    private T[] distinctArray;

    public DistinctDecorator(SmartArray<T> smartArray, MyComparator comparator)
    {
        this.smartArray = smartArray;
        this.distinctArray = distinct(smartArray.toArray(), comparator);
    }

    public static void main(String... args)
    {
        SmartArray<Integer> arr = new BaseArray<>(new Integer[] {5, 2, 1, 7, 2, 3, 5, 8});

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean compareBool(Object o1, Object o2) {
                return ((Integer)o1).equals((Integer)o2);
            }
        };

        DistinctDecorator<Integer> DD = new DistinctDecorator<>(arr, comparator);
        System.out.println(Arrays.toString(DD.distinctArray));
    }

    public T[] getDistinctArray()
    {
        return this.distinctArray;
    }

    public T[] distinct(T[] arrayToDistinct, MyComparator comparator)
    {
        LinkedList<T> disctinctedList = new LinkedList<>();

        outerLoop:
        for (T distinct_el : arrayToDistinct)
        {
            for (T alreadyDistinct_el : disctinctedList)
            {
                if (comparator.compareBool(distinct_el, alreadyDistinct_el))
                {
                    continue outerLoop;
                }
            }

            disctinctedList.addLast(distinct_el);
        }

        return (T[])disctinctedList.toArray();
    }
}
