//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 动态规划 矩阵 
// 👍 336 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1){
            return matrix[0][0];
        }
        int[][]dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0],dp[i - 1][1]) + matrix[i][0];
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j-1],Math.min(dp[i- 1][j],dp[i - 1][j + 1])) + matrix[i][j];
            }
            dp[i][n - 1]= Math.min(dp[i -  1][n - 2],dp[i - 1][n - 1]) + matrix[i][n - 1];
        }

        int res = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res,dp[n - 1][i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
