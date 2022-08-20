//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2025 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int nums = strs.length;
        int minLength = 1024;
        int f = 0;

        for (int i = 0; i < nums; i++) {
            int length = strs[i].length();
            if (length < minLength) {
                minLength = length;
                f = i;
            }
        }

        for (int i = 1; i <= minLength; i++) {
            for (int j = 0; j < nums; j++) {
                if (j == f) {
                    continue;
                }
                if (!strs[j].startsWith(strs[f].substring(0, i))) {
                    return strs[f].substring(0, i - 1);
                }
            }
        }

        return strs[f];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
