//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4661 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int maxLen = 0, maxL = 0, maxR = 0;
        boolean[][] dp = new boolean[n][n];
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[r - 1][l + 1])) {
                    dp[r][l] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxR = r;
                        maxL = l;
                    }
                }
            }
        }
        return s.substring(maxL, maxR + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
