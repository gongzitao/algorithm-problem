public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int res = Math.min(height[left],height[right]) * (height.length - 1);
        while(left < right){
            if(height[left] > height[right]){
                right--;
                //res = Math.max(res, Math.min(heigth[right], height[left]) * (right - left + 1));
            }
            else {
                left++;
                //res = Math.max(res, Math.min(heigth[right], height[left]) * (right - left + 1));
            }
            res = Math.max(res, Math.min(height[right], height[left]) * (right - left));
        }
        return res;
    }
}