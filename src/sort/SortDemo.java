/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */

package sort;

public class SortDemo {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }


    /**
     * 快速排序（不稳定）
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i = low, j = high;
        int pivot = arr[(i + j) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (i < high) {
            quickSort(arr, i, high);
        }

        if (j > low) {
            quickSort(arr, low, j);
        }
    }

}
