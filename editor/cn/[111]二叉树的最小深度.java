//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 848 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<TreeNode>();
        int minLen = 0;

        if (root != null) {
            treeNodes.offer(root);
            minLen++;
        }
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.remove();
                if (treeNode.left == null & treeNode.right == null) {
                    return minLen;
                }
                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                }
            }
            minLen++;
        }
        return minLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
