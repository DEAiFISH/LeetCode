//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1174 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] vis = new int[nums.length];
        dfs(ans, new ArrayList<Integer>(), nums, vis, 0);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> a, int[] nums, int[] vis, int index) {
        if (index == nums.length) {
            if (!ans.contains(a)) {
                ans.add(new ArrayList<Integer>(a));

            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 0) {
                a.add(nums[i]);
                vis[i] = 1;
                dfs(ans, a, nums, vis, index + 1);
                a.remove(a.size() - 1);
                vis[i] = 0;
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
