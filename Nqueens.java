import java.util.ArrayList;
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(n <= 0) return res;
        int[] map = new int[n];
        helper(0,n,map,res);
        return res;
    }
    private void helper(int i,int n, int[] map,ArrayList<String[]> res){
        if(i == n){
            String[] item = new String[map.length];
            for(int j = 0; j < map.length; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < map.length; k++){
                    if(map[j] == k)
                        sb.append('Q');
                    else sb.append('.');
                }
                item[j] = sb.toString();
            }
            res.add(item);
            return;
        }
        //for(int j = i; j < map.length; j++){
        for(int k = 0;k < map.length; k++){
            map[i] = k;
            if(check(map,i)){
                helper(i + 1,n, map,res);
            }
        }
        // }
    }
    private boolean check(int[] map, int i){
        for(int j = 0; j < i; j++){
            if(map[j] == map[i] || Math.abs(j - i) == Math.abs(map[j] - map[i]))
                return false;
        }
        return true;
    }
}