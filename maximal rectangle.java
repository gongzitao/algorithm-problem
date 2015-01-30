public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix[0].length; i++){
            left[i] = 0;
            right[i] = matrix[0].length;
            height[i] = 0;
        }
        for(int i = 0; i < matrix.length; i++){
            int left_elem = 0;
            int right_elem = matrix[0].length;
            for(int j = 0; j < matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j],left_elem);
                    height[j]++;
                }
                else{
                    left[j] = 0;
                    height[j] = 0;
                    left_elem = j + 1;
                }
            }
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j],right_elem);
                    res = Math.max(res,(right[j] - left[j]) * height[j]);
                }
                else{
                    right[j] = matrix[0].length;
                    right_elem = j;
                }
            }
        }
        return res;
    }
}