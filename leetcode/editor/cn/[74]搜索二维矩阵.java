//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 709 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[mid][matrix[0].length - 1] == target) {
                return true;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= matrix.length) return false;
        int temp = left;
        left = 0;
        right = matrix[0].length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[temp][mid] == target) {
                return true;
            } else if (matrix[temp][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
