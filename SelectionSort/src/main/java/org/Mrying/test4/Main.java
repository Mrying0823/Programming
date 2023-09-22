package org.Mrying.test4;

import java.util.Arrays;

/**
 * @since 2023/9/22 10:40
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,0,0,0,3,0,0,2,1,1};
        nums = new SelectionSort().selectionSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
