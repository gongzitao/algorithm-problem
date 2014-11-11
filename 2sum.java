import java.util.HashMap;
import java.util.Arrays;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        if(numbers == null || numbers.length == 0) return ret;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                if(map.get(target - numbers[i]) < i){
                    ret[0] = map.get(target - numbers[i]) + 1;
                    ret[1] = i + 1;
                }
                else{
                    ret[0] = i + 1;
                    ret[1] = map.get(target - numbers[i]) + 1;
                }
            }
            else{
                map.put(numbers[i], i);
            }
        }
        return ret;
    }
}