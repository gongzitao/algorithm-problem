import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length == 0)
            return 0;
        int ret = num[0];
        int gap = Integer.MAX_VALUE;
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++){
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                if(num[i] + num[j] + num[k] == target){
                    return target;
                }
                else if(num[i] + num[j] + num[k] < target){
                    if(Math.abs(num[i] + num[j] + num[k] - target) < gap){
                        ret = num[i] + num[j] + num[k];
                        gap = Math.abs(num[i] + num[j] + num[k] - target);
                    }
                    j++;
                }
                else{
                    if(Math.abs(num[i] + num[j] + num[k] -target) < gap){
                        ret = num[i] + num[j] + num[k];
                        gap = Math.abs(num[i] + num[j] + num[k] - target);
                    }
                    k--;
                }
            }
        }
        return ret;
    }
}