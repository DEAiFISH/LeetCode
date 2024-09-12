//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2：
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
//
// Related Topics 树 广度优先搜索 
// 👍 441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<Node> linked = new LinkedList<>();
        linked.add(root);
        while(!linked.isEmpty()){
            int len = linked.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = linked.poll();
                if(node.children != null){
                    linked.addAll(node.children);
                }
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
