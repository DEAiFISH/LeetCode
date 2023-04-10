//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 323 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(c[i]) == 1) {
                return c[i];
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
