//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1084 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> ans = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtrack(candidates, target, 0, 0, visited);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int sum, int startIndex, boolean[] visited) {
        /* 回溯成功 */
        if (target == sum) {
            /* 使用path直接给list赋值 */
            ArrayList<Integer> list = new ArrayList<>(path);
            ans.add(list);
        }
        /* for循环中的判断条件是决定回溯是否继续下去的标准，即剪枝 */
        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target; i++) {
            /* 去重条件：当前值与前一个值相等，且前一个值未使用，表示分别存在包含前一个值和当前值的两组数据 */
            if (i > 0 && candidates[i - 1] == candidates[i] && !visited[i - 1]) {
                continue;
            }
            sum += candidates[i];
            visited[i] = true;
            path.add(candidates[i]);
            /* 运行到backtrack表示添加candidates[i]，跳出当前循环 */
            backtrack(candidates, target, sum, i + 1, visited);
            /* 以下三步是对上述三步的回溯，表示不添加candidates[i]，继续当前循环 */
            sum -= candidates[i];
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
