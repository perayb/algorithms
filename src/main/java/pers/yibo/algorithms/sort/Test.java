package pers.yibo.algorithms.sort;

import java.util.Arrays;

/**
 * @author yibo
 * @date 2021-11-09 17:59
 **/
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 7, 3, 9, 4, 8, 5, 6, 2};
        SortFunction selection = new SelectionSort();
        selection.sort(a);
        System.out.println(selection.isSorted(a));
        System.out.println(Arrays.toString(a));

        a = new int[]{1, 5, 7, 3, 9, 4, 8, 5, 6, 2};
        SortFunction insertion = new InsertionSort();
        insertion.sort(a);
        System.out.println(insertion.isSorted(a));
        System.out.println(Arrays.toString(a));

    }
}
