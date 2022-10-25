//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1523 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arrayList.add(temp);
            temp = temp.next;
        }

        int size = arrayList.size();


        if (size <= 1) {
            return head;
        }
        ListNode pre = null;
        if (size % 2 != 0) {
            pre = arrayList.get(size - 1);
            size--;
        }
        head = arrayList.get(1);
        head.next = arrayList.get(0);
        temp = head.next;
        for (int i = 2; i < size; i += 2) {
            temp.next = arrayList.get(i + 1);
            temp.next.next = arrayList.get(i);
            temp = temp.next.next;
        }
        temp.next = pre;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
