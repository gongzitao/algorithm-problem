public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int up = 0;
        int down = matrix.length - 1;
        int row = 0;
        while(up <= down){
            int mid = (up + down) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) {
                down = mid - 1;
            }
            else{
                up = mid + 1;
            }
        }
        if(down < 0 ) return false;
        int left = 0;
        int right = matrix[0].length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[down][mid] == target) return true;
            else if(matrix[down][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}