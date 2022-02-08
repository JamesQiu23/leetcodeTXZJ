package leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/8 19:02
 */
public class Q003_无重复字符的最长子串 {

    /**
     * 纯暴力写法，超时
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }

        String[] split = s.split("");

        Integer max = 0;
        for (int i = 0; i < split.length-1; i++) {
            Set<String> set = new HashSet<>();
            set.add(split[i]);
            int count = 1;
            for (int j = i+1; j < split.length; j++) {
                if (set.add(split[j])){
                    count++;
                } else {
                    max = max >= count ? max : count;
                    break;
                }
            }
            max = max >= count ? max : count;
        }

        return max;
    }


    /**
     * 方法：滑动窗口
     * 想了很久，参考了答案写出的
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; //左窗口边界
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) { //i就是右窗口边界
            char key = s.charAt(i);
            if (map.containsKey(key)){
                //1.为什么是map.get(key) + 1？ 答：如果后面出现相同字符，则从前面这个相同字符的下一个字符开始新一轮窗口
                //2.为什么要和left比较？ 答：left不一定就比出现相同字符的索引小，比如"abba"，当left开启新一轮循环指向第二个b时，如果i指向第二个a，
                    //则从map获取到第一个a的索引+1的值(为1)，也比此时的left小(为2)，此时肯定不能把left又设置到第一个a的下一个字符上
                left = Math.max(map.get(key) + 1, left);
            }
            //为什么对于已存在的字符，还有更新其索引值？ 答："abcbefgb"，为了使新一轮的滑动窗口的left不永远是第一个b的下一个字符，而是最近的这个b的下一个字符位置
            map.put(s.charAt(i), i);
            maxLength = Math.max(i - left + 1, maxLength);
        }

        return maxLength;
    }



}
