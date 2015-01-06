import java.util.ArrayList;
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        if(n == 0)
            return ret;
        helper(n,n,new StringBuilder(), ret);
        return ret;
    }
    private void helper(int left,int right, StringBuilder str, ArrayList<String> ret){
        if(left == 0 && right == 0) {
            ret.add(new String(str.toString()));
            return;
        }
        if(left < 0 || right < 0) return;
        if(left <= right){
            str.append('(');
            helper(left - 1, right, str,ret);
        }
        str.append(')');
        helper(left, right - 1,str, ret);
    }
}