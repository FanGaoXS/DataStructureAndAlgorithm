package homework.leetcode;

import list.ArrayList;
import struct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/14/12:37
 * @Description:
 *                  https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    //直接在链表上操作
    public ListNode removeElements(ListNode head, int val) {
        ListNode resultNode = new ListNode(-1,head);
        ListNode tempResultNode = resultNode;
        ListNode preNode = resultNode;
        while (resultNode!=null) {
            if (resultNode.val == val){
                while (resultNode!=null&&resultNode.val == val) {   //while循环迭代相同的元素
                    resultNode = resultNode.next;
                }
                preNode.next = resultNode;
                preNode = resultNode;
                continue;
            }
            preNode = resultNode;
            resultNode = resultNode.next;
        }
        return tempResultNode.next;
    }
    //使用ArrayList
    public ListNode removeElements2(ListNode head, int val) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null) {
            if (head.val != val) nodes.add(head);
            head = head.next;
        }
        ListNode resultNode = new ListNode(-1);
        ListNode tempResultNode = resultNode;
        for (int i = 0; i < nodes.size(); i++) {
            resultNode.next = nodes.get(i);
            resultNode = resultNode.next;
        }
        resultNode.next = null;
        return tempResultNode.next;
    }
}
