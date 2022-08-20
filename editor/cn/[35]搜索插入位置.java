//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1574 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int index = (right + 1) / 2;
        boolean flag = false;
        while (nums[index] != target) {
            if (left >= right) {
                flag = true;
                break;
            }
            if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = (left + right) / 2;
        }

        if (flag) {
            int len = nums.length;
            int[] arr = new int[len + 1];

            for (int i = 0; i < len; i++) {
                arr[i] = nums[i];
            }
            arr[len] = target;

            Arrays.sort(arr);

            index = searchInsert(arr, target);
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
