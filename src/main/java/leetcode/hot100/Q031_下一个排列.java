package leetcode.hot100;

import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/13 20:10
 */
public class Q031_下一个排列 {

    /**
     * 思路：比如1 5 8 4 7 6 5 3 1，从尾往前都是递增的直到4，那么就要交换4和4后面的一个数，这个数选择比4稍微大点的5
     * 得 1 5 8 5 7 6 4 3 1，再讲交换后的数字的5的后面重新从小到大排序
     * 得 1 5 8 5 1 3 4 6 7
     *
     * 和下面标准答案思路一样，但是我这一大堆罗里吧嗦，还运行错误，艹
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int flag = length - 2;
        while (flag >= 0 && nums[flag] >= nums[flag+1]){
            flag--;
        }

        if (flag>=0){
            int point = length-1;
            while (point >= 0 && nums[flag] >= nums[point]){
                point--;
            }

            swap(nums, flag, point);
        }

        reverse(nums, flag+1);

    }


    /**
     * 标准答案，抄的
     * @param nums
     */
    public static void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //如果i直接为-1，则表示数组所有的元素都是从大到小排序，那么需要返回一个从小到大排序的最小值
        reverse(nums, i + 1);
    }

    /**
     * 交换数组某连个索引的元素交换
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 将数组的从指定位置之后的元素从头到尾逆序
     * @param nums
     * @param start
     */
    public static void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }



}
