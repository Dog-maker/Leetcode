//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0)return 0;
        int maxSize = 0;
        int[] status = new int[s.length()];
        status[0] = 0;
        for(int i = 1;i<s.length();++i){
            if("(".equals(String.valueOf(s.charAt(i)))){
                status[i] = 0;
                continue;
            }
            else {
                //前一位判断
                if("(".equals(String.valueOf(s.charAt(i-1)))){
                    status[i] = 2;
                }else {
                    if(i-status[i-1]-1>=0 && "(".equals(String.valueOf(s.charAt(i-status[i-1]-1)))){
                        status[i] = status[i-1]+2;
                    }else {
                        status[i] = 0;
                        continue;
                    }
                }
                if(i-status[i-1]-1>0 )
                    status[i] = status[i-status[i]]+status[i];
            }
            if(status[i] > maxSize)
                maxSize = status[i];
        }
        return maxSize;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
