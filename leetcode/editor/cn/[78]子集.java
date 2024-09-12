//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1778 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backTrace(nums, res, 0, new LinkedList<>());

        return res;

    }

    public void backTrace(int[] nums, List<List<Integer>> res, int index, LinkedList<Integer> trace) {
        res.add(new ArrayList<>(trace));

        //根据示例，组合起来得子集是有序得，故起点为index+1
        for (int i = index; i < nums.length; i++) {
            trace.add(nums[i]);
            backTrace(nums, res, i + 1, trace);
            trace.removeLast();
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
