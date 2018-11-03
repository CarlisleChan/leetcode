/*

给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */

class ListNode(var `val`: Int = 0) {
     var next: ListNode? = null
}

class Solution {
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val l3 = ListNode(0)
    var firstHead = l1
    var secondHead = l2
    var thirdHead = l3
    var offset = 0
    while (true) {
      if (firstHead == null && secondHead == null && offset == 0) {
        break
      }

      var num1 = 0
      var num2 = 0

      if (firstHead != null) {
        num1 = firstHead.`val`
        firstHead = firstHead.next
      }
      if (secondHead != null) {
        num2 = secondHead.`val`
        secondHead = secondHead.next
      }

      thirdHead.`val` = (num1 + num2 + offset) % 10
      offset = (num1 + num2 + offset) / 10

      if (firstHead != null || secondHead != null || offset > 0) {
        thirdHead.next = ListNode(0)
        thirdHead = thirdHead.next!!
      }
    }
    return l3
  }
}

fun main(args: Array<String>) {
  val firstListNode = ListNode(2)
  firstListNode.next = ListNode(4)
  firstListNode.next?.next = ListNode(3)

  val secondListNode = ListNode(5)
  secondListNode.next = ListNode(6)
  secondListNode.next?.next = ListNode(4)

  var listNode = Solution().addTwoNumbers(firstListNode, secondListNode)
  do {
    println(listNode?.`val`)
    listNode = listNode?.next
  } while(listNode != null)
}