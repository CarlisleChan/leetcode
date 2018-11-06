/**

编写一个函数，其作用是将输入的字符串反转过来。

示例 1:

输入: "hello"
输出: "olleh"
示例 2:

输入: "A man, a plan, a canal: Panama"
输出: "amanaP :lanac a ,nalp a ,nam A"

 */
class Solution {
  public String reverseString(String s) {
    char[] array = s.toCharArray();
    int length = array.length;
    for(int i = 0; i < (length / 2); i++) {
      char temp = array[i];
      array[i] = array[length - i - 1];
      array[length - i - 1] = temp;
    }
    return new String(array);
  }
}