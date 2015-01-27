import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) return res;
        boolean[][] map = getMap(s);
        helper(s,map,0,new ArrayList<String>(), res);
        return res;
    }
    private void helper(String s, boolean[][] map, int i, ArrayList<String> item, ArrayList<ArrayList<String>> res){
        if(i == s.length()){
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int j = i; j < s.length(); j++){
            
            if(map[i][j]){
                String str = s.substring(i,j + 1);
                item.add(str);
                helper(s,map,j + 1,item,res);
                item.remove(item.size() - 1);
            }
        }
    }
    private boolean[][] getMap(String s){
        boolean[][] map = new boolean[s.length()][s.length()];
        
        for(int i = s.length() - 1;i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if((j - i < 2 || map[i + 1][j - 1]) && s.charAt(i) == s.charAt(j))
                    map[i][j] = true;
            }
        }
        return map;
    }
}