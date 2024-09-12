//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 1968 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) == '(' || s.charAt(stack.getLast()) == ')') {
                stack.addLast(i);
            } else {
                stack.removeLast();
                res = Math.max(res, stack.isEmpty() ? i + 1 : i - stack.getLast());
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
