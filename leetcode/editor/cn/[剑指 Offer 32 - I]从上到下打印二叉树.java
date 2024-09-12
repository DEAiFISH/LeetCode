//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// Related Topics 树 广度优先搜索 二叉树 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;

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
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> link = new ArrayDeque<>();
        if (root != null) {
            link.add(root);
        }
        while (!link.isEmpty()) {
            TreeNode node = link.removeFirst();
            if (node.left != null) {
                link.add(node.left);
            }
            if (node.right != null) {
                link.add(node.right);
            }
            list.add(node.val);
        }
        int[] array = new int[list.size()];
        int i = 0;
        for (int a : list) {
            array[i++] = a;
        }
        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
