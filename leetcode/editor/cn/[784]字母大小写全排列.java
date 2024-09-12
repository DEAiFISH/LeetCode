//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 446 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> list = new ArrayList<>();
        help(s, 0, "", list);
        return list;
    }

    private void help(String s, int index, String str, List<String> list) {
        if (index >= s.length()) {
            list.add(str);
            return;
        }
        char c = s.charAt(index);
        if (Character.isDigit(c)) {
            help(s, index + 1, str + c, list);
            return;
        }
        help(s, index + 1, str + Character.toLowerCase(c), list);
        help(s, index + 1, str + Character.toUpperCase(c), list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
