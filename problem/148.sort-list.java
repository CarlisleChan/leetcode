import java.util.List;

/**

在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
  }
}
class Solution {
  public ListNode sortList(ListNode head) {
      if(head == null || head.next == null) {
        return head;
      }

      ListNode p1 = head;
      ListNode midNode = getMidNode(head);
      ListNode p2 = midNode.next;
      midNode.next = null;

      p1 = sortList(p1);
      p2 = sortList(p2);

      return merge(p1, p2);
  }

  private ListNode getMidNode(ListNode head) {
    ListNode m1 = head;
    ListNode m2 = head;
    while(m1 != null && m2 != null) {
      if(m2.next == null || m2.next.next == null) {
        return m1;
      }
      m1 = m1.next;
      m2 = m2.next.next;
    }
    return head;
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode(0);
    ListNode head = l3;
    while(l1 != null || l2 != null) {
      if(l1 != null && l2 != null) {
        if(l1.val < l2.val) {
          head.next = l1;
          l1 = l1.next;
        } else {
          head.next = l2;
          l2 = l2.next;
        }
        head = head.next;
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