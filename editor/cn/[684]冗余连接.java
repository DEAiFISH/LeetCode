//树可以看成是一个连通且 无环 的 无向 图。 
//
// 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信
//息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。 
//
// 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: edges = [[1,2], [1,3], [2,3]]
//输出: [2,3]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
// 
//
// 
//
// 提示: 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ai < bi <= edges.length 
// ai != bi 
// edges 中无重复元素 
// 给定的图是连通的 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 571 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (f(edges[i][0]) == f(edges[i][1])) {
                return edges[i];
            }
            u(edges[i][0], edges[i][1]);
        }
        return null;
    }

    private void u(int i, int j) {
        father[f(i)] = f(j);
    }

    private int f(int x) {
        if (x != father[x]) {
            father[x] = f(father[x]);
        }
        return father[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
