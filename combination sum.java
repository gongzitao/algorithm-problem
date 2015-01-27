import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(candidates,target,0,0,new ArrayList<Integer>(),res);
        return res;
    }
    private void helper(int[] candidates, int target, int sum, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            //if(i > 0 && candidates[i - 1] == candidates[i]) continue;
            item.add(candidates[i]);
            helper(candidates,target,sum + candidates[i],i,item,res);
            item.remove(item.size() - 1);
        }
    }
}