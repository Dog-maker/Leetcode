//给你一个二进制串 s （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 
//= s）。 
//
// 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。 
//
// 由于答案可能很大，请将它对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：s = "10101"
//输出：4
//解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
//"1|010|1"
//"1|01|01"
//"10|10|1"
//"10|1|01"
// 
//
// 示例 2： 
//
// 输入：s = "1001"
//输出：0
// 
//
// 示例 3： 
//
// 输入：s = "0000"
//输出：3
//解释：总共有 3 种分割 s 的方法。
//"0|0|00"
//"0|00|0"
//"00|0|0"
// 
//
// 示例 4： 
//
// 输入：s = "100100010100110"
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// s[i] == '0' 或者 s[i] == '1' 
// 3 <= s.length <= 10^5 
// 
// Related Topics 字符串 
// 👍 5 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(String s) {
        int index = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1')
                index++;
        }
        if(index % 3 != 0)
            return 0;
        if(index == 0){
            long n = s.length()-2;
            return (int)((n+(n*(n-1)/2))%1000000007);
        }
        int all = index;
        int a = 0,b,c = 0,d = 0;
        for(int i = 0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)).equals("1")){

                if(index == all/3*2+1)
                    a = i;
                if(index == all/3+1)
                    c = i;
                index--;
            }
        }
        b = s.indexOf("1",a+1);
        d = s.indexOf("1",c+1);

        long result = (long)(b-a)*(d-c);
        if(result >= 1000000007 )
            return (int)((result)%(1000000007));
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
