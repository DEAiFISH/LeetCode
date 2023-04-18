//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
//
// Related Topics 数组 双指针 排序 👍 295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l < r && nums[l] % 2 != 0) {
                l++;
            }
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
