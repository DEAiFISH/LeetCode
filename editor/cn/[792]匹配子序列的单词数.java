//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 235 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Queue<int[]>[] q = new Queue[26];//模拟26个字符指针
        for (int i = 0; i < 26; i++) q[i] = new LinkedList<>();
        for (int i = 0; i < words.length; i++) q[words[i].charAt(0) - 'a'].add(new int[]{i, 0});
        for (char c : s.toCharArray()) { // O(n)
            //目前指针位于c子母的字符串进行移动
            int size = q[c - 'a'].size();
            while (size-- > 0) {
                int[] tem = q[c - 'a'].poll();
                int i = tem[0], len = tem[1];
                if (len + 1 == words[i].length()) {
                    ans++;
                    continue;
                }
                char t = words[i].charAt(len + 1);
                q[t - 'a'].add(new int[]{i, len + 1}); //指针移动
            }
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
