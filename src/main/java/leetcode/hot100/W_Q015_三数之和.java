package leetcode.hot100;

import java.util.*;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/12 1:30
 */
public class W_Q015_三数之和 {
    /**
     * 暴力破解
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length<3){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 2; i < length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (nums[k] + nums[j] + nums[i] == 0){
                        String s = nums[k] + "," + nums[j] + "," + nums[i];
                        set.add(s);
                    }
                }
            }
        }

        for (String s : set) {
            String[] split = s.split(",");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(split[0]));
            list.add(Integer.parseInt(split[1]));
            list.add(Integer.parseInt(split[2]));
            res.add(list);
        }

        return res;
    }

}
