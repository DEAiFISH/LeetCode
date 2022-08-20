//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);//建立伪头节点
        ListNode cur = newHead;//让cur指针指向伪头节点
        while (list1 != null && list2 != null) {//循环条件,当有一个链表的节点的next指针指向空就跳出。
            if (list1.val < list2.val) {
                cur.next = list1;//小于则让cur指针指向它
                list1 = list1.next;//list1指向下一个节点
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;//cur指针指向那个更小的节点
        }
//当有一个链表节点已经遍历完之后,另外一个链表剩余的节点不用遍历了，直接让cur指向它们就可以了。
        cur.next = list1 == null ? list2 : list1;
        return newHead.next;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
