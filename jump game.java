public class Solution {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) return false;
        //if(A.length == 1 && A[0] == 0) return false;
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(max < i) break;
            max = Math.max(max,A[i] + i);
        }
        if(max >= A.length - 1) return true;
        else return false;
    }
}