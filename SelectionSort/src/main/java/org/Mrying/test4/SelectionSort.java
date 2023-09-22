package org.Mrying.test4;

/**
 * @since 2023/9/22 10:42
 */
public class SelectionSort {

    private static void swap(int[] nums,int j,int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] selectionSort(int[] nums) {

        // 外循环遍历数组元素，i 表示当前排序范围的起始位置
        for(int i = 0;i < nums.length-1;i++) {
            // 最小元素索引
            int minIndex = i;
            // 内循环遍历未排序的部分，j 表示待比较元素的位置
            for(int j = i+1;j < nums.length;j++) {
                // 如果找到比当前最小元素还小的元素，更新最小元素的索引
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小元素与起始位置元素交换位置
            swap(nums, minIndex, i);
        }

        return nums;
    }
}
