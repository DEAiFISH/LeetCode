//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1399 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：35.8 MB, 在所有 Java 提交中击败了93.46%的用户
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode h = head;
        int index = 0;
        ListNode pre = null; // 用于翻转链表
        ListNode next; // 用于翻转链表
        ListNode start = null, end = null; // 翻转前的头结点，翻转前的尾结点
        ListNode l = head, r = null; // 翻转前的头结点的前驱， 翻转前的尾结点的后继
        while (h != null) {
            index++; // 记录到达第几个结点
            if (index >= left && index <= right) { // 在指定范围内的结点进行翻转
                if (index == left) { // 翻转前的头结点
                    start = h;
                } else if (index == right) { // 翻转前的尾结点
                    end = h;
                    r = h.next; // 翻转前的尾结点的后继
                }

                next = h.next;
                h.next = pre;
                pre = h;
                h = next;
                continue;
            } else if (index == left - 1) { // 翻转前的头结点的前驱
                l = h;
            }
            h = h.next;
        }

        if (left == 1) { // 左边界是链表开头
            start.next = r;
            return end;
        } else if (right == index) { // 有边界是链表结尾
            l.next = end;
            return head;
        } else { // 左右边界都在链表内部
            l.next = end;
            start.next = r;
            return head;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
