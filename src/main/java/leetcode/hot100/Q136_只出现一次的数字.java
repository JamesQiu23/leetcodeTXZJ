package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/4 1:56
 */
public class Q136_只出现一次的数字 {

    /**
     * 方法一：第一时间想到hash表
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null){
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }
        }

        int result = -1;
        for (Integer i : map.keySet()) {
            result = map.get(i) == false ? i : result;
        }

        return result;
    }


    /**
     * 位运算
     * 注意题目是：其他元素均出现2次，不是2次以上而只是2次
     * 异或运算：
     * 任何数和0做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0
     * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
     *
     * 时间复杂度 O(n) 因为需要遍历全部数组元素
     * 空间复杂度 O(1) 不涉及到内存空间
     *
     */
    public int singleNumber1(int[] nums) {
        int res = 0;
        for(int i=0; i<nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }

}
