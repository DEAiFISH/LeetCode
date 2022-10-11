//给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。 
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "bank", s2 = "kanb"
//输出：true
//解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
// 
//
// 示例 2： 
//
// 输入：s1 = "attack", s2 = "defend"
//输出：false
//解释：一次字符串交换无法使两个字符串相等
// 
//
// 示例 3： 
//
// 输入：s1 = "kelb", s2 = "kelb"
//输出：true
//解释：两个字符串已经相等，所以不需要进行字符串交换
// 
//
// 示例 4： 
//
// 输入：s1 = "abcd", s2 = "dcba"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1.length == s2.length 
// s1 和 s2 仅由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length(), a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (a == -1) {
                a = i;
            } else if (b == -1) {
                b = i;
            } else {
                return false;
            }
        }
        if (a == -1) {
            return true;
        }
        if (b == -1) {
            return false;
        }
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
