//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 
//d 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 数组 哈希表 
// 👍 50 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashSet<Double> set = new HashSet<>();
        HashSet<Double> res = new HashSet<>();

        for (int n : nums) {
            set.add((double) n);
        }

        int sum = 0;
        for (int i = 0; i < nums.length - 3; i++) { // #1
            set.remove((double) nums[i]);
            for (int j = nums.length - 1; j > i + 2; j--) { // #4
                set.remove((double) nums[j]);
                for (int k = i + 1; k < j - 1; k++) { // #2
                    set.remove((double) nums[k]);
                    double x = 1d * nums[i] * nums[j] / nums[k];
                    double y = nums[i] + nums[j] + nums[k] + x;
                    if (set.contains(x)) {
                        if (!res.contains(y)) {
                            sum += 8;
                            res.add(y);
                        }
                    }
                    set.add((double) nums[k]);
                }
                set.add((double) nums[j]);
            }
            set.add((double) nums[i]);
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
