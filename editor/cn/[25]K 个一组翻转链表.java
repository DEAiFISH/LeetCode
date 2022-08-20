//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1762 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arrayList.add(temp);
            temp = temp.next;
        }

        int size = arrayList.size();


        if (size < k) {
            return head;
        }
        ListNode pre = null;
        if (size % k != 0) {
            int index = size - 1;
            while (index % k != 0) {
                index--;
            }
            pre = arrayList.get(index);
            size = index;
        }
        size = size / k;

        head = arrayList.get(k - 1);
        temp = head;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < k; j++) {
                temp.next = arrayList.get(i * k + k - j - 1);
                temp = temp.next;
            }
        }

        temp.next = pre;

        return head;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
