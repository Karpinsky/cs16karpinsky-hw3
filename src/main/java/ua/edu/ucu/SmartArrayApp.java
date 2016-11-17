package main.java.ua.edu.ucu;

import java.util.Arrays;
import main.java.ua.edu.ucu.functions.MyComparator;
import main.java.ua.edu.ucu.functions.MyFunction;
import main.java.ua.edu.ucu.functions.MyPredicate;
import main.java.ua.edu.ucu.smartarr.*;
import main.java.ua.edu.ucu.smartarr.decorators.DistinctDecorator;
import main.java.ua.edu.ucu.smartarr.decorators.FilterDecorator;
import main.java.ua.edu.ucu.smartarr.decorators.MapDecorator;
import main.java.ua.edu.ucu.smartarr.decorators.SortDecorator;

public class SmartArrayApp
{
    public static Integer[] filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers)
    {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }

            @Override
            public boolean compareBool(Object o1, Object o2) {
                return false;
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray<Integer> sa = new BaseArray<>(integers);

        FilterDecorator<Integer> fSa = new FilterDecorator<>(sa, pr); // Result: [2, 1, 3];
        sa.setOriginal(fSa.getFilteredArray());
        SortDecorator<Integer> sSa = new SortDecorator<>(sa, cmp); // Result: [1, 2, 3]
        sa.setOriginal(sSa.getSortedArray());
        MapDecorator<Integer> mSa = new MapDecorator<>(sa, func); // Result: [2, 4, 6]
        sa.setOriginal(mSa.getAppliedArray());

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[] findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students)
    {
        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        SmartArray<Student> studentSmartArray = new BaseArray<>(students);

        Integer minYear = 2;

        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return minYear.equals(((Student) t).getYear()) && (((Student) t).getGPA() >= 4);
            }
        };

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student student1 = (Student)o1;
                Student student2 = (Student)o2;
                int student1SurnameLength = student1.getSurname().length();
                int student2SurnameLength = student2.getSurname().length();

                int minLength = student1SurnameLength < student2SurnameLength ? student1SurnameLength : student2SurnameLength;
                int result = 0;

                for (int i = 0; i < minLength; ++i)
                {
                    result = student1.getSurname().charAt(i) - student2.getSurname().charAt(i);
                    if (result != 0)
                    {
                        break;
                    }
                }

                return result;
            }

            @Override
            public boolean compareBool(Object o1, Object o2) {
                Student student1 = (Student)o1;
                Student student2 = (Student)o2;

                return student1.getSurname().equals(student2.getSurname()) && student1.getName().equals(student2.getName());
            }
        };


        FilterDecorator<Student> fSa = new FilterDecorator<>(studentSmartArray, predicate);
        studentSmartArray.setOriginal(fSa.getFilteredArray());

        DistinctDecorator<Student> dSa = new DistinctDecorator<>(studentSmartArray, comparator);
        studentSmartArray.setOriginal(dSa.getDistinctArray());

        SortDecorator<Student> sSa = new SortDecorator<>(studentSmartArray, comparator);
        studentSmartArray.setOriginal(sSa.getSortedArray());

        Object[] result = studentSmartArray.toStringArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
