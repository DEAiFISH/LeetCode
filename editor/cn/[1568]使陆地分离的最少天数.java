//给你一个大小为 m x n ，由若干 0 和 1 组成的二维网格 grid ，其中 1 表示陆地， 0 表示水。岛屿 由水平方向或竖直方向上相邻的 1 （陆
//地）连接形成。 
//
// 如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。 
//
// 一天内，可以将 任何单个 陆地单元（1）更改为水单元（0）。 
//
// 返回使陆地分离的最少天数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
//输出：2
//解释：至少需要 2 天才能得到分离的陆地。
//将陆地 grid[1][1] 和 grid[0][2] 更改为水，得到两个分离的岛屿。 
//
// 示例 2： 
// 
// 
//输入：grid = [[1,1]]
//输出：2
//解释：如果网格中都是水，也认为是分离的 ([[1,1]] -> [[0,0]])，0 岛屿。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 强连通分量 
// 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int minDays(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // 岛屿数量不为 1，陆地已经分离
        if (count(grid, n, m) != 1) {
            return 0;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) {
                    grid[i][j] = 0;
                    if (count(grid, n, m) != 1) {
                        // 更改一个陆地单元为水单元后陆地分离
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int count(int[][] grid, int n, int m) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    cnt++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        // 还原
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return cnt;
    }

    public void dfs(int x, int y, int[][] grid, int n, int m) {
        grid[x][y] = 2;
        for (int i = 0; i < 4; ++i) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] != 1) {
                continue;
            }
            dfs(tx, ty, grid, n, m);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
