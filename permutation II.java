import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
        Arrays.sort(num);
        boolean[] map = new boolean[num.length];
        //res.add(new ArrayList<Integer>());
        helper(res, new ArrayList<Integer>(),num,map);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item, int[] num, boolean[] map){
        if(item.size() == num.length ){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = 0; i < num.length; i++){
            if(i > 0 && map[i - 1] && num[i - 1] == num[i]) continue;
            if(!map[i]){
                map[i] = true;
                item.add(num[i]);
                helper(res,item,num,map);
                map[i] = false;
                item.remove(item.size() - 1);
            }
        }
    }
}