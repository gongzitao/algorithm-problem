import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3) return ret;
        Arrays.sort(num);
        for(int i = 0;i < num.length - 2; i++){
            //for(int j = i + 1; j < num.length; j++){
            int j = i + 1;
            int k = num.length - 1;
            if(i == 0 || num[i] != num[i - 1]){
                while(j < k){
                    
                    if(num[j] + num[k] == -num[i]){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[k]);
                        ret.add(item);
                        j++;
                        k--;
                        // remove duplicate
                        while(j < k && num[j] == num[j - 1]){
                            j++;
                        }
                        while(k > j && num[k] == num[k + 1]){
                            k--;
                        }
                    }
                    else if(num[j] + num[k] < -num[i]){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
            } 
        }
        return ret;
    }
}