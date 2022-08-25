//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是回文串，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入："race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 564 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();

        int l = 0;
        int r = len - 1;

        while (l < r) {
            char lChar = s.charAt(l);
            while (('A' > lChar || 'Z' < lChar && 'a' > lChar || 'z' < lChar) && l < r) {
                l++;
                lChar = s.charAt(l);
            }
            char rChar = s.charAt(r);
            while (('A' > rChar || 'Z' < rChar && 'a' > rChar || 'z' < rChar) && l < r) {
                r--;
                rChar = s.charAt(r);
            }

            if (!(lChar + "").toUpperCase().equals((rChar + "").toUpperCase())) {
                return false;
            }

            l++;
            r--;
        }


        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
