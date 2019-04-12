/**
 * Created by IntelliJ IDEA.
 *
 * @Avatar: xyb
 * Date: 2017/9/4
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */

package sort;

import java.util.Arrays;

public class SortTest {


    public static void main(String[] args) {
        int[] arr = {1, 2, 54, 25, 7, 4, 8, 3, 7, 3, 7, 3, 7, 9};

//        SortDemo.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        // 快速排序
        SortDemo.quickSort(arr);
        System.out.println(Arrays.toString(arr));

        // 不使用set去除重复的元素
        int[] uniqueArray = new int[arr.length];
        int preValue = arr[0];
        uniqueArray[0] = preValue;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (preValue != arr[i]) {
                uniqueArray[count++] = arr[i];
            }
            preValue = arr[i];
        }

        // 压缩数组
        int[] compressArray = new int[count];
        System.arraycopy(uniqueArray, 0, compressArray, 0, count);
        System.out.println(Arrays.toString(compressArray));


    }


}
