//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 
// 👍 781 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return ans;
    }
    private void backTracking(int[] nums, int startIndex){
        if(path.size() >= 2){
            ans.add(path);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty() && path.getLast() < nums[i] || set.contains(nums[i])){
                continue;
            }

            set.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums,i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
