//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 
// 👍 2666 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                res = Math.max(res, width * curHeight);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            res = Math.max(res, width * curHeight);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
