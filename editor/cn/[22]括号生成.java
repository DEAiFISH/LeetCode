//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2817 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(n, "", res,0,0);
        return res;
    }

    private static void dfs(int n, String path, List<String> res,int left, int right) {
        if (left > n || left < right) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }

        dfs(n, path + "(", res,left + 1, right);
        dfs(n, path + ")", res,left,right + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
