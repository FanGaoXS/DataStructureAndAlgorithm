package homework.leetcode;

import list.ArrayList;
import list.List;
import struct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/14/13:22
 * @Description:
 *  https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    // ArrayList
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null) {
            nodes.add(head);
            head = head.next;
        }
        return nodes.get(nodes.size()/2);
    }
    // 快慢节点
    public ListNode middleNode2(ListNode head) {
        //如果只有一个节点
        if (head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
