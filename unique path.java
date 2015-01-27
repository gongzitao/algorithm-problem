public class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) return 0;
        int[][] res = new int[m  + 1][n  + 1];
        //res[0][0] =
        for(int i = 0; i < res[0].length; i++){
            res[1][i] = 1;
        }
        for(int i = 1; i < res.length; i++) res[i][1] = 1;
        
        for(int i = 2; i < res.length; i++){
            for(int j = 2; j < res[0].length; j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m][n];
    }
}