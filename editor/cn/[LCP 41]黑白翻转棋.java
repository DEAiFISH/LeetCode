//在 `n*m` 大小的棋盘中，有黑白两种棋子，黑棋记作字母 `"X"`, 白棋记作字母 `"O"`，空余位置记作 `"."`。当落下的棋子与其他相同颜色的棋
//子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
//
//![1.gif](https://pic.leetcode-cn.com/1630396029-eTgzpN-6da662e67368466a96d203
//f67bb6e793.gif){:height=170px}![2.gif](https://pic.leetcode-cn.com/1630396240-
//nMvdcc-8e4261afe9f60e05a4f740694b439b6b.gif){:height=170px}![3.gif](https://pic.
//leetcode-cn.com/1630396291-kEtzLL-6fcb682daeecb5c3f56eb88b23c81d33.gif){:height=170
//px}
//
//「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 `chessboard`。若下一步可放置一枚黑棋，请问选手最多能翻转
//多少枚白棋。
//
//**注意：**
//- 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 **继续** 翻转白棋
//- 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
//
//**示例 1：**
//
//> 输入：`chessboard = ["....X.","....X.","XOOO..","......","......"]`
//>
//> 输出：`3`
//>
//> 解释：
//> 可以选择下在 `[2,4]` 处，能够翻转白方三枚棋子。
//
//**示例 2：**
//
//> 输入：`chessboard = [".X.",".O.","XO."]`
//>
//> 输出：`2`
//>
//> 解释：
//> 可以选择下在 `[2,2]` 处，能够翻转白方两枚棋子。
//> ![2126c1d21b1b9a9924c639d449cc6e65.gif](https://pic.leetcode-cn.com/16266832
//55-OBtBud-2126c1d21b1b9a9924c639d449cc6e65.gif)
//
//**示例 3：**
//
//> 输入：`chessboard = [".......",".......",".......","X......",".O.....","..O....
//","....OOX"]`
//>
//> 输出：`4`
//>
//> 解释：
//> 可以选择下在 `[6,3]` 处，能够翻转白方四枚棋子。
//> ![803f2f04098b6174397d6c696f54d709.gif](https://pic.leetcode-cn.com/16303937
//70-Puyked-803f2f04098b6174397d6c696f54d709.gif)
//
//**提示：**
//- `1 <= chessboard.length, chessboard[i].length <= 8`
//- `chessboard[i]` 仅包含 `"."、"O"` 和 `"X"`
//
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 43 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int flipChess(String[] chessboard) {
        int res = 0;
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                if (chessboard[i].charAt(j) == '.') {
                    res = Math.max(res, bfs(chessboard, i, j));
                }
            }
        }
        return res;
    }

    public int bfs(String[] chessboard, int px, int py) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[0].length(); ++j) {
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{px, py});
        board[px][py] = 'X';
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            for (int i = 0; i < 8; ++i) {
                if (judge(board, t[0], t[1], dirs[i][0], dirs[i][1])) {
                    int x = t[0] + dirs[i][0], y = t[1] + dirs[i][1];
                    while (board[x][y] != 'X') {
                        queue.offer(new int[]{x, y});
                        board[x][y] = 'X';
                        x += dirs[i][0];
                        y += dirs[i][1];
                        ++cnt;
                    }
                }
            }
        }
        return cnt;
    }

    public boolean judge(char[][] board, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (0 <= x && x < board.length && 0 <= y && y < board[0].length) {
            if (board[x][y] == 'X') {
                return true;
            } else if (board[x][y] == '.') {
                return false;
            }
            x += dx;
            y += dy;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
