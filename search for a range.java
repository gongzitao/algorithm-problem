public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A == null || A.length == 0) return res;
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target){
                //check left
                int num = mid;
                while(num >= 0 && A[num] == target){
                    res[0] = num;
                    num--;
                }
                num = mid;
                while(num < A.length && A[num] == target){
                    res[1] = num;
                    num++;
                }
                return res;
            }
            else if(A[mid] < target){
                left = mid  + 1;
            }
            else right = mid - 1;
        }
        return res;
    }
}