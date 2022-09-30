//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 432 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();

        rowIndex++;
        int[][] YH = new int[rowIndex][];

        for (int i = 0; i < rowIndex; i++) {
            YH[i] = new int[rowIndex - i];
            YH[i][0] = 1;
            YH[0][i] = 1;
        }


        for (int i = 1; i < rowIndex; i++) {
            for (int j = 1; j < rowIndex - i; j++) {
                YH[i][j] = YH[i - 1][j] + YH[i][j - 1];
            }
        }

        for (int i = 0; i < rowIndex; i++) {
            res.add(YH[i][rowIndex - 1 - i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
