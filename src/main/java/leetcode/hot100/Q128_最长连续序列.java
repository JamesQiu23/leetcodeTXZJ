package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/4 2:33
 */
public class Q128_最长连续序列 {

    /**
     * 使用hash表，查找元素速度为1
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        Set<Integer> set = new HashSet<>(); //使用hash表，使查找元素时为O(1)，还能去重
        for (int i : nums) {
            set.add(i);
        }

        int longest = -1;
        for (Integer i : set) {
            if (!set.contains(i-1)){
                int temp = i;
                int curLength = 1;
                while (set.contains(temp+1)){
                    curLength++;
                    temp++;
                }
                longest = longest >= curLength ? longest : curLength;
            }
        }

        return longest;
    }



}
