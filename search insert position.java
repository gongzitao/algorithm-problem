public class Solution {
    public int searchInsert(int[] A, int target) {
        int res = 0;
        if(A == null || A.length == 0) return 0;
        //if(target < A[0]) return 0;
        //if(target > A[A.length - 1]) return A.length;
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}