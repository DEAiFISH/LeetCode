//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。 
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 45 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;    // 矩阵尺寸
        Map<String, Integer> rowSeqCount = new HashMap<>();     // 存储行数字序列字符串的哈希表
        StringBuilder sb;      // 用于生成数字序列字符串
        String rowSeq;          // 数字序列字符串
        for (int i = 0; i < n; i++) {     // 遍历每一行
            sb = new StringBuilder();   // 每一行新建一个对象
            // 生成行数字序列字符串
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
                sb.append('%');
            }
            rowSeq = sb.toString();
            // 哈希表记录这个数字序列字符串个数
            rowSeqCount.put(rowSeq, rowSeqCount.getOrDefault(rowSeq, 0) + 1);
        }
        int count = 0;
        for (int j = 0; j < n; j++) {     // 遍历每一列
            sb = new StringBuilder();   // 每一列新建一个对象
            // 生成列数字序列字符串
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]);
                sb.append('%');
            }
            rowSeq = sb.toString();
            // 从哈希表中查询是和这个列数字序列字符串相同的行数字序列字符串的个数
            count += rowSeqCount.getOrDefault(rowSeq, 0);
        }
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
