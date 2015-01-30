import java.util.ArrayList;
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        boolean[] map = new boolean[s.length() + 1];
        map[0] = true;
        for(int i = 1;i <= s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(map[j] && dict.contains(s.substring(j,i))){
                    map[i] = true;
                    break;
                }
            }
        }
        if(!map[s.length()]) return res;
        helper(s,dict,new String(),res,0);
        return res;
    }
    private void helper(String s, Set<String> dict, String str, ArrayList<String> res, int index){
        if(index == s.length()){
            res.add(str);
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(dict.contains(s.substring(index,i + 1))){
                //sb.append(s.substring(index,i));
                if(str.length() == 0)
                    helper(s,dict,s.substring(index,i + 1),res,i + 1);
                //sb.delete(index,)
                else helper(s,dict,str + " " + s.substring(index,i + 1),res, i + 1);
            }
        }
    }
}