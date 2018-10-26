/*

给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 */

class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
      val complement = target - nums[i]
      if (map.containsKey(complement)) {
        return intArrayOf(map[complement]!!, i)
      }
      map[nums[i]] = i
    }
    return intArrayOf()
  }
}

fun main(args: Array<String>) {
  val result = Solution().twoSum(intArrayOf(2, 7, 11, 15), 9)
  println(result.joinToString())
}