package leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/13 16:19
 */
public class Q020_有效的括号 {

    public static void main(String[] args) {
        boolean valid = isValid("){");
    }

    /**
     * 用栈解决是最好的
     * 有更简洁的写法，下面写得太丑了，可以将'('作为key，')'作为value存在map中
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int length = s.length();

        if (s == null || s.length() == 0){
            return false;
        }

        if(length%2 == 1){
            return false;
        }

        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']'){
                if (stack.size() == 0){
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && chars[i] == ')'){
                    continue;
                } else if (pop == '[' && chars[i] == ']'){
                    continue;
                } else if (pop == '{' && chars[i] == '}'){
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (stack.size() == 0){
            return true;
        } else {
            return false;
        }

    }


}
