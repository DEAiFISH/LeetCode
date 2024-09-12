//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 284 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> link = new ArrayDeque<>();
        int floot = 1;
        if (root != null) {
            floot++;
            link.add(root);
        }
        while (!link.isEmpty()) {
            floot++;
            int size = link.size();
            ArrayDeque<Integer> list = new ArrayDeque<>();
            while (size > 0) {
                TreeNode node = link.removeFirst();
                if (node.left != null) {
                    link.add(node.left);
                }
                if (node.right != null) {
                    link.add(node.right);
                }
                if (floot % 2 == 0) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }

                size--;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
