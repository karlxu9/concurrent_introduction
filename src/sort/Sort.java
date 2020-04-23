package sort;

import java.util.Arrays;

/**
 * 模块描述: <br>
 * ()
 *
 * @Author: Mr. xyb
 * @Date: 2019/4/20 14:28
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Sort {

    private static int[] arr = {2, 6, 4, 3, 16, 17, 19, 36, 18, 24, 33, 39, 21, 48};


    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }

        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static int[] ShellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }

    /**
     * 并归排序
     *
     * @param arr
     * @return
     */
    public static int[] MergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 并归排序 -- 合并两个数组的排序
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, index = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
        // System.out.println(Arrays.toString(insertionSort(arr)));
        // System.out.println(Arrays.toString(ShellSort(arr)));
        // System.out.println(Arrays.toString(MergeSort(arr)));
    }
}