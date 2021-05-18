//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// 👍 32 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
    int[] leapMonthDay = {31,29,31,30,31,30,31,31,30,31,30,31};
    public int daysBetweenDates(String date1, String date2) {
        int date1To2100 = to2100(date1);
        int date2To2100 = to2100(date2);
        return Math.abs(date1To2100-date2To2100);
    }

    //和2100年的差距
    public int to2100(String data){
        int resultDay;
        String[] allData = data.split("-");
        //年差距
        int year = Integer.valueOf(allData[0])+1;
        int minYear = 2100-year;
        resultDay = minYear%4*365 + minYear/4*1461;
        resultDay = resultDay + toNextYear(Integer.valueOf(allData[0])%4 == 0 && Integer.valueOf(allData[0])%100 != 0,Integer.valueOf(allData[1]), Integer.valueOf(allData[2]));
        return resultDay;
    }

    //获取到第二年的时间
    public int toNextYear(boolean isleap,int month,int day){
        int result = 0;
        if(isleap){
            result = leapMonthDay[month-1] - day;
            for(int i = month; i < 12 ;++i)
                result = result + leapMonthDay[i];
        }else {
            result = monthDay[month-1] - day;
            for(int i = month; i < 12 ;++i)
                result = result + monthDay[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
