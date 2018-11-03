import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper;

/**

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }
}

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode(0);
    ListNode head = l3;
    while(l1 != null || l2 != null) {
      if(l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          head.next = l1;
          l1 = l1.next;
        } else {
          head.next = l2;
          l2 = l2.next;
        }
        p = p.next;
      } else if (l1 == null) {
        head.next = l2;
        break;
      } else if (l2 == null) {
        head.next = l1;
        break;
      }
    }
    return l3.next;
  }
}