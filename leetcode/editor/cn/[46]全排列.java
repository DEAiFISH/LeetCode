//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2169 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[] vis = new int[nums.length];
        dfs(ans, new ArrayList<Integer>(), nums, vis, 0);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer> a, int[] nums, int[] vis, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(a));
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
