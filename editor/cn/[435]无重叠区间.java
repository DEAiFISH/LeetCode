//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 811 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
//这一题用贪心的原因在于每一次我们都贪心的选择右边界小的的范围（在有限的边界内，右边界小的放的个数多，那么删除的就少）
        //特判
        if (intervals.length == 0) return -1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        //按右边界来排序，实际上这一步是贪心算法的关键，因为排序过后才能从低到高依次选择
        int ans = 1;
        //必选的是第一位的
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
