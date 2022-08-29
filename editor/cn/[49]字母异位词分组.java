//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //判断是否为空字符串数组
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        //1.创建一个哈希表
        Map<String, List> map = new HashMap<String, List>();
        for (String s : strs) {
            //将字符串转化为字符数组
            char[] chars = s.toCharArray();
            //对字符数组按照字母顺序排序
            Arrays.sort(chars);
            //将排序后的字符串作为哈希表中的key值
            String key = String.valueOf(chars);
            //2.判读哈希表中是否有该key值
            if (!map.containsKey(key)) {
                //若不存在，则为新的异位词语，在map中创建新的键值对
                map.put(key, new ArrayList());
            }
            //3.将该字符串放在对应key的list中
            map.get(key).add(s);
        }
        //返回map中所有键值对象构成的list
        return new ArrayList(map.values());
    }
}

//leetcode submit region end(Prohibit modification and deletion)
