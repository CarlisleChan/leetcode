/*

给定一个字符串，找出不含有重复字符的最长子串的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 无重复字符的最长子串是 "b"，其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。

 */

class Solution {
  fun lengthOfLongestSubstring(s: String): Int {
    val length = s.length
    var ans = 0
    var i = 0
    var j = 0
    var map = HashMap<Char, Int>()
    while (i < length && j < length) {
        if (map.containsKey(s[j])) {
            i = Math.max(map[s[j]]!!, i)
        }
        ans = Math.max(j - i + 1, ans)
        map[s[j]] = j + 1
        j++
    }
    return ans
  }
}

fun main(args: Array<String>) {
  val result = Solution().lengthOfLongestSubstring("pwwkew")
  println("length: $result")
}