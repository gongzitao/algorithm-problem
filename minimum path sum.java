public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < grid[0].length; j++){
            res[0][j] = res[0][j - 1] + grid[0][j];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                res[i][j] = Math.min(res[i - 1][j],res[i][j - 1]) + grid[i][j];
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }
}