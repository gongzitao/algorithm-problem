public class Solution {
    public int sqrt(int x) {
        if(x < 1) return 0;
        int left = 1;
        int right = x / 2 + 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid <= x / mid && x / (mid + 1) < mid + 1) return mid;
            if(mid < x / mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}