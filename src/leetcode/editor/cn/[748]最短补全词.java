

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = null;
        int allSize = 0;
        int maxSize = 0;
        Map<String,Integer> map = new HashMap();
        String mas;
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0;i<licensePlate.length();i++){
            if (String.valueOf(licensePlate.charAt(i)).matches("[a-z]")){
                mas = String.valueOf(licensePlate.charAt(i));
                if(map.get(mas) == null){
                    map.put(mas, 1);
                    allSize++;
                }else {
                    map.put(mas, map.get(mas)+1);
                    allSize++;
                }
            }
        }

        for(int i = 0;i<words.length;i++){
            if(haveMas(map, words[i]) == 0 || haveMas(map, words[i])<maxSize)
                continue;
            if(result == null)
                result = words[i];
            if(maxSize == allSize & words[i].length() >= result.length())
                continue;
            result = words[i];
            maxSize = haveMas(map, words[i]);
            if(maxSize == allSize & allSize == words[i].length())
                return words[i];
        }
        return result;
    }

    public int haveMas(Map<String,Integer> map,String str){
        int index = 0;
        int result = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            for(int i = 0;i<entry.getValue(); i++){
                if(str.indexOf(entry.getKey(),index) != -1){
                    result++;
                    index = str.indexOf(entry.getKey(),index)+1;
                }
            }
            index = 0;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
