//给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字
//符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。 
//
// 示例： 
//
// 输入：
//big = "mississippi"
//smalls = ["is","ppi","hi","sis","i","ssippi"]
//输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
// 
//
// 提示： 
//
// 
// 0 <= len(big) <= 1000 
// 0 <= len(smalls[i]) <= 1000 
// smalls的总字符数不会超过 100000。 
// 你可以认为smalls中没有重复字符串。 
// 所有出现的字符均为英文小写字母。 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 滑动窗口 👍 48 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiSearch(String big, String[] smalls) {
        int len = smalls.length;
        ArrayList[] list = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < len; i++) {
            int index = 0;
            if (smalls[i].length() == 0) {
                continue;
            }
            while ((index = big.indexOf(smalls[i], index)) != -1) {
                list[i].add(index++);
            }
        }

        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            int size = list[i].size();
            res[i] = new int[size];
            for (int j = 0; j < size; j++) {
                res[i][j] = (Integer) list[i].get(j);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
