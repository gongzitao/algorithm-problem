public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean[][] map = new boolean[s.length()][s.length()];
        map = getMap(s);
        int[] res = new int[s.length() + 1];
        res[0] = 0;
        for(int i = 0; i < s.length(); i++){
            res[i + 1] = i + 1;
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(map[j][i]){
                    res[i + 1] = Math.min(res[i + 1], res[j] + 1);
                }
            }
        }
        return res[s.length()] - 1;
    }
    private boolean[][] getMap(String s){
        boolean[][] map = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if((j - i < 2 || map[i + 1][j - 1]) && s.charAt(i) == s.charAt(j))
                    map[i][j] = true;
            }
        }
        return map;
    }
}