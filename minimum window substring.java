import java.util.HashMap;
public class Solution {
    public String minWindow(String S, String T) {
        if(T == null || S == null) return null;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> cur = new HashMap<Character,Integer>();
        for(int i = 0; i < T.length(); i++){
            cur.put(T.charAt(i),0);
            if(map.containsKey(T.charAt(i)))
                map.put(T.charAt(i),map.get(T.charAt(i))  + 1);
            else
                map.put(T.charAt(i), 1);
        }
        int left = -1;
        int right = S.length();
        int start = 0;
        int len = 0;
        for(int i = 0; i < S.length(); i++){
            if(cur.containsKey(S.charAt(i))){
                cur.put(S.charAt(i),cur.get(S.charAt(i)) + 1);
                if(cur.get(S.charAt(i)) <= map.get(S.charAt(i))){
                    len++;
                }
                if(len == T.length()){
                    while(!cur.containsKey(S.charAt(start)) || cur.get(S.charAt(start)) > map.get(S.charAt(start))){
                        if(cur.containsKey(S.charAt(start))){
                            cur.put(S.charAt(start), cur.get(S.charAt(start)) - 1);
                        }
                        start++;
                    }
                    if(i - start < right - left){
                        left = start;
                        right = i;
                    }
                }
            }
        }
        if(left == -1) return "";
        return S.substring(left,right + 1);
    }
}