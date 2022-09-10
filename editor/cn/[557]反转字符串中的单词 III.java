//给定一个字符串
// s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 
// s 包含可打印的 ASCII 字符。 
// 
// s 不包含任何开头或结尾空格。 
// 
// s 里 至少 有一个词。 
// 
// s 中的所有单词都用一个空格隔开。 
// 
//
// Related Topics 双指针 字符串 👍 479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        int len = s1.length;
        int i = 0;
        while (i < len) {
            s1[i] = reverseString(s1[i].toCharArray());
            i++;
        }
        i = 0;
        s = "";
        while (i < len) {
            s += s1[i] + " ";
            i++;
        }
        s = s.trim();

        return s;
    }

    private String reverseString(char[] s) {
        int len = s.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }

        return new String(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
