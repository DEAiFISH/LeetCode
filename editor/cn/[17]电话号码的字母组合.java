//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2063 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private String letterMap[] = {
            "",
            "",
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private LinkedList<String> res;
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        res = new LinkedList<>();
        if (digits.equals("")) {
            return res;
        }

        findCombination(digits, 0);
        return res;
    }

    private void findCombination(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int number = digits.charAt(index) - '0';
        for (int i = 0; i < letterMap[number].length(); i++) {
            sb.append(letterMap[number].charAt(i));
            findCombination(digits,index + 1);
            sb.deleteCharAt(index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
