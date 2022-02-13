package leetcode.hot100;

/**
 * @desc:
 * @author: James Qiu
 * @datetime: 2022/2/11 21:03
 */
public class Q011_盛最多水的容器 {

    /**
     * 方法一：双循环遍历
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }

        int length = height.length;
        int max = 0;
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                int area = (right - left) * Math.min(height[left], height[right]);
                max = Math.max(area, max);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea1(height);
    }

    /**
     * 方法二：双指针
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }

        int length = height.length;

        int left = 0;
        int right = length-1;
        int max = 0;
        while (left<=right){
            int area = (right-left)*Math.min(height[left], height[right]);
            max = Math.max(max, area);

            //下面的步骤就很妙，只留更高的，这就避免了要每一个都留着，再遍历其他
            if(height[left] >= height[right]){
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

}
