import java.util.HashMap;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int res = 0;
        int i = 0;
        while(i < s.length()){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                res++;
                //i++;
            }
            else{
                i = map.get(s.charAt(i));
                res = 0;
                map.clear();
            }
            i++;
        }
        return res;
    }
}