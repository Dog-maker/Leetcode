//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 示例 1: 
//
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。 
// Related Topics 位运算 
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        if(words.length == 1)
            return 0;
        int maxSize = 0;
        for(int i =0;i<words.length;i++){
            for(int j = i+1;j<words.length;j++){
                if(maxSize > words[i].length()*words[j].length())
                    continue;
                if(compareNotSame(words[i],words[j])){
                    maxSize = words[i].length()*words[j].length();
                }
            }
        }
        return maxSize;
    }

    private boolean compareNotSame(String word, String word1) {
        if(word.length() <= word1.length()){
            for(int i = 0;i<word.length();i++){
                if(word1.indexOf(word.charAt(i)) != -1)
                    return false;
            }
        }else {
            return compareNotSame(word1, word);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
