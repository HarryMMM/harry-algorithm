package com.harryai.algorithm.utlis;

/**
 * @author Harry
 * @since 2020/05/04 22:09
 **/
public final class CustomFunction {
    public interface NoResFunction<T> {
        void apply(T arr);
    }


    public interface Comparator<T> {
        boolean compare(T[] arr1, int index1, T[] arr2, int index2);
    }

    public interface Comparator1<T> {
        boolean compare(T[] arr, int index1, int index2);
    }
}
