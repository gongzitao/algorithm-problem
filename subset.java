import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) return res;
        ArrayList<Integer> item = new ArrayList<Integer>();
        res.add(item);
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                ArrayList<Integer> list = new ArrayList<Integer>(res.get(j));
                list.add(S[i]);
                res.add(list);
            }
        }
        return res;
    }
}