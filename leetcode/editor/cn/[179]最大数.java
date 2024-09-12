//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 
// 👍 1252 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (x, y) -> {
            int sy = 10,sx = 10;
            while(sx <= x){
                sx *= 10;
            }
            while(sy <= y){
                sy *= 10;
            }
            return (y * sx + x) - (x * sy + y);
        });

        if(arr[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : arr) {
            sb.append(i);
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
