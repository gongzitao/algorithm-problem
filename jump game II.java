public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length <= 1) return 0;
        int step = 0;
        int max = 0;
        for(int i = 0; i < A.length; i++){
            int num = max;
            for(int j = i; j <= num; j++){
                max = Math.max(max,A[j] + j);
                if(max >= A.length - 1) return step + 1;
            }
            step++;
            //if(max >= A.length - 1) return step;
        }
        return step;
    }
}