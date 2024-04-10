//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 
// 👍 1769 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private LinkedList<String> path = new LinkedList<>();
    private List<List<String>> ans = new LinkedList<>();
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        computePalindrome(s.toCharArray());
        backTracking(s, 0);
        return ans;
    }

    private void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
//            if (isPalindrome(check)) {
            if(dp[startIndex][i]){
                path.add(s.substring(startIndex, i + 1));
                backTracking(s, i + 1);
                path.removeLast();
            }
        }
    }

    /*private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }*/

    /**
     * @description 动态规划 判断是否为回文
     *
     * @author DEAiFISH
     * @date 2024/4/9 00:37
     * @param chars
     * @return void
     */
    private void computePalindrome(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }

        for (int i = chars.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < chars.length; j++) {
                dp[i][j] = chars[i] == chars[j];
                if(j - i != 1){
                    dp[i][j] &= dp[i + 1][j - 1] ;
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
