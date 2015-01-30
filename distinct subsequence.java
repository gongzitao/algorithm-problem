public class Solution {
    public int numDistinct(String S, String T) {
        if(S == null || S.length() == 0 || T == null || T.length() == 0) return 0;
        int[][] res = new int[S.length() + 1][T.length() + 1];
        // res[0][0] = 0;
        for(int i = 0; i <= S.length(); i++){
            res[i][0] = 1;
            //else res[i][0] = 0;
        }
        
        for(int i = 1; i <= S.length(); i++){
            for(int j = 1;j <= T.length(); j++){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                }
                else res[i][j] = res[i - 1][j];
            }
        }
        return res[S.length()][T.length()];
    }
}