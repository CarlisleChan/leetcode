/*

验证给定的字符串是否为数字。

例如:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true

思路:
确定有穷状态
0 初始无输入或者只有space的状态
1 输入了数字之后的状态
2 前面无数字，只输入了dot的状态
3 输入了+/-状态
4 前面有数字和有dot的状态
5 'e' or 'E'输入后的状态
6 输入e之后输入+/-的状态
7 输入e后输入数字的状态
8 前面有有效数输入之后，输入space的状态

 */

class Solution {
    val dfa = mapOf(
            1 to mapOf("space" to 1, "sign" to 2, "digit" to 3, "." to 4),
            2 to mapOf("digit" to 3, "." to 4),
            3 to mapOf("digit" to 3, "." to 5, "e" to 6, "space" to 9),
            4 to mapOf("digit" to 5),
            5 to mapOf("digit" to 5, "e" to 6, "space" to 9),
            6 to mapOf("sign" to 7, "digit" to 8),
            7 to mapOf("digit" to 8),
            8 to mapOf("digit" to 8, "space" to 9),
            9 to mapOf("space" to 9)
    )

    fun isNumber(s: String): Boolean {
        var status = 1
        for (c in s) {
            var item = c.toString()
            when {
                item >= "0" && item <= "9" -> item = "digit"
                item == " " -> item = "space"
                item == "+" || item == "-" -> item = "sign"
            }
            if (dfa[status]!!.containsKey(item)) {
                status = dfa[status]!![item]!! 
            } else {
                return false
            }
        }
        return status == 3 || status == 5 || status == 8 || status == 9
    }
}

fun main(args: Array<String>) {
    val result = Solution().isNumber("123")
    println("isNumber: $result")
}