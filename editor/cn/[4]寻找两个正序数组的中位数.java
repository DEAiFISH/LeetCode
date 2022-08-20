//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4958 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        for (len = 0; len < len1; len++) {
            arr[len] = nums1[len];
        }
        int t;
        for (len = len1, t = 0; len < len1 + len2; t++, len++) {
            arr[len] = nums2[t];
        }
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len - 1; i++) {
            int l = i;
            for (int j = i; j < len; j++) {
                if (arr[l] > arr[j]) {
                    l = j;
                }
            }
            int tt = arr[i];
            arr[i] = arr[l];
            arr[l] = tt;
        }

        if (len % 2 == 0) {
            return (double) (arr[len / 2] + arr[(len / 2) - 1]) / 2;
        }
        return arr[(len - 1) / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
