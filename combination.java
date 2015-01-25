import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k <= 0) return res;
        //boolean[] map = new boolean[n]
        helper(res,new ArrayList<Integer>(),n,k,0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item, int n, int k,int index){
        if(item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = index; i < n; i++){
            item.add(i + 1);
            helper(res, item, n ,k, i + 1);
            item.remove(item.size() - 1);
        }
    }
}