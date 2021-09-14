package homework.leetcode;

import struct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/14/13:05
 * @Description:
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = head;
        ListNode preNode = head;
        while (head!=null&&head.next!=null) {
            if (head.val == head.next.val){
                preNode = head;
                while (head.next!=null&&head.val == head.next.val){
                    head = head.next;
                }
                head = head.next;
                preNode.next = head;
                continue;
            }
            head = head.next;
        }
        return tempHead;
    }
}
