import java.util.ArrayList;
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        helper(res, new String(), n, 0, 0);
        return res;
    }
    private void helper(ArrayList<String> res, String item, int n, int left, int right){
        if(left == n && right == n){
            res.add(item);
            return;
        }
        if(left < n)
            helper(res,item + "(",n,left + 1, right);
        if(left  > right && right < n)
            helper(res,item + ")",n,left,right + 1);
    }
}