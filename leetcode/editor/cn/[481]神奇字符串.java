//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 137 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MX = (int) 1e5;
    private static final int[] acc = new int[MX + 1];

    static {
        char[] s = new char[MX + 1];
        s[0] = 1;
        s[1] = s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < MX; ++i) {
            c ^= 3; // 1^3=2, 2^3=1，这样就能在 1 和 2 之间转换
            s[j++] = c;
            if (s[i] == 2) s[j++] = c;
        }
        for (int i = 0; i < MX; ++i)
            acc[i + 1] = acc[i] + 2 - s[i]; // 2-1=1，2-2=0，这样就只统计了 1
    }

    public int magicalString(int n) {
        return acc[n];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
